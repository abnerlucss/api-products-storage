package com.abnerlucss.apiproductsstorage.controllers;

import com.abnerlucss.apiproductsstorage.models.Provider;
import com.abnerlucss.apiproductsstorage.models.dtos.ProductDTO;
import com.abnerlucss.apiproductsstorage.models.dtos.ProviderDTO;
import com.abnerlucss.apiproductsstorage.services.ProductService;
import com.abnerlucss.apiproductsstorage.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/provider")
public class ProviderController {
    @Autowired
    private ProviderService providerService;

    @PostMapping
    public Provider createProvider(@RequestBody ProductDTO body) {
        return providerService.createProvider(body);
    }

    @GetMapping("/{id}")
    public Optional<Provider> getProviderById(@PathVariable UUID id) {
        return providerService.getProviderById(id);
    }

    @GetMapping
    public List<Provider> getAllProviders() {
        return providerService.getAllProviders();
    }

    @PutMapping("/{id}")
    public Provider updateProviderById(@PathVariable UUID id, @RequestBody ProviderDTO body) {
        return providerService.updateProviderById(id, body);
    }

    @DeleteMapping("{id}")
    public boolean deleteProviderById(@PathVariable UUID id) {
        return providerService.deleteProviderById(id);
    }

}
