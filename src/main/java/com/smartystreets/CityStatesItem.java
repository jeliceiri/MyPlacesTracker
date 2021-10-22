package com.smartystreets;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CityStatesItem{

    @JsonProperty("city")
    private String city;

    @JsonProperty("state_abbreviation")
    private String stateAbbreviation;

    @JsonProperty("state")
    private String state;

    @JsonProperty("mailable_city")
    private boolean mailableCity;

    public void setCity(String city){
        this.city = city;
    }

    public String getCity(){
        return city;
    }

    public void setStateAbbreviation(String stateAbbreviation){
        this.stateAbbreviation = stateAbbreviation;
    }

    public String getStateAbbreviation(){
        return stateAbbreviation;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getState(){
        return state;
    }

    public void setMailableCity(boolean mailableCity){
        this.mailableCity = mailableCity;
    }

    public boolean isMailableCity(){
        return mailableCity;
    }

    @Override
     public String toString(){
        return 
            "CityStatesItem{" + 
            "city = '" + city + '\'' + 
            ",state_abbreviation = '" + stateAbbreviation + '\'' + 
            ",state = '" + state + '\'' + 
            ",mailable_city = '" + mailableCity + '\'' + 
            "}";
        }
}