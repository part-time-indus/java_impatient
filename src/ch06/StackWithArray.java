package ch06;

import java.lang.reflect.Array;

public class StackWithArray<E> {
    private E[] mem;
    private int currIndex;
    public Class<E> clsType;

    public StackWithArray(Class<E> cl, int n){
        this.clsType = cl;
        mem = buildArray(n);
        currIndex = -1;

    }

    private E[] buildArray(int n){
        @SuppressWarnings("unchecked")
        E[] result = (E[]) java.lang.reflect.Array.newInstance(this.clsType, n);
        return result;
    }

    public E pop(){
        if(currIndex < 1){
            return null;
        }
        var item = mem[currIndex];
        mem[currIndex] = null;
        currIndex--;
        return item;
    }

    public void push(E item){
        E[] tempArr;
        if(mem.length < currIndex + 10){
            tempArr = buildArray(mem.length*2);
        }else{
            tempArr = buildArray(mem.length);
        }
        tempArr[0] = item;
        for(int i=0; i <= currIndex; i++ ){
            tempArr[i+1] = mem[i];
        }
        mem = tempArr;
        currIndex++;
    }


    public boolean isEmpty(){
        return (Array.get(mem, 0) == null);
    }

    public static void main(String[] args){
        var stack = new StackWithArray<String>(String.class, 20);
        System.out.println(stack.isEmpty());
        stack.push("First");
        System.out.println(stack.isEmpty());
        System.out.println(stack.mem[0]);
        stack.push("Second");
        System.out.println(stack.mem[0]);
        System.out.println(stack.mem[1]);
        System.out.println(stack.pop());


    }
}
