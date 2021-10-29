package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Ethnicity{

	@JsonProperty("non-hispanic")
	private int nonHispanic;

	@JsonProperty("hispanic")
	private int hispanic;

	public void setNonHispanic(int nonHispanic){
		this.nonHispanic = nonHispanic;
	}

	public int getNonHispanic(){
		return nonHispanic;
	}

	public void setHispanic(int hispanic){
		this.hispanic = hispanic;
	}

	public int getHispanic(){
		return hispanic;
	}

	@Override
 	public String toString(){
		return 
			"Ethnicity{" + 
			"non-hispanic = '" + nonHispanic + '\'' + 
			",hispanic = '" + hispanic + '\'' + 
			"}";
		}
}