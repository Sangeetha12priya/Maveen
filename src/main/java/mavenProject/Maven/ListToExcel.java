package mavenProject.Maven;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ListToExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream out = new FileOutputStream(new File("C:\\Users\\sangeetha.kulasekara\\eclipse-workspace\\Maven\\TaskXL\\xlsheet.xslx"));
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Employee Data");
		
		List <String> l1 = new ArrayList<String>();
		l1.add("l1  1");
		l1.add("l1  2");
		
		List <String> l2 = new ArrayList<String>();
		l2.add("l2  1");
		l2.add("l2  2");
		
		List <List <String>> list = new ArrayList <List <String>>();
		list.add(l1);
		list.add(l2);
		
		Iterator <List <String>> i = list.iterator();
		int rownum = 0;
		int cellnum = 0;
		
		while(i.hasNext()) {
			List <String> templist = (List <String>)i.next();
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
