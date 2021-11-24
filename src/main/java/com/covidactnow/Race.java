package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Race{

	@JsonProperty("other")
	private int other;

	@JsonProperty("white")
	private int white;

	@JsonProperty("asian")
	private int asian;

	@JsonProperty("black")
	private int black;

	@JsonProperty("middle_eastern_or_north_africa")
	private int middleEasternOrNorthAfrica;

	@JsonProperty("ai_an")
	private int aiAn;

	@JsonProperty("pacific_islander")
	private int pacificIslander;

	@JsonProperty("unknown")
	private int unknown;

	public void setOther(int other){
		this.other = other;
	}

	public int getOther(){
		return other;
	}

	public void setWhite(int white){
		this.white = white;
	}

	public int getWhite(){
		return white;
	}

	public void setAsian(int asian){
		this.asian = asian;
	}

	public int getAsian(){
		return asian;
	}

	public void setBlack(int black){
		this.black = black;
	}

	public int getBlack(){
		return black;
	}

	public void setMiddleEasternOrNorthAfrica(int middleEasternOrNorthAfrica){
		this.middleEasternOrNorthAfrica = middleEasternOrNorthAfrica;
	}

	public int getMiddleEasternOrNorthAfrica(){
		return middleEasternOrNorthAfrica;
	}

	public void setAiAn(int aiAn){
		this.aiAn = aiAn;
	}

	public int getAiAn(){
		return aiAn;
	}

	public void setPacificIslander(int pacificIslander){
		this.pacificIslander = pacificIslander;
	}

	public int getPacificIslander(){
		return pacificIslander;
	}

	public void setUnknown(int unknown){
		this.unknown = unknown;
	}

	public int getUnknown(){
		return unknown;
	}

	@Override
 	public String toString(){
		return 
			"Race{" + 
			"other = '" + other + '\'' + 
			",white = '" + white + '\'' + 
			",asian = '" + asian + '\'' + 
			",black = '" + black + '\'' + 
			",middle_eastern_or_north_africa = '" + middleEasternOrNorthAfrica + '\'' + 
			",ai_an = '" + aiAn + '\'' + 
			",pacific_islander = '" + pacificIslander + '\'' + 
			",unknown = '" + unknown + '\'' + 
			"}";
		}
}