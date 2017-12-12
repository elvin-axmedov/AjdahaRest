package com.ajdaha.rest.resources;

import com.ajdaha.rest.models.SalesMan;
import com.ajdaha.rest.sql.DBOperations;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Lenovo on 19-Nov-17.
 */
@Path("salesman")
public class SalesManResource {
    DBOperations db = new DBOperations();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SalesMan> getSalesMans() {
        return db.getSalesMans();
    }
}
