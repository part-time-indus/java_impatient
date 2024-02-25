package ch04.ex;

public class DiscountedItem extends Item{
    private final double discount;

    DiscountedItem(String description, double price, double discount){
        super(description, price);
        this.discount = discount;
    }

    @Override
    public boolean equals(Object other){
        if(!super.equals(other)) return false;
        if(other.getClass() == this.getClass()){
            DiscountedItem discObj = (DiscountedItem) other;
            return discount == discObj.discount;
        }
        return true;

    }


}
