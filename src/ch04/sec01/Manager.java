package ch04.sec01;

import ch02.sec02.Employee;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary){
        super(name, salary);
        bonus = 0;
    }
    public void setBonus(double bonus){
        this.bonus = bonus;
    }
    @Override
    public double getSalary(){
        return super.getSalary() + bonus;
    }

    public static void main(String[] varargs){
        Manager boss = new Manager("Hu Kares",1500.00);
        boss.setBonus(500);
        boss.raiseSalary(5);
    }

}
