package com.abnerlucss.apiproductsstorage.models;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "provider_id")
    private Provider provider;

    public Product() {
    }

    public Product(String name, Provider provider) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.provider = provider;
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

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
