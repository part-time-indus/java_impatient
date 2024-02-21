package ch04.ex;

public class Rectangle extends Shape implements Cloneable{
    private final double width;
    private final double height;
    public Rectangle(Point topLeft, double width, double height){
        super(topLeft);
        this.width = width;
        this.height = height;
    }

    @Override

    public Point getCenter(){
        return new Point(this.p.x + (this.width/2), this.p.y + (this.height/2));
    }

    @Override
    public Rectangle clone() throws CloneNotSupportedException{
        Rectangle cloneRect = (Rectangle) super.clone();
        cloneRect.p = (Point) this.p.clone();
        return cloneRect;
    }
}

