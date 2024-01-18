package ch02.sec02;

public record Point(double x, double y) {
    public Point translate(double by_x, double by_y){
        return new Point(x+by_x, y+by_y);


    }
    public Point scale(int factor){
        double new_X = factor * x;
        double new_y = factor * this.y;
        return new Point(new_X, new_y);
    }

}

/**
 *
 */
class Point_Mut{

    double x;
    double y;
    public Point_Mut(double x, double y){
        x= this.x;
        y = this.y;

    }

    public void translate(double by_x, double  by_y){
        this.x += by_x;
        this.y += by_y;
    }

    public void Scale(int factor){
        this.x = this.x * factor;
        this.y = this.y * factor;
    }

}
