package jsonOperations;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class TopperFinder {
	Scanner scan = new Scanner(System.in);
	@SuppressWarnings("unchecked")
	public void writeToJsonFile() throws IOException
	{
		JSONObject oJsonObject = new JSONObject();
		System.out.println("Enter the number of students :");
		int numberOfStudents = scan.nextInt();
		//scan.next();
		for (int startCount = 0; startCount < numberOfStudents; startCount++)
		{
		System.out.println("Enter the Roll No :");
		oJsonObject.put("RollNo", scan.next());
		System.out.println("Enter the Student Name :");
		oJsonObject.put("StudentName", scan.next());
		System.out.println("Enter the Total Marks :");
		oJsonObject.put("TotalMarks",scan.next());
		System.out.println("Enter the Result :");
		oJsonObject.put("Result",scan.next());
		
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(oJsonObject);
		}
		scan.close();
		String userWorkingDirectory = System.getProperty("user.dir");
	    String path = userWorkingDirectory + File.separator ;
	    FileWriter file = new FileWriter(path +"StudentDetails.json");
		file.write(oJsonObject.toJSONString());
		file.close();
		System.out.println("File written successfully...");
	}
	public void readJsonFile() throws IOException, ParseException, ClassCastException
	{
		JSONParser oJsonParser = new JSONParser();
		String userWorkingDirectory = System.getProperty("user.dir");
	    String path = userWorkingDirectory + File.separator + "StudentDetails.json";
		FileReader oFileReader = new FileReader(path);
		Object parsedObject = oJsonParser.parse(oFileReader);
		JSONObject oJsonObject = (JSONObject) parsedObject;
		String rollNo = (String) oJsonObject.get("RollNo");
		String studentName = (String) oJsonObject.get("StudentName");
		String totalMarks = (String) oJsonObject.get("TotalMarks");
		String result = (String) oJsonObject.get("Result");
		System.out.println("File read successfully..");
		System.out.println("Roll No : "+rollNo);
		System.out.println("Student Name : "+studentName);
		System.out.println("Total Marks : "+totalMarks);
		System.out.println("Result : "+result);
		List<String> list = new ArrayList<String>();
		list.add(rollNo);
		list.add(studentName);
		list.add(totalMarks);
		list.add(result);
		//return list;
		
	}
	
	
	
	
}
	
		
		

		
	

	