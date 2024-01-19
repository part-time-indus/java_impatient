package ch02.sec02;
import java.util.ArrayList;
import java.util.Random;
import java.util.random.RandomGenerator;

public class RandomNumbers {
    private static RandomGenerator randGen = new Random();
    public static int randomElement(int[] els){
        int len = els.length;
        if(len == 0) return 0;
        int index = randGen.nextInt(0, len);
        return els[index];
    }

    public static int randomElement(ArrayList<Integer> els){
        int len = els.size();
        if(len == 0) return 0;
        int index = randGen.nextInt(0, len);
        return els.get(index);
    }



}
