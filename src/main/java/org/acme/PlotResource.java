package org.acme;

import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Incoming;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/simulator")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlotResource {
    List<Plot> plots = new ArrayList<>();
    @GET
    public List<Plot> getAllList(){
        return plots;
    }
    @Incoming("plot-in")
    public void addToList(Plot plot){
        plots.add(plot);
    }
}