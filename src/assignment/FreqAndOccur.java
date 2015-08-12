package assignment;

import java.util.ArrayList;

public class FreqAndOccur {

	public int frequency = 0;
	public ArrayList<Integer> sentenceNumbers = new ArrayList<Integer>();

	public FreqAndOccur(int lineNumber) {
		addFreqAndOccur(lineNumber);
	}

	public void addFreqAndOccur(int lineNumber) {
		frequency++;
		sentenceNumbers.add(lineNumber);
	}
}
