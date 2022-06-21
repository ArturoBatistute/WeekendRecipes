package com.woods.recepies.controller;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.woods.recepies.services.RecepiesService;

@RestController
@RequestMapping(value = "/randomRecipe")
public final class recipesController {

	@Autowired
	RecepiesService recepiesService;

	@GetMapping
	@RequestMapping(produces = "application/json")
	public String getRandomRecipe() throws JsonProcessingException, ParseException {

		final String uri = "https://api.spoonacular.com/recipes/random?number=1&tags=french&apiKey=45b69c42c8b04505957ac03fdfb72f0a";

		final RestTemplate restTemplate = new RestTemplate();
		final Object jsonObject = restTemplate.getForObject(uri, Object.class);
		final Gson gson = new Gson().newBuilder().setPrettyPrinting().create();

		final String jsonString = gson.toJson(jsonObject);

		return recepiesService.parseRecipeUrl(jsonString);

	}
}
