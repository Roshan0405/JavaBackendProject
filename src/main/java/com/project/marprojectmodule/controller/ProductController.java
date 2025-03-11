package com.project.marprojectmodule.controller;

import com.project.marprojectmodule.models.Product;

import com.project.marprojectmodule.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    //  @RequestMapping(value ="/products", method = RequestMethod.POST)
    @PostMapping("/products")   //    It same work as @RequestMapping
    public void createProduct(Product product) {

    }
    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        productService.getSingleProduct(id);
        return null;
    }

    public void updateProduct(Product product) {

    }

    public void deleteProduct(long id) {

    }
}
