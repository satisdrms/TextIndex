package com.satisdrms.textsearch.custom;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class ConvertToText {
	private static ConvertToText instance = null;

	private ConvertToText() {
		// Dummy constructor with access modifier as private for singleton
		// design
	}

	public static ConvertToText getInstance() {
		if (instance == null)
			instance = new ConvertToText();
		return instance;
	}

	@SuppressWarnings("null")
	public String convert(TLocations found) {
		StringBuilder textString = new StringBuilder();
		for (File f : found.getFiles()) {
			textString.append("doc_name: " + f.getName()
					+ " occurences(TokenNumber,Position): ");
			for (Token t : found.getTokenLocations(f)) {
				textString.append("(" + t.getTokennumber() + ","
						+ t.getPosition() + ") ");
			}
			textString.append("\n");
		}

		return textString.toString();
	}
}
