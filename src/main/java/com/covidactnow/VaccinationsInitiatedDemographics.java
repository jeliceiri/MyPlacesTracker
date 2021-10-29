package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VaccinationsInitiatedDemographics{

	@JsonProperty("race")
	private Race race;

	@JsonProperty("ethnicity")
	private Ethnicity ethnicity;

	@JsonProperty("sex")
	private Sex sex;

	@JsonProperty("age")
	private Age age;

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

	public void setSex(Sex sex){
		this.sex = sex;
	}

	public Sex getSex(){
		return sex;
	}

	public void setAge(Age age){
		this.age = age;
	}

	public Age getAge(){
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