package ch03.sec03;

import java.util.Comparator;

public class LengthComparator implements Comparator<String> {
    public int compare(String first, String second){
        return first.length() - second.length();
    }
}
