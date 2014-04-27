package DataHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import Structure.Activity;
import Structure.Resource;

public abstract class AbsDataExtractor {
	public abstract ArrayList<Activity> getListAct() throws IOException;
	public abstract boolean[][] getPrecedences() throws IOException;
	public abstract ArrayList<Resource> getResources() throws IOException;
	
	
	protected void initMatrix(boolean[][] precedence){
		
		for(int i=0;i < precedence.length; i++){
			for(int j=0;j < precedence.length; j++){
				precedence[i][j]=false;
			}
		}
	}
	protected String readFileAsString(String filePath) throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }
}
