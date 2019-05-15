package app.resources;

import app.dao.BasicCrudDao;
import app.entities.Company;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Component
@Path("/company")
public class CompanyResource {

    private static final Logger log = Logger.getLogger(CompanyResource.class);

    @Autowired
    private BasicCrudDao<Company> companyDao;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Company> findAll() {
        log.warn("getAll method called");
        return companyDao.findAll();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Company get(@PathParam("id") int id) {
        return companyDao.findById(id);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Company company) {
        companyDao.create(company);
        return Response.status(Response.Status.CREATED.getStatusCode()).build();
    }

    @PUT
    @Path("/edit/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") int id, Company company) {
        companyDao.update(company);
        return Response.status(Response.Status.CREATED.getStatusCode()).build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteById(@PathParam("id") int id) {
        companyDao.deleteById(id);
        return Response.status(Response.Status.OK.getStatusCode()).build();
    }

    @DELETE
    @Path("/delete")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(Company company) {
        companyDao.delete(company);
        return Response.status(Response.Status.OK.getStatusCode()).build();
    }
}