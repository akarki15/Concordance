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
	boolean printSentenceNumbers = false;

	public static void main(String[] args) {

		if (args.length < 1) {
			System.out.println("Usage: java Concordance <path> [L] \n");
			System.out.println("<path> \t Path to the input text file");
			System.out
					.println("L \t Optional parameter that displays line numbers");
		} else {
			Concordance concordance = new Concordance(args[0]);
			if (args.length > 1 && args[1].toLowerCase().equals("l")) {
				concordance.printSentenceNumbers = true;
			}
			concordance.printConcordance();
		}
		// ~/Desktop/jam/Bridgewater/src/assignment/testFiles/HuckleberryFinn.txt
		// Concordance concordance = new Concordance(args[0]);
		// concordance.printConcordance();

	}

	public Concordance(String inputFilePath) {
		this.inputFilePath = inputFilePath;
		generateConcordance();
	}

	private void printConcordance() {
		for (String key : frequencyMap.keySet()) {
			System.out.println(key + "\t\t" + frequencyMap.get(key).frequency);
			if (printSentenceNumbers) {
				System.out.print("\t[");
			}
		}

	}

	private void generateConcordance() {

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(
					inputFilePath));
			String line = "";
			int lineCount = 0;
			LineParser lineParser = new LineParser();
			while ((line = bufferedReader.readLine()) != null) {
				lineCount++;
				ArrayList<String> wordList = lineParser.parseLine(line);
				processLine(wordList, lineCount);
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

	private void processLine(ArrayList<String> wordList, int lineCount) {
		for (String s : wordList) {
			if (frequencyMap.containsKey(s)) {
				frequencyMap.get(s).addFreqAndOccur(lineCount);
				;
			} else {
				frequencyMap.put(s, new FreqAndOccur(lineCount));
			}
		}
	}

}
