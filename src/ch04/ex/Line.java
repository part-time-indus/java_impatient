package ch04.ex;

public class Line  extends Shape{

    private final Point to;
    public Line(Point from, Point to){
        super(from);
        this.to = to;
    }
    @Override
    public Point getCenter(){
        return new Point((p.x - to.x)/2, (p.y - to.y)/2);
    }

    @Override
    public Line clone() throws CloneNotSupportedException{
        return (Line) super.clone();
    }
}
