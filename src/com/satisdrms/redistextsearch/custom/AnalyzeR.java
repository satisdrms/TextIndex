package com.satisdrms.redistextsearch.custom;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Map;

public class AnalyzeR implements CGrammar {
	String inputPath;
	BufferedReader reader = null;
	IndexR indexObj;
	String filePathInWindows = null;

	public AnalyzeR(String inputPath) {
		indexObj = new IndexR();
		this.inputPath = inputPath;
	}

	public IndexR process() {

		filePathInWindows = inputPath;
		if (inputPath == null)
			return null;

		LinkedList<File> allFiles = findAllFilesInSubFolders(filePathInWindows);

		for (File file : allFiles) {
			System.out.println(file.toString());
			if (file.isFile()) {
				tokenizeCCodeAndAddToIndex(file);
			}
		}
		return indexObj;
	}

	private LinkedList<File> findAllFilesInSubFolders(String filePathInWindows) {
		File initialFolder = new File(filePathInWindows);
		LinkedList<File> allFiles = new LinkedList<File>();
		LinkedList<File> processFolders = new LinkedList<File>();
		processFolders.add(initialFolder);
		while (true) {
			LinkedList<File> nextLevel = new LinkedList<File>();
			while (!processFolders.isEmpty()) {
				File folder = processFolders.remove();
				if (folder.isDirectory()) {
					nextLevel.addAll(Arrays.asList(folder.listFiles()));
				} else {
					allFiles.add(folder);
				}
			}
			if (nextLevel.size() == 0)
				break;
			else
				processFolders.addAll(nextLevel);
		}
		return allFiles;
	}

	/**
	 * @param xc
	 */
	@SuppressWarnings("unused")
	private void slp(int xc) {
		try {
			Thread.sleep(xc);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void tokenizeCCodeAndAddToIndex(File file) {
		try {
			StringBuilder content = new StringBuilder(new String(
					Files.readAllBytes(Paths.get(file.toURI()))));
			IndexR tokens = CParser.parse(content, file);
		} catch (IOException e) {
		}

	}

	public String getRelativePath(File file, String folderPath) {
		folderPath = folderPath.replace('/', '\\');
		folderPath = folderPath.substring(1);
		String filePath = file.getAbsolutePath();
		String finFile = null;
		if (filePath.startsWith(folderPath)) {
			finFile = filePath.substring(folderPath.length());
		}
		return finFile;
	}

}
