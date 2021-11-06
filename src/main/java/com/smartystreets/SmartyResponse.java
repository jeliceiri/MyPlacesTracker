package com.smartystreets;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SmartyResponse{

	@JsonProperty("SmartyResponse")
	private List<SmartyResponseItem> smartyResponse;

	public void setSmartyResponse(List<SmartyResponseItem> smartyResponse){
		this.smartyResponse = smartyResponse;
	}

	public List<SmartyResponseItem> getSmartyResponse(){
		return smartyResponse;
	}

	@Override
 	public String toString(){
		return 
			"SmartyResponse{" + 
			"smartyResponse = '" + smartyResponse + '\'' + 
			"}";
		}
}