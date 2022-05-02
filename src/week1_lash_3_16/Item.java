package week1_lash_3_16;

public class Item {
    // Attributes (global to class)
    private int itemID;
    private String itemName;
    private int qtyOnHand;
    private double itemCost;
    private double itemPrice;
    private String warehouse;

    // Default constructor
    public Item() {
        this.itemID = Integer.MIN_VALUE;
        this.itemName = null;
        this.qtyOnHand = Integer.MIN_VALUE;
        this.itemCost = 0.00d;
        this.itemPrice = 0.00d;
        this.warehouse = null;
    }

    // Arg-based constructor
    public Item(int itemID, String itemName, String qtyOnHand, double itemCost, double itemPrice, String warehouse) {
        this.itemID = itemID;
        this.itemName = itemName;
        setQtyOnHand(qtyOnHand);
        this.itemCost = itemCost;
        this.itemPrice = itemPrice;
        this.warehouse = warehouse;
    }

    public void setQtyOnHand(String qtyOnHand) {
        try {
            this.qtyOnHand = Integer.parseInt(String.valueOf(qtyOnHand));
        } catch (Exception e) {
            this.qtyOnHand = 0;
            throw e; //hand off to Java to kill the program
        }
    }

    // Get total item value
    public double calcTotalInventoryValue() {
        return qtyOnHand * itemCost;
    }

    public int getItemID() {
        return itemID;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", itemName='" + itemName + '\'' +
                ", qtyOnHand=" + qtyOnHand +
                ", itemCost=" + itemCost +
                ", itemPrice=" + itemPrice +
                ", warehouse='" + warehouse + '\'' +
                '}';
    }

    public String csvExport() {
        return ("%d,%s,%d,%s,%s,%s\n".formatted(itemID, itemName, qtyOnHand, itemCost, itemPrice, warehouse));
    }
}
