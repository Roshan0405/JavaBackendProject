package com.project.marprojectmodule.service;

import com.project.marprojectmodule.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FakeStoreProductService implements ProductService {

    @Override
    public Product getSingleProduct(long id) {
        System.out.println("We are in getSingleProduct");
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }
}
