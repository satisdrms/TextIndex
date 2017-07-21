package com.satisdrms.redistextsearch.custom;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.satisdrms.redistextsearch.custom.CGrammar.TermType;

public class IndexR {

	// Term and files and where it is found in the file
	Map<String, TermList> index;

	public IndexR() {
		index = new HashMap<String, TermList>();
	}

	public void add(TermType variable, File file, String str) {
		// TODO Auto-generated method stub

	}

	public IndexR getIndex() {
		// TODO Auto-generated method stub
		return this;
	}

	public void setIndex(IndexRBean readObject) {
		
		
	}

}
