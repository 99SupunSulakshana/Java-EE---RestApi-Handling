package com.restful.projects.ABCHospitalProject_BusinessTier;

import java.util.List;

import abchospital_db.AppoinmentRepository;
import abchospital_models.Appoinment;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("appoinments")
public class AppoinmentResource {

	AppoinmentRepository repo = new AppoinmentRepository(); 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Appoinment> getAppoinemnt()
	{
		
		System.out.println("get Appoinemnts Called..");
		return repo.getAppoinments();
		
	}
		
	
	
	@GET
	@Path("appoinment/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Appoinment getAppoinment(@PathParam("id")int id)
	{
		return repo.getAppoinment(id);
	}
	
	@POST
	@Path("appoinment")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Appoinment createAppoinment(Appoinment a1)
	{
		System.out.println(a1);
		repo.create(a1);
		
		return a1;
	}
	
	@PUT
	@Path("appoinment")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Appoinment updateAppoinment(Appoinment a1)
	{
		System.out.println(a1);
		
		if(repo.getAppoinment(a1.getId()).getId()==0)
		{
			repo.create(a1);
			
		}else
		{
			repo.update(a1);
		}
		repo.update(a1);
		
		return a1;
	}
	
	
	@DELETE
	@Path("appoinment/{id}")
	public Appoinment deleteAppoinemnt(@PathParam("id") int id)
	{
		Appoinment a = repo.getAppoinment(id);
		if(a.getId()!=0)
		repo.delete(id);
		return a;
	}

}
