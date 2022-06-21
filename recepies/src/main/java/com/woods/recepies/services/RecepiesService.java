package com.woods.recepies.services;

import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class RecepiesService {

	public String parseRecipeUrl(String json) {

		final JsonElement jelement = JsonParser.parseString(json);

		JsonObject mainObject = jelement.getAsJsonObject();

		final JsonArray recipesArray = mainObject.getAsJsonArray("recipes");

		mainObject = recipesArray.get(0).getAsJsonObject();

		final String recipeUrl = mainObject.get("sourceUrl").getAsString();

		return recipeUrl;
	}
}
