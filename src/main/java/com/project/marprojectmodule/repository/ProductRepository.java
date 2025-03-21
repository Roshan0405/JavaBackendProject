package com.project.marprojectmodule.repository;

import com.project.marprojectmodule.models.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

//import java.awt.print.Pageable;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

//    @Override
    Page<Product> findAll(Pageable pageable);

    Product save(Product product);

    Product findByTitle(String title);

    Product findByDescription(String description);


//    Implement HQL - Hibernate Query Language
    @Query("select p from Product p where p.category.id = :categoryId")
    List<Product> getProductByCategoryId(@Param("categoryId") Long categoryId);

//    Implement Native SQL Query
    @Query(value = "select * from product p where p.category_id = :categoryId" , nativeQuery = true)
    List<Product> getProductByCategoryIdNativeQueries(@Param("categoryId") Long categoryId);

    @Query("select p.title as title, p.id as id from Product p where p.category.id = :categoryId")
    List<ProductProjection> getProductByCategoryIdUsingProjections(@Param("categoryId") Long categoryId);
}
