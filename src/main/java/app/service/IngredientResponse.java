/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.recipe.Ingredient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Day
 */
public class IngredientResponse extends AbstractResponse {

    private List<Ingredient> ingredients;

    public List<Ingredient> getIngredients() {
        if (ingredients == null) {
            ingredients = new ArrayList();
        }
        return ingredients;
    }

    public void setIngredient(List<Ingredient> ingredient) {
        this.ingredients = ingredient;
    }
}
