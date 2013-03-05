package windowBuilder;
/*
 * DataContainer is a Singleton Class 
 */

public class DataContainer {
	
	private static DataContainer instance = new DataContainer();
	
	private double PC;
	private double PM;
	private double CC;
	private double CD;
	
	private int ACrosserIndex;
	private int RCrosserIndex;
	private int AMutatorIndex;
	private int RMutatorIndex;
	private int PReplacerIndex;
	private int PSelectorIndex;
	
	private int FCalculatorIndex;
	
	public double getPC() {
		return PC;
	}

	public void setPC(double pC) {
		PC = pC;
	}

	public double getPM() {
		return PM;
	}

	public void setPM(double pM) {
		PM = pM;
	}

	public double getCC() {
		return CC;
	}

	public void setCC(double cC) {
		CC = cC;
	}

	public double getCD() {
		return CD;
	}

	public void setCD(double cD) {
		CD = cD;
	}

	public int getACrosserIndex() {
		return ACrosserIndex;
	}

	public void setACrosserIndex(int aCrosserIndex) {
		ACrosserIndex = aCrosserIndex;
	}

	public int getRCrosserIndex() {
		return RCrosserIndex;
	}

	public void setRCrosserIndex(int rCrosserIndex) {
		RCrosserIndex = rCrosserIndex;
	}

	public int getAMutatorIndex() {
		return AMutatorIndex;
	}

	public void setAMutatorIndex(int aMutatorIndex) {
		AMutatorIndex = aMutatorIndex;
	}

	public int getRMutatorIndex() {
		return RMutatorIndex;
	}

	public void setRMutatorIndex(int rMutatorIndex) {
		RMutatorIndex = rMutatorIndex;
	}

	public int getPReplacerIndex() {
		return PReplacerIndex;
	}

	public void setPReplacerIndex(int pReplacerIndex) {
		PReplacerIndex = pReplacerIndex;
	}

	public int getPSelectorIndex() {
		return PSelectorIndex;
	}

	public void setPSelectorIndex(int pSelectorIndex) {
		PSelectorIndex = pSelectorIndex;
	}

	public int getFCalculatorIndex() {
		return FCalculatorIndex;
	}

	public void setFCalculatorIndex(int fCalculatorIndex) {
		FCalculatorIndex = fCalculatorIndex;
	}

	private DataContainer(){}
	
	public static DataContainer getInstance(){
		return instance;
	}
}
