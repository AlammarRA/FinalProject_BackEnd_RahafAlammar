package com.example.final_backend_project_rahafalammar.Model.Customers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRecipes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "title can't be empty")
    private String title;
    @NotEmpty(message = "Ingredients can't be empty")
    @Column(columnDefinition = "TEXT",nullable = false)
    private String ingredients;
    @NotEmpty(message = "description can't be empty")
    @Column(columnDefinition = "TEXT",nullable = false)
    private String description;
    @NotNull(message = "chefs Recipes Code name can't be empty")
    private Integer chefsRecipesCode;
    @NotEmpty(message = "Author name can't be empty")
    private String author;
    private Integer recipesCode;
    private Integer userId;
}
