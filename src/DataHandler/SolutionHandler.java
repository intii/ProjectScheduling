package DataHandler;
import java.io.IOException;
import java.util.*;

import Structure.Activity;
import Structure.Resource;
public class SolutionHandler {

	private boolean[][] precedenceMatrix;
	private ArrayList<Resource> resources;
	private ArrayList<Activity> activities;
	
	private AbsDataExtractor extractor;
	
	public SolutionHandler(int activities, int resources, int skills){
		//this.extractor = new StructMaker(activities, resources, skills);
		try {
			this.extractor = new JSONExtractor();
			this.precedenceMatrix = extractor.getPrecedences();
			this.resources = extractor.getResources();
			this.activities = extractor.getListAct();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void initMatrix(boolean[][] precedence){
		
		for(int i=0;i < precedence.length; i++){
			for(int j=0;j < precedence[i].length; j++){
				precedence[i][j]=false;
			}
		}
	}
	
	public void getAssignedResources(ArrayList<ArrayList<Resource>> res, boolean[][] a){
			
		for(int i =0; i < res.size(); i++){
			ArrayList<Resource> aux = res.get(i);
			for(int j =0; j < aux.size(); j++){
				a[aux.get(j).getId()-1][i] = true;
			}
		}
	}
	
	public boolean isPredecessor(int i, int j){
	//returns true if i is a predecessor of j
		return this.precedenceMatrix[i][j];
	}
	
	public boolean isSuccessor(int i, int j){
		//returns true if i is a successor of j
		return this.precedenceMatrix[j][i];
	}
	
	public ArrayList<Resource> getResources(){
		return this.resources ;
	}
		
	public boolean[][] getPrecedenceMatrix() {
		return this.precedenceMatrix;
	}

	public ArrayList<Activity> getActivities() {
		return this.activities;
	}



}
