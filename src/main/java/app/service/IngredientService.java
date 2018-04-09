/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import org.springframework.stereotype.Component;

/**
 *
 * @author Day
 */

@Path("ingredient")
@Component
@Consumes("application/json")
@Produces("application/json")
public interface IngredientService {
    @GET
    @Path("/all")
    public IngredientResponse getIngredient();

    }
