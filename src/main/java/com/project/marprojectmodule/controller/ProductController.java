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
    public Product createProduct(@RequestBody Product product) {
    Product p = productService.createProduct(product.getId(), product.getTitle(),
            product.getDescription(), product.getPrice(), product.getImageUrl(), product.getCategory().getTitle());
    return p;
    }

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable("id") long id) {
        System.out.println("Starting the api call");
        Product p = productService.getSingleProduct(id);
        System.out.println("Ending the api call");
        return p;
    }

    public void updateProduct(Product product) {

    }

    public void deleteProduct(long id) {

    }
}
