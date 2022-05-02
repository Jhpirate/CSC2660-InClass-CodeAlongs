package week1_lash_3_16;

import java.util.ArrayList;
import java.util.Random;

// internal static classes know all about each other even if private. That's why its now extracted here
//class Item {
//    // Attributes (global to class)
//    private int itemID;
//    private String itemName;
//    private int qtyOnHand;
//    private double itemCost;
//    private double itemPrice;
//
//    // Default constructor
//    public Item() {
//        this.itemID = Integer.MIN_VALUE;
//        this.itemName = null;
//        this.qtyOnHand = Integer.MIN_VALUE;
//        this.itemCost = 0.00d;
//        this.itemPrice = 0.00d;
//    }
//
//    // Arg-based constructor
//    public Item(int itemID, String itemName, String qtyOnHand, double itemCost, double itemPrice) {
//        this.itemID = itemID;
//        this.itemName = itemName;
//        setQtyOnHand(qtyOnHand);
//        this.itemCost = itemCost;
//        this.itemPrice = itemPrice;
//    }
//
//    public void setQtyOnHand(String qtyOnHand) {
//        try {
//            this.qtyOnHand = Integer.parseInt(String.valueOf(qtyOnHand));
//        } catch (Exception e) {
//            this.qtyOnHand = 0;
//            throw e; //hand off to Java to kill the program
//        }
//    }
//
//    // Get total item value
//    public double calcTotalInventoryValue() {
//        return qtyOnHand * itemCost;
//    }
//
//    public int getItemID() {
//        return itemID;
//    }
//
//    @Override
//    public String toString() {
//        return "Item{" +
//                "itemID=" + itemID +
//                ", itemName='" + itemName + '\'' +
//                ", qtyOnHand=" + qtyOnHand +
//                ", itemCost=" + itemCost +
//                ", itemPrice=" + itemPrice +
//                '}';
//    }
//}

public class InventoryManagement {

    public static void main(String[] args) {
        ArrayList<Item> itemList = new ArrayList<>();
        itemList.add(new Item(0, "Pliers", String.valueOf(12), 5.00, 6.99, "A"));
//        itemList.add(new Item(itemList.get(itemList.size() - 1).getItemID() + 1, "Nails", String.valueOf(1000), 0.01, 0.10, "B"));
//        itemList.add(new Item(itemList.get(itemList.size() - 1).getItemID() + 1, "Hammer", 50, 7.34, 9.99));
//        itemList.add(new Item(itemList.get(itemList.size() - 1).getItemID() + 1, "Hammer", "Hello", 7.34, 9.99));

        // add a bunch of random items
        final String[] ITEMS = {"outlet", "door", "soda can", "fridge", "radio", "sandal", "greeting card", "shoe lace", "lip gloss", "fork"};
        final Random rand = new Random();
        for (String item : ITEMS) {
            itemList.add(new Item(itemList.get(itemList.size() - 1).getItemID() + 1, item, String.valueOf(rand.nextInt(1000)), rand.nextInt(100000) / 100d, rand.nextInt(100000) / 100d, "A"));
        }


        for (Item currentItem : itemList) {
            System.out.printf("%s | totalItemCost: $%,.2f\n", currentItem, currentItem.calcTotalInventoryValue());
        }


    }
}
