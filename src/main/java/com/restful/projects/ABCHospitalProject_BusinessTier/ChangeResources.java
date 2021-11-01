package com.restful.projects.ABCHospitalProject_BusinessTier;

import java.util.List;

import abchospital_db.ChangeRepository;
import abchospital_models.Change;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("changes")
public class ChangeResources {
	ChangeRepository repo = new ChangeRepository(); 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Change> getChanges()
	{
		
		System.out.println("get Branchers combination Called..");
		return repo.getChanges();
		
	}
		
	
	
	@GET
	@Path("change/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Change getChange(@PathParam("id")int id)
	{
		return repo.getChange(id);
	}
	
	@POST
	@Path("change")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Change createChange(Change c1)
	{
		System.out.println(c1);
		repo.create(c1);
		
		return c1;
	}
	
	@PUT
	@Path("change")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Change updateChange(Change c1)
	{
		System.out.println(c1);
		
		if(repo.getChange(c1.getId()).getId()==0)
		{
			repo.create(c1);
			
		}else
		{
			repo.update(c1);
		}
		repo.update(c1);
		
		return c1;
	}
	
	
	@DELETE
	@Path("change/{id}")
	public Change deleteChange(@PathParam("id") int id)
	{
		Change c = repo.getChange(id);
		if(c.getId()!=0)
		repo.delete(id);
		return c;
	}
}
