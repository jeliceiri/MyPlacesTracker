package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Annotations{

	@JsonProperty("vaccinesDistributed")
	private Object vaccinesDistributed;

	@JsonProperty("vaccinationsInitiated")
	private VaccinationsInitiated vaccinationsInitiated;

	@JsonProperty("cases")
	private Cases cases;

	@JsonProperty("icuBeds")
	private IcuBeds icuBeds;

	@JsonProperty("hospitalBeds")
	private HospitalBeds hospitalBeds;

	@JsonProperty("vaccinesAdministered")
	private Object vaccinesAdministered;

	@JsonProperty("infectionRate")
	private InfectionRate infectionRate;

	@JsonProperty("newCases")
	private Object newCases;

	@JsonProperty("caseDensity")
	private CaseDensity caseDensity;

	@JsonProperty("vaccinationsCompleted")
	private VaccinationsCompleted vaccinationsCompleted;

	@JsonProperty("contactTracerCapacityRatio")
	private Object contactTracerCapacityRatio;

	@JsonProperty("infectionRateCI90")
	private InfectionRateCI90 infectionRateCI90;

	@JsonProperty("negativeTests")
	private Object negativeTests;

	@JsonProperty("icuCapacityRatio")
	private IcuCapacityRatio icuCapacityRatio;

	@JsonProperty("vaccinationsInitiatedRatio")
	private Object vaccinationsInitiatedRatio;

	@JsonProperty("contactTracers")
	private Object contactTracers;

	@JsonProperty("positiveTests")
	private Object positiveTests;

	@JsonProperty("testPositivityRatio")
	private TestPositivityRatio testPositivityRatio;

	@JsonProperty("newDeaths")
	private Object newDeaths;

	@JsonProperty("vaccinationsCompletedRatio")
	private Object vaccinationsCompletedRatio;

	@JsonProperty("deaths")
	private Deaths deaths;

	public void setVaccinesDistributed(Object vaccinesDistributed){
		this.vaccinesDistributed = vaccinesDistributed;
	}

	public Object getVaccinesDistributed(){
		return vaccinesDistributed;
	}

	public void setVaccinationsInitiated(VaccinationsInitiated vaccinationsInitiated){
		this.vaccinationsInitiated = vaccinationsInitiated;
	}

	public VaccinationsInitiated getVaccinationsInitiated(){
		return vaccinationsInitiated;
	}

	public void setCases(Cases cases){
		this.cases = cases;
	}

	public Cases getCases(){
		return cases;
	}

	public void setIcuBeds(IcuBeds icuBeds){
		this.icuBeds = icuBeds;
	}

	public IcuBeds getIcuBeds(){
		return icuBeds;
	}

	public void setHospitalBeds(HospitalBeds hospitalBeds){
		this.hospitalBeds = hospitalBeds;
	}

	public HospitalBeds getHospitalBeds(){
		return hospitalBeds;
	}

	public void setVaccinesAdministered(Object vaccinesAdministered){
		this.vaccinesAdministered = vaccinesAdministered;
	}

	public Object getVaccinesAdministered(){
		return vaccinesAdministered;
	}

	public void setInfectionRate(InfectionRate infectionRate){
		this.infectionRate = infectionRate;
	}

	public InfectionRate getInfectionRate(){
		return infectionRate;
	}

	public void setNewCases(Object newCases){
		this.newCases = newCases;
	}

	public Object getNewCases(){
		return newCases;
	}

	public void setCaseDensity(CaseDensity caseDensity){
		this.caseDensity = caseDensity;
	}

	public CaseDensity getCaseDensity(){
		return caseDensity;
	}

	public void setVaccinationsCompleted(VaccinationsCompleted vaccinationsCompleted){
		this.vaccinationsCompleted = vaccinationsCompleted;
	}

	public VaccinationsCompleted getVaccinationsCompleted(){
		return vaccinationsCompleted;
	}

	public void setContactTracerCapacityRatio(Object contactTracerCapacityRatio){
		this.contactTracerCapacityRatio = contactTracerCapacityRatio;
	}

	public Object getContactTracerCapacityRatio(){
		return contactTracerCapacityRatio;
	}

	public void setInfectionRateCI90(InfectionRateCI90 infectionRateCI90){
		this.infectionRateCI90 = infectionRateCI90;
	}

	public InfectionRateCI90 getInfectionRateCI90(){
		return infectionRateCI90;
	}

	public void setNegativeTests(Object negativeTests){
		this.negativeTests = negativeTests;
	}

	public Object getNegativeTests(){
		return negativeTests;
	}

	public void setIcuCapacityRatio(IcuCapacityRatio icuCapacityRatio){
		this.icuCapacityRatio = icuCapacityRatio;
	}

	public IcuCapacityRatio getIcuCapacityRatio(){
		return icuCapacityRatio;
	}

	public void setVaccinationsInitiatedRatio(Object vaccinationsInitiatedRatio){
		this.vaccinationsInitiatedRatio = vaccinationsInitiatedRatio;
	}

	public Object getVaccinationsInitiatedRatio(){
		return vaccinationsInitiatedRatio;
	}

	public void setContactTracers(Object contactTracers){
		this.contactTracers = contactTracers;
	}

	public Object getContactTracers(){
		return contactTracers;
	}

	public void setPositiveTests(Object positiveTests){
		this.positiveTests = positiveTests;
	}

	public Object getPositiveTests(){
		return positiveTests;
	}

	public void setTestPositivityRatio(TestPositivityRatio testPositivityRatio){
		this.testPositivityRatio = testPositivityRatio;
	}

	public TestPositivityRatio getTestPositivityRatio(){
		return testPositivityRatio;
	}

	public void setNewDeaths(Object newDeaths){
		this.newDeaths = newDeaths;
	}

	public Object getNewDeaths(){
		return newDeaths;
	}

	public void setVaccinationsCompletedRatio(Object vaccinationsCompletedRatio){
		this.vaccinationsCompletedRatio = vaccinationsCompletedRatio;
	}

	public Object getVaccinationsCompletedRatio(){
		return vaccinationsCompletedRatio;
	}

	public void setDeaths(Deaths deaths){
		this.deaths = deaths;
	}

	public Deaths getDeaths(){
		return deaths;
	}

	@Override
 	public String toString(){
		return 
			"Annotations{" + 
			"vaccinesDistributed = '" + vaccinesDistributed + '\'' + 
			",vaccinationsInitiated = '" + vaccinationsInitiated + '\'' + 
			",cases = '" + cases + '\'' + 
			",icuBeds = '" + icuBeds + '\'' + 
			",hospitalBeds = '" + hospitalBeds + '\'' + 
			",vaccinesAdministered = '" + vaccinesAdministered + '\'' + 
			",infectionRate = '" + infectionRate + '\'' + 
			",newCases = '" + newCases + '\'' + 
			",caseDensity = '" + caseDensity + '\'' + 
			",vaccinationsCompleted = '" + vaccinationsCompleted + '\'' + 
			",contactTracerCapacityRatio = '" + contactTracerCapacityRatio + '\'' + 
			",infectionRateCI90 = '" + infectionRateCI90 + '\'' + 
			",negativeTests = '" + negativeTests + '\'' + 
			",icuCapacityRatio = '" + icuCapacityRatio + '\'' + 
			",vaccinationsInitiatedRatio = '" + vaccinationsInitiatedRatio + '\'' + 
			",contactTracers = '" + contactTracers + '\'' + 
			",positiveTests = '" + positiveTests + '\'' + 
			",testPositivityRatio = '" + testPositivityRatio + '\'' + 
			",newDeaths = '" + newDeaths + '\'' + 
			",vaccinationsCompletedRatio = '" + vaccinationsCompletedRatio + '\'' + 
			",deaths = '" + deaths + '\'' + 
			"}";
		}
}