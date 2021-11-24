package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AnomaliesItem{

	@JsonProperty("date")
	private String date;

	@JsonProperty("original_observation")
	private double originalObservation;

	@JsonProperty("type")
	private String type;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setOriginalObservation(double originalObservation){
		this.originalObservation = originalObservation;
	}

	public double getOriginalObservation(){
		return originalObservation;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	@Override
 	public String toString(){
		return 
			"AnomaliesItem{" + 
			"date = '" + date + '\'' + 
			",original_observation = '" + originalObservation + '\'' + 
			",type = '" + type + '\'' + 
			"}";
		}
}