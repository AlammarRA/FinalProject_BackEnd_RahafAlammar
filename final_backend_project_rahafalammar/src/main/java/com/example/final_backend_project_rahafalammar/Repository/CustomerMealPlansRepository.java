package com.example.final_backend_project_rahafalammar.Repository;

import com.example.final_backend_project_rahafalammar.Model.Customers.CustomerMealPlans;
import com.example.final_backend_project_rahafalammar.Model.Customers.CustomerRecipes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerMealPlansRepository extends JpaRepository<CustomerMealPlans,Integer> {
    List<CustomerMealPlans> findByUserId(Integer id);
}
