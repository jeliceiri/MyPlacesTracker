package com.jilleliceiri.mptr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Trip")
@Table(name = "trips")
public class Trip {


    public Trip() {
    }

    public Trip(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "trip_name")
    private String name;
    //private List<String> destinations; // each destination has a hospital ICU capacity
    //private List<Note> notes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Trip {" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

}
