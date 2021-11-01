package com.restful.projects.ABCHospitalProject_BusinessTier;

import java.util.List;

import abchospital_db.MedicalpkgRepository;
import abchospital_models.MediPackage;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("packages")
public class MedicipkgResource {
	MedicalpkgRepository repo = new MedicalpkgRepository(); 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MediPackage> getMediPackages()
	{
		
		System.out.println("get Medical Packages Called..");
		return repo.getMediPackages();
		
	}
		
	@GET
	@Path("package/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public MediPackage getMediPackage(@PathParam("id")int id)
	{
		return repo.getMediPackage(id);
	}
	
	@POST
	@Path("package")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public MediPackage createMediPackage(MediPackage m1)
	{
		System.out.println(m1);
		repo.create(m1);
		
		return m1;
	}
	
	@PUT
	@Path("package")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public MediPackage updateMediPackage(MediPackage m1)
	{
		System.out.println(m1);
		
		if(repo.getMediPackage(m1.getId()).getId()==0)
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
	@Path("package/{id}")
	public MediPackage deleteMediPackage(@PathParam("id") int id)
	{
		MediPackage m = repo.getMediPackage(id);
		if(m.getId()!=0)
		repo.delete(id);
		return m;
	}


}
