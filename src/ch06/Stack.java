package ch06;
import java.util.ArrayList;

public class Stack<E> {
    ArrayList<E> mem;
    public Stack(){
        mem = new ArrayList<E>();
    }


    public void push(E item){
        mem.addFirst(item);
    }

    public E pop(){
        return mem.removeLast();
    }

    public boolean isEmpty(){
        return mem.isEmpty();
    }
}
