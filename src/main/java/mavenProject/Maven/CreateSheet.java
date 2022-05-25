package mavenProject.Maven;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
public class CreateSheet  
	{  
	public void createAndAdd() throws Exception   
	{  
			String filename = "C:\\Users\\sangeetha.kulasekara\\eclipse-workspace\\Maven\\TaskXL\\xlsheet.xlsx";  
			//FileOutputStream fileOut = new FileOutputStream(filename);  

			FileInputStream fileIn = new FileInputStream(filename);
			XSSFWorkbook workBook = new XSSFWorkbook(fileIn);
			XSSFSheet sheet = workBook.createSheet("sheet2");

			XSSFRow nRow;
			  Object[] headerObject = new Object[]{"Name","Team"};
		      Object[] firstObject = new Object[]{"Sasi","Falcon"};
		      Object[] SecondObject = new Object[]{"Lokesh","COE"};
		      //Object[] thirdObject = new Object[]{"Akilan","CoE"};
		      Object[] finalObject = new Object[]{"uDHAY","WK"};

			/*Object[] headerObject =new Object[] {"RollNumber","StudentName","TotalMarks","Result"};
			Object[] firstObject = new Object[] {"112","Shiva","477","Pass"};
			Object[] SecondObject = new Object[] {"114","Raja","342","Pass"};
			Object[] finalObject = new Object[] {"117","Mani","171","Fail"};*/

			Map<String,Object[]> map = new TreeMap <String,Object[]>();
			map.put("0", headerObject);
			map.put("1", firstObject);
			map.put("2", SecondObject);
			map.put("3", finalObject);
			
			Set <String> key = map.keySet();
			int row = 0;
			
			for(String str : key)
			{
				nRow = sheet.createRow(row++);
				Object[] objArray = map.get(str);
				
				int cell = 0;
				for(Object obj : objArray)
				{
					XSSFCell xssfCell = nRow.createCell(cell++);
					xssfCell.setCellValue((String)obj);
				}
			}
			FileOutputStream fileOut = new FileOutputStream(filename); 
			workBook.write(fileOut);
			fileOut.close();  
			workBook.close();
			System.out.println("Excel file has been Writen successfully.");  
		
	}  
	
	public static void main(String arg[]) throws Exception
	{
		CreateSheet oCreateSheet = new CreateSheet();
		oCreateSheet.createAndAdd();
	}
}  