package com.alevel.java9.metahack.api.entities;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "theme")
    private String theme;

    @Column(name="description")
    @Type(type = "text")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "max_teams_qty")
    private Integer maxTeamsQty;

    @Column(name = "max_team_participants_qty")
    private Integer maxTeamParticipantsQty;

    @Column(name = "start_date")
    @Type(type = "date")
    private Date startDate;

    @Column(name = "end_date")
    @Type(type = "date")
    private Date endDate;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "events_teams",
            joinColumns = @JoinColumn(name = "event_id"),
            inverseJoinColumns = @JoinColumn(name = "team_id")
    )
        private Set<Team> teams;

    @OneToMany (mappedBy = "events", fetch = FetchType.LAZY)
    private Set<Award>awards;

    @OneToMany (mappedBy = "events", fetch = FetchType.LAZY)
    private Set<MetaData> metaData;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "organizer_id")
    private User user;

    @OneToMany(mappedBy = "events")
    private Set<Project> projects;

    public Event(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getMaxTeamsQty() {
        return maxTeamsQty;
    }

    public void setMaxTeamsQty(Integer maxTeamsQty) {
        this.maxTeamsQty = maxTeamsQty;
    }

    public Integer getMaxTeamParticipantsQty() {
        return maxTeamParticipantsQty;
    }

    public void setMaxTeamParticipantsQty(Integer maxTeamParticipantsQty) {
        this.maxTeamParticipantsQty = maxTeamParticipantsQty;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Set<Team> getTeams() {
        return teams;
    }

    public void setTeams(Set<Team> teams) {
        this.teams = teams;
    }

    public Set<Award> getAwards() {
        return awards;
    }

    public void setAwards(Set<Award> awards) {
        this.awards = awards;
    }

    public Set<MetaData> getMetaData() {
        return metaData;
    }

    public void setMetaData(Set<MetaData> metaData) {
        this.metaData = metaData;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", theme='" + theme + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", maxTeamsQty=" + maxTeamsQty +
                ", maxTeamParticipantsQty=" + maxTeamParticipantsQty +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", teams=" + teams +
                ", awards=" + awards +
                ", metaData=" + metaData +
                ", user=" + user +
                ", projects=" + projects +
                '}';
    }
}
