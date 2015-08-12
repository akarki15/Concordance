package assignment;

import java.util.ArrayList;

public class FreqAndOccur {

	public int frequency = 0;
	public ArrayList<Integer> lineNumbers = new ArrayList<Integer>();

	public FreqAndOccur(int lineNumber) {
		addFreqAndOccur(lineNumber);
	}

	public void addFreqAndOccur(int lineNumber) {
		frequency++;
		lineNumbers.add(lineNumber);
	}
}
