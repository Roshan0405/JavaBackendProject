package com.project.marprojectmodule.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class Category extends BaseModel {
    private String title;

    //Usually, cascade is applied on @OneToMany because:
    //You usually want to delete products when a category is deleted.
    // Read about cascading here : https://www.baeldung.com/jpa-cascade-types
    @JsonIgnore
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Product> products;

}