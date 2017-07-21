package com.satisdrms.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.satisdrms.redistextsearch.custom.CustomR;
import com.satisdrms.redistextsearch.custom.CGrammar.TermType;

/* 
 * Passing the values to rest api through the query param
 * http://localhost:8080/WebTextSearchExample/satisdrms/redissearchinindex?term=const&type=function
 * Possible values for type is
 * all/function/parameter/variable 
 * 
 * */

@Path("/searchindex")
public class RedisSearchIndex {
	// @Path("{term}")
	@GET
	@Produces("application/json")
	public String serachInput(@QueryParam("term") String term,
			@QueryParam("type") String type) {
		String inLoc = "C:\\rest\\indexbean.ser";

		long cstartTime = System.nanoTime();
		CustomR.readIndexFromFile(inLoc);
		long sstartTime = System.nanoTime();
		String resultString = CustomR.searchTerm(term, TermType.valueOf(type));
		long endTime = System.nanoTime();

		long loadIndexDuration = (long) (sstartTime - cstartTime) / 1000000 / 1000;
		long searchDuration = (long) (endTime - sstartTime) / 1000000;
		String ind = ("The index file read took " + loadIndexDuration + " seconds");
		String ser = ("The search took " + searchDuration + " milliseconds");
		return ind + "\n" + ser + "\n" + resultString;
	}
}
