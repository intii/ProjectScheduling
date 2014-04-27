package AlgorithmExecution;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;

import windowBuilder.DataContainer;
import Crosser.*;
import DataHandler.SolutionHandler;
import Mutator.*;
import FitnessCalculator.*;
import InitialPopulator.InitialPopulator;
import PopulationReplacer.*;
import ParentSelector.*;
import Representation.ParetoSet;
import Representation.SolutionsPrinter;
import SolutionDecoder.AbsSolutionDecoder;
import SolutionDecoder.SolutionDecoderA;
import Structure.Solution;

public class Executor implements Runnable {

	
	private AbsActivityCrosser ac;
	private AbsResourceCrosser rc;
	private AbsActivityMutator am;
	private AbsResourceMutator rm;
	private AbsPopulationReplacer pr;
	private AbsFitnessCalculator fc;
	private SolutionHandler sh;
	private InitialPopulator ip;
	private AbsParentSelector ps;
	private double pc;
	private double pm;
	private int nInitialSolutions;
	private int cutCondition;
	private Boolean multiObjective;
	private double crossDiscriminant;
	private AbsSolutionDecoder sd;
	private Document outputDoc;
	
	public Executor(SolutionHandler sh){
		this.sh = sh;
		this.sd = new SolutionDecoderA(sh);
	}
	 
	
	private AbsActivityCrosser factoryActivityCrosser(int option){
		switch(option){
		case 0: return new ActivityCrosserA(sh.getActivities().size());
		case 1: return new ActivityCrosserB(sh.getActivities().size());
		default: return null;
		}

	}

	private AbsResourceCrosser factoryResourceCrosser(int option){
		switch(option){
		case 0: return new ResourceCrosserA(sh.getActivities().size(),this.crossDiscriminant);
		case 1: return new OnePointResourceCrosser(sh.getActivities().size());
		default: return null;
		}

	}

	private AbsActivityMutator factoryActivityMutator(int option){
		switch(option){
		case 0: return new ActivityMutatorA(this.sh,this.pm);
		case 1: return new ActivityMutatorAdj(this.sh,this.pm);
		default: return null;
		}
	
	}
	
	private AbsResourceMutator factoryResourceMutator(int option){
		return new ResourceMutatorA(this.pm,this.sh,this.ip);
		}
	
	private AbsPopulationReplacer factoryPopulationReplacer(int option){
		switch(option){
		case 0: return new PopulationReplacerA(this.fc);
		case 1: return new PopulationReplacerB(this.fc);
		case 2: return new PopulationReplacerC(this.fc);
		default: return null;
		}
	
	}
	
	private AbsFitnessCalculator factoryFitnessCalculator(int option){
		switch(option){
		case 0: return new FitnessCalculatorEf(this.sd);
		case 1: return new FitnessCalculatorMS(this.sd);
		case 2: return new FitnessCalculatorMulti(this.sd,new FitnessCalculatorEf(this.sd) , new FitnessCalculatorMS(this.sd));
		default: return null;
		}
	
	}
	
	private AbsParentSelector factoryParentSelector(int option){
		switch(option){
		case 0: return new ParentSelectorA(this.fc);
		case 1: return new ParentSelectorB(this.fc);
		default: return null;
		}
	
	}
	
	/*
	 * setEnvironment sets up all the algorithm components 
	 * @param 	configValues: the initial configuration values, probabilities and conditions
	 * 			options: the kind of components that the user chose on the view
	 */
	public void setEnvironment( Document outputDoc ){
		DataContainer dataContainer = DataContainer.getInstance();
		this.pc = dataContainer.getPC();
		this.pm = dataContainer.getPM();
		this.nInitialSolutions = dataContainer.getInitialSolutions();
		this.cutCondition = (int)dataContainer.getCC();;
		this.crossDiscriminant = dataContainer.getCD();
		this.outputDoc = outputDoc;
		this.fc = this.factoryFitnessCalculator(dataContainer.getFCalculatorIndex());
		this.multiObjective = (dataContainer.getFCalculatorIndex() == 2);
		this.fc.setMultiobjective(this.multiObjective);
		this.ip = new InitialPopulator(this.sh);
		this.ac = this.factoryActivityCrosser(dataContainer.getACrosserIndex());
		this.am = this.factoryActivityMutator(dataContainer.getAMutatorIndex());
		this.rc = this.factoryResourceCrosser(dataContainer.getRCrosserIndex());
		this.rm = this.factoryResourceMutator(dataContainer.getRMutatorIndex());
		this.ps = factoryParentSelector(dataContainer.getPSelectorIndex());
		this.pr = this.factoryPopulationReplacer(dataContainer.getPReplacerIndex());

	}
	@Override
	public void run(){
		AbsMutator m = new MutatorA(this.am,this.rm);
		AbsCrosser cr = new CrosserA(this.ac, this.rc, this.pc);
		Solver solv = new Solver();
		solv.setFitnessCalculator(this.fc);
		solv.setCrosser(cr);
		solv.setInitialPopulator(this.ip);
		solv.setMutator(m);
		solv.setNumberInitialSolutions(this.nInitialSolutions);
		solv.setParentSelector(this.ps);
		solv.setPopulationReplacer(this.pr);
		solv.setCutCondition(this.cutCondition);
		ArrayList<Solution> result = solv.solve(this.outputDoc);
		if(!this.multiObjective){
			try {
				this.outputDoc.insertString(this.outputDoc.getLength(), "====================================================\n", null);
				this.outputDoc.insertString(this.outputDoc.getLength(), "====================RESULT SET =====================\n", null);
				this.outputDoc.insertString(this.outputDoc.getLength(), "====================================================\n", null);
				for(Solution s : result){
					this.outputDoc.insertString(this.outputDoc.getLength(), SolutionsPrinter.printOneSolution(s, fc), null);
				}
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} else {
			ParetoSet pareto = new ParetoSet(fc,result);
			HashSet<Solution> resultPareto = pareto.getSet();
			try {
				this.outputDoc.insertString(this.outputDoc.getLength(), "====================================================\n", null);
				this.outputDoc.insertString(this.outputDoc.getLength(), "====================PARETO SET =====================\n", null);
				this.outputDoc.insertString(this.outputDoc.getLength(), "====================================================\n", null);
				for(Solution s : resultPareto){
					this.outputDoc.insertString(this.outputDoc.getLength(), SolutionsPrinter.printOneSolution(s, fc), null);
					
				}
				this.outputDoc.insertString(this.outputDoc.getLength(), "Pareto Set Size: "+resultPareto.size(), null);
			} catch (BadLocationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
