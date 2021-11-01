package com.restful.projects.ABCHospitalProject_BusinessTier;

import java.util.List;

import abchospital_db.DoctorRepository;
import abchospital_models.Doctor;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("doctors")
public class DoctorResource {
	
	DoctorRepository repo = new DoctorRepository(); 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Doctor> getDoctors()
	{
		
		System.out.println("get Doctors Called..");
		return repo.getDoctors();
		
	}
		
	
	
	@GET
	@Path("doctor/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Doctor getDoctor(@PathParam("id")int id)
	{
		return repo.getDoctor(id);
	}
	
	@POST
	@Path("doctor")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Doctor createDoctor(Doctor d1)
	{
		System.out.println(d1);
		repo.create(d1);
		
		return d1;
	}
	
	@PUT
	@Path("doctor")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Doctor updateDoctor(Doctor d1)
	{
		System.out.println(d1);
		
		if(repo.getDoctor(d1.getId()).getId()==0)
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
	@Path("doctor/{id}")
	public Doctor deleteDoctor(@PathParam("id") int id)
	{
		Doctor d = repo.getDoctor(id);
		if(d.getId()!=0)
		repo.delete(id);
		return d;
	}


}
