/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.datasource.IngredientsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Day
 */
public class IngredientServiceImpl implements IngredientService{
private static final Logger logger = LoggerFactory.getLogger(IngredientServiceImpl.class);
	
	@Autowired
        private IngredientsRepository repositoryIngredient;
	
	@Override
	public IngredientResponse getIngredient() {
		
		IngredientResponse response = new IngredientResponse();
		response.setCode("200");
		response.setDescription("ok");
		
		try{
			response.getIngredients().addAll(repositoryIngredient.findIngredients());
                        
		} catch (Exception e) {
			logger.error("Error al recuperar los ingredientes de la base de datos.");
			response.setCode("500");
			response.setDescription("Ha ocurrido un error al consultar los ingredientes");
		}
		
		return response;
	}    
}
