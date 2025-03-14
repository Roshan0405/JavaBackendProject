package com.project.marprojectmodule.repository;

import com.project.marprojectmodule.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByTitle(String title);
}
