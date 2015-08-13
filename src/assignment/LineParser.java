package assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class LineParser {
	/*
	 * Class for parsing words from line and updating sentenceCount in
	 * Concordance class
	 */

	public ArrayList<String> parseLine(String line, Concordance concordance) {
		// Use space and punctuation marks ( ) , " . ? ! - : [ ] as delimiters
		// for words

		String periodRegex = "[^\\. ]{3}\\."; // ignore i.e., e.g.
		String sentenceEndingPunctuations = "[?!;]" + "|" + periodRegex;
		String otherPunctuations = "[ ,:\"\\]\\[\\(\\)]";

		// Update number of sentences
		concordance.sentenceCount = line.split(sentenceEndingPunctuations).length;
		System.out.println(concordance.sentenceCount + "<<<<<<<<<<<<<<<<<<");
		// Split the line into words
		String[] splitWords = line.split(otherPunctuations + "|"
				+ sentenceEndingPunctuations);
		
		for (char c: line.toCharArray()){
			if (c=='?' || c=='!'|| c==';') || (c == '.')
		}
		
		
		// Check each word before adding it to wordList
		ArrayList<String> wordList = new ArrayList<String>();
		for (String s : splitWords) {
			String parsedS = parseWord(s);
			if (parsedS != null) {
				wordList.add(parsedS);
			}
		}

		return wordList;
	}

	private String parseWord(String word) {
		word = word.trim().toLowerCase(); // remove unwanted spaces and convert
											// to lowercase

		// Ignore empty strings, and strings that are not words
		if (word.length() == 0 || !isWord(word))
			return null;

		return word;
	}

	// Returns true if the parameter word is composed of just letters and
	// possibly apostrophe and period
	private boolean isWord(String word) {
		// ignore single apostrophe
		if (word.equals("'"))
			return false;

		// check each char and determine whether the word is composed of
		// letters, apostrophe or period
		boolean isWord = true;
		for (char s : word.toCharArray()) {
			isWord = isWord
					&& ((s >= 'a' && s <= 'z') || (s == '\'') || (s == '.'));
		}

		return isWord;
	}
}
