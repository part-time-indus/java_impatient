package ch04.ex;

public class PointTest {

    public static void main(String[] args) {
        LabeledPoint lp = new LabeledPoint("E",10.4,5.2);
        Point p = new Point(-2.3,4.1);
        System.out.println(lp.dist(p));
        System.out.println(lp.distFromOrigin());
    }

}