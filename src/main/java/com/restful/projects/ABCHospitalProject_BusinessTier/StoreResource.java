package com.restful.projects.ABCHospitalProject_BusinessTier;

import java.util.List;

import abchospital_db.StoreRepository;
import abchospital_models.Store;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("stores")
public class StoreResource {
	
	StoreRepository repo = new StoreRepository(); 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Store> getStore()
	{
		
		System.out.println("get Store Details Called..");
		return repo.getStores();
		
	}
		
	
	
	@GET
	@Path("store/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Store getStore(@PathParam("id")int id)
	{
		return repo.getStore(id);
	}
	
	@POST
	@Path("store")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Store createStore(Store s1)
	{
		System.out.println(s1);
		repo.create(s1);
		
		return s1;
	}
	
	@PUT
	@Path("store")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Store updateStore(Store s1)
	{
		System.out.println(s1);
		
		if(repo.getStore(s1.getId()).getId()==0)
		{
			repo.create(s1);
			
		}else
		{
			repo.update(s1);
		}
		repo.update(s1);
		
		return s1;
	}
	
	
	@DELETE
	@Path("store/{id}")
	public Store deleteStore(@PathParam("id") int id)
	{
		Store s = repo.getStore(id);
		if(s.getId()!=0)
		repo.delete(id);
		return s;
	}


}
