package ch06;
import java.util.*;
import ch06.Pair;

public class Arrays {

    public static <E extends Comparable<E>> Pair<E> firstLast(ArrayList<E> a){
        return new Pair<>(a.getFirst(), a.getLast());
    }
}
