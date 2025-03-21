package com.project.marprojectmodule.controller;

import com.project.marprojectmodule.dto.ErrorDto;
import com.project.marprojectmodule.exceptions.ProductNotFoundException;
import com.project.marprojectmodule.models.Product;
import org.springframework.data.domain.Page;
import com.project.marprojectmodule.service.ProductService;
//import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    private ProductService productService;
    List<Product> products = new ArrayList<>();

    public ProductController(@Qualifier("SelfProductService") ProductService productService) {
        this.productService = productService;
    }

    //  @RequestMapping(value ="/products", method = RequestMethod.POST)
    @PostMapping("/products")   //    It same work as @RequestMapping
    public Product createProduct(@RequestBody Product product) throws ProductNotFoundException {
    Product p = productService.createProduct(product.getId(), product.getTitle(),
            product.getDescription(), product.getPrice(), product.getImageUrl(), product.getCategory().getTitle());
    return p;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable("id") long id) throws ProductNotFoundException {
        System.out.println("Starting the api call");
        Product p = productService.getSingleProduct(id);
        System.out.println("Ending the api call");

        ResponseEntity<Product> response = new ResponseEntity<>(p, HttpStatus.OK);

        return response;
    }

    public void updateProduct(Product product) {

    }

    public void deleteProduct(long id) {

    }

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity<ErrorDto> handleProductNotFoundException(Exception e) {
//        ErrorDto errorDto = new ErrorDto();
//        errorDto.setMessage(e.getMessage());
//
//        ResponseEntity<ErrorDto> response = new ResponseEntity<>(errorDto, HttpStatus.NOT_FOUND);
//
//        return response;
//    }

     @GetMapping("/products")
    public Page<Product> getAllProducts(@RequestParam("pageNumber") int pageNumber, @RequestParam("pageSize")int pageSize, @RequestParam("fieldName")String fieldName, @RequestParam("searchQuery") String searchQuery) {
        return productService.getAllProducts(pageNumber, pageSize, fieldName);
    }
}
