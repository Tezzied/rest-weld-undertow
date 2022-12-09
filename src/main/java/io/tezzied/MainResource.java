package io.tezzied;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("example")
public class MainResource {
    private MainService mainService;

    public MainService getMainService() {
        return mainService;
    }
    @Inject
    public void setMainService(MainService mainService) {
        this.mainService = mainService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello() {
        String hello = mainService.sayHello();
        return Response.ok(hello).build();
    }
}
