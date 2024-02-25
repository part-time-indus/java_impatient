package ch04.ex;

import java.util.Objects;

public class Item {
    private final String description;
    private final double price;

    public Item(String description, double price){
        this.description = description;
        this.price = price;
    }

    @Override
    public boolean equals(Object other){
        if(this == other) return true;
        if(other == null) return false;
        if(!(other instanceof Item otherObj)) return false;
        return otherObj.price == this.price && this.description.equals(otherObj.description);
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.description, this.price);
    }
}
