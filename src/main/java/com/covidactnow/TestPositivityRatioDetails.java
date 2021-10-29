package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestPositivityRatioDetails{

	@JsonProperty("source")
	private String source;

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	@Override
 	public String toString(){
		return 
			"TestPositivityRatioDetails{" + 
			"source = '" + source + '\'' + 
			"}";
		}
}