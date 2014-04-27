package Representation;
import java.util.ArrayList;

import FitnessCalculator.AbsFitnessCalculator;
import FitnessCalculator.FitnessCalculatorMulti;
import Structure.Solution;


public class SolutionsPrinter {

	private static void checkMinMaxAvg(Double maxFitness, Double minFitness, Double avgFitness, Double currentFitness) {
		if( currentFitness > maxFitness){
			maxFitness = currentFitness;
		}
		if (currentFitness < minFitness)
			minFitness = currentFitness;
		avgFitness += currentFitness;
	}
	public static String printSolutionSet(ArrayList<Solution> current, AbsFitnessCalculator fc, int j){

		Double minFitness1 = new Double(200);
		Double minFitness2 = new Double(200);
		Double maxFitness1 = new Double(-1);
		Double maxFitness2 = new Double(-1);
		Double avgFitness1 = new Double(0);
		Double avgFitness2 = new Double(0);
		String out = "";
		if(!fc.isMultiobjective()) {
			for(Solution s: current){
				Double currentFitness = fc.getFitness(s);
				if( currentFitness > maxFitness1){
					maxFitness1 = currentFitness;
				}
				if (currentFitness < minFitness1)
					minFitness1 = currentFitness;
				avgFitness1 += currentFitness;
			}
			avgFitness1 = avgFitness1/current.size();
			out += "Cycle "+j+"\n";
			out += "Number of generated Solutions = "+Solution.getCounter() +"\n";
			out += "Maximum Fitness = "+maxFitness1 +"\n";
			out += "Minimum Fitness = "+minFitness1 +"\n";
			out += "Average Fitness = "+avgFitness1 +"\n";
			out += "----------------------------------------------------------";
			out += "\n";
		} else {
			FitnessCalculatorMulti multiFc = (FitnessCalculatorMulti) fc;
			AbsFitnessCalculator fc1 = multiFc.getFc1();
			AbsFitnessCalculator fc2 = multiFc.getFc2();
			for(Solution s: current){
				Double currentFitness1 = new Double(fc1.getFitness(s));
				Double currentFitness2 = new Double(fc2.getFitness(s));
				if( currentFitness1 > maxFitness1){
					maxFitness1 = currentFitness1;
				}
				if (currentFitness1 < minFitness1)
					minFitness1 = currentFitness1;
				avgFitness1 += currentFitness1;
				if( currentFitness2 > maxFitness2){
					maxFitness2 = currentFitness2;
				}
				if (currentFitness2 < minFitness2)
					minFitness2 = currentFitness2;
				avgFitness2 += currentFitness2;
			}
			avgFitness1 = avgFitness1/current.size();
			avgFitness2 = avgFitness2/current.size();
			out += "Cycle "+j+"\n";
			out += "Number of generated Solutions = "+Solution.getCounter() +"\n";
			out += "Maximum MS Fitness = "+maxFitness2 +"\n";
			out += "Minimum MS Fitness = "+minFitness2 +"\n";
			out += "Average MS Fitness = "+avgFitness2 +"\n\n";
			out += "Maximum Ef Fitness = "+maxFitness1 +"\n";
			out += "Minimum Ef Fitness = "+minFitness1 +"\n";
			out += "Average Ef Fitness = "+avgFitness1 +"\n";
			out += "----------------------------------------------------------";
			out += "\n";
		}
		
		return out;
	}
	
	public static String printOneSolution(Solution s, AbsFitnessCalculator fc){
		String out = new String();
		out = s.toString();
		out += "\n";
		out += fc.toString(s);
		out += "\n";
		out+= "************************************************************************** \n";
		return out;
	}
}
