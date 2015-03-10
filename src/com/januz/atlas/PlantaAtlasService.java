package com.januz.atlas;

import static spark.Spark.*;
import spark.Request;
import spark.Response;
import spark.Route;

public class PlantaAtlasService {
	
	public static void main(String[] args) {

		get("/hello", "application/json", new Route() {
			
			@Override
			public Object handle(Request arg0, Response arg1) throws Exception {
				Planta aPlant = new Planta(1, "Jacaranda", "Jacaranda Mimosifolia", "Un jacaranda", "Bignoniasias");
				return aPlant;
			}
		}, new JsonTransformer());

	}

}
