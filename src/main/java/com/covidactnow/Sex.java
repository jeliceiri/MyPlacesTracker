package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Sex{

	@JsonProperty("female")
	private int female;

	@JsonProperty("male")
	private int male;

	public void setFemale(int female){
		this.female = female;
	}

	public int getFemale(){
		return female;
	}

	public void setMale(int male){
		this.male = male;
	}

	public int getMale(){
		return male;
	}

	@Override
 	public String toString(){
		return 
			"Sex{" + 
			"female = '" + female + '\'' + 
			",male = '" + male + '\'' + 
			"}";
		}
}