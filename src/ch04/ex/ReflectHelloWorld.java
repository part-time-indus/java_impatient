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
        Class<?> cl = java.lang.System.class;
            var out = cl.getDeclaredField("out");
            out.setAccessible(true);
            var pStreamCls = out.getType();
            var println = pStreamCls.getDeclaredMethod("println", String.class);
            var underlyingObj = out.get(null);
            println.invoke(underlyingObj,"Hello World");
    }
}
