package com.smartystreets;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ZipcodesItem{

    @JsonProperty("zipcode")
    private String zipcode;

    @JsonProperty("zipcode_type")
    private String zipcodeType;

    @JsonProperty("county_fips")
    private String countyFips;

    @JsonProperty("latitude")
    private double latitude;

    @JsonProperty("precision")
    private String precision;

    @JsonProperty("state_abbreviation")
    private String stateAbbreviation;

    @JsonProperty("state")
    private String state;

    @JsonProperty("county_name")
    private String countyName;

    @JsonProperty("default_city")
    private String defaultCity;

    @JsonProperty("longitude")
    private double longitude;

    public void setZipcode(String zipcode){
        this.zipcode = zipcode;
    }

    public String getZipcode(){
        return zipcode;
    }

    public void setZipcodeType(String zipcodeType){
        this.zipcodeType = zipcodeType;
    }

    public String getZipcodeType(){
        return zipcodeType;
    }

    public void setCountyFips(String countyFips){
        this.countyFips = countyFips;
    }

    public String getCountyFips(){
        return countyFips;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }

    public double getLatitude(){
        return latitude;
    }

    public void setPrecision(String precision){
        this.precision = precision;
    }

    public String getPrecision(){
        return precision;
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

    public void setCountyName(String countyName){
        this.countyName = countyName;
    }

    public String getCountyName(){
        return countyName;
    }

    public void setDefaultCity(String defaultCity){
        this.defaultCity = defaultCity;
    }

    public String getDefaultCity(){
        return defaultCity;
    }

    public void setLongitude(double longitude){
        this.longitude = longitude;
    }

    public double getLongitude(){
        return longitude;
    }

    @Override
     public String toString(){
        return 
            "ZipcodesItem{" + 
            "zipcode = '" + zipcode + '\'' + 
            ",zipcode_type = '" + zipcodeType + '\'' + 
            ",county_fips = '" + countyFips + '\'' + 
            ",latitude = '" + latitude + '\'' + 
            ",precision = '" + precision + '\'' + 
            ",state_abbreviation = '" + stateAbbreviation + '\'' + 
            ",state = '" + state + '\'' + 
            ",county_name = '" + countyName + '\'' + 
            ",default_city = '" + defaultCity + '\'' + 
            ",longitude = '" + longitude + '\'' + 
            "}";
        }
}