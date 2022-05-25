package jsonOperations;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Runner {

	public static void main(String[] args) throws IOException, ParseException {
		
		JsonOperations oJsonOperations = new JsonOperations();
		oJsonOperations.writeJsonFile();
		oJsonOperations.writeExcel(oJsonOperations.readJsonFile());

	}

}
