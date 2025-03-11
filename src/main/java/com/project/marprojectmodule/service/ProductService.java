package com.project.marprojectmodule.service;

import com.project.marprojectmodule.models.Product;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(long id);

    List<Product> getAllProducts();

    Product createProduct(Product product);

}
