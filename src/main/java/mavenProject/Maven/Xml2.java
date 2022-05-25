package mavenProject.Maven;

import java.io.*;
import java.util.Scanner;

/**
 * test id=1
 * Description =lc
 **/
public class Xml2 {
    File file;
    String fileName ;
    public void creatingFile(){
        fileName = new String();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name Your File:");
        fileName = scanner.nextLine();

        String userWorkingDirectory = System.getProperty("user.dir");
        String path = userWorkingDirectory + File.separator + fileName ;
        System.out.println(path);

        file = new File(path);
        try {
            boolean result = file.createNewFile();
            if(result){
                System.out.println("Assigned File name was new:" + file.getCanonicalPath() );
            } else {
                System.out.println(" File name was already present and contents to be overriden " + file.getCanonicalPath());
            }
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
        scanner.close();
    }

    public void writingFile() throws IOException {
        FileWriter fileWriter;
        System.out.println("Contents to be Written in created file");
        fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        Scanner input = new Scanner(System.in);

        String Lines = " ";
        while (!Lines.equals("Exit")) {
            Lines = input.nextLine();
            if (Lines.equals("Exit")) {
                break;
            }else {
                bufferedWriter.write(Lines);
                bufferedWriter.newLine();
            }
        }
        bufferedWriter.flush();
        bufferedWriter.close();
        input.close();
    }

    public void readingFile() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String read;
        while ((read=bufferedReader.readLine())!=null){
            System.out.println("Contents present in created File:"+ read);
        }
        bufferedReader.close();

    }

    public void analysingFile() throws IOException {
        BufferedReader bufferedReader;
        int lineCount = 0;
        int wordCount = 0;
        bufferedReader = new BufferedReader(new FileReader(file));
        String currentLine = bufferedReader.readLine();
        while (currentLine!=null){
            lineCount ++;
            String [] words = currentLine.split(" ");
            wordCount = wordCount + words.length;
            currentLine=bufferedReader.readLine();
        }
        System.out.println("Number of Line:  "+ lineCount);
        System.out.println("Number of Words:  "+ wordCount);
        bufferedReader.close();
    }


    public static void main(String[] args) throws IOException {
        Xml2 handlingFile = new Xml2();
        handlingFile.creatingFile();
        handlingFile.writingFile();
        handlingFile.readingFile();
        handlingFile.analysingFile();
    }
}
