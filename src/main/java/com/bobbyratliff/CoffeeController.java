package com.bobbyratliff;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/Coffee")
public class CoffeeController {

    @GET
    public Response getCoffeeCup() {
        CoffeeCup keepCalm = new CoffeeCup();
        keepCalm.message = "Keep Calm and Carry On";
        keepCalm.countryOfOrigin = "Britain";
        keepCalm.color = "red";
        keepCalm.numHandles = 1;
        return Response.ok(keepCalm).build();
    }

    @POST
    public Response customMessage(@QueryParam("message") String message) {
        CoffeeCup cup = new CoffeeCup();
        cup.message = message;
        cup.countryOfOrigin = "China";
        cup.color = "red";
        cup.numHandles = 1;
        return Response.ok(cup).build();
    }

    @POST
    @Path("/Cup")
    public Response echoCoffee(CoffeeCup cup) {
        return Response.ok(cup).build();
    }

    static class CoffeeCup {
        public String message;
        public String color;
        public String countryOfOrigin;
        public int numHandles;
        public String size;
    }
}
