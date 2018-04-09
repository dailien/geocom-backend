/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.datasource;

import app.recipe.Ingredient;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Day
 */
public interface IngredientsRepository extends Repository<Ingredient, Long> {

    Ingredient save(Ingredient entity);

    @Query("Select i.name, SUM(i.amount) From Ingredient i GROUP BY i.name")
    List<Ingredient> findIngredients();

    List<Ingredient> findAll();

    void delete(Ingredient ingredient);

    boolean findBy(Long id);
}
