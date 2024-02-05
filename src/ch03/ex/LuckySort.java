package ch03.ex;
import java.util.*;


public class LuckySort {

    public static void luckySort(ArrayList<String> strings, Comparator<String> comp){
        ArrayList<String> cp_sort = new ArrayList<>(strings);
        cp_sort.sort(comp);
        boolean match = false;
        while(!match){
            Collections.shuffle(strings);
            if(strings.equals(cp_sort)) match = true;
        }
    }
}



