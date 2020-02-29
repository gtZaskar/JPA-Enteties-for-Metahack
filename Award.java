package com.alevel.java9.metahack.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "awards")
public class Award {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "place")
    private Integer place;

    @Column(name = "award")
    private String award;

    @ManyToOne (optional = false, cascade = CascadeType.ALL)
    @JoinColumn (name = "team_id")
    private Team team;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    public Award(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Award{" +
                "id=" + id +
                ", place=" + place +
                ", award='" + award + '\'' +
                ", team=" + team +
                ", event=" + event +
                '}';
    }
}
