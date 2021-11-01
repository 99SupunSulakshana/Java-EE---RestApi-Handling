package com.restful.projects.ABCHospitalProject_BusinessTier;

import java.util.List;

import abchospital_db.UserRepository;
import abchospital_models.User;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("users")
public class UserResource {
	
	UserRepository repo = new UserRepository(); 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getAliens()
	{
		
		System.out.println("get Users Called..");
		return repo.getUsers();
		
	}
		
	
	
	@GET
	@Path("user/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public User getUser(@PathParam("id")int id)
	{
		return repo.getUser(id);
	}
	
	@POST
	@Path("user")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public User createUser(User u1)
	{
		System.out.println(u1);
		repo.create(u1);
		
		return u1;
	}
	
	@PUT
	@Path("user")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public User updateUser(User u1)
	{
		System.out.println(u1);
		
		if(repo.getUser(u1.getId()).getId()==0)
		{
			repo.create(u1);
			
		}else
		{
			repo.update(u1);
		}
		repo.update(u1);
		
		return u1;
	}
	
	
	@DELETE
	@Path("user/{id}")
	public User deleteUser(@PathParam("id") int id)
	{
		User u = repo.getUser(id);
		if(u.getId()!=0)
		repo.delete(id);
		return u;
	}

}
