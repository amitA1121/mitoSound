package com.mitosound.model;

import java.util.UUID;

import org.hibernate.annotations.Generated;
import jakarta.persistence.*;

@Entity 
@Table(name = "artists")
public class Artist {
    
    @Id 
    @Generated 
    public UUID id;

    @Column(nullable = false, length = 50)
    public String name;

    public String description;



    protected Artist() {
    }

    public Artist(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String name() {
        return name;
    }

    public String description() {
        return description;
    }
}
