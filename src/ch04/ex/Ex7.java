package ch04.ex;

public class Ex7 {

    public static Object add(Object first, Object second){
        if(first instanceof Number firstNum && second instanceof Number secondNum){
            return firstNum.intValue() + secondNum.intValue();
        }
        if(first instanceof Boolean firstBool && second instanceof Boolean secondBool){
            return firstBool || secondBool;
        }
        return first.toString() + " " + second.toString();
    }
}
