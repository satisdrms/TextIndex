package com.satisdrms.redistextsearch.custom;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CParser implements CGrammar {

	public static IndexR parse(StringBuilder content, File file) {

		cleanForParsingAndTokenize(content);
		// System.out.println(content.toString());
		IndexR indexedFile = new IndexR();
		boolean dataType = false;
		StringBuilder currentToken = new StringBuilder("");

		for (String str : content.toString().split(" ")) {

			System.out.println(currentToken);

			if (isDataType(str)) {
				if (!dataType) {
					// initial check is data type start
					currentToken.append(str);
					dataType = true;
				} else if (isDataTypeAfterAppending(currentToken, str)) {
					// is it type after appending second term
					currentToken.append(" " + str);
				} else {
					// if not data type after appending second term the previous
					// term is data type and current term is the variable
					indexedFile.add(TermType.VARIABLE, file, str);
				}
			}

		}

		// for(TermType t:indexedFile.getTermTypeIndex().keySet()){
		// System.out.println(t);
		// for(File)
		// }
		//
		return indexedFile;
	}

	private static boolean isDataType(String currentToken) {
		if (CDataTypes.contains(currentToken))
			return true;
		else
			return false;
	}

	private static boolean isDataTypeAfterAppending(StringBuilder currentToken,
			String str) {
		if (CDataTypes.contains(currentToken.toString() + " " + str))
			return true;
		else
			return false;
	}

	/**
	 * @param content
	 * 
	 *            adding spaces to tokenize the braces to identify the functions
	 *            and blocks
	 * 
	 */
	private static void cleanForParsingAndTokenize(StringBuilder content) {
		addSpacesToTokenize(content);
		String[] tokens = content.toString().split(" ");
		content.delete(0, content.length());
		String lastToken = "";
		for (String s : tokens) {

			if (s.equals("")
					|| (s.equals(" ") && lastToken.equals(" ") || s
							.equals("\n"))) {

				lastToken = s;
				continue;
			}
			content.append(" " + s);
			lastToken = s;
		}
	}

	/**
	 * @param content
	 */
	private static void addSpacesToTokenize(StringBuilder content) {
		replaceAll(content, "(", " ( ");
		replaceAll(content, ")", " ) ");
		replaceAll(content, "{", " { ");
		replaceAll(content, "}", " } ");
		replaceAll(content, "=", " = ");
		replaceAll(content, ";", " ; ");
		replaceAll(content, "\n", " ");
	}

	private static void replaceAll(StringBuilder cleanTerm, String find,
			String replacement) {
		int index = cleanTerm.indexOf(find);
		while (index != -1) {
			cleanTerm.replace(index, index + find.length(), replacement);
			index += replacement.length(); // Move to the end of the replacement
			index = cleanTerm.indexOf(find, index);
		}
	}
}
