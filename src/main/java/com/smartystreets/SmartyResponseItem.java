package com.smartystreets;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SmartyResponseItem{

    @JsonProperty("zipcodes")
    private List<ZipcodesItem> zipcodes;

    @JsonProperty("city_states")
    private List<CityStatesItem> cityStates;

    @JsonProperty("input_index")
    private int inputIndex;

    public void setZipcodes(List<ZipcodesItem> zipcodes){
        this.zipcodes = zipcodes;
    }

    public List<ZipcodesItem> getZipcodes(){
        return zipcodes;
    }

    public void setCityStates(List<CityStatesItem> cityStates){
        this.cityStates = cityStates;
    }

    public List<CityStatesItem> getCityStates(){
        return cityStates;
    }

    public void setInputIndex(int inputIndex){
        this.inputIndex = inputIndex;
    }

    public int getInputIndex(){
        return inputIndex;
    }

    @Override
     public String toString(){
        return 
            "SmartyResponseItem{" + 
            "zipcodes = '" + zipcodes + '\'' + 
            ",city_states = '" + cityStates + '\'' + 
            ",input_index = '" + inputIndex + '\'' + 
            "}";
        }
}