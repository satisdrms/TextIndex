package com.satisdrms.redistextsearch.custom;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class ConvertToJSON {
	private static ConvertToJSON instance = null;

	private ConvertToJSON() {
		// Dummy constructor with access modifier as private for singleton
		// design
	}

	public static ConvertToJSON getInstance() {
		if (instance == null)
			instance = new ConvertToJSON();
		return instance;
	}

	public String convert(TermLocations found) {
		String jsonInString = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonInString = mapper.writeValueAsString(found.getTokensCol());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonInString;
	}
}
