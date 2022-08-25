package com.example.final_backend_project_rahafalammar.Controller;

import com.example.final_backend_project_rahafalammar.Model.Chefs.ChefsRecipes;
import com.example.final_backend_project_rahafalammar.Model.Users;
import com.example.final_backend_project_rahafalammar.Response.ApiResponse;
import com.example.final_backend_project_rahafalammar.Service.CustomerService;
import com.example.final_backend_project_rahafalammar.dto.MealPlansDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/add_recipes/{id}")
    public ResponseEntity addRecipesToPlan(@PathVariable Integer id, @AuthenticationPrincipal Users user){
        customerService.addRecipesToCustomerRecipes(id,user);
        return ResponseEntity.status(200).body(new ApiResponse("New Recipe added to customer recipes list!",200));
    }

    @PostMapping("/add_meal_plan")
    public ResponseEntity addMealPlan(@RequestBody MealPlansDto mealPlansDto , @AuthenticationPrincipal Users user){
        customerService.addRecipesToCustomerMealPlans(mealPlansDto,user);
        return ResponseEntity.status(200).body(new ApiResponse("New Meal Plan added to customer Meal Plans list!",200));
    }

    @GetMapping("/get_recipes")
    public ResponseEntity getRecipes(@AuthenticationPrincipal Users user){
        return ResponseEntity.status(200).body(customerService.getRecipes(user));
    }

    @RequestMapping(path = "/update_plan" , method = RequestMethod.PUT)
    public ResponseEntity updatePlan(@RequestBody MealPlansDto mealPlansDto , @AuthenticationPrincipal Users user){
        customerService.updateDayOnMealPlan(mealPlansDto);
        return ResponseEntity.status(200).body(new ApiResponse("Plan updated!",200));
    }

    @RequestMapping(path = "/delete_plan" , method = RequestMethod.DELETE)
    public ResponseEntity deletePlan(@RequestParam Integer id, @AuthenticationPrincipal Users user){
        customerService.deleteFromPlanById(id);
        return ResponseEntity.status(200).body(new ApiResponse("Recipe deleted!",200));
    }

    @GetMapping("/get_author")
    public ResponseEntity getRecipesByAuthor(@RequestParam String Author, @AuthenticationPrincipal Users user){
        return ResponseEntity.status(200).body(customerService.getRecipesByAuthor(Author,user));
    }

    @GetMapping("/get_title")
    public ResponseEntity getRecipesByTitle(@RequestParam String title , @AuthenticationPrincipal Users user){
        return ResponseEntity.status(200).body(customerService.getRecipesByTitle(title,user));
    }

    @GetMapping("/get_meal_plan")
    public ResponseEntity getRecipesPlan(@AuthenticationPrincipal Users user){
        return ResponseEntity.status(200).body(customerService.getMealPlans(user));
    }

}