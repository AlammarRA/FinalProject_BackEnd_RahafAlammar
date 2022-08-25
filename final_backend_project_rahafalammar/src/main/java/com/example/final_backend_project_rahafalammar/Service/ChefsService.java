package com.example.final_backend_project_rahafalammar.Service;

import com.example.final_backend_project_rahafalammar.Model.Chefs.ChefsRecipes;
import com.example.final_backend_project_rahafalammar.Model.Enum.Meals;
import com.example.final_backend_project_rahafalammar.Model.Users;
import com.example.final_backend_project_rahafalammar.Repository.ChefsRecipesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ChefsService {
    private final ChefsRecipesRepository chefsRecipesRepository;

    public List<ChefsRecipes> getRecipes(Users users){
        return chefsRecipesRepository.findChefsRecipesByAuthorId(users.getId());
    }

    public void addRecipes(ChefsRecipes chefsRecipes, Users user) {
        chefsRecipes.setAuthorId(user.getId());
        chefsRecipesRepository.save(chefsRecipes);
    }

    public void updateRecipesById(ChefsRecipes updateRecipes , Integer code){
        ChefsRecipes chefsRecipes = chefsRecipesRepository.findChefsRecipesByCode(code);
        chefsRecipes.setTitle(updateRecipes.getTitle());
        chefsRecipes.setIngredients(updateRecipes.getIngredients());
        chefsRecipes.setDescription(updateRecipes.getDescription());
        chefsRecipesRepository.save(chefsRecipes);
    }

    public void deleteRecipesById(Integer code){
        ChefsRecipes chefsRecipes = chefsRecipesRepository.getById(code);
        chefsRecipesRepository.delete(chefsRecipes);
    }

    public List<ChefsRecipes> getRecipesByType(Meals type){
        return chefsRecipesRepository.findChefsRecipesByType(type);
    }

}
