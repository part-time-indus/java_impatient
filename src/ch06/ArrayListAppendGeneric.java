package ch06;
import java.util.*;

public class ArrayListAppendGeneric {

    public static <S>void append(ArrayList<S> src, ArrayList<? super S> dest){
        for(S e: src){
            dest.add(e);
        }
    }

//    public static <S> void append(ArrayList<? extends S> src, ArrayList<S> dest){
//        for(S e: src){
//            dest.add(e);
//        }
//    }
}
