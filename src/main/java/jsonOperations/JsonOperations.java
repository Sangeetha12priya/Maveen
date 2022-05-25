package jsonOperations;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonOperations {
	Scanner scan = new Scanner(System.in);
	@SuppressWarnings("unchecked")
	public void writeJsonFile() throws IOException
	{
		JSONObject oJsonObject = new JSONObject();
		System.out.println("EmployeeId :");
		oJsonObject.put("EmployeeID", scan.nextLine());
		System.out.println("Employee Name :");
		oJsonObject.put("EmployeeName", scan.nextLine());
		System.out.println("Employee Role :");
		oJsonObject.put("EmployeeRole",scan.nextLine());
		scan.close();
		String userWorkingDirectory = System.getProperty("user.dir");
	    String path = userWorkingDirectory + File.separator ;
	    FileWriter file = new FileWriter(path +"employeeDetails.json");
		file.write(oJsonObject.toJSONString());
		file.close();
		System.out.println("File written successfully...");
	}
	
	public List<String> readJsonFile() throws IOException, ParseException, ClassCastException
	{
		JSONParser oJsonParser = new JSONParser();
		String userWorkingDirectory = System.getProperty("user.dir");
	    String path = userWorkingDirectory + File.separator + "employeeDetails.json";
		FileReader oFileReader = new FileReader(path);
		Object parsedObject = oJsonParser.parse(oFileReader);
		JSONObject oJsonObject = (JSONObject) parsedObject;
		String id = (String) oJsonObject.get("EmployeeID");
		String name = (String) oJsonObject.get("EmployeeName");
		String role = (String) oJsonObject.get("EmployeeRole");
		System.out.println("File read successfully..");
		System.out.println("EmployeeID : "+id);
		System.out.println("EmployeeName : "+name);
		System.out.println("EmployeeRole : "+role);
		List<String> list = new ArrayList<String>();
		list.add(id);
		list.add(name);
		list.add(role);
		return list;
		
	}
	
	public void writeExcel(List<String> list) throws IOException
	{
		String userWorkingDirectory = System.getProperty("user.dir");
	    String path = userWorkingDirectory + File.separator + "TaskXL" + File.separator + "EmployeeSheet.xlsx";
		FileOutputStream out = new FileOutputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Employee Data2");
		XSSFRow row;
		
        Map <String,List<String>> map = new LinkedHashMap<String,List<String>>();
        map.put("1", list);
        
        Set<String> keyid = map.keySet();
        int rowid = 0;
  
        for (String key : keyid) {
  
            row = sheet.createRow(rowid++);
            List<String> objectArr = map.get(key);
            int cellid = 0;
  
            for (Object obj : objectArr) {
                Cell cell = row.createCell(cellid++);
                cell.setCellValue((String)obj);
            }
            workbook.write(out);
            System.out.println("Excel file written successfully..");
            workbook.close();
        }
                          
	}
}
