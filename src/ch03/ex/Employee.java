package ch03.ex;

public class Employee  implements  Measurable{
    double salary;
    String name;
    public Employee(String name, double salary){
        this.salary = salary;
        this.name = name;
    }
    public int compareTo(Employee other){
        return Double.compare(salary, other.salary);
    }


    public double getMeasure(){
        return this.salary;
    }

    public static double average(Measurable[] objects){
        double sum = 0.0;
        for(Measurable obj: objects){
            sum = sum + obj.getMeasure();

        }
        return sum/(objects.length);
    }

    public static Measurable largest(Measurable[] objects){
        Measurable largest = objects[0];
        for(Measurable obj: objects){
            if(obj.getMeasure() > largest.getMeasure()){
                largest = obj;
            }
        }
        return largest;
    }

    public static String highestSalary(Employee[] employees){
        Employee result = (Employee) largest(employees);
        if(result != null){
            return result.name;
        }
        return "";
    }

}
