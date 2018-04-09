package app.service;

import app.datasource.IngredientsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import app.datasource.RecipeDatasource;
import app.recipe.Recipe;
import org.springframework.web.bind.annotation.RequestBody;
import app.datasource.RecipesRepository;
import app.recipe.Ingredient;
import java.util.ArrayList;
import java.util.List;

public class RecipeServiceImpl implements RecipeService {

	private static final Logger logger = LoggerFactory.getLogger(RecipeServiceImpl.class);
	
	@Autowired
	private RecipesRepository recipeRepo;
        
        @Autowired
	private IngredientsRepository ingredientRepo;
	
	@Override
	public RecipesResponse getRecipes() {
		
		RecipesResponse response = new RecipesResponse();
		response.setCode("200");
		response.setDescription("ok");
		
		try{
			response.getRecipes().addAll(recipeRepo.findAll());
		} catch (Exception e) {
			logger.error("Error al obtener las recetas de la base de datos.");
			response.setCode("500");
			response.setDescription("Ha ocurrido un error al consultar las recetas");
		}
		
		return response;
	}

        @Override
	public AbstractResponse postRecipe(@RequestBody Recipe recipe) {
		
		RecipesResponse response = new RecipesResponse();
		response.setCode("200");
		response.setDescription("ok");
		
		try{
                    List<Ingredient> list = recipe.getIngredients();
                    recipe.setIngredients(new ArrayList());
                    recipe = recipeRepo.save(recipe);
                    
                    for (int i = 0; i <list.size(); i++) {
                        Ingredient ingre = list.get(i);
                        ingre.setRecipeId(recipe.getId());
                        ingredientRepo.save(ingre);
                    }
		} catch (Exception e) {
			logger.error("Error al insertar la receta en la base de datos");
			response.setCode("500");
			response.setDescription("Ha ocurrido un error al insertar la receta");
		}
		
		return response;
	}
        
         @Override
	public AbstractResponse deleteRecipe(@RequestBody Recipe recipe) {
		
		RecipesResponse response = new RecipesResponse();
		response.setCode("200");
		response.setDescription("ok");
		
		try{
                    recipeRepo.delete(recipe);
		} catch (Exception e) {
			logger.error("Error al eliminar la receta en la base de datos");
			response.setCode("500");
			response.setDescription("Ha ocurrido un error al eliminar la receta");
		}
		
		return response;
	}
	
         @Override
	public AbstractResponse updateRecipe(@RequestBody Recipe recipe) {
		
		RecipesResponse response = new RecipesResponse();
		response.setCode("200");
		response.setDescription("ok");
		
		try{
                    if (recipeRepo.exists(recipe.getId())) {
                         recipeRepo.save(recipe);
                    }
                    else{
                        response.setCode("404");
                        response.setDescription("Not found");
                    }
		} catch (Exception e) {
			logger.error("Error al editar la receta en la base de datos");
			response.setCode("500");
			response.setDescription("Ha ocurrido un error al editar la receta");
		}
		
		return response;
	}

}
