package com.restful.projects.ABCHospitalProject_BusinessTier;

import java.util.List;

import abchospital_db.PatientRepository;
import abchospital_models.Patient;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("patients")
public class PatientResource {
	
	
	PatientRepository repo = new PatientRepository(); 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Patient> getAliens()
	{
		
		System.out.println("get Patients Called..");
		return repo.getPatients();
		
	}
		
	
	
	@GET
	@Path("patient/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Patient getPatient(@PathParam("id")int id)
	{
		return repo.getPatient(id);
	}
	
	@POST
	@Path("patient")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Patient createPatient(Patient p1)
	{
		System.out.println(p1);
		repo.create(p1);
		
		return p1;
	}
	
	@PUT
	@Path("patient")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Patient updatePatient(Patient p1)
	{
		System.out.println(p1);
		
		if(repo.getPatient(p1.getId()).getId()==0)
		{
			repo.create(p1);
			
		}else
		{
			repo.update(p1);
		}
		repo.update(p1);
		
		return p1;
	}
	
	
	@DELETE
	@Path("patient/{id}")
	public Patient deletePatient(@PathParam("id") int id)
	{
		Patient p = repo.getPatient(id);
		if(p.getId()!=0)
		repo.delete(id);
		return p;
	} 

}
