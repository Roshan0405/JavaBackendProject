package com.project.marprojectmodule.service;

import com.project.marprojectmodule.dto.FakeStoreProductDto;
import com.project.marprojectmodule.exceptions.ProductNotFoundException;
import com.project.marprojectmodule.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(long id) throws ProductNotFoundException {
        System.out.println("Inside FakeStoreProductService");
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakeStoreProductDto.class);

//        System.out.println(fakeStoreProductDto.toString());

        if(fakeStoreProductDto == null) {
            throw new ProductNotFoundException("Product not found id=" + id);
        }
        return fakeStoreProductDto.getProduct();
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize, String fieldName) {
//        Page<Product> products = productRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(fieldName).ascending())
        return null;
    }


    @Override
    public Product createProduct(long id, String title, String description, double price, String image, String category) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();
        fakeStoreProductDto.setId(id);
        fakeStoreProductDto.setTitle(title);
        fakeStoreProductDto.setDescription(description);
        fakeStoreProductDto.setPrice(price);
        fakeStoreProductDto.setCategory(category);
        fakeStoreProductDto.setImage(image);

        FakeStoreProductDto response = restTemplate.postForObject("https://fakestoreapi.com/products",
                fakeStoreProductDto, FakeStoreProductDto.class);

        return response.getProduct();
    }


}
