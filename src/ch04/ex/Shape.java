package ch04.ex;

public abstract class Shape {
    public Point p;
    public Shape(Point p){
        this.p = p;
    }

    public void moveBy(double dx, double dy){
        p.x += dx;
        p.y += dy;
    }

    public abstract Point getCenter();
}
