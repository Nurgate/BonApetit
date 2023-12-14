package com.bonappetit.repo;

import com.bonappetit.model.entity.Recipe;
import com.bonappetit.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
//    List<Recipe> findByAssignee(User user);
//
    @Query(nativeQuery = true, value = "SELECT * FROM tasks WHERE assignee_id IS NULL")
    List<Recipe> getAllAvailable();


}
