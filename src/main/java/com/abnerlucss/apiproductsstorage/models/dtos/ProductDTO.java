package com.abnerlucss.apiproductsstorage.models.dtos;

import com.abnerlucss.apiproductsstorage.models.Provider;

import java.util.UUID;

public class ProductDTO {
    private String name;
    private UUID providerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getProviderId() {
        return providerId;
    }

    public void setProviderId(UUID provider) {
        this.providerId = provider;
    }
}
