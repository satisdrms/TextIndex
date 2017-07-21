package com.satisdrms.redistextsearch.custom;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class IndexRBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6800950741328610216L;
	Map<String, TermList> index;

	public IndexRBean() {
		index = new HashMap<String, TermList>();
	}

}
