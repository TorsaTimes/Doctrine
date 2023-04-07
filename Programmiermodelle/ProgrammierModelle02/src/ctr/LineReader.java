package ctr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.Iterator;

public class LineReader implements Iterable<String>{

	FileIterator fI;

	public LineReader(Reader reader) {
	BufferedReader buffreader = new BufferedReader(reader); 
	fI = new FileIterator(buffreader);	

	}

	@Override
	public Iterator<String> iterator() {
		return fI;
	}

}
