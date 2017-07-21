package com.satisdrms.textsearch.custom;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Index {

	// Term and files and where it is found in the file
	Map<String, TLocations> index;

	public Index() {
		index = new HashMap<String, TLocations>();
	}

	public void add(String s, File file, int pos) {
		if (index.containsKey(s)) {
			TLocations updTloc = index.get(s);
			updTloc.add(file, pos);
		} else {
			TLocations newTloc = new TLocations();
			newTloc.add(file, pos);
			index.put(s, newTloc);
		}
	}

	public boolean contains(String term) {
		if (term == null || term.isEmpty())
			return false;
		Set<String> termSet = (Set<String>) index.keySet();
		if (termSet.contains(term))
			return true;
		else
			return false;
	}

	public TLocations get(String term) {
		if (term == null || term.isEmpty())
			return null;
		return index.get(term);
	}
}
