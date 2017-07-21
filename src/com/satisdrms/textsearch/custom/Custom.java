package com.satisdrms.textsearch.custom;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

class servConn extends HttpServlet   {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void connTest() {
		String inputPath = "/WEB-INF/input/temp/sample.txt";

		ServletContext servletContext = this.getServletContext();

		String contextPath = servletContext.getRealPath(File.separator);
		System.out.println(contextPath+"-- ");
		InputStream is = servletContext.getResourceAsStream(inputPath);
		String text;
		BufferedReader r = new BufferedReader(new InputStreamReader(is));
		try {
			while ((text = r.readLine()) != null) {
				System.out.println(text);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void connTest1() {
		String inputPath = "/input/temp/sample.txt";
		File folder1 = new File("./");
		File[] listOfFiles1 = folder1.listFiles();
		System.out.println("input path is " + inputPath + " files count ");
		System.out.println("--" + listOfFiles1.length);
		for (File file : listOfFiles1) {
			System.out.println(file.toString());
		}
	}
}

public class Custom {
	private Map<File, TLocations> files;
	private static Index indexObj;

	public static void main(String[] args) {

		// System.out.println(Calendar.getInstance().getTime());
		// analyzeFiles(inputPath);
		// System.out.println(Calendar.getInstance().getTime());
		// searchTerm();

		servConn sc = new servConn();
		sc.connTest();

	}

	public static String searchTerm(String term) {
		TermSearch termSearch = new TermSearch(indexObj);
		// String term = getInput();
		String jSonString = termSearch.search(term.toLowerCase());
		return jSonString;

	}

	private static String getInput() {
		System.out.print("Enter the term to search:- ");
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();

	}

	public static void analyzeFiles(String inputpath) {
		Analyze analyze = new Analyze(inputpath);
		indexObj = analyze.process();
	}
}
