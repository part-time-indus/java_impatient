package ch04.ex;

public class Main {
    public static void main(String[] varargs){
        Item item = new Item("Notebook A4", 5.0);
        DiscountedItem discItem = new DiscountedItem("Notebook A4", 5.0, 2.0);
        DiscountedItem discItem2 = new DiscountedItem("Notebook A4", 5.0, 2.5);
        if(item.equals(discItem)){
            System.out.println("Notebook A4 equals A4@2.0 disc");
        }
        if(!discItem.equals(discItem2)){
            System.out.println("Notebook A4@2.0 disc does not equal A4@2.5 disc");

        }
        if(item.equals(discItem2)){
            System.out.println("Notebook A4 equals A4@2.5 disc");

        }
        System.out.println("None are equal");
    }
}
