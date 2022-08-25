package com.example.final_backend_project_rahafalammar.Repository;

import com.example.final_backend_project_rahafalammar.Model.Chefs.ChefsRecipes;
import com.example.final_backend_project_rahafalammar.Model.Enum.Meals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ChefsRecipesRepository extends JpaRepository<ChefsRecipes,Integer> {
    List<ChefsRecipes> findChefsRecipesByAuthorId(Integer id);
    ChefsRecipes findChefsRecipesByCode(Integer code);
    List<ChefsRecipes> findChefsRecipesByType(Meals type);

}
