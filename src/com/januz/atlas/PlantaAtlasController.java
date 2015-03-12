package com.januz.atlas;

import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

import java.io.ObjectOutputStream.PutField;

import spark.Request;

import com.google.gson.Gson;

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
		
		
		put("/planta", "application/json", (request, response) -> {
			PlantaDto aPlant = parseBody(request, PlantaDto.class);
			PlantaDao pl = new PlantaDao();
			pl.editaPlanta(aPlant);
			return null;
		}, new JsonTransformer());
	
		get("/status", "application/json", (request, response) -> {

			return "Dale Pibe que Vamos Bien!!!!";
		}, new JsonTransformer());
	}
	
	// --------------------------------------------------------
	// Private Methods
	// --------------------------------------------------------
	private static <T> T parseBody(Request request, Class<T> aClass) {
		return gson.fromJson(request.body(), aClass);
	}
}
