package ch02.sec02;
import ch02.sec02.Point;


public class Car {
    private double dist;
    private Double gas;

    private final Double efficiency;

    public Car(double efficiency){
        this.efficiency = efficiency;
        this.dist = 0.0;
        this.gas = 0.0;

    }

    public void drive(int dist){
        double gasReq = efficiency * dist;
        if(this.gas < gasReq){
            System.out.println("Low on gas. Please fill up the tank");
        }else {
            this.gas = this.gas - (dist * efficiency);
            System.out.printf("Gas Remaining: %f Gallons\n", this.gas);
        }
    }
    public void addGas(double gas){
        this.gas += gas;
    }

    public double getDist(){
        return  this.dist;
    }

    public double getGasLevel(){
        return gas;
    }

}
