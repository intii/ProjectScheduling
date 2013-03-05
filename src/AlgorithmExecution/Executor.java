package AlgorithmExecution;
import java.util.ArrayList;

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
	private double crossDiscriminant;
	private AbsSolutionDecoder sd;
	private Document outputDoc;
	
	public Executor(SolutionHandler sh){
		this.sh = sh;
		this.sd = new SolutionDecoderA(sh);
	}
	 
	
	private AbsActivityCrosser factoryActivityCrosser(int option){
		switch(option){
		case 0: return new ActivityCrosserA(this.nInitialSolutions);
		case 1: return new ActivityCrosserB(this.nInitialSolutions);
		default: return null;
		}

	}

	private AbsResourceCrosser factoryResourceCrosser(int option){
		switch(option){
		case 0: return new ResourceCrosserA(this.nInitialSolutions,this.crossDiscriminant);
		case 1: return new OnePointResourceCrosser(this.nInitialSolutions);
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
		this.nInitialSolutions = 32;
		this.cutCondition = (int)dataContainer.getCC();;
		this.crossDiscriminant = dataContainer.getCD();
		this.outputDoc = outputDoc;
		this.fc = this.factoryFitnessCalculator(0);
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
	}
}