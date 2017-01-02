/**
 * Class for reading in and writing out csv/txt files.
 * @author joshstringfellow
 */
package uk.ac.kingston.ci5100.football.a1.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author joshstringfellow
 */
public class DataFiles {
    
    public static String[] readCSV(String filePath) {
        String[] csvStringArray = new String[countLines(filePath)];
        try {
           // file read statements here
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            // Column attribute info line
            String headerString = br.readLine();
            csvStringArray[0] = br.readLine();
            int lineCount = 1;
            while (br.ready()) {
                csvStringArray[lineCount] = br.readLine();
                lineCount++;
            }
        } catch(Exception e) {
            System.out.println("readCSV ran into error parsing file.");
        }
        return csvStringArray;
    }
    
    public static int countLines(String filePath) {
        int lineCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) lineCount++;
        } catch(Exception e) {
            System.out.println("countLines method ran into error reading file.");
        }
        System.out.println(lineCount);
        // -1 to ingore header line.
        return lineCount -1;
    }
    
    public static void outputFormattedData(String fileName, String data) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(fileName);
            fileWriter.write(data);
        } catch (Exception e) {
            System.out.println("Error in outputting formatted data.");
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
            }
        }
    }
    
//    public static void writeCSV(String fileName, String[] data, String header) {
//        FileWriter fileWriter = null;
//        try {
//            fileWriter = new FileWriter(fileName);
//            //Write the CSV file header
//            fileWriter.append(header);
//            //Add a new line separator after the header
//            fileWriter.append(NEW_LINE_SEPARATOR);
//            //Write a new student object list to the CSV file
//            for (Student student : students) {
//                fileWriter.append(String.valueOf(student.getId()));
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(student.getFirstName());
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(student.getLastName());
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(student.getGender());
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(String.valueOf(student.getAge()));
//                fileWriter.append(NEW_LINE_SEPARATOR);
//            }
//            System.out.println("CSV file was created successfully !!!");
//        } catch (Exception e) {
//            System.out.println("Error in CsvFileWriter !!!");
//            e.printStackTrace();
//        } finally {
//            try {
//                fileWriter.flush();
//                fileWriter.close();
//            } catch (IOException e) {
//                System.out.println("Error while flushing/closing fileWriter !!!");
//                e.printStackTrace();
//            }
//        }
//    }
}
