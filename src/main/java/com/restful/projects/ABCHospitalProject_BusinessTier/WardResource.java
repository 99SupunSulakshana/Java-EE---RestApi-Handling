package com.restful.projects.ABCHospitalProject_BusinessTier;

import java.util.List;

import abchospital_db.WardRepository;
import abchospital_models.Ward;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("wards")
public class WardResource {
	
	WardRepository repo = new WardRepository(); 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ward> getWards()
	{
		
		System.out.println("get Wards Called..");
		return repo.getWards();
		
	}
		
	
	@GET
	@Path("ward/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Ward getWard(@PathParam("id")int id)
	{
		return repo.getWard(id);
	}
	
	@POST
	@Path("ward")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Ward createWard(Ward w1)
	{
		System.out.println(w1);
		repo.create(w1);
		
		return w1;
	}
	
	@PUT
	@Path("ward")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Ward updateWard(Ward w1)
	{
		System.out.println(w1);
		
		if(repo.getWard(w1.getId()).getId()==0)
		{
			repo.create(w1);
			
		}else
		{
			repo.update(w1);
		}
		repo.update(w1);
		
		return w1;
	}
	
	
	@DELETE
	@Path("ward/{id}")
	public Ward deleteWard(@PathParam("id") int id)
	{
		Ward w = repo.getWard(id);
		if(w.getId()!=0)
		repo.delete(id);
		return w;
	}
	

}
