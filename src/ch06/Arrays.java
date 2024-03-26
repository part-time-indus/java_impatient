package ch06;
import java.util.*;
import ch06.Pair;

public class Arrays {

    public static <E extends Comparable<E>> Pair<E> firstLast(ArrayList<E> a){
        return new Pair<>(a.getFirst(), a.getLast());
    }

    public static <E extends Comparable<E>> E min(ArrayList<E> a){
        E min = a.getFirst();
        for(int i = 1; i < a.size(); i++){
            if(a.get(i).compareTo(min) < 0){
                min = a.get(i);
            }
        }
        return min;

    }

    public static <E extends Comparable<E>> E max(ArrayList<E> a){
        E max = a.getFirst();
        for(int i = 1; i < a.size(); i++){
            if(a.get(i).compareTo(max) > 0){
                max = a.get(i);
            }
        }
        return max;
    }
}
