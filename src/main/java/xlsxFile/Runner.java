package xlsxFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) throws IOException {
		ReadTextWriteExcel oReadTextWriteExcel = new ReadTextWriteExcel();
		Scanner scan = new Scanner (System.in);
		String filename1,filename2,filename3;
        System.out.println("Name Your File1:");
        filename1 = scan.nextLine();
        String userWorkingDirectory1 = System.getProperty("user.dir");
        String path1 = userWorkingDirectory1 + File.separator + filename1 ;
        System.out.println(path1);
        System.out.println("Name Your File2:");
        filename2 = scan.nextLine();
        String userWorkingDirectory2 = System.getProperty("user.dir");
        String path2 = userWorkingDirectory2 + File.separator + filename2 ;
        System.out.println(path2);
        System.out.println("Name Your File3:");
        filename3 = scan.nextLine();
        String userWorkingDirectory3 = System.getProperty("user.dir");
        String path3 = userWorkingDirectory3 + File.separator + filename3 ;
        System.out.println(path3);
        scan.close();
//		String filename1 = "C:\\Users\\sangeetha.kulasekara\\eclipse-workspace\\Maven\\TaskXL\\StudentOne.txt";
//		String filename2 = "C:\\Users\\sangeetha.kulasekara\\eclipse-workspace\\Maven\\TaskXL\\StudentTwo.txt";
//		String filename3 = "C:\\Users\\sangeetha.kulasekara\\eclipse-workspace\\Maven\\TaskXL\\StudentThree.txt";
		List<String> list1 = null;
		List<String> list2 = null;
		List<String> list3 = null;
		try {
			list1 = ReadTextWriteExcel.readTextAndMakeList(filename1);
			list2 = ReadTextWriteExcel.readTextAndMakeList(filename2);
			list3 = ReadTextWriteExcel.readTextAndMakeList(filename3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list1);
		System.out.println(list2);
		System.out.println(list3);
		oReadTextWriteExcel.listToExcel(list1, list2, list3);
		
	}

}
