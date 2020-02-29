package com.alevel.java9.metahack.api.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 60)
    private String name;

    @ManyToMany(mappedBy = "teams")
    private Set<User> users;

    @ManyToMany(mappedBy = "teams")
    private Set<Event> events;

    @OneToMany (mappedBy = "teams" , fetch = FetchType.EAGER)
    private Set<Award>awards;

    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "leader_id")
    private User leader;

    @OneToMany(mappedBy = "teams")
    private Set<Project> projects;

    public Team(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<Award> getAwards() {
        return awards;
    }

    public void setAwards(Set<Award> awards) {
        this.awards = awards;
    }

    public User getLeader() {
        return leader;
    }

    public void setLeader(User leader) {
        this.leader = leader;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", users=" + users +
                ", events=" + events +
                ", awards=" + awards +
                ", leader=" + leader +
                ", projects=" + projects +
                '}';
    }
}
