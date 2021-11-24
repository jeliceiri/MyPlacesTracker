package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ethnicity{

	@JsonProperty("hispanic")
	private int hispanic;

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
			"hispanic = '" + hispanic + '\'' +
			"}";
		}
}