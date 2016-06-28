package com.example.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.example.enums.PhoneType;
import com.example.gson.util.GsonUtil;
import com.example.model.Person;
import com.example.model.Phone;

@Component
@Path("/hello")
public class HelloWorldService {
 
	private static final Logger LOG = LoggerFactory.getLogger(HelloWorldService.class);
	
	@Autowired
	private ApplicationContext context;
	
	public void setApplicationContext(ApplicationContext context) {
		this.context = context;
	}
	
	@Autowired(required = true)
	private GsonUtil gsonUtil;
	
	public void setGsonUtil(GsonUtil gsonUtil) {
		this.gsonUtil = gsonUtil;
	}

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	@GET
	@Path("/getNumber/{param}")
	public Response getNumber(@PathParam("param") String msg) {
 
		String code;
		if ("1".equals(msg)) {
			code = "ONE";
		} else if ("2".equals(msg)) {
			code = "TWO";
		} else if ("3".equals(msg)) {
			code = "THREE";
		} else {
			code = "I don't know that number.";
		}
		String output = "Jersey number is : " + code;
 
		return Response.status(200).entity(output).build();
 
	}
	
	@GET
	@Path("/getString")
	public Response getString(@QueryParam("qparam") String msg) {
 
		String code;
		if ("ONE".equalsIgnoreCase(msg)) {
			code = "1";
		} else if ("TWO".equalsIgnoreCase(msg)) {
			code = "2";
		} else if ("THREE".equalsIgnoreCase(msg)) {
			code = "3";
		} else {
			code = "I don't know that string number.";
		}
		String output = "Jersey string is : " + code;
 
		return Response.status(200).entity(output).build();
 
	}
	
	@GET
	@Path("/getPerson")
	public Response getPerson() {
		Person person = new Person().setFirstName("Dave").setLastName("Kieras").setExcluded("should not be here")
				.addPhone(new Phone().setPhoneNumber("816-885-1597").setPhoneType(PhoneType.MOBILE))
				.addPhone(new Phone().setPhoneNumber("913-549-3197").setPhoneType(PhoneType.HOME));
		LOG.debug("Context is " + context);
		LOG.debug("gsonUtil = " + gsonUtil);
		String output = gsonUtil.getGson().toJson(person);
		return Response.status(200).entity(output).build();
	}
	
	@POST
	@Path("/setPerson")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setPerson(String json) {
		Person person = gsonUtil.getGson().fromJson(json, Person.class);
		
		person.setFirstName("David");
		
		String output = gsonUtil.getGson().toJson(person);
		return Response.status(200).entity(output).build();
	}
 
}
