package week1_lash_3_16;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


// JARED HEERINGA
// 03/25/2022
// NOTE: WENT OFF PLAN AND DID MY OWN STUFF
// MAY NOT WORK ON YOUR MACHINE

public class ReadInventoryFile {
    public static void main(String[] args) {
        final String fileName = "./inventoryItems.csv";
        System.out.println(System.getProperty("user.dir"));

        try {
            ArrayList<Item> item1 = readInventoryFile(fileName);
            ArrayList<Item> item2 = readInv2(fileName);

            System.out.println("Printing List #1 From Scanner and File");
            printItemsList(item1);

            System.out.println("Printing List #2 From Buffered Reader and File");
            printItemsList(item2);

            writeInventoryOutToDisk(item1, "newOutputFileName.txt");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printItemsList(ArrayList<Item> item) {
        for (Item currentItem : item) {
            System.out.println(currentItem);
        }
    }

    public static ArrayList<Item> readInventoryFile(String filePath) throws FileNotFoundException {
        ArrayList<Item> items = new ArrayList<>();

        Scanner inFile = new Scanner(new File(filePath));

        inFile.nextLine(); // move past header

        while (inFile.hasNextLine()) {
            String[] lineItems = inFile.nextLine().split("[,]");
            items.add(new Item(Integer.parseInt(lineItems[0]), lineItems[1], lineItems[2], Double.parseDouble(lineItems[3]), Double.parseDouble(lineItems[4]), lineItems[5]));
        }

        return items;
    }

    public static ArrayList<Item> readInv2(String filePath) throws FileNotFoundException {
        ArrayList<Item> items = new ArrayList<>();

        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        String line;
        try {
            bufferedReader.readLine(); //move past header in first row
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split("[,]");
                items.add(new Item(Integer.parseInt(tokens[0]),
                        tokens[1],
                        tokens[2],
                        Double.parseDouble(tokens[3]),
                        Double.parseDouble(tokens[4]),
                        tokens[5]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return items;
    }

    public static void writeInventoryOutToDisk(ArrayList<Item> inventory_items, String outputName) throws IOException {
        FileWriter fw = new FileWriter(new File("./" + outputName), false);

        fw.write("id,item_name,qtyOnHand,itemCost,itemPrice,warehouse\n");

        for (Item i : inventory_items) {
            fw.write(i.csvExport());
        }

        fw.close();
    }
}
