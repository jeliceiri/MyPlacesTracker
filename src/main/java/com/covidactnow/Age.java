package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Age{

	@JsonProperty("25-34")
	private int jsonMember2534;

	@JsonProperty("18-24")
	private int jsonMember1824;

	@JsonProperty("16-17")
	private int jsonMember1617;

	@JsonProperty("55-64")
	private int jsonMember5564;

	@JsonProperty("12-15")
	private int jsonMember1215;

	@JsonProperty("65_plus")
	private int jsonMember65Plus;

	@JsonProperty("35-44")
	private int jsonMember3544;

	@JsonProperty("45-54")
	private int jsonMember4554;

	public void setJsonMember2534(int jsonMember2534){
		this.jsonMember2534 = jsonMember2534;
	}

	public int getJsonMember2534(){
		return jsonMember2534;
	}

	public void setJsonMember1824(int jsonMember1824){
		this.jsonMember1824 = jsonMember1824;
	}

	public int getJsonMember1824(){
		return jsonMember1824;
	}

	public void setJsonMember1617(int jsonMember1617){
		this.jsonMember1617 = jsonMember1617;
	}

	public int getJsonMember1617(){
		return jsonMember1617;
	}

	public void setJsonMember5564(int jsonMember5564){
		this.jsonMember5564 = jsonMember5564;
	}

	public int getJsonMember5564(){
		return jsonMember5564;
	}

	public void setJsonMember1215(int jsonMember1215){
		this.jsonMember1215 = jsonMember1215;
	}

	public int getJsonMember1215(){
		return jsonMember1215;
	}

	public void setJsonMember65Plus(int jsonMember65Plus){
		this.jsonMember65Plus = jsonMember65Plus;
	}

	public int getJsonMember65Plus(){
		return jsonMember65Plus;
	}

	public void setJsonMember3544(int jsonMember3544){
		this.jsonMember3544 = jsonMember3544;
	}

	public int getJsonMember3544(){
		return jsonMember3544;
	}

	public void setJsonMember4554(int jsonMember4554){
		this.jsonMember4554 = jsonMember4554;
	}

	public int getJsonMember4554(){
		return jsonMember4554;
	}

	@Override
 	public String toString(){
		return 
			"Age{" + 
			"25-34 = '" + jsonMember2534 + '\'' + 
			",18-24 = '" + jsonMember1824 + '\'' + 
			",16-17 = '" + jsonMember1617 + '\'' + 
			",55-64 = '" + jsonMember5564 + '\'' + 
			",12-15 = '" + jsonMember1215 + '\'' + 
			",65_plus = '" + jsonMember65Plus + '\'' + 
			",35-44 = '" + jsonMember3544 + '\'' + 
			",45-54 = '" + jsonMember4554 + '\'' + 
			"}";
		}
}