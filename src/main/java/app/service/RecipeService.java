package app.service;

import app.recipe.Recipe;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

@Path("recipe")
@Component
@Consumes("application/json")
@Produces("application/json")
public interface RecipeService {

    @GET
    @Path("/all")
    public RecipesResponse getRecipes();

    @POST
    @Path("/post")
    public AbstractResponse postRecipe(@RequestBody Recipe recipe);

    @DELETE
    @Path("/delete")
    public AbstractResponse deleteRecipe(@RequestBody Recipe recipe);
    
    @PUT
    @Path("/update")
    public AbstractResponse updateRecipe(@RequestBody Recipe recipe);
}
