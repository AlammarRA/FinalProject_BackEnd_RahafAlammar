package com.example.final_backend_project_rahafalammar.Controller;

import com.example.final_backend_project_rahafalammar.Model.Chefs.ChefsRecipes;
import com.example.final_backend_project_rahafalammar.Model.Enum.Meals;
import com.example.final_backend_project_rahafalammar.Model.Users;
import com.example.final_backend_project_rahafalammar.Response.ApiResponse;
import com.example.final_backend_project_rahafalammar.Service.ChefsService;
import com.example.final_backend_project_rahafalammar.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/chefs")
public class ChefsController {

   private final ChefsService recipesService;
   private final CustomerService customerService;


   //// Chefs Recipes ////

   @GetMapping("/get_recipes")
    public ResponseEntity getRecipes(@AuthenticationPrincipal Users user){
       return ResponseEntity.status(200).body(recipesService.getRecipes(user));
   }

   @PostMapping("/add_recipes")
    public ResponseEntity addRecipes(@RequestBody ChefsRecipes chefsRecipes, @AuthenticationPrincipal Users user){
       recipesService.addRecipes(chefsRecipes,user);
       return ResponseEntity.status(200).body(new ApiResponse("New Recipe added!",200));
   }

   @RequestMapping(path = "/update_recipes/{id}" , method = RequestMethod.PUT)
   public ResponseEntity updateRecipe(@RequestBody @Valid ChefsRecipes updateRecipes, @PathVariable Integer id){
        recipesService.updateRecipesById(updateRecipes,id);
        return ResponseEntity.status(200).body(new ApiResponse("Recipe updated!",200));
    }

   @RequestMapping(path = "/delete_recipes" , method = RequestMethod.DELETE)
   public ResponseEntity deleteRecipe(@RequestParam Integer id){
        recipesService.deleteRecipesById(id);
        return ResponseEntity.status(200).body(new ApiResponse("Recipe deleted!",200));
    }


    @GetMapping("/get_recipes_by_type/{type}")
    public ResponseEntity getRecipesByType(@PathVariable Meals type){
        return ResponseEntity.status(200).body(recipesService.getRecipesByType(type));
    }

    @GetMapping("/get_counter")
    public ResponseEntity getRecipesCounter(@RequestParam String Author){
        return ResponseEntity.status(200).body(customerService.getCounter(Author));
    }
   /////////////////////////////////////////////////////////////////////////////////////////////////////////


}
