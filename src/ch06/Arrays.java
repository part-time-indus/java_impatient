package ch06;
import java.io.Closeable;
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
    public static <E extends Comparable<E>> Pair<E> minMax(ArrayList<E> a){
        return new Pair<>(min(a), max(a));
    }

    public static <T> void minMax(List<T> elements, Comparator<? super T> comp, List<? super T> result){
        T min = elements.getFirst();
        T max = elements.getFirst();
        for(int i = 1; i < elements.size(); i++){
            T currEl = elements.get(i);
            if(comp.compare(currEl, min) < 0){
                min = currEl;
            }else if(comp.compare(currEl, max) > 0){
                max =currEl;
            }
        }
        result.add(min);
        result.add(max);
    }
    private static <T> void maxMin(List<T> elements, Comparator<? super T> comp, List<? super T> result){
        minMax(elements, comp, result);
        swapHelper(result,0, 1);
    }

    private static void swap(List<?> elements, int i, int j){
        swapHelper(elements, i, j);
    }

    private static <T> void swapHelper(List<T> elements, int i, int j){
        T temp = elements.get(i);
        elements.set(i, elements.get(j));
        elements.set(j, temp);
    }

    public static <T extends Closeable> void closeAll(ArrayList<T> elems) throws Exception{
        class ClosingException extends Exception{
            public ClosingException(String msg, Exception e){
                super(msg, e);
            }
        }
        ClosingException ex = null;
        for(T el: elems){
            try {
                el.close();
            }catch(Exception e){
                if(ex == null){
                    ex = new ClosingException("Couldn't close the resource", e);
                }
            }
        }
        if(ex != null){
            throw ex;
        }
    }

}
