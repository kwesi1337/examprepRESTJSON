/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.GsonBuilder;
import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import util.RandomGenerator;
/**
 *
 * @author josephawwal
 */
@Path("/addresses")
public class RestService {
    
    
    public RestService(){
        
        
       new GsonBuilder().setPrettyPrinting().create();
       
    }
    
    
    @GET
    @Path("{number}/{person}")
    public Response getQuote(@PathParam("number") int number, @PathParam("person") String person){
        
        
        String data = RandomGenerator.getData(number, person);
        return Response.status(Response.Status.OK).entity(data).header("Access-Control-Allow-Origin", "*").type(MediaType.APPLICATION_JSON).build();
        
    }
    
}
