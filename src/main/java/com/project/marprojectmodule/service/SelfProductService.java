package com.project.marprojectmodule.service;


//This class is for to implement out own/self database


import com.project.marprojectmodule.exceptions.ProductNotFoundException;
import com.project.marprojectmodule.models.Category;
import com.project.marprojectmodule.models.Product;
import com.project.marprojectmodule.repository.CategoryRepository;
import com.project.marprojectmodule.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        Optional<Product> p = productRepository.findById(id);

        if(p.isPresent()) {
            return p.get();
        }
        throw new ProductNotFoundException("Product not found in our database");
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> lp = (List<Product>) productRepository.findAll();
        return List.of();
    }

    @Override
    public Product createProduct(long id, String title, String description, double price, String image, String categoryTitle) {

        Product p = new Product();
        Optional<Category> currentCat = categoryRepository.findByTitle(categoryTitle);
        if(currentCat.isEmpty()) {
            Category newCat = new Category();
            newCat.setTitle(categoryTitle);
            Category newRow = categoryRepository.save(newCat);
            p.setCategory(newRow);
        } else {
            Category currentCategory = currentCat.get();
            p.setCategory(currentCategory);
        }
        p.setTitle(title);
        p.setDescription(description);
        p.setPrice(price);
//        p.setImageUrl();
        Product savedProduct = productRepository.save(p);
        return savedProduct;
    }
}
