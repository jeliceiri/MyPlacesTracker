package com.covidactnow;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewDeaths{

	@JsonProperty("sources")
	private List<Object> sources;

	@JsonProperty("anomalies")
	private List<AnomaliesItem> anomalies;

	public void setSources(List<Object> sources){
		this.sources = sources;
	}

	public List<Object> getSources(){
		return sources;
	}

	public void setAnomalies(List<AnomaliesItem> anomalies){
		this.anomalies = anomalies;
	}

	public List<AnomaliesItem> getAnomalies(){
		return anomalies;
	}

	@Override
 	public String toString(){
		return 
			"NewDeaths{" + 
			"sources = '" + sources + '\'' + 
			",anomalies = '" + anomalies + '\'' + 
			"}";
		}
}