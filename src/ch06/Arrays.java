package ch06;
import java.io.Closeable;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.IntFunction;

import ch06.Pair;
import java.lang.reflect.*;

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

    public static <T, R> ArrayList<R> map(ArrayList<T> list, Function<T,R> func){
        ArrayList<R> newList = new ArrayList<>();
        for(T el: list){
            newList.add(func.apply(el));
        }
        return newList;
    }

    public static <T> T[] repeat(int n, T obj, IntFunction<T[]> constr){
        T[] result = constr.apply(n);
        for(int i = 0; i < n; i++){
            result[i] = obj;
        }
        return result;
    }

    @SuppressWarnings("unchecked cast")
    public static <T> T[] repeat(int n, T obj){
        ArrayList<T> list = new ArrayList<>();
        Object arr;
        for(int i = 0; i < n; i++){
            list.add(obj);
        }
        return (T[])list.toArray();
    }

    @SuppressWarnings("unchecked cast")
    @SafeVarargs
    public static <T> T[] repeat(int n, T... objs){
        T[] result =(T[]) Array.newInstance(objs.getClass().getComponentType(), n * objs.length);
        for(int i = 0; i < n; i++){
            System.arraycopy(objs, 0, result, 0, objs.length*n);
        }
        return result;
    }

    @SafeVarargs
    public static <T> T[] construct(int n, T... values){
        ArrayList<T> list = new ArrayList<>(java.util.Arrays.asList(values));
        return list.toArray(values);
    }

    public static<V, T extends Throwable> V doWork(Callable<V> c, T ex) throws T{

    }
    public static void main(){
        var result = repeat(10, 42, Integer[]::new);
//        System.out.println(repeat(10, 42, int[]::new));
    }
}
