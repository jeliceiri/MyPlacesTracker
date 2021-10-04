package com.jilleliceiri.mptr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * The type Destination.
 */
@Entity(name = "Destination")
@Table(name = "destinations")
public class Destination {

    // TODO add new instance variables: zip code, hospital capacity, fips code
    // TODO add DestinationDao tests, add generic dao,
    // TODO will need another dao test on entity for delete?

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String city;

    @ManyToOne
    private Trip trip;
    //private String hospitalCapacity;
    //private String weatherInfo

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

    @Override
    public String toString() {
        return "Destination{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", trip=" + trip +
                '}';
    }
}
