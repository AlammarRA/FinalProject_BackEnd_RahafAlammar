package com.example.final_backend_project_rahafalammar.Repository;

import com.example.final_backend_project_rahafalammar.Model.Customers.CustomerRecipes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRecipesRepository extends JpaRepository<CustomerRecipes,Integer> {
    List<CustomerRecipes> findByUserId(Integer id);

    List<CustomerRecipes> findCustomerRecipesByAuthorAndUserId(String AuthorName,Integer userID);

    List<CustomerRecipes> findCustomerRecipesByTitleAndUserId(String title, Integer UserID);

    List<CustomerRecipes> findCustomerRecipesByAuthor(String authorName);


}