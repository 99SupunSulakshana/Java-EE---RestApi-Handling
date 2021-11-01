package com.restful.projects.ABCHospitalProject_BusinessTier;

import java.util.List;

import abchospital_db.MedicineDetailsRepository;
import abchospital_models.Medicine;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("medicines")
public class MedicineDetaileResource {

	MedicineDetailsRepository repo = new MedicineDetailsRepository(); 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Medicine> getMedicine()
	{
		
		System.out.println("get Medicine Details Called..");
		return repo.getMedicines();
		
	}
		
	
	
	@GET
	@Path("medicine/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Medicine getMedicine(@PathParam("id")int id)
	{
		return repo.getMedicine(id);
	}
	
	@POST
	@Path("medicine")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Medicine createMedicine(Medicine m1)
	{
		System.out.println(m1);
		repo.create(m1);
		
		return m1;
	}
	
	@PUT
	@Path("medicine")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Medicine updateMedicine(Medicine m1)
	{
		System.out.println(m1);
		
		if(repo.getMedicine(m1.getId()).getId()==0)
		{
			repo.create(m1);
			
		}else
		{
			repo.update(m1);
		}
		repo.update(m1);
		
		return m1;
	}
	
	
	@DELETE
	@Path("medicine/{id}")
	public Medicine deleteMedicine(@PathParam("id") int id)
	{
		Medicine m = repo.getMedicine(id);
		if(m.getId()!=0)
		repo.delete(id);
		return m;
	}
}
