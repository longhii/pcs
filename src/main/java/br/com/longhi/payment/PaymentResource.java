package br.com.longhi.payment;

import br.com.longhi.payment.event.dto.request.RequestEvent;
import br.com.longhi.payment.event.service.EventService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.NoSuchElementException;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/")
public class PaymentResource {

    @Inject
    private EventService eventService;

    @POST
    @Path("/event")
    public Response postEvent(RequestEvent requestEvent) {
        try {
            var responseEvent = eventService.createEvent(requestEvent);

            return Response.status(Response.Status.CREATED)
                    .entity(responseEvent)
                    .build();
        } catch (NoSuchElementException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(0)
                    .build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/balance")
    public Response getBalance(@QueryParam("account_id") String accountId) {
        if (accountId == null) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("Account ID is required")
                    .build();
        }

        try {
            var balance = eventService.getBalanceAccount(accountId);
            return Response.ok().entity(balance).build();
        } catch (NoSuchElementException e) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(0)
                    .build();
        }
    }

    @POST
    @Path("/reset")
    public Response postReset() {
       eventService.reset();

        return Response.ok()
                .entity("OK")
                .build();
    }
}
