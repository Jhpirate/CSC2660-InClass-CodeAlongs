package Simple_CSV_Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ParseCSVFile {
    public static void main(String[] args) {
        try {
            Scanner csvFile = new Scanner(new File("./sampleCSVFIle.csv"));

            //print the header here
            System.out.println("Name | Age | Gender | Major");

            // loop through the file until there are no more contents in it
            while (csvFile.hasNextLine()) {
                // get a single row from the file
                String singleRow = csvFile.nextLine();

                //split the row by commas
                String[] columnsFromRow = singleRow.split(",");

                // you can now address each column of the row you split above by columnsFromRow[index here]
                System.out.printf("%s | %s | %s | %s\n", columnsFromRow[0], columnsFromRow[1], columnsFromRow[2], columnsFromRow[3]);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
