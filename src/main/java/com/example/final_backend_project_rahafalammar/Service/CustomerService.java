package com.example.final_backend_project_rahafalammar.Service;

import com.example.final_backend_project_rahafalammar.Model.Chefs.ChefsRecipes;
import com.example.final_backend_project_rahafalammar.Model.Customers.CustomerMealPlans;
import com.example.final_backend_project_rahafalammar.Model.Customers.CustomerRecipes;
import com.example.final_backend_project_rahafalammar.Model.Users;
import com.example.final_backend_project_rahafalammar.Repository.CustomerMealPlansRepository;
import com.example.final_backend_project_rahafalammar.Repository.CustomerRecipesRepository;
import com.example.final_backend_project_rahafalammar.Repository.ChefsRecipesRepository;
import com.example.final_backend_project_rahafalammar.Repository.UserRepository;
import com.example.final_backend_project_rahafalammar.dto.MealPlansDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final ChefsRecipesRepository chefsRecipesRepository;
    private final UserRepository userRepository;
    private final CustomerRecipesRepository customerRecipesRepository;
    private final CustomerMealPlansRepository customerMealPlansRepository;

    public List<CustomerMealPlans> getMealPlans(Users users){
        return customerMealPlansRepository.findByUserId(users.getId());
    }

    public void addRecipesToCustomerRecipes(Integer code , Users user) {
        ChefsRecipes chefsRecipes = chefsRecipesRepository.findChefsRecipesByCode(code);
        CustomerRecipes customerRecipes = new CustomerRecipes();
        customerRecipes.setTitle(chefsRecipes.getTitle());
        customerRecipes.setDescription(chefsRecipes.getDescription());
        customerRecipes.setIngredients(chefsRecipes.getIngredients());
        customerRecipes.setRecipesCode(chefsRecipes.getCode());
        customerRecipes.setChefsRecipesCode(chefsRecipes.getAuthorId());
        Users users = userRepository.findUsersById(chefsRecipes.getAuthorId());
        customerRecipes.setAuthor(users.getUsername());
        customerRecipes.setUserId(user.getId());
        customerRecipesRepository.save(customerRecipes);
    }

    public void addRecipesToCustomerMealPlans(MealPlansDto mealPlansDto,Users users) {
        CustomerRecipes customerRecipes = customerRecipesRepository.getById(mealPlansDto.getId());
        CustomerMealPlans customerMealPlans = new CustomerMealPlans();
        customerMealPlans.setTitle(customerRecipes.getTitle());
        customerMealPlans.setIngredients(customerRecipes.getIngredients());
        customerMealPlans.setDay(mealPlansDto.getDay());
        customerMealPlans.setUserId(users.getId());
        customerMealPlansRepository.save(customerMealPlans);
    }

    public void updateDayOnMealPlan(MealPlansDto updateCustomerMealPlans){
        CustomerMealPlans customerMealPlans = customerMealPlansRepository.getById(updateCustomerMealPlans.getId());
        customerMealPlans.setDay(updateCustomerMealPlans.getDay());
        customerMealPlansRepository.save(customerMealPlans);
    }

    public List<CustomerRecipes> getRecipes(Users users){
        return customerRecipesRepository.findByUserId(users.getId());
    }

    public void deleteFromPlanById(Integer id){
        CustomerMealPlans customerMealPlans = customerMealPlansRepository.getReferenceById(id);
        customerMealPlansRepository.delete(customerMealPlans);
    }

    public List<CustomerRecipes> getRecipesByAuthor(String AuthorName,Users users){
        return customerRecipesRepository.findCustomerRecipesByAuthorAndUserId(AuthorName,users.getId());
    }

    public List<CustomerRecipes> getRecipesByTitle(String title,Users users){
        return customerRecipesRepository.findCustomerRecipesByTitleAndUserId(title,users.getId());
    }

    public Integer getCounter(String authorName){
        List<CustomerRecipes> userRec = customerRecipesRepository.findCustomerRecipesByAuthor(authorName);
        return userRec.size();
    }
}
