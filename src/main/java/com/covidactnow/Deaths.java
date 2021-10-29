package com.covidactnow;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Deaths{

	@JsonProperty("sources")
	private List<SourcesItem> sources;

	@JsonProperty("anomalies")
	private List<Object> anomalies;

	public void setSources(List<SourcesItem> sources){
		this.sources = sources;
	}

	public List<SourcesItem> getSources(){
		return sources;
	}

	public void setAnomalies(List<Object> anomalies){
		this.anomalies = anomalies;
	}

	public List<Object> getAnomalies(){
		return anomalies;
	}

	@Override
 	public String toString(){
		return 
			"Deaths{" + 
			"sources = '" + sources + '\'' + 
			",anomalies = '" + anomalies + '\'' + 
			"}";
		}
}