package ctr;

import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;


public class SensorAggregator {

	private String line = "";

	public double getMax(String sensorName, String from, String to) {
	
		final List<String> headerLineFromCsvData = new ArrayList<>();//List für den Header der CSV-Datei - Die Sensornamen
		final List<String[]> list = new ArrayList<String[]>();//Liste in der mit hilfe des Bufferreaders die lines erreingespeichert werden

		final int indexNumberOfToDate;//Zeilen index des Anfangsdatums From sprich welche der ca. 42000 zeilen ist die, die mit from übereinstimmt
		final int indexNumberOfFromDate;//Zeilen index des enddatums to sprich welche der ca. 42000 zeilen ist die, die mit to übereinstimmt

		final String sensorVar = ("\"" + sensorName + "\"");//Sensorname für Pattern Match genutzt.

		try {
			@SuppressWarnings("resource")
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Samde\\Dropbox\\Semester4\\Programmiermodelle\\Praktikum\\Neuer Ordner\\jena.csv"));
			

			while ((line = br.readLine()) != null) {
				final String[] lineValuesAsArray = line.split(",");
				list.add(lineValuesAsArray);
				headerLineFromCsvData.add(line);
			}
		} catch (IOException e) {
		}
			//---------------------------------------------------------------------------------------------------
		final List<String> findIndexOfSensorName = Arrays.asList(headerLineFromCsvData.get(0).split(","));//Header row in der CSV Datei in eigener List<String> speichern

			final String indexOftheFirstColumn = IntStream.range(0, findIndexOfSensorName.size())//den Index (die Column) herrausfinden mit hilfe des Sensornamens (Pattern)
					.filter(s -> findIndexOfSensorName.get(s).equals(sensorVar)).mapToObj(String::valueOf)
					.collect(Collectors.joining());

			final int indexNumberOfSensorColumns = Integer.parseInt(indexOftheFirstColumn);//index der Column in der CSV-Datei (welche werte gebraucht werden)
			//----------------------------------------------------------------------------------------------------------------------------------------------
			//------------------------------------------------------------------------------------------------------------------------------------------------
			final String ergOfFromDateIndex = IntStream.rangeClosed(0, list.size()-1)//die row mit dem Datum From ausfinding machen
						.filter(x -> list.get(x)[0].equals(from)).mapToObj(String::valueOf).collect(Collectors.joining(","));
			indexNumberOfFromDate = Integer.parseInt(ergOfFromDateIndex);
			
			final String ergOfToDateIndex = IntStream.rangeClosed(0, list.size()-1).filter(x -> list.get(x)[0].equals(to))//die row mit dem Datum to ausfinding machen
					.mapToObj(String::valueOf).collect(Collectors.joining(","));
			indexNumberOfToDate = Integer.parseInt(ergOfToDateIndex);
			//-------------------------------------------------------------------------------------------------------------------------------------------------------
			
			final List<String[]> stream = list.stream().skip(indexNumberOfFromDate).limit((indexNumberOfToDate - indexNumberOfFromDate)+1).collect(Collectors.toList());//Von der grossen Liste nur die rows extrahieren die zwischen dem 
			final List<String> value = (List<String>) stream.stream().map(s -> s[indexNumberOfSensorColumns]).collect(Collectors.toList());//Die Zeilen von Date from bis Date To mit dem Index (der column) von dem Sensornamen extrahieren

			final DoubleStream ds = value.stream().mapToDouble(Double::parseDouble);//Die List mit den Werten in ein DoubleStream parsen 

		final Double result = (ds.max().getAsDouble())*100;//Den DoubleStream mit max filtern um den grössten Wert herrauszufinden und in einer Final variable speichern
			
		return result;
	}
}

