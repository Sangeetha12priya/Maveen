package xlsxFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTextWriteExcel {
	
	public static List <String> readTextAndMakeList(String fileName) 
	{
		List <String> result = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader (fileName));
			String line;
			while ((line=br.readLine())!= null) {
				result.add(line);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		finally {
			if(br!=null)
			{
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
		
	}
	public void listToExcel(List<String> list1,List<String> list2,List<String> list3) throws IOException
	{
		FileOutputStream out = new FileOutputStream(new File("C:\\Users\\sangeetha.kulasekara\\eclipse-workspace\\Maven\\TaskXL\\xlsheet.xslx"));
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Student Data");
		List <String> listHeader = new ArrayList <String>();
		listHeader.add("Roll Number");
		listHeader.add("Student Name");
		listHeader.add("Total Marks");
		listHeader.add("Result");		
		
		List <List <String>> list = new ArrayList <List <String>>();
		list.add(listHeader);
		list.add(list1);
		list.add(list2);
		list.add(list3);
		
		Iterator <List <String>> iterator = list.iterator();
		int rownum = 0;
		int cellnum = 0;
		
		while(iterator.hasNext()) {
			List <String> templist = (List <String>)iterator.next();
			Iterator <String> tempIterator = templist.iterator();
			Row row = sheet.createRow(rownum++);
			cellnum =0;
			while (tempIterator.hasNext()) {
				String temp = (String) tempIterator.next();
				Cell cell = row.createCell(cellnum++);
				cell.setCellValue(temp);
			}
		}
		System.out.println("File written successfully..");
		workbook.write(out);
		out.close();
		workbook.close();
	}
	

}
