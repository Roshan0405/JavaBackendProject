package com.project.marprojectmodule.repository;

import com.project.marprojectmodule.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {




    Product save(Product product);

    Product findByTitle(String title);

    Product findByDescription(String description);


}
