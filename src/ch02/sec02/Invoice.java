package ch02.sec02;

import java.util.ArrayList;

public class Invoice{
    public static void main(String[] args){
        Invoice inv = new Invoice();
        inv.addItem(new Item("Shampoo", 10, 5));
        inv.addItem(new Item("Brush", 7, 1));
        inv.printInvoice();

    }
    private static class Item{
        String description;
        int unitPrice;
        int quantity;

        public Item(String description, int quantity, int unitPrice){
            this.description = description;
            this.quantity = quantity;
            this.unitPrice = unitPrice;
        }

        double price(){return quantity*unitPrice;}
    }
    private ArrayList<Item> items = new ArrayList<>();
    public void addItem(Item newItem){
        items.add(newItem);
    }

    public void printInvoice(){
        System.out.println("Description    Quantity    UnitPrice");
        for(Item item: items){
            int offset = 16-item.description.length() + 1;
            String formatStr = "%s" + "%" + offset + "d" + "%11d";
            System.out.printf(formatStr, item.description, item.quantity,item.unitPrice);
            System.out.println();
        }
    }
}
