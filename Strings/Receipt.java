import java.util.Formatter;

public class Receipt {
    private double total = 0;
    private Formatter formatter = new Formatter(System.out);

    private final int itemStringWidth = 15;
    private final int quantityStringWidth = 5;
    private final int priceStringWidth = 10;

    public void printTitle() {
        String string = "%-" + itemStringWidth + "s %" + quantityStringWidth + "s %" + priceStringWidth + "s\n";
        formatter.format(string, "Item", "Qty", "Price");
        formatter.format(string, "----", "---", "-----");
    }

    public void print(String name, int qty, double price) {
        formatter.format("%-" + itemStringWidth + ".15s %" + quantityStringWidth + "d %" + priceStringWidth + ".2f\n", name, qty, price);
        total += price;
    }

    public void printTotal() {
        String string = "%-" + itemStringWidth + "s %" + quantityStringWidth + "s %" + priceStringWidth;
        formatter.format(string + ".2f\n", "Tax", "", total * 0.13);
        formatter.format(string + "s\n", "", "", "-----");
        formatter.format(string + ".2f\n", "Total", "", total * 1.13);
    }

    public static void main(String[] args) {
        Receipt receipt = new Receipt();
        receipt.printTitle();
        receipt.print("Jack's Magic Beans", 4, 4.25);
        receipt.print("Princess Peas", 3, 5.1);
        receipt.print("Three Bears Porridge", 1, 14.29);
        receipt.printTotal();
    }
}