package trailJson;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class TopperFinder {

	String jsonFile;
	Scanner scanner = new Scanner(System.in);
	FileReader fileReader;
	String path;
	JSONObject jsonObject1;
	JSONArray jsonArray = new JSONArray();
	String rollNo1, name1, Mark1, Result1;
	ArrayList<String> list;
	ArrayList<String> stringStore;

	@SuppressWarnings("unchecked")
	public void writeToJsonFile() {

		System.out.println("Enter the File Name");
		jsonFile = scanner.next();

		String userPath = System.getProperty("user.dir");
		path = userPath + File.separator + jsonFile;
		FileWriter file = null;
		try {
			file = new FileWriter(path);
		} catch (IOException e) {

			e.printStackTrace();
		}
		int studentCount = 5;

		for (int index = 0; index < studentCount; index++) {
			jsonObject1 = new JSONObject();
			System.out.println("Enter the rollNo: ");
			jsonObject1.put("student rollNo", scanner.next());
			System.out.println("Enter the name: ");
			jsonObject1.put("student name", scanner.next());
			System.out.println("Enter the mark: ");
			jsonObject1.put("student Mark", scanner.next());
			System.out.println("Enter the result: ");
			jsonObject1.put("student Result", scanner.next());
			System.out.println("Student MarkSheet: " + jsonObject1);

			jsonArray.add(jsonObject1);
		}

		try {

			file.write(jsonArray.toJSONString());
			file.close();

		} catch (IOException exp) {

			exp.printStackTrace();
		}
		System.out.println("JSON1 file created..... ");
	}

	public ArrayList<String> readJsonFile(int num) {

		@SuppressWarnings("unused")
		JSONObject jsonObj1 = new JSONObject();

		JSONParser jsonParser = new JSONParser();

		JSONArray jsonArray = new JSONArray();

		try {
			list = new ArrayList<String>();
			fileReader = new FileReader(path);

			jsonArray = (JSONArray) jsonParser.parse(fileReader);
			System.out.println(jsonArray);

			JSONObject jsonObject2 = (JSONObject) jsonArray.get(num);

			rollNo1 = (String) jsonObject2.get("student rollNo");
			System.out.println("Student RollNo " + rollNo1);
			name1 = (String) jsonObject2.get("student name");
			System.out.println("Student Name " + name1);
			Mark1 = (String) jsonObject2.get("student Mark");
			System.out.println("Student Mark " + Mark1);
			Result1 = (String) jsonObject2.get("student Result");
			System.out.println("Student Result " + Result1);

			list.add(rollNo1);
			list.add(name1);
			list.add(Mark1);
			list.add(Result1);
			System.out.println(list);

		} catch (Exception exp) {
			exp.printStackTrace();
		}
		return list;
	}

	public void findTheTopperStudent() {

		ArrayList<String> arrayList1 = readJsonFile(0);
		String mark1 = arrayList1.get(2);
		int string1 = Integer.parseInt(mark1);
		ArrayList<String> arrayList2 = readJsonFile(1);
		String mark2 = arrayList2.get(2);
		int string2 = Integer.parseInt(mark2);
		ArrayList<String> arrayList3 = readJsonFile(2);
		String mark3 = arrayList3.get(2);
		int string3 = Integer.parseInt(mark3);
		ArrayList<String> arrayList4 = readJsonFile(3);
		String mark4 = arrayList4.get(2);
		int string4 = Integer.parseInt(mark4);
		ArrayList<String> arrayList5 = readJsonFile(4);
		String mark5 = arrayList5.get(2);
		int string5 = Integer.parseInt(mark5);

		TreeSet<String> set = new TreeSet<String>();
		set.add(mark1);
		set.add(mark2);
		set.add(mark3);
		set.add(mark4);
		set.add(mark5);

		String compare = set.last();
		int string = Integer.parseInt(compare);

		System.out.println(set.last());
		stringStore = new ArrayList<String>();

		if (string == string1) {
			stringStore = arrayList1;
		} else if (string == string2) {
			stringStore = arrayList2;
		} else if (string == string3) {
			stringStore = arrayList3;
		} else if (string == string4) {
			stringStore = arrayList4;
		} else if (string == string5) {
			stringStore = arrayList5;
		}
		System.out.println("Topper Mark " + stringStore);
	}

	public void writeToXlsxFile() {

		System.out.println("Enter Your XLSX File Name:");
		String exlfile = scanner.next();

		String filePath = System.getProperty("user.dir");
		System.out.println(filePath);
		path = filePath + File.separator + exlfile;
		System.out.println(path);

		@SuppressWarnings("unused")
		File file = new File(path);

		try {

			FileInputStream fileInputStream = new FileInputStream(path);

			try {

				XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
				XSSFSheet xssfSheet = xssfWorkbook.createSheet("Sheet2");

				XSSFRow xssfRow;
				XSSFCell xssfCell;
				ArrayList<String> list = new ArrayList<String>();
				list.add("Roll Number");
				list.add("Name");
				list.add("Total Marks");
				list.add("Result");

				Map<String, ArrayList<String>> map = new TreeMap<String, ArrayList<String>>();
				map.put("0", list);
				map.put("1", stringStore);

				Set<String> set = map.keySet();

				int row = 0;
				for (String str : set) {
					xssfRow = xssfSheet.createRow(row++);
					ArrayList<String> objArray = map.get(str);

					int cell = 0;
					for (Object obj : objArray) {
						xssfCell = xssfRow.createCell(cell++);
						xssfCell.setCellValue((String) obj);
					}
				}

				FileOutputStream fileOutputStream = new FileOutputStream(path);
				xssfWorkbook.write(fileOutputStream);
				xssfWorkbook.close();
				fileOutputStream.close();
				System.out.println("File Successfully Created");

			} catch (FileNotFoundException e) {
// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		TopperFinder topperFinder = new TopperFinder();
		topperFinder.writeToJsonFile();
//topperFinder.readJsonFile();
		topperFinder.findTheTopperStudent();
		topperFinder.writeToXlsxFile();
	}

}
