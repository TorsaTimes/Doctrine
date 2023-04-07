package ctr;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) throws FileNotFoundException {

			SensorAggregator sA = new SensorAggregator();
			
			System.out.println(sA.getMax("T (degC)","02.01.2009 00:00:00" , "02.01.2009 23:50:00"));
	}
	}
	


