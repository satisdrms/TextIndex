package com.satisdrms.redistextsearch.custom;

import com.satisdrms.redistextsearch.custom.CGrammar.TermType;

//Sample OutPut(postings List for a input term) would look like below for Lucene
//doc_id: 40 occurences: (3,20) (25,197)

public class TermSearchR {
	IndexR indexObj;

	public TermSearchR(IndexR indexObj) {
		this.indexObj = indexObj;
	}

	public String search(String term, TermType termType) {
		// TermLocations found = null;
		// String docsFound = null;
		// if (indexObj.contains(term)) {
		// found = indexObj.get(term,termType);
		// // jSonString = convertToJSON(found);
		// docsFound = "The term \"" + term
		// + "\" is found in the below docs!!";
		// docsFound = docsFound + "\n\n";
		// docsFound = docsFound + convertToText(found);
		// docsFound = docsFound + "\n";
		//
		// } else {
		// docsFound = "The term \"" + term + "\" is not found!!";
		// }
		// return docsFound;
		return null;
	}

	private String convertToText(TermLocations found) {
		String textString = ConvertToText.getInstance().sortAndConvertToText(
				found);
		return textString;
	}

	@SuppressWarnings("unused")
	private String convertToJSON(TermLocations found) {
		String jSonString = ConvertToJSON.getInstance().convert(found);
		return jSonString;

	}

}
