package org.acme.timeManagement;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.QueryParam;
import jakarta.inject.Inject;
import jakarta.annotation.security.RolesAllowed; 
import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.jwt.JsonWebToken;


@Path("/user")
@RolesAllowed("applicationUser")
public class userResource {

    @Inject
    userService userService;
    @Inject
    SecurityIdentity identity;
    @Inject
    JsonWebToken jwt;

    @POST
    @Path("/create")
    @Produces(MediaType.TEXT_PLAIN)
    public String createUser()
    {
        userService.createUser(); 
        return "User Created";
    }

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUser()
    {
        String userID = jwt.getClaim("sub");
        //String id = identity.getPrincipal().getName();
        //User user = userService.getUser(Integer.parseInt(id));
        //return user;
        return userID;
    }
}
