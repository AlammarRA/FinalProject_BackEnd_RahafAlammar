package com.example.final_backend_project_rahafalammar.Model.Chefs;

import com.example.final_backend_project_rahafalammar.Model.Enum.Meals;
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
public class ChefsRecipes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer code;
    @NotEmpty(message = "title can't be empty")
    private String title;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Meals type;
    @NotEmpty(message = "Ingredients can't be empty")
    @Column(columnDefinition = "TEXT",nullable = false)
    private String ingredients;
    @NotEmpty(message = "description can't be empty")
    @Column(columnDefinition = "TEXT",nullable = false)
    private String description;
    private Integer authorId;
}
