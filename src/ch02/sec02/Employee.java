package ch02.sec02;

public class Employee {
    private String name;
    private double salary;

    public Employee(String name, double Salary){
        this.name = name;
        this.salary = salary;
    }

    public Employee(double Salary){
        this("", Salary);
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent/100;
        salary += raise;
    }
    public String getName(){
        return name;
    }
}
