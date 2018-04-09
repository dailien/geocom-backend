package app.datasource;

import java.util.List;

import app.recipe.Recipe;


public interface RecipeDatasource {

	List<Recipe> findAll();
	
}
