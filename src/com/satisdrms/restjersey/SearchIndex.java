package com.satisdrms.restjersey;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.satisdrms.textsearch.custom.Custom;

@Path("/searchinindex")
public class SearchIndex {
	@Path("{term}")
	@GET
	@Produces("application/json")
	public String serachInput(@PathParam("term") String term) {
		String inputPath = "/input/stories/";
		Custom.analyzeFiles(inputPath);
		String jSonString = Custom.searchTerm(term);
		return jSonString;
	}
}
