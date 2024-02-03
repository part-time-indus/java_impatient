package ch03.sec03;


public class Employee implements Comparable<Employee>{
    double salary;
    public Employee(double salary){
        this.salary = salary;
    }
    public int compareTo(Employee other){
        return Double.compare(salary, other.salary);
    }
}

