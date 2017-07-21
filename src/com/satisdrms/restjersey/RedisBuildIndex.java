package com.satisdrms.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import com.satisdrms.redistextsearch.custom.CustomR;

/* 
 * Below is a sample API call to build index and save to file
 * http://localhost:8080/WebTextSearchExample/satisdrms/redisbuildindex
 *  */

@Path("/redisbuildindex")
public class RedisBuildIndex {
	// @Path("{term}")
	@GET
	@Produces("application/json")
	public String serachInput() {
		String inputPath = "C:\\rest\\input\\redis\\";
		CustomR.analyzeFiles(inputPath);
		String outLoc = "C:\\rest\\indexbean.ser";
		CustomR.writeIndexToFile(outLoc);
		return "Index Built and Saved in File!!";
	}
}
