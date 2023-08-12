package org.acme.timeManagement;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.QueryParam;
import jakarta.inject.Inject;
import io.quarkus.security.identity.SecurityIdentity;
import org.eclipse.microprofile.jwt.JsonWebToken;
import jakarta.annotation.security.RolesAllowed;


@Path("/checkOut")
@RolesAllowed("applicationUser")
public class checkOutResource {

    @Inject
    checkOutService checkOutService;
    @Inject 
    SecurityIdentity identity;
    @Inject
    JsonWebToken jwt;

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public void checkOut()
    {
        String userID = jwt.getClaim("sub");
        checkOutService.checkOut(userID);
        return;
    }
}
