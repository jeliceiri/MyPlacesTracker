package com.jilleliceiri.mptr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity(name = "User")
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    private String username;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Trip> tripSet = new HashSet<>();

    public User(String username) {
        this.username = username;
    }

    public User() {

    }

    public User(String username, Set<Trip> tripSet) {
        this.username = username;
        this.tripSet = tripSet;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<Trip> getTripSet() {
        return tripSet;
    }

    public void setTripSet(Set<Trip> tripSet) {
        this.tripSet = tripSet;
    }

    public void addTrip(Trip newTrip) {
        tripSet.add(newTrip);
        newTrip.setUser(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}