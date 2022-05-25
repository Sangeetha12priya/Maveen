package jsonOperations;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class TopperFindRunner {

	public static void main(String[] args) throws IOException, ParseException {
		
		TopperFinder oTopperFinder = new TopperFinder();
		oTopperFinder.writeToJsonFile();
		oTopperFinder.readJsonFile();

	}

}
