package assignment;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

public class Concordance {

	String inputFilePath;
	TreeMap<String, FreqAndOccur> frequencyMap = new TreeMap<String, FreqAndOccur>();

	public static void main(String[] args) {

		Concordance concordance = new Concordance(
				"/Users/aashishkarki/Desktop/metamorphosis.txt");
		concordance.printConcordance();
	}

	public Concordance(String inputFilePath) {
		this.inputFilePath = inputFilePath;
		generateConcordance();
	}

	private void printConcordance() {
		for (String key : frequencyMap.keySet()) {
			System.out.println(key + "\t" + frequencyMap.get(key).frequency);
		}

	}

	private void generateConcordance() {

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					inputFilePath));
			String line = "";
			LineParser lineParser = new LineParser();
			while ((line = bufferedReader.readLine()) != null) {
				ArrayList<String> wordList = lineParser.parseLine(line);
				processLine(wordList);
			}

			bufferedReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found " + inputFilePath);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error in reading file " + inputFilePath);
			e.printStackTrace();
		}

	}

	private void processLine(ArrayList<String> wordList) {
		for (String s : wordList) {
			if (frequencyMap.containsKey(s)) {
				frequencyMap.get(s).addFreqAndOccur(111);
				;
			} else {
				frequencyMap.put(s, new FreqAndOccur(111));
			}
		}
	}

}
