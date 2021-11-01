package com.restful.projects.ABCHospitalProject_BusinessTier;

import java.util.List;

import abchospital_db.DischargeRepository;
import abchospital_models.Discharge;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;


@Path("discharges")
public class DischargeResource {
	DischargeRepository repo = new DischargeRepository(); 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Discharge> getDischarges()
	{
		
		System.out.println("get Discharge Details Called..");
		return repo.getDischarges();
		
	}
		
	
	@GET
	@Path("discharge/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Discharge getDischarge(@PathParam("id")int id)
	{
		return repo.getDischarge(id);
	}
	
	@POST
	@Path("discharge")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Discharge createDischarge(Discharge d1)
	{
		System.out.println(d1);
		repo.create(d1);
		
		return d1;
	}
	
	@PUT
	@Path("discharge")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Discharge updateDischarge(Discharge d1)
	{
		System.out.println(d1);
		
		if(repo.getDischarge(d1.getId()).getId()==0)
		{
			repo.create(d1);
			
		}else
		{
			repo.update(d1);
		}
		repo.update(d1);
		
		return d1;
	}
	
	
	@DELETE
	@Path("discharge/{id}")
	public Discharge deleteDischarge(@PathParam("id") int id)
	{
		Discharge d = repo.getDischarge(id);
		if(d.getId()!=0)
		repo.delete(id);
		return d;
	}

}
