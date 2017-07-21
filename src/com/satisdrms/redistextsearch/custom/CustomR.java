package com.satisdrms.redistextsearch.custom;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.satisdrms.redistextsearch.custom.CGrammar.TermType;

public class CustomR {
	private static IndexR indexObj;

	public static String searchTerm(String term, TermType termType) {
		TermSearchR termSearch = new TermSearchR(indexObj);
		String jSonString = termSearch.search(term.toLowerCase(), termType);
		return jSonString;

	}

	public static void analyzeFiles(String inputpath) {
		AnalyzeR analyze = new AnalyzeR(inputpath);
		indexObj = analyze.process();
	}

	public static void writeIndexToFile(String outLoc) {
		try {
			FileOutputStream fos = new FileOutputStream(outLoc);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(indexObj);
			oos.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void readIndexFromFile(String outLoc) {
		indexObj = new IndexR();
		FileInputStream fis;
		try {
			fis = new FileInputStream(outLoc);
			ObjectInputStream ois = new ObjectInputStream(fis);
			indexObj = ((IndexR) ois.readObject());
			ois.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
