package com.restful.projects.ABCHospitalProject_BusinessTier;

import java.util.List;

import abchospital_db.ChannelingRepository;
import abchospital_models.Channel;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("channels")
public class ChannelingResource {
	
	ChannelingRepository repo = new ChannelingRepository(); 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Channel> getChannels()
	{
		
		System.out.println("get Channel Details Called..");
		return repo.getChannels();
		
	}
		
	
	
	@GET
	@Path("channel/{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Channel getChannel(@PathParam("id")int id)
	{
		return repo.getChannel(id);
	}
	
	@POST
	@Path("channel")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Channel createChannel(Channel c1)
	{
		System.out.println(c1);
		repo.create(c1);
		
		return c1;
	}
	
	@PUT
	@Path("channel")
	@Consumes({MediaType.APPLICATION_XML,MediaType.APPLICATION_JSON})
	public Channel updateChannel(Channel c1)
	{
		System.out.println(c1);
		
		if(repo.getChannel(c1.getId()).getId()==0)
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
	@Path("channel/{id}")
	public Channel deleteChannel(@PathParam("id") int id)
	{
		Channel c = repo.getChannel(id);
		if(c.getId()!=0)
		repo.delete(id);
		return c;
	}


}
