package com.jilleliceiri.mptr.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * The type Trip.
 */
@Entity(name = "Trip")
@Table(name = "trips")
public class Trip {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "trip_name")
    private String name;

    @ManyToOne
    private User user;

    // fetch - careful if have too many destinations on a trip will load all at once (Lazy load as needed)
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Destination> destinationSet = new HashSet<>(); // each destination has a hospital ICU capacity

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Note> noteSet = new HashSet<>();


    /**
     * Instantiates a new Trip.
     */
    public Trip() {
    }

    /**
     * Instantiates a new Trip.
     *
     * @param name the name
     */
    public Trip(String name) {
        this.name = name;
    }

    /**
     * Instantiates a new Trip.
     *
     * @param id   the id
     * @param name the name
     */
    public Trip(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Trip(String name, User user) {
        this.name = name;
        this.user = user;
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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets destination set.
     *
     * @return the destination set
     */
    public Set<Destination> getDestinationSet() {
        return destinationSet;
    }

    /**
     * Sets destination set.
     *
     * @param destinationSet the destination set
     */
    public void setDestinationSet(Set<Destination> destinationSet) {
        this.destinationSet = destinationSet;
    }

    /**
     * Add destination.
     *
     * @param destination the destination
     */
    public void addDestination(Destination destination) {
        destinationSet.add(destination);
        destination.setTrip(this);
    }

    /**
     * Remove destination.
     *
     * @param destination the destination
     */
    public void removeDestination(Destination destination) {
        destinationSet.remove(destination);
        destination.setTrip(null);
    }

    /**
     * Gets note set.
     *
     * @return the note set
     */
    public Set<Note> getNoteSet() {
        return noteSet;
    }

    /**
     * Sets note set.
     *
     * @param noteSet the note set
     */
    public void setNoteSet(Set<Note> noteSet) {
        this.noteSet = noteSet;
    }

    /**
     * Add note.
     *
     * @param newNote the new note
     */
    public void addNote(Note newNote) {
        noteSet.add(newNote);
        newNote.setTrip(this);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // TODO regenerate tostring


    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", user=" + user +
                ", destinationSet=" + destinationSet +
                ", noteSet=" + noteSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return id == trip.id && name.equals(trip.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }


}
