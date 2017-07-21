package com.satisdrms.redistextsearch.custom;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.satisdrms.redistextsearch.custom.CGrammar.TermType;

public class TokenTypeCol {
	Map<TermType, List<Token>> tokens;

	public TokenTypeCol() {
		tokens = new HashMap<TermType, List<Token>>();
	}

	public TokenTypeCol(TermType t, List<Token> lst) {
		tokens = new HashMap<TermType, List<Token>>();
		tokens.put(t, lst);
	}

	public int getSize() {
		int size = 0;
		for (List<Token> lst : tokens.values()) {
			size = size + lst.size();
		}
		return size;
	}

	public void add(Token next, TermType termType) {
		if (tokens.containsKey(termType)) {
			List<Token> tokensList = tokens.get(termType);
			tokensList.add(next);
		} else {
			List<Token> tokensList = new LinkedList<Token>();
			tokensList.add(next);
			tokens.put(termType, tokensList);
		}

	}

	public List<Token> getTermTypeCol(TermType termType) {
		if (termType == null)
			return null;
		return tokens.get(termType);
	}

 	public Set<TermType> getAllTermType() {
		if (tokens == null)
			return null;
		// TODO Auto-generated method stub
		return tokens.keySet();
	}

	public List<Token> getTokensList(TermType t) {
		// TODO Auto-generated method stub
		return null;
	}
}
