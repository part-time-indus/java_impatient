package ch04.ex;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.function.DoubleFunction;

public class ReflectHelloWorld {
    public static void main(String[] varargs) throws ClassNotFoundException, NoSuchMethodException{
        var cls = java.lang.Double.class;
        var cls2 = java.lang.Math.class;
        try {
            printVals(cls.getMethod("toHexString", double.class), 5.0, 9.0, 1.0);
            printVals(cls2.getMethod("sqrt", double.class), 5, 9, 1);
            printVals2(Math::sqrt,  19, 25, 1);

        }catch (Exception e){
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

    public static void printVals(Method m, double lower, double upper, double step) throws IllegalAccessException, InvocationTargetException{
        var pType = m.getParameters()[0].getType();
        var pName = pType.getSimpleName();
        if(m.getParameterCount() != 1){
            System.out.println("Incorrect method type. Method must have 1 parameter of type Double or double");
            return;
        }
        if(!pName.equals("double")){
            System.out.println("Incorrect method type. Method must have 1 parameter of type Double or double");
        }
        for(double i = lower; i < upper; i = i + step){
            System.out.println(m.getName() + "(" + i + ")" + " = " + m.invoke(null, i));
        }

    }
    public static void printVals2(DoubleFunction<Object> m, double lower, double upper, double step) throws IllegalAccessException, InvocationTargetException{
        for(double i = lower; i < upper; i = i + step){
            System.out.println(m.getClass().getDeclaringClass().getSimpleName() + "(" + i + ")" + " = " + m.apply(i));
        }
    }
}
