
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gerald
 */
@Path("test")

public class RestHello {
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String pruebaApi() {
            
        return "{\"hola1\":\"" + "hola1"
                 + "\", \"hola2\":\"" + "hola2"+"\" }";
    }
}
