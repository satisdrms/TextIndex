package com.satisdrms.textsearch.custom;

import java.io.File;

//Sample OutPut(postings List for a input term) would look like below for Lucene
//doc_id: 40 occurences: (3,20) (25,197)

public class TermSearch {
	Index indexObj;

	public TermSearch(Index indexObj) {
		this.indexObj = indexObj;
	}

	public String search(String term) {
		TLocations found = null;
		String docsFound = null;
		if (indexObj.contains(term)) {
			found = indexObj.get(term);
			// jSonString = convertToJSONAndPrint(found);
			docsFound = "The term \"" + term
					+ "\" is found in the below docs!!";
			docsFound = docsFound + "\n\n";
			docsFound = docsFound + convertToText(found);
			docsFound = docsFound + "\n";

		} else {
			docsFound = "The term \"" + term + "\" is not found!!";
		}
		return docsFound;
	}

	private String convertToText(TLocations found) {
		String textString = ConvertToText.getInstance().convert(found);
		return textString;
	}

	private String convertToJSONAndPrint(TLocations found) {
		String jSonString = ConvertToJSON.getInstance().convert(found);
		return jSonString;

	}

}
