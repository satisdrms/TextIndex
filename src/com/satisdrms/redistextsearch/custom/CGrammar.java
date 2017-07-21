package com.satisdrms.redistextsearch.custom;

import java.util.Arrays;
import java.util.LinkedList;

public interface CGrammar {
	/*
	 * Characters to ignore while creating tokens
	 */
	public static final Character[] puncts = { '!', '"', '#', '$', '%', '&',
			'\'', '(', ')', '*', '+', ',', '-', '.', '/', ':', ';', '<', '=',
			'>', '?', '@', '[', '\\', ']', '^', '_', '~', '`' };

	public static enum TermType {
		FUNCTION, PARAMETER, VARIABLE, ALL, MISC
	}

	/*
	 * Symbols which needs to be considered when tokenizing the C code
	 * Functions,Variables,Parameters List are identified with these
	 */
	public static final Character[] CSymbols = { '(', ')', '{', '}', '=' };

	public static final LinkedList<String> CDataTypes = new LinkedList<String>(
			Arrays.asList("char", "signed char", "unsigned char", "short",
					"short int", "signed short", "signed short int",
					"unsigned short", "unsigned short int", "int", "signed",
					"signed int", "unsigned", "unsigned int", "long",
					"long int", "signed long", "signed long int",
					"unsigned long", "unsigned long int", "long long",
					"long long int", "signed long long",
					"signed long long int", "unsigned long long",
					"unsigned long long int", "float", "double", "long double"));

}
