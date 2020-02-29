package com.alevel.java9.metahack.api.entities;

import javax.persistence.*;

@Entity
@Table(name = "metadata")
public class MetaData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tag_value")
    private String tagValue;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_id")
    private Tag tag;

    public MetaData(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagValue() {
        return tagValue;
    }

    public void setTagValue(String tagValue) {
        this.tagValue = tagValue;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    @Override
    public String toString() {
        return "MetaData{" +
                "id=" + id +
                ", tagValue='" + tagValue + '\'' +
                ", event=" + event +
                ", tag=" + tag +
                '}';
    }
}
