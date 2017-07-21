package com.satisdrms.textsearch.custom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.servlet.http.HttpServlet;

public class Analyze extends HttpServlet implements AllPunctuations {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String inputPath;
	BufferedReader reader = null;
	Index indexObj;

	public Analyze(String inputPath) {
		indexObj = new Index();
		this.inputPath = inputPath;
	}

	public Index process() {
		readFiles(inputPath);
		return indexObj;
	}

	private void readFiles(String inputPath) {
		if (inputPath == null)
			return;
		ClassLoader classLoader = Thread.currentThread()
				.getContextClassLoader();
		// getting the absolute path for the files in project folder
		String filePathInWindows = classLoader.getResource("../.." + inputPath)
				.getFile();

		File folder = new File(filePathInWindows);
		File[] listOfFiles = folder.listFiles();
		for (File file : listOfFiles) {
			if (file.isFile()) {
				tokenizeFile(file);
			}
		}
	}

	private void tokenizeFile(File file) {
		try {
			reader = new BufferedReader(new FileReader(file));
			String line;
			int pos = 0;
			while ((line = reader.readLine()) != null) {
				String[] terms = line.split(" ");
				for (String s : terms) {
					StringBuilder cleanTerm = new StringBuilder(s.toLowerCase());
					removePunctuations(cleanTerm);
					if (isATerm(cleanTerm)) {
						indexObj.add(cleanTerm.toString(), file, pos);
						// System.out.println(cleanTerm);
					}
					pos = pos + s.length() + 1;
				}
			}

		} catch (IOException e) {
		}

	}

	private void removePunctuations(StringBuilder cleanTerm) {
		for (Character c : puncts) {
			replaceAll(cleanTerm, c.toString(), "");
		}
	}

	private void replaceAll(StringBuilder cleanTerm, String find,
			String replacement) {
		int index = cleanTerm.indexOf(find);
		while (index != -1) {
			cleanTerm.replace(index, index + find.length(), replacement);
			index += replacement.length(); // Move to the end of the replacement
			index = cleanTerm.indexOf(find, index);
		}
	}

	private boolean isATerm(StringBuilder cleanTerm) {
		if (cleanTerm == null || cleanTerm.toString().equals(""))
			return false;
		return true;
	}

	private boolean isAPunctuation(String s) {
		for (Character c : puncts)
			if (c.toString().equals(s))
				return true;
		return false;
	}

}
