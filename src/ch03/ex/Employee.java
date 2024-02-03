package ch03.ex;

public class Employee  implements  Measurable{
    double salary;
    public Employee(double salary){
        this.salary = salary;
    }
    public int compareTo(Employee other){
        return Double.compare(salary, other.salary);
    }


    public double getMeasure(){
        return this.salary;
    }

    public double average(Measurable[] objects){
        double sum = 0.0;
        for(Measurable obj: objects){
            sum = sum + obj.getMeasure();

        }
        return sum/(objects.length);
    }
}
