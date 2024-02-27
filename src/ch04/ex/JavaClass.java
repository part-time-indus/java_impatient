package ch04.ex;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class JavaClass {

    public static void main(String[] varargs){
        try {
            var cl = int[].class;
            MethodPrinter(cl.getName());
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());

        }

    }

    public static void MethodPrinter(String className) throws ClassNotFoundException{
        Class<?> cl = Class.forName(className);
        while(cl != null){
            for(Method m: cl.getDeclaredMethods()){
                System.out.println(
                        Modifier.toString(m.getModifiers()) + " " +
                                m.getReturnType().getCanonicalName() + " " +
                                m.getName() + Arrays.toString(m.getParameters())
                );
            }
            cl = cl.getSuperclass();
        }

    }

}
