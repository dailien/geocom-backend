/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.datasource;

import app.recipe.Recipe;
import java.util.List;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Day
 */
public interface RecipesRepository extends Repository<Recipe,Long>{

    Recipe save(Recipe entity);

    List<Recipe> findAll();

    void delete(Recipe entity);

    boolean exists(Long id);

}
