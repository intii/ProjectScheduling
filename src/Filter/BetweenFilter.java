package Filter;

import java.util.*;

import Structure.Resource;
import Structure.TimeRange;
public class BetweenFilter implements IFilter{
	
	private int min;
	private int max;
	private ArrayList<ArrayList<TimeRange>> usedRes;

	public BetweenFilter(int min, int max, ArrayList<ArrayList<TimeRange>> ur ) {
		this.min = min;
		this.max = max;
		this.usedRes = ur;
	}

	@Override
	public boolean isValid(Resource r){
		for(TimeRange t : this.usedRes.get(r.getId()-1)){
			if(t.isBetween(min, max)){
				return false;
			}	
		}
		return true;
	}

}
