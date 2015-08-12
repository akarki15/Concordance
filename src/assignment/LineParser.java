package assignment;

import java.util.ArrayList;

public class LineParser {

	public ArrayList<String> parseLine(String line, Concordance concordance) {
		// Use space and punctuation marks ( ) , " . ? ! - : [ ] as delimiters
		// for words
		String punctuationRegex = "[ ,?!:\"\\]\\[\\(\\)]+";
		String periodRegex = "[a-zA-Z\\]\\)\\}0-9]{3}.[a-zA-Z\\]\\)\\}0-9]{3}";

		// String[] splitWords = line
		// .split(" |,|\"|\\.|;|\\?|\\(|\\)|-|!|/|:|\\[|\\]");
		String[] splitWords = line.split(punctuationRegex );
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
	// possibly apostrophe
	private boolean isWord(String word) {
		// ignore single apostrophe
		if (word.equals("'"))
			return false;

		// check each char and determine whether the word is composed of letters
		// and apostrophe
		boolean isWord = true;
		for (char s : word.toCharArray()) {
			isWord = isWord && ((s >= 'a' && s <= 'z') || (s == '\''));
		}

		return isWord;
	}
}
