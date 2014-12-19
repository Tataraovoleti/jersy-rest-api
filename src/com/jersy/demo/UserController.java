/**
 * Copyright 2014@ fazalcode
 * All Rights Reserved to fazalcode
 */
package com.jersy.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 *
 * @author Tatarao voleti
 * @date 25-Jun-2014
 */

@Path("/u")
public class UserController {

	/**
	 * Say plain text hello.
	 *
	 * @return the string
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayHello() {
		return "Hello Jersey";
	}

	/**
	 * Check name.
	 *
	 * @param i
	 *            the i
	 * @return the string
	 */
	@GET
	@Path("/name/{i}")
	@Produces(MediaType.TEXT_HTML)
	public Response displayName(@PathParam("i") String i) {

		String view= "Hello "+i;
		
		return Response.status(200).entity(view).build();
	}

	/**
	 * Gets the json.
	 *
	 * @return the json
	 */
	@GET
	@Path("/json-response")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJsonResponse() {

		DemoBean db= new DemoBean();
		db.setEid("1");
		db.setEname("Tata");
		return Response.status(200).entity(db).build();
	}
	
}
