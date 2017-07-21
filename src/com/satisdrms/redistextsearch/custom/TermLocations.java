package com.satisdrms.redistextsearch.custom;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.satisdrms.redistextsearch.custom.CGrammar.TermType;

public class TermLocations implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4148335659561955777L;
	Map<File, TokenTypeCol> tokensType;

	public TermLocations() {
		tokensType = new HashMap<File, TokenTypeCol>();

	}

	public void add(File file, int pos, TermType termType) {

		if (tokensType.containsKey(file)) {
			TokenTypeCol tokensList = tokensType.get(file);
			Token next = new Token(tokensList.getSize(), pos);
			tokensList.add(next, termType);
		} else {
			TokenTypeCol tokensList = new TokenTypeCol();
			Token next = new Token(0, pos);
			tokensList.add(next, termType);
			tokensType.put(file, tokensList);
		}
	}

	public Set<File> getFiles() {
		if (tokensType == null)
			return null;
		else {
			return tokensType.keySet();
		}

	}

	public TokenTypeCol getTokenLocations(File f) {
		if (f == null)
			return null;
		else {
			return tokensType.get(f);
		}

	}

	public Map<File, TokenTypeCol> getTokensCol() {
		return tokensType;
	}

	public TermLocations get(TermType termType) {
		TermLocations result = new TermLocations();
		if (!termType.equals(TermType.ALL)) {
			for (File f : tokensType.keySet()) {
				List<Token> tokenCol = tokensType.get(f).getTermTypeCol(
						termType);
				if (tokenCol != null) {
					result.put(f, new TokenTypeCol(termType, tokenCol));
				}
			}
			return result;
		} else
			return this;

	}

	private void put(File f, TokenTypeCol ttCol) {
		tokensType.put(f, ttCol);
	}
}
