package com.covidactnow;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class IcuBeds{

	@JsonProperty("sources")
	private List<SourcesItem> sources;

	@JsonProperty("anomalies")
	private List<Object> anomalies;

	@JsonProperty("currentUsageTotal")
	private int currentUsageTotal;

	@JsonProperty("currentUsageCovid")
	private int currentUsageCovid;

	@JsonProperty("capacity")
	private int capacity;

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

	public void setCurrentUsageTotal(int currentUsageTotal){
		this.currentUsageTotal = currentUsageTotal;
	}

	public int getCurrentUsageTotal(){
		return currentUsageTotal;
	}

	public void setCurrentUsageCovid(int currentUsageCovid){
		this.currentUsageCovid = currentUsageCovid;
	}

	public int getCurrentUsageCovid(){
		return currentUsageCovid;
	}

	public void setCapacity(int capacity){
		this.capacity = capacity;
	}

	public int getCapacity(){
		return capacity;
	}

	@Override
 	public String toString(){
		return 
			"IcuBeds{" + 
			"sources = '" + sources + '\'' + 
			",anomalies = '" + anomalies + '\'' + 
			",currentUsageTotal = '" + currentUsageTotal + '\'' + 
			",currentUsageCovid = '" + currentUsageCovid + '\'' + 
			",capacity = '" + capacity + '\'' + 
			"}";
		}
}