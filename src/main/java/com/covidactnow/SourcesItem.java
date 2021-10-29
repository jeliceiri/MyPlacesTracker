package com.covidactnow;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SourcesItem{

	@JsonProperty("name")
	private String name;

	@JsonProperty("type")
	private String type;

	@JsonProperty("url")
	private String url;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	@Override
 	public String toString(){
		return 
			"SourcesItem{" + 
			"name = '" + name + '\'' + 
			",type = '" + type + '\'' + 
			",url = '" + url + '\'' + 
			"}";
		}
}