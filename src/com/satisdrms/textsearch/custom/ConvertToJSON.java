package com.satisdrms.textsearch.custom;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;

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

	public String convert(TLocations found) {
		// JSONObject obj = new JSONObject();
		// System.out.println(obj.toJSONString());
		String jsonInString = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			jsonInString = mapper.writeValueAsString(found.getTokens());
			// System.out.println(jsonInString);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonInString;
	}
}
