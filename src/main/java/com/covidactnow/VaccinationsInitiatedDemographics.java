package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VaccinationsInitiatedDemographics{

	@JsonProperty("race")
	private Race race;

	@JsonProperty("ethnicity")
	private Ethnicity ethnicity;

	@JsonProperty("sex")
	private Object sex;

	@JsonProperty("age")
	private Object age;

	public void setRace(Race race){
		this.race = race;
	}

	public Race getRace(){
		return race;
	}

	public void setEthnicity(Ethnicity ethnicity){
		this.ethnicity = ethnicity;
	}

	public Ethnicity getEthnicity(){
		return ethnicity;
	}

	public void setSex(Object sex){
		this.sex = sex;
	}

	public Object getSex(){
		return sex;
	}

	public void setAge(Object age){
		this.age = age;
	}

	public Object getAge(){
		return age;
	}

	@Override
 	public String toString(){
		return 
			"VaccinationsInitiatedDemographics{" + 
			"race = '" + race + '\'' + 
			",ethnicity = '" + ethnicity + '\'' + 
			",sex = '" + sex + '\'' + 
			",age = '" + age + '\'' + 
			"}";
		}
}