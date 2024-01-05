package ch01.sec01;
import java.math.BigInteger;
import java.util.Scanner;
import java.util.Random;
public class HelloWorld {
    public static void main(String[] args){
//        int_to_hex();
//        normalize_angle();
//        max_num();
//        min_max_double();
//        double_cast_int();
//        math_ops();
//        remove_space("This is a demo sentence");
        rand_string();
    }




    //Exercise 1
    public static void int_to_hex(){
        System.out.print("Please enter any integer: ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.printf("%x", num);
    }

    //Exercise 2

    public static void normalize_angle(){
        System.out.print("Please enter angle in degrees: ");
        Scanner scan = new Scanner(System.in);
        int angle = scan.nextInt();
//        int normalized_angle = angle % 360;
        int normalized_angle = Math.floorMod(angle, 360);
        System.out.printf("The normalized angle is: %d", normalized_angle);


    }

    //Exercise 3
    public static void max_num(){
        int num_of_inputs = 3;
        int count = 0;

        String[] ordinal_nums  = {"First", "Second", "Third"} ;
        int max_num = Integer.MIN_VALUE;
        Scanner scan = new Scanner(System.in);
        System.out.println("This program calculates the maximum of given three numbers. ");
        System.out.println("You will be prompted for three numbers. Please enter each number as required. ");
        while(count < num_of_inputs){
            System.out.printf("Please enter %s number: ", ordinal_nums[count]);
            int num = scan.nextInt();
            if(max_num < num){
                max_num = num;
            }
            count++;
        }
        System.out.printf("The maximum of numbers you entered is: %d", max_num);
    }

    //Exercise 4
    public static void min_max_double(){
        double min_val = Math.nextUp(0.0d);
        double max_val = Math.nextDown(Double.POSITIVE_INFINITY);
        System.out.printf("Max positive double: %f\n", max_val);
        System.out.printf("Min positive double: %f\n", min_val);
    }

    //Exercise 5
    public static void double_cast_int(){
        double number = Math.nextDown(Double.POSITIVE_INFINITY);
        int int_number = (int) number;

        System.out.printf("Max double number is: %f\n", number);
        System.out.printf("Max double number cast to int is: %d", int_number);
    }

    //Exercise 6

    public static void factorial(int num){
        BigInteger result = BigInteger.ONE;
        int iter = num;
        while(iter > 0){
            result = BigInteger.valueOf(iter).multiply(result);
            iter--;
        }
        System.out.printf("Factorial of number %d is: %d\n", num, result);
    }

    //Exercise 7

    public static void math_ops(){
        System.out.println("This program will perform addition, subtraction, multiplication, division and modulus on two numbers.");
        System.out.println("Please enter two numbers between 0 and 429496729 following prompt for each. ");
        int num1 = 0;
        int num2 = 0;
        int min_input = 0;
        int max_input = 429496729;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Please enter the first number: ");
            num1 = scan.nextInt();
            System.out.print("Please enter the second number: ");
            num2 = scan.nextInt();
        }while(!(num1 > min_input && num1 < max_input) && (num2 > min_input && num2 < max_input));
        int sum = num1 + num2;
        int product = num1 * num2;
        int divide = num1/num2;
        int remainder = num1 % num2;
        System.out.printf("%d + %d = %d\n", num1,num2,sum);
        System.out.printf("%d * %d = %d\n", num1,num2,product);
        System.out.printf("%d / %d = %d\n", num1,num2,divide);
        System.out.printf("%d mod %d = %d\n", num1, num2, remainder);
    }

    //Exercise 8
    public static void remove_space(String str){
        String[] chunks = str.split(" ");
        System.out.println(chunks.length);
        String result = "";
        for(String chunk: chunks){
            System.out.println(chunk);
        }
    }

    //Exercise 9


    //Exercise 10
    public static void rand_string(){
        int string_len = 8;
        int cur_char = 0;
        StringBuilder result_string = new StringBuilder();
        while (cur_char < string_len){
            long rand_num = new Random().nextLong();
            result_string.append(Long.toString(rand_num, 36));
            cur_char++;
        }
        System.out.println(result_string.toString());

    }

}


