package DataHandler;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import Structure.Activity;
import Structure.Resource;

public class JSONExtractor extends AbsDataExtractor {
	private static final String activityFilePath = "projectData.json";
	private static final String resourceFilePath = "resourceData.json";
	
	private JSONArray activities;
	private JSONArray resources;
	
	public JSONExtractor() {
		String activityFile;
		String resourceFile;
		try {
			activityFile = this.readFileAsString(activityFilePath);
			resourceFile = this.readFileAsString(resourceFilePath);
			this.activities = (JSONArray)JSONValue.parse(activityFile);
			this.resources = (JSONArray)JSONValue.parse(resourceFile);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<Activity> getListAct() throws IOException {
		ArrayList<Activity> activityList = new ArrayList<Activity>();
		int id,duration;
		int[] res;
		for(Object obj : this.activities) {
			JSONObject activity = (JSONObject) obj;
			JSONArray array = (JSONArray)activity.get("resources");
			
			id = ((Long)activity.get("id")).intValue();
			duration = ((Long)activity.get("duration")).intValue();
			
			res = new int[array.size()];
			for (int i = 0; i < array.size(); i++) {
				res[i] = ((Long) array.get(i)).intValue();
			}
			
			activityList.add(new Activity(id, duration, res));
		}
		return activityList;
	}

	@Override
	public boolean[][] getPrecedences() throws IOException {
		int matrixSize = this.activities.size();
		boolean [][] matrix = new boolean[matrixSize][matrixSize];
		this.initMatrix(matrix);
		int value;
		int index = 0;
		
		for(Object obj: this.activities) {
			JSONObject activity = (JSONObject) obj;
			JSONArray successors = (JSONArray) activity.get("successors");
			for(Object successor: successors) {
				value =  ((Long) successor).intValue();
				matrix[index][value-1] = true;
			}
			index++;
		}
		
		return matrix;
	}

	@Override
	public ArrayList<Resource> getResources() throws IOException {
		ArrayList<Resource> resources = new ArrayList<Resource>();
		int id,skill;
		double effectiveness;
		for(Object obj: this.resources) {
			JSONObject resource = (JSONObject) obj;
			id = ((Long)resource.get("id")).intValue();
			skill = ((Long)resource.get("skill")).intValue();
			effectiveness = ((Double)resource.get("effectiveness")).doubleValue();
			resources.add(new Resource(id, skill, effectiveness));
		}
		
		return resources;
	}

}
