package ch04.ex;


import java.lang.reflect.Field;
import java.lang.reflect.InaccessibleObjectException;

public class UniversalToString {

    public String toString(Object obj) throws IllegalAccessException, InaccessibleObjectException {
        StringBuilder str = new StringBuilder();
        if(obj == null){
            return "null";

        }
        var cl = obj.getClass();
        str.append(cl.getSimpleName()).append(" [");
        var fields = cl.getDeclaredFields();
        var lastField = fields[fields.length - 1];

        for(Field f: fields){
            if(f.get(obj) != obj){
                f.setAccessible(true);
                str.append(f.getName()).append(" = ").append(f.get(obj));
                if(f != lastField){
                    str.append(", ");
                }

            }
        }
        str.append("]");
        return str.toString();

    }
}
