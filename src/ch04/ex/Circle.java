package ch04.ex;

public class Circle extends Shape implements Cloneable{
    private final double r;
    public Circle(double r, Point center){
        super(center);
        this.r = r;
    }
    @Override
    public Point getCenter(){
        return this.p;
    }

    @Override
    public Circle clone() throws CloneNotSupportedException{
        Circle cloneCircle = (Circle) super.clone();
        cloneCircle.p = (Point) this.p.clone();
        return cloneCircle;

    }
}
