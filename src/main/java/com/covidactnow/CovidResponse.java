package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CovidResponse{

	@JsonProperty("riskLevels")
	private RiskLevels riskLevels;

	@JsonProperty("actuals")
	private Actuals actuals;

	@JsonProperty("country")
	private String country;

	@JsonProperty("level")
	private String level;

	@JsonProperty("cdcTransmissionLevel")
	private int cdcTransmissionLevel;

	@JsonProperty("county")
	private String county;

	@JsonProperty("fips")
	private String fips;

	@JsonProperty("annotations")
	private Annotations annotations;

	@JsonProperty("long")
	private Object jsonMemberLong;

	@JsonProperty("url")
	private String url;

	@JsonProperty("population")
	private int population;

	@JsonProperty("lastUpdatedDate")
	private String lastUpdatedDate;

	@JsonProperty("locationId")
	private String locationId;

	@JsonProperty("state")
	private String state;

	@JsonProperty("metrics")
	private Metrics metrics;

	@JsonProperty("lat")
	private Object lat;

	public void setRiskLevels(RiskLevels riskLevels){
		this.riskLevels = riskLevels;
	}

	public RiskLevels getRiskLevels(){
		return riskLevels;
	}

	public void setActuals(Actuals actuals){
		this.actuals = actuals;
	}

	public Actuals getActuals(){
		return actuals;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getCountry(){
		return country;
	}

	public void setLevel(String level){
		this.level = level;
	}

	public String getLevel(){
		return level;
	}

	public void setCdcTransmissionLevel(int cdcTransmissionLevel){
		this.cdcTransmissionLevel = cdcTransmissionLevel;
	}

	public int getCdcTransmissionLevel(){
		return cdcTransmissionLevel;
	}

	public void setCounty(String county){
		this.county = county;
	}

	public String getCounty(){
		return county;
	}

	public void setFips(String fips){
		this.fips = fips;
	}

	public String getFips(){
		return fips;
	}

	public void setAnnotations(Annotations annotations){
		this.annotations = annotations;
	}

	public Annotations getAnnotations(){
		return annotations;
	}

	public void setJsonMemberLong(Object jsonMemberLong){
		this.jsonMemberLong = jsonMemberLong;
	}

	public Object getJsonMemberLong(){
		return jsonMemberLong;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setPopulation(int population){
		this.population = population;
	}

	public int getPopulation(){
		return population;
	}

	public void setLastUpdatedDate(String lastUpdatedDate){
		this.lastUpdatedDate = lastUpdatedDate;
	}

	public String getLastUpdatedDate(){
		return lastUpdatedDate;
	}

	public void setLocationId(String locationId){
		this.locationId = locationId;
	}

	public String getLocationId(){
		return locationId;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setMetrics(Metrics metrics){
		this.metrics = metrics;
	}

	public Metrics getMetrics(){
		return metrics;
	}

	public void setLat(Object lat){
		this.lat = lat;
	}

	public Object getLat(){
		return lat;
	}

	@Override
 	public String toString(){
		return 
			"CovidResponse{" + 
			"riskLevels = '" + riskLevels + '\'' + 
			",actuals = '" + actuals + '\'' + 
			",country = '" + country + '\'' + 
			",level = '" + level + '\'' + 
			",cdcTransmissionLevel = '" + cdcTransmissionLevel + '\'' + 
			",county = '" + county + '\'' + 
			",fips = '" + fips + '\'' + 
			",annotations = '" + annotations + '\'' + 
			",long = '" + jsonMemberLong + '\'' + 
			",url = '" + url + '\'' + 
			",population = '" + population + '\'' + 
			",lastUpdatedDate = '" + lastUpdatedDate + '\'' + 
			",locationId = '" + locationId + '\'' + 
			",state = '" + state + '\'' + 
			",metrics = '" + metrics + '\'' + 
			",lat = '" + lat + '\'' + 
			"}";
		}
}