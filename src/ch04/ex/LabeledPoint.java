package ch04.ex;

import java.util.Objects;

public class LabeledPoint extends Point{
    private final String label;
    public LabeledPoint(String label, double x, double y){
        super(x, y);
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

    public double dist(Point to){
        return Math.sqrt(Math.pow(this.x - to.x, 2) + Math.pow(this.y - to.y,2));
    }

    public double distFromOrigin(){
        Point o = new Point(0,0);
        return this.dist(o);
    }

    @Override
    public String toString(){
        return this.getClass().getName() + " [label=" + this.label + " x=" + this.x + " y=" + this.y + "]";
    }

    @Override
    public boolean equals(Object other){
        if(other == this) return true;
        if(other == null) return false;
        if(other.getClass() != this.getClass()) return false;

        LabeledPoint otherP = (LabeledPoint) other;
        return otherP.label.equals(label) && otherP.x == this.x && otherP.y == this.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.label, this.x, this.y);
    }
}
