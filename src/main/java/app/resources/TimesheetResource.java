package app.resources;

import app.dao.BasicCrudDao;
import app.entities.Timesheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/Timesheet")
public class TimesheetResource {

    @Autowired
    private BasicCrudDao<Timesheet> basicCrudDao;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Timesheet timesheet) {
        basicCrudDao.create(timesheet);
        return Response.status(Response.Status.CREATED.getStatusCode()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Timesheet> getAll() {
        return basicCrudDao.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Timesheet get(@PathParam("id") int id) {
        return basicCrudDao.findById(id);
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        basicCrudDao.deleteById(id);
        return Response.status(Response.Status.OK.getStatusCode()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Timesheet timesheet) {
        if (id != timesheet.getId()) {
            return Response.status(Response.Status.CONFLICT.getStatusCode()).build();
        }
        basicCrudDao.update(timesheet);
        return Response.status(Response.Status.CREATED.getStatusCode()).build();
    }

}
