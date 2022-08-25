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
public class CustomerMealPlans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "title can't be empty")
    private String title;
    @NotEmpty(message = "Ingredients can't be empty")
    @Column(columnDefinition = "TEXT",nullable = false)
    private String ingredients;
    @NotNull(message = "user id can't be empty")
    private Integer userId;
    @NotNull(message = "days can't be empty")
    private String day;
}
