package ch04.ex;

import java.util.Objects;

public class Point implements Cloneable {
    protected double x;
    protected double y;
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    @Override
    public String toString(){
        return this.getClass().getName() + " [x=" + this.x + " y=" + this.y + "]";
    }

    @Override
    public boolean equals(Object other){
        if(this == other) return true;
        if (other == null) return false;
        if(other.getClass() != getClass()) return false ;
        Point otherP = (Point) other;
        return otherP.x == this.x && otherP.y == this.y;
    }

    @Override
    public int hashCode(){
        return Objects.hash(this.x, this.y);
    }

    @Override
    public Point clone() throws CloneNotSupportedException{
        return (Point) super.clone();
    }

}