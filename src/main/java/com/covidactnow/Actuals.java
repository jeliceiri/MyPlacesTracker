package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Actuals{

	@JsonProperty("vaccinesDistributed")
	private Object vaccinesDistributed;

	@JsonProperty("vaccinationsInitiated")
	private int vaccinationsInitiated;

	@JsonProperty("cases")
	private int cases;

	@JsonProperty("icuBeds")
	private IcuBeds icuBeds;

	@JsonProperty("hospitalBeds")
	private HospitalBeds hospitalBeds;

	@JsonProperty("vaccinesAdministered")
	private int vaccinesAdministered;

	@JsonProperty("newCases")
	private int newCases;

	@JsonProperty("vaccinationsCompleted")
	private int vaccinationsCompleted;

	@JsonProperty("negativeTests")
	private Object negativeTests;

	@JsonProperty("contactTracers")
	private Object contactTracers;

	@JsonProperty("positiveTests")
	private Object positiveTests;

	@JsonProperty("vaccinationsInitiatedDemographics")
	private VaccinationsInitiatedDemographics vaccinationsInitiatedDemographics;

	@JsonProperty("newDeaths")
	private int newDeaths;

	@JsonProperty("vaccinesAdministeredDemographics")
	private Object vaccinesAdministeredDemographics;

	@JsonProperty("deaths")
	private int deaths;

	public void setVaccinesDistributed(Object vaccinesDistributed){
		this.vaccinesDistributed = vaccinesDistributed;
	}

	public Object getVaccinesDistributed(){
		return vaccinesDistributed;
	}

	public void setVaccinationsInitiated(int vaccinationsInitiated){
		this.vaccinationsInitiated = vaccinationsInitiated;
	}

	public int getVaccinationsInitiated(){
		return vaccinationsInitiated;
	}

	public void setCases(int cases){
		this.cases = cases;
	}

	public int getCases(){
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

	public void setVaccinesAdministered(int vaccinesAdministered){
		this.vaccinesAdministered = vaccinesAdministered;
	}

	public int getVaccinesAdministered(){
		return vaccinesAdministered;
	}

	public void setNewCases(int newCases){
		this.newCases = newCases;
	}

	public int getNewCases(){
		return newCases;
	}

	public void setVaccinationsCompleted(int vaccinationsCompleted){
		this.vaccinationsCompleted = vaccinationsCompleted;
	}

	public int getVaccinationsCompleted(){
		return vaccinationsCompleted;
	}

	public void setNegativeTests(Object negativeTests){
		this.negativeTests = negativeTests;
	}

	public Object getNegativeTests(){
		return negativeTests;
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

	public void setVaccinationsInitiatedDemographics(VaccinationsInitiatedDemographics vaccinationsInitiatedDemographics){
		this.vaccinationsInitiatedDemographics = vaccinationsInitiatedDemographics;
	}

	public VaccinationsInitiatedDemographics getVaccinationsInitiatedDemographics(){
		return vaccinationsInitiatedDemographics;
	}

	public void setNewDeaths(int newDeaths){
		this.newDeaths = newDeaths;
	}

	public int getNewDeaths(){
		return newDeaths;
	}

	public void setVaccinesAdministeredDemographics(Object vaccinesAdministeredDemographics){
		this.vaccinesAdministeredDemographics = vaccinesAdministeredDemographics;
	}

	public Object getVaccinesAdministeredDemographics(){
		return vaccinesAdministeredDemographics;
	}

	public void setDeaths(int deaths){
		this.deaths = deaths;
	}

	public int getDeaths(){
		return deaths;
	}

	@Override
 	public String toString(){
		return 
			"Actuals{" + 
			"vaccinesDistributed = '" + vaccinesDistributed + '\'' + 
			",vaccinationsInitiated = '" + vaccinationsInitiated + '\'' + 
			",cases = '" + cases + '\'' + 
			",icuBeds = '" + icuBeds + '\'' + 
			",hospitalBeds = '" + hospitalBeds + '\'' + 
			",vaccinesAdministered = '" + vaccinesAdministered + '\'' + 
			",newCases = '" + newCases + '\'' + 
			",vaccinationsCompleted = '" + vaccinationsCompleted + '\'' + 
			",negativeTests = '" + negativeTests + '\'' + 
			",contactTracers = '" + contactTracers + '\'' + 
			",positiveTests = '" + positiveTests + '\'' + 
			",vaccinationsInitiatedDemographics = '" + vaccinationsInitiatedDemographics + '\'' + 
			",newDeaths = '" + newDeaths + '\'' + 
			",vaccinesAdministeredDemographics = '" + vaccinesAdministeredDemographics + '\'' + 
			",deaths = '" + deaths + '\'' + 
			"}";
		}
}