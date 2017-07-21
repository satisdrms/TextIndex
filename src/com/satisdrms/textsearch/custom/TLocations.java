package com.satisdrms.textsearch.custom;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TLocations {
	Map<File, List<Token>> tokens;

	public TLocations() {
		tokens = new HashMap<File, List<Token>>();
	}

	public void add(File file, int pos) {

		if (tokens.containsKey(file)) {
			List<Token> tokensList = tokens.get(file);
			Token next = new Token(tokensList.size(), pos);
			tokensList.add(next);
		} else {
			List<Token> tokensList = new LinkedList<Token>();
			Token next = new Token(0, pos);
			tokensList.add(next);
			tokens.put(file, tokensList);
		}
	}

	public Set<File> getFiles() {
		if (tokens == null)
			return null;
		else {
			return tokens.keySet();
		}

	}

	public List<Token> getTokenLocations(File f) {
		if (f == null)
			return null;
		else {
			return tokens.get(f);
		}

	}

	public Map<File, List<Token>> getTokens() {
		return tokens;
	}
}
