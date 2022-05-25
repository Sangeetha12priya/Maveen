package mavenProject.Maven;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Xml {

	public static List<String> changeList(String filename) throws IOException
	{
		List <String> result = new ArrayList<>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader (filename));
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
				br.close();
			}
		}
		return result;
		
	}
	public static void main(String [] args) {
		String filename = "C:\\Users\\sangeetha.kulasekara\\eclipse-workspace\\Maven\\TaskXL\\StudentOne.txt";
		List<String> list = null;
		try {
			list = changeList(filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//list.forEach(System.out::println);
		System.out.println(list);
	}

}
