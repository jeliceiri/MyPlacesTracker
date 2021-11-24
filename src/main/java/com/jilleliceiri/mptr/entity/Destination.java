package com.jilleliceiri.mptr.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * The type Destination.
 */
@Entity(name = "Destination")
@Table(name = "destinations")
public class Destination {

    // TODO add DestinationDao tests
    // TODO will need another dao test on entity for delete

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @NotEmpty
    private String city;

    // two digits
    @NotEmpty
    @Size(min = 2, max = 2, message = "must be two digits")
    private String state;

    // 5 digits https://www.zipcodeapi.com/API#locToZips or https://www.smartystreets.com/products/apis/us-zipcode-api
    private String zipCode;

    // 5 digits https://www.smartystreets.com/products/apis/us-zipcode-api
    private String countyFipsCode;

    // https://api.covidactnow.org/v2/county/26103.json?apiKey=78de86dd6d95400cb27a7bfdbfe4b47d
    private String countyHospitalCapacity;

    // https://covidactnow.org/covid-risk-levels-metrics

    @ManyToOne
    private Trip trip;

    /**
     * Instantiates a new Destination.
     */
    public Destination() {
    }

    /**
     * Instantiates a new Destination.
     *
     * @param city the city
     * @param trip the trip
     */
    public Destination(String city, Trip trip) {
        this.city = city;
        this.trip = trip;
    }

    /**
     * Instantiates a new Destination.
     *
     * @param city                   the city
     * @param state                  the state
     * @param zipCode                the zip code
     * @param countyFipsCode         the county fips code
     * @param countyHospitalCapacity the county hospital capacity
     * @param trip                   the trip
     */
    public Destination(String city, String state, String zipCode, String countyFipsCode, String countyHospitalCapacity, Trip trip) {
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.countyFipsCode = countyFipsCode;
        this.countyHospitalCapacity = countyHospitalCapacity;
        this.trip = trip;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets trip.
     *
     * @return the trip
     */
    public Trip getTrip() {
        return trip;
    }

    /**
     * Sets trip.
     *
     * @param trip the trip
     */
    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    /**
     * Gets city.
     *
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     *
     * @param city the city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     *
     * @param state the state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets zip code.
     *
     * @return the zip code
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets zip code.
     *
     * @param zipCode the zip code
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * Gets county fips code.
     *
     * @return the county fips code
     */
    public String getCountyFipsCode() {
        return countyFipsCode;
    }

    /**
     * Sets county fips code.
     *
     * @param countyFipsCode the county fips code
     */
    public void setCountyFipsCode(String countyFipsCode) {
        this.countyFipsCode = countyFipsCode;
    }

    /**
     * Gets county hospital capacity.
     *
     * @return the county hospital capacity
     */
    public String getCountyHospitalCapacity() {
        return countyHospitalCapacity;
    }

    /**
     * Sets county hospital capacity.
     *
     * @param countyHospitalCapacity the county hospital capacity
     */
    public void setCountyHospitalCapacity(String countyHospitalCapacity) {
        this.countyHospitalCapacity = countyHospitalCapacity;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", countyFipsCode='" + countyFipsCode + '\'' +
                ", countyHospitalCapacity='" + countyHospitalCapacity + '\'' +
                // removed trip > stackoverflow error recursive loop
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Destination that = (Destination) o;
        return id == that.id && Objects.equals(city, that.city) && Objects.equals(state, that.state) && Objects.equals(zipCode, that.zipCode) && Objects.equals(countyFipsCode, that.countyFipsCode) && Objects.equals(countyHospitalCapacity, that.countyHospitalCapacity) && Objects.equals(trip, that.trip);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, city, state, zipCode, countyFipsCode, countyHospitalCapacity, trip);
    }
}
