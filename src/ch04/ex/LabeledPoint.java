package ch04.ex;

public class LabeledPoint extends Point{
    private String label;
    public LabeledPoint(String label, double x, double y){
        super(x, y);
        this.y = y;
    }

    public String getLabel(){
        return label;
    }

}
