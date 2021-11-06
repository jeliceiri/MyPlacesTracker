package com.smartystreets;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AlternateCountiesItem{

	@JsonProperty("county_fips")
	private String countyFips;

	@JsonProperty("state_abbreviation")
	private String stateAbbreviation;

	@JsonProperty("state")
	private String state;

	@JsonProperty("county_name")
	private String countyName;

	public void setCountyFips(String countyFips){
		this.countyFips = countyFips;
	}

	public String getCountyFips(){
		return countyFips;
	}

	public void setStateAbbreviation(String stateAbbreviation){
		this.stateAbbreviation = stateAbbreviation;
	}

	public String getStateAbbreviation(){
		return stateAbbreviation;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setCountyName(String countyName){
		this.countyName = countyName;
	}

	public String getCountyName(){
		return countyName;
	}

	@Override
 	public String toString(){
		return 
			"AlternateCountiesItem{" + 
			"county_fips = '" + countyFips + '\'' + 
			",state_abbreviation = '" + stateAbbreviation + '\'' + 
			",state = '" + state + '\'' + 
			",county_name = '" + countyName + '\'' + 
			"}";
		}
}