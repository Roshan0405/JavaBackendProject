package com.project.marprojectmodule.service;

import com.project.marprojectmodule.exceptions.ProductNotFoundException;
import com.project.marprojectmodule.models.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Product getSingleProduct(long id) throws ProductNotFoundException;

//    List<Product> getAllProducts(int pageNumber, int pageSize, String fieldName);

    Page<Product> getAllProducts(int pageNumber, int pageSize, String fieldName);

    Product createProduct(long id, String title, String description, double price, String image, String category);

    Product updateProduct(long id, String title, String description, double price, String image, String category);

    Product deleteProduct(long id) throws ProductNotFoundException;

}
