package com.abnerlucss.apiproductsstorage.services;

import com.abnerlucss.apiproductsstorage.controllers.ProductController;
import com.abnerlucss.apiproductsstorage.models.Product;
import com.abnerlucss.apiproductsstorage.models.Provider;
import com.abnerlucss.apiproductsstorage.models.dtos.ProductDTO;
import com.abnerlucss.apiproductsstorage.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@SuppressWarnings("unused")
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProviderService providerService;

    public Product createProduct(ProductDTO body) {
        Provider provider = providerService.getProviderById(body.getProviderId()).orElse(null);

        if (provider == null)
            return null;

        Product product = new Product(
                body.getName(),
                provider
        );

        return productRepository.save(product);
    }

    public Product getProductById(UUID id) {
        Optional<Product> product = productRepository.findById(id);

        if(product.isEmpty())
            return null;

        return product.get();

    }

    public List<Product> getAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    public boolean deleteProductById(UUID id) {
        Product productToDelete = getProductById(id);
        if(productToDelete == null){
            return false;
        }
        productRepository.deleteById(id);
        return true;
    }

    public Product updateProductById(UUID id, ProductDTO body) {
        Product productToUpdate = getProductById(id);
        if(productToUpdate == null)
            return null;

        Provider provider = providerService.getProviderById(body.getProviderId()).orElse(null);

        if (provider == null)
            return null;

        productToUpdate.setName(body.getName());
        productToUpdate.setProvider(provider);

        productRepository.save(productToUpdate);

        return productToUpdate;
    }

}
