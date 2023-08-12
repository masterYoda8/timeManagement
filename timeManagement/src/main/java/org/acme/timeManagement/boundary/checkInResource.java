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


@Path("/checkIn")
@RolesAllowed("applicationUser")
public class checkInResource {

    @Inject
    checkInService checkInService;
    @Inject 
    SecurityIdentity identity;
    @Inject
    JsonWebToken jwt;

    @POST
    public void checkIn()
    {
        if (identity.isAnonymous()){
        }
        String userID = jwt.getClaim("sub");
        checkInService.checkIn(userID);
        return;
    }
}
