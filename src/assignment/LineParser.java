package assignment;

import java.util.ArrayList;

public class LineParser {

	public ArrayList<String> parseLine(String line) {
		// Use space and various puncutation marks as delimiters
		String[] splitWords = line
				.split(" |,|\"|\\.|;|\\?|\\(|\\)|-|!|/|:|\\[|\\]");
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
