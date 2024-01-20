package ch01.sec01;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
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
//        rand_string();
//        non_ascii_chars("This text contains a non ascii ɮ. There is another non ascii character here ͱ. \u03FA is also non ascii");
//        System.out.println(Arrays.toString(direction(Direction.S)));
//        System.out.println(lottery_nums());
//        int[][] matrix = new int[][]{{16,3,2,13}, {5,10,11,8}, {9,6,7,12}, {4,15,14,1}};
//        System.out.println(magic_square(matrix));
        pascal_triangle(34);
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

    //Exercise 11
    public static void non_ascii_chars(String text){
        int total_code_points = text.codePointCount(0, text.length());
        for(int i = 0; i < total_code_points; i++){
            int curr_code_point = text.codePointAt(i);
            if(curr_code_point > 127){
                System.out.println(Character.toChars(curr_code_point));
            }
        }
    }

    public enum Direction{
        N, S, W, E,
    };

    //Exercise 12
    public static int[] direction(Direction dir)  {
        return switch(dir){
            case W -> new int[]{-1,0};
            case E -> new int[]{1,0};
            case N -> new int[]{0, 1};
            case S -> new int[]{0, -1};
        };
    }

    //Exercise 13

    public static int[] change_direction(Direction move_dir, int[] curr_dir){
        int[] dir_before_move = Arrays.copyOf(curr_dir, curr_dir.length);
        switch(move_dir){
            case E -> dir_before_move[0]+=1;
            case W -> dir_before_move[0]-=1;
            case S -> dir_before_move[1]-=1;
            case N -> dir_before_move[1]+=1;

        }
        return dir_before_move;
    }

    //Exercise 18
    public static String lottery_nums(){
        int picks = 6;
        ArrayList<Integer> number_pool = new ArrayList<Integer>();
        ArrayList<Integer> number_picked = new ArrayList<Integer>();

        Random rand_gen = new Random();
        for(int i = 1; i <= 49; i++){
            number_pool.add(i);
        }
        for(int i = 0; i < 6; i++){
            int rand_index = rand_gen.nextInt(1,50-i);
            number_picked.add(number_pool.remove(rand_index));
        }
        return number_picked.toString();
    }

    //Exercise 19

    public static boolean magic_square(int[][] matrix){

        int prev_sum = 0;
        int row_len = matrix.length;
        int col_len = matrix[0].length;
        if(row_len != col_len) return false;
        if(col_len < 3) return false;
        //Check the rows
        for(int i = 0; i < row_len; i++) {
            int curr_row_sum = 0;
            for (int j = 0; j < col_len; j++) {
                curr_row_sum += matrix[i][j];
            }
            if(i == 0){
                prev_sum = curr_row_sum;
                continue;
            }
            return (prev_sum == curr_row_sum);
        }
        //2. check the columns
        for(int i = 0; i < col_len; i++){

            int curr_col_sum = 0;
            for(int j=0; j < row_len; j++){
                curr_col_sum += matrix[j][i];
            }
            if(i == 0){
                prev_sum = curr_col_sum;
                continue;
            }
            return(prev_sum == curr_col_sum);
        }

        //3. check the diagonals
        int left_diagonal_sum = 0;
        int right_diagonal_sum = 0;
        for (int i = 0; i < row_len; i++){
            int last_i = (row_len - 1);
            left_diagonal_sum += matrix[i][i];
            right_diagonal_sum += matrix[last_i-i][last_i-i];
        }
        return left_diagonal_sum == right_diagonal_sum;

    }

    //Exercise 20
    public static ArrayList<ArrayList<Integer>> pascal_triangle(int n){
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();
        for(int i = 0; i <n; i++){
            ArrayList<Integer> row = new ArrayList<Integer>();
            row.add(1);
            if(i > 0) {
                row.add(1);
            }
            triangle.add(row);
            for(int j = 1; j < i; j++){
                int el_add = triangle.get(i-1).get(j-1) + triangle.get(i-1).get(j);
                triangle.get(i).add(j, el_add);
            }
        }
        for(ArrayList<Integer> row: triangle){
            System.out.println(row.toString());
        }
        return triangle;
    }
    //Exercise 31
    public static int average(int first_num, int... rest){
        int sum = first_num;
        int count = rest.length + 1;
        for(int num: rest){
            sum = sum + num;
        }
        return sum/count;
    }



}


