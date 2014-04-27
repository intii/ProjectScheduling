package Representation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import FitnessCalculator.AbsFitnessCalculator;
import Structure.Solution;


public class ParetoSet {

	private AbsFitnessCalculator fc;
	private ArrayList<Solution> initialSolutions;
	
	public ParetoSet(AbsFitnessCalculator fc, ArrayList<Solution> solutions){
		this.fc = fc;
		this.initialSolutions = solutions;
		this.fc.fitnessLoader(solutions);
	}
	
	public HashSet<Solution> getSet(){
		HashSet<Solution> result = new HashSet<Solution>( );
		for( Solution s2 : this.initialSolutions){
			boolean dominated = false;
			Iterator<Solution> it = this.initialSolutions.iterator();
			while( it.hasNext() && !dominated ) {
				Solution s1 = it.next();
				if( this.fc.isDominated( s2, s1 ) ) {
					dominated = true;
				}
			}
			if(!dominated)
				result.add(s2);
		}
		return result; 
	}
}
