package com.alevel.java9.metahack.api.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tags")
public class Tag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @OneToMany (mappedBy = "tags", fetch = FetchType.LAZY)
    private Set<MetaData> metaData;

    public Tag(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<MetaData> getMetaData() {
        return metaData;
    }

    public void setMetaData(Set<MetaData> metaData) {
        this.metaData = metaData;
    }

    @Override
    public String toString() {
        return "Tag{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", metaData=" + metaData +
                '}';
    }
}
