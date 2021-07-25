package com.abnerlucss.apiproductsstorage.controllers;

import com.abnerlucss.apiproductsstorage.models.Product;
import com.abnerlucss.apiproductsstorage.models.dtos.ProductDTO;
import com.abnerlucss.apiproductsstorage.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody ProductDTO body){
        return productService.createProduct(body);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable UUID id){
        return productService.getProductById(id);
    }

    @GetMapping()
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PutMapping("{id}")
    public Product updateProductById(@PathVariable UUID id, @RequestBody ProductDTO body){
        return productService.updateProductById(id, body);
    }

    @DeleteMapping("/{id}")
    public boolean deleteProductById(@PathVariable UUID id){
        return productService.deleteProductById(id);
    }
}
