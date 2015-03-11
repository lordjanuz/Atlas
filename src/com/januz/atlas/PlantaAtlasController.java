package com.januz.atlas;

import static spark.Spark.*;

import com.google.gson.Gson;

import spark.Request;
import spark.Route;

public class PlantaAtlasController {
	private static Gson gson = new Gson(); 

	public static void main(String[] args) {

		post("/planta", "application/json", (request, response) -> {
			PlantaDto aPlant = parseBody(request, PlantaDto.class);
			PlantaDao pl = new PlantaDao();
			pl.createPlanta(aPlant);
			return null;
		}, new JsonTransformer());

		get("/planta/:id", "application/json", (request, response) -> {
			String value = request.params(":id");
			PlantaDao pl = new PlantaDao();
			return pl.getPlantaById(value);
		}, new JsonTransformer());
		
		get("/planta", "application/json", (request, response) -> {
			
			String value = request.queryParams("query");
			PlantaDao pl = new PlantaDao();
			return pl.getPlantaByCientificName(value);
		}, new JsonTransformer());
	}
	
	private static <T> T parseBody(Request request, Class<T> aClass){
		return gson.fromJson(request.body(), aClass);
	}
}
	