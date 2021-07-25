package com.abnerlucss.apiproductsstorage.services;

import com.abnerlucss.apiproductsstorage.models.Provider;
import com.abnerlucss.apiproductsstorage.models.dtos.ProductDTO;
import com.abnerlucss.apiproductsstorage.models.dtos.ProviderDTO;
import com.abnerlucss.apiproductsstorage.repositories.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@SuppressWarnings("unused")
public class ProviderService {
    @Autowired
    private ProviderRepository providerRepository;

    public Provider updateProviderById(UUID id, ProviderDTO body) {
        Provider providerToUpdate = getProviderById(id).orElse(null);

        if(providerToUpdate == null){
            return null;
        }

        providerToUpdate.setName(body.getName());

        return providerRepository.save(providerToUpdate);
    }

    public Provider createProvider(ProductDTO body) {
        Provider provider = new Provider(
                body.getName()
        );
        return providerRepository.save(provider);
    }

    public Optional<Provider> getProviderById(UUID providerID) {
        return providerRepository.findById(providerID);
    }

    public List<Provider> getAllProviders(){
        return (List<Provider>) providerRepository.findAll();
    }

    public boolean deleteProviderById(UUID id){
        Provider providerToDelete = getProviderById(id).orElse(null);

        if(providerToDelete == null)
            return false;

        providerRepository.deleteById(id);

        return true;
    }
}
