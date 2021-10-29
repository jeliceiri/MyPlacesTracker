package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Metrics{

	@JsonProperty("testPositivityRatio")
	private double testPositivityRatio;

	@JsonProperty("infectionRate")
	private double infectionRate;

	@JsonProperty("caseDensity")
	private double caseDensity;

	@JsonProperty("testPositivityRatioDetails")
	private TestPositivityRatioDetails testPositivityRatioDetails;

	@JsonProperty("contactTracerCapacityRatio")
	private Object contactTracerCapacityRatio;

	@JsonProperty("infectionRateCI90")
	private double infectionRateCI90;

	@JsonProperty("vaccinationsCompletedRatio")
	private double vaccinationsCompletedRatio;

	@JsonProperty("icuCapacityRatio")
	private double icuCapacityRatio;

	@JsonProperty("vaccinationsInitiatedRatio")
	private double vaccinationsInitiatedRatio;

	public void setTestPositivityRatio(double testPositivityRatio){
		this.testPositivityRatio = testPositivityRatio;
	}

	public double getTestPositivityRatio(){
		return testPositivityRatio;
	}

	public void setInfectionRate(double infectionRate){
		this.infectionRate = infectionRate;
	}

	public double getInfectionRate(){
		return infectionRate;
	}

	public void setCaseDensity(double caseDensity){
		this.caseDensity = caseDensity;
	}

	public double getCaseDensity(){
		return caseDensity;
	}

	public void setTestPositivityRatioDetails(TestPositivityRatioDetails testPositivityRatioDetails){
		this.testPositivityRatioDetails = testPositivityRatioDetails;
	}

	public TestPositivityRatioDetails getTestPositivityRatioDetails(){
		return testPositivityRatioDetails;
	}

	public void setContactTracerCapacityRatio(Object contactTracerCapacityRatio){
		this.contactTracerCapacityRatio = contactTracerCapacityRatio;
	}

	public Object getContactTracerCapacityRatio(){
		return contactTracerCapacityRatio;
	}

	public void setInfectionRateCI90(double infectionRateCI90){
		this.infectionRateCI90 = infectionRateCI90;
	}

	public double getInfectionRateCI90(){
		return infectionRateCI90;
	}

	public void setVaccinationsCompletedRatio(double vaccinationsCompletedRatio){
		this.vaccinationsCompletedRatio = vaccinationsCompletedRatio;
	}

	public double getVaccinationsCompletedRatio(){
		return vaccinationsCompletedRatio;
	}

	public void setIcuCapacityRatio(double icuCapacityRatio){
		this.icuCapacityRatio = icuCapacityRatio;
	}

	public double getIcuCapacityRatio(){
		return icuCapacityRatio;
	}

	public void setVaccinationsInitiatedRatio(double vaccinationsInitiatedRatio){
		this.vaccinationsInitiatedRatio = vaccinationsInitiatedRatio;
	}

	public double getVaccinationsInitiatedRatio(){
		return vaccinationsInitiatedRatio;
	}

	@Override
 	public String toString(){
		return 
			"Metrics{" + 
			"testPositivityRatio = '" + testPositivityRatio + '\'' + 
			",infectionRate = '" + infectionRate + '\'' + 
			",caseDensity = '" + caseDensity + '\'' + 
			",testPositivityRatioDetails = '" + testPositivityRatioDetails + '\'' + 
			",contactTracerCapacityRatio = '" + contactTracerCapacityRatio + '\'' + 
			",infectionRateCI90 = '" + infectionRateCI90 + '\'' + 
			",vaccinationsCompletedRatio = '" + vaccinationsCompletedRatio + '\'' + 
			",icuCapacityRatio = '" + icuCapacityRatio + '\'' + 
			",vaccinationsInitiatedRatio = '" + vaccinationsInitiatedRatio + '\'' + 
			"}";
		}
}