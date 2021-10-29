package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Race{

	@JsonProperty("white")
	private int white;

	@JsonProperty("asian")
	private int asian;

	@JsonProperty("black")
	private int black;

	@JsonProperty("ai_an")
	private int aiAn;

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

	public void setAiAn(int aiAn){
		this.aiAn = aiAn;
	}

	public int getAiAn(){
		return aiAn;
	}

	@Override
 	public String toString(){
		return 
			"Race{" + 
			"white = '" + white + '\'' + 
			",asian = '" + asian + '\'' + 
			",black = '" + black + '\'' + 
			",ai_an = '" + aiAn + '\'' + 
			"}";
		}
}