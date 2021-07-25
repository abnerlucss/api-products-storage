package com.abnerlucss.apiproductsstorage.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "provider")
public class Provider {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    public Provider() {
    }

    public Provider(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
