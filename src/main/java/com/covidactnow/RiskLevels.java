package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RiskLevels{

	@JsonProperty("testPositivityRatio")
	private int testPositivityRatio;

	@JsonProperty("infectionRate")
	private int infectionRate;

	@JsonProperty("caseDensity")
	private int caseDensity;

	@JsonProperty("overall")
	private int overall;

	@JsonProperty("contactTracerCapacityRatio")
	private int contactTracerCapacityRatio;

	@JsonProperty("icuCapacityRatio")
	private int icuCapacityRatio;

	public void setTestPositivityRatio(int testPositivityRatio){
		this.testPositivityRatio = testPositivityRatio;
	}

	public int getTestPositivityRatio(){
		return testPositivityRatio;
	}

	public void setInfectionRate(int infectionRate){
		this.infectionRate = infectionRate;
	}

	public int getInfectionRate(){
		return infectionRate;
	}

	public void setCaseDensity(int caseDensity){
		this.caseDensity = caseDensity;
	}

	public int getCaseDensity(){
		return caseDensity;
	}

	public void setOverall(int overall){
		this.overall = overall;
	}

	public int getOverall(){
		return overall;
	}

	public void setContactTracerCapacityRatio(int contactTracerCapacityRatio){
		this.contactTracerCapacityRatio = contactTracerCapacityRatio;
	}

	public int getContactTracerCapacityRatio(){
		return contactTracerCapacityRatio;
	}

	public void setIcuCapacityRatio(int icuCapacityRatio){
		this.icuCapacityRatio = icuCapacityRatio;
	}

	public int getIcuCapacityRatio(){
		return icuCapacityRatio;
	}

	@Override
 	public String toString(){
		return 
			"RiskLevels{" + 
			"testPositivityRatio = '" + testPositivityRatio + '\'' + 
			",infectionRate = '" + infectionRate + '\'' + 
			",caseDensity = '" + caseDensity + '\'' + 
			",overall = '" + overall + '\'' + 
			",contactTracerCapacityRatio = '" + contactTracerCapacityRatio + '\'' + 
			",icuCapacityRatio = '" + icuCapacityRatio + '\'' + 
			"}";
		}
}