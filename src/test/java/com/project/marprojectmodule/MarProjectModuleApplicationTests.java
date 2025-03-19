package com.project.marprojectmodule;

import com.project.marprojectmodule.models.Category;
import com.project.marprojectmodule.models.Product;
import com.project.marprojectmodule.repository.CategoryRepository;
import com.project.marprojectmodule.repository.ProductProjection;
import com.project.marprojectmodule.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MarProjectModuleApplicationTests {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testQueries() {
//        List<Product> allProducts = productRepository.getProductByCategoryId(1L);
//
//        for (Product product : allProducts) {
//            System.out.println(product);
//        }
        List<ProductProjection> productProjectionList = productRepository.getProductByCategoryIdUsingProjections(1L);
        System.out.println(productProjectionList.get(0).getTitle());
    }

//    @Test
//    void testNativeQueries() {
//        List<Product> allProducts = productRepository.getProductByCategoryIdNativeQueries(1L);
//
//        for (Product product : allProducts) {
//            System.out.println(product);
//
//        }
//    }

//    @Test
//    void testProductProjection() {
//
//    }

    @Test
    void fetchTypesTest(){
//        Category cat = categoryRepository.findById(1L).get();
//        System.out.println(cat.getId());
//        System.out.println("We Are Done Here");
//
//        List<Product> currentProduct = cat.getProducts();
//        System.out.println(currentProduct.size());
//        System.out.println("We Got Products As Well");
    }

}
