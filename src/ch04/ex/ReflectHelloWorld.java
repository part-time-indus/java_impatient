package ch04.ex;


import java.lang.reflect.InvocationTargetException;

public class ReflectHelloWorld {
    public static void main(String[] varargs){
        try {
            print();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void print() throws NoSuchFieldException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        var start = System.nanoTime();
        Class<?> cl = java.lang.System.class;
        var out = cl.getField("out");
        var pStreamCls = out.getType();
        var println = pStreamCls.getDeclaredMethod("println", String.class);
        var underlyingObj = out.get(null);
        println.invoke(underlyingObj,"Hello World");
        var finish = System.nanoTime();
        System.out.println("Time: "+ (finish-start) + "ns");
        start = System.nanoTime();
        System.out.println("Hello World");
        finish = System.nanoTime();
        System.out.println("Time: "+ (finish-start) + "ns");

    }
}
