package com.bobbyratliff;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/Coffee")
public class CoffeeController {

    @GET
    public Response getCoffeeCup() {
        CoffeeCup keepCalm = new CoffeeCup();
        keepCalm.message = "Keep Calm and Carry On";
        keepCalm.color = "red";
        keepCalm.numHandles = 1;
        return Response.ok(keepCalm).build();
    }

    static class CoffeeCup {
        public String message;
        public String color;
        public String countryOfOrigin;
        public int numHandles;
        public String size;
    }
}
