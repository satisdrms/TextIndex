package com.satisdrms.redistextsearch.custom;

import java.io.File;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.satisdrms.redistextsearch.custom.CGrammar.TermType;

class TokenSorter implements Comparator<Map.Entry<File, TokenTypeCol>> {
	public int compare(Map.Entry<File, TokenTypeCol> m1,
			Map.Entry<File, TokenTypeCol> m2) {
		return (m2.getValue().getSize() - m1.getValue().getSize());
	}
}

class MapSorter {
	public static void sort(Map<File, TokenTypeCol> tokens) {
		List<Map.Entry<File, TokenTypeCol>> unsortedList = new LinkedList<Map.Entry<File, TokenTypeCol>>(
				tokens.entrySet());
		Collections.sort(unsortedList, new TokenSorter());
		tokens.clear();
		for (Map.Entry<File, TokenTypeCol> entry : unsortedList) {
			tokens.put(entry.getKey(), entry.getValue());
		}
	}
}

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

	public String convert(TermLocations found) {
		StringBuilder textString = new StringBuilder();
		for (File f : found.getFiles()) {
			textString.append("doc_name: " + f.getName()
					+ " occurences(TokenNumber,Position): ");
			TokenTypeCol ttcoll = found.getTokenLocations(f);
			for (TermType t : ttcoll.getAllTermType()) {
				List<Token> tokCol = ttcoll.getTokensList(t);
				for (Token tt : tokCol) {
					textString.append("(" + tt.getTokennumber() + ","
							+ tt.getPosition() + ") ");
				}
			}
			textString.append("\n");
		}

		return textString.toString();
	}

	public String sortAndConvertToText(TermLocations found) {
		StringBuilder textString = new StringBuilder();
		Map<File, TokenTypeCol> tokensType = found.getTokensCol();
		List<Map.Entry<File, TokenTypeCol>> unsortedList = new LinkedList<Map.Entry<File, TokenTypeCol>>(
				tokensType.entrySet());

		Collections.sort(unsortedList, new TokenSorter());
		for (Map.Entry<File, TokenTypeCol> entry : unsortedList) {

		}

		// TokenTypeCol tokens = found.getTokens();
		// List<Map.Entry<File, List<Token>>> unsortedList = new
		// LinkedList<Map.Entry<File, List<Token>>>(
		// tokens.entrySet());
		// Collections.sort(unsortedList, new TokenSorter());
		// for (Map.Entry<File, List<Token>> entry : unsortedList) {
		// textString.append("doc_name: " + entry.getKey()/* .getName() */
		// + " occurences(TokenNumber,Position): ");
		// for (Token t : entry.getValue()) {
		// textString.append(t.toString());
		// }
		// textString.append("\n\n");
		// }
		return textString.toString();

	}
}
