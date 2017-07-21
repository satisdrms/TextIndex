package com.satisdrms.redistextsearch.custom;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.satisdrms.redistextsearch.custom.CGrammar.TermType;

public class TermList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6917502258814382583L;

	Map<TermType, List<File>> termTypeIndex;

	public TermList() {
		termTypeIndex = new HashMap<TermType, List<File>>();
	}

	public void add(TermType termType, File file, String str) {
		if (termTypeIndex.containsKey(termType)) {
			List<File> fileList = termTypeIndex.get(termType);
			fileList.add(file);
		} else {
			List<File> fileList = new LinkedList<File>();
			fileList.add(file);
			termTypeIndex.put(termType, fileList);
		}

	}

	public Map<TermType, List<File>> getTermTypeIndex() {
		return termTypeIndex;
	}

	public void setTermTypeIndex(Map<TermType, List<File>> termTypeIndex) {
		this.termTypeIndex = termTypeIndex;
	}
}
