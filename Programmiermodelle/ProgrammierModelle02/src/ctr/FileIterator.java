package ctr;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

public class FileIterator implements Iterator<String> {

	BufferedReader reader;
	String zwischenSpeicher = "";
	boolean wasNext = false;

	public FileIterator(BufferedReader br) {
		this.reader = br;
	}

	@Override
	public boolean hasNext() {
		if (wasNext == false) {
			try {
				zwischenSpeicher = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			wasNext = true;
			return (zwischenSpeicher != null);
		} else {
			return (zwischenSpeicher != null);
		}
	}

	@Override
	public String next() {
		if (wasNext == false) {
			try {
				zwischenSpeicher = reader.readLine();
			} catch (IOException e) {

				e.printStackTrace();
			}
			wasNext = true;
			return zwischenSpeicher;
		} else {
			wasNext = false;
			return zwischenSpeicher;
		}
	}

}
