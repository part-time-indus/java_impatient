package ch06;

public class Entry<K,V> {
    private K key;
    private V value;

    public Entry(K key, V value){
        this.key = key;
        this.value = value;
    }


    public static <T> void swap(T[] arr, int i, int j){
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static <T> T[] swap2(int i, int j, T... values){
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }

    public void setValue(V value){
        this.value = value;
    }

    public K getKey() {return key;}

    public V getValue() {return value;}


    public static void main(String[] args){
//        Double[] result = Entry.swap2(0,1,1.5, 2,3);
        Double[] result2 = Entry.<Double>swap2(0,1, 1.5,2.0,3.0);
    }

}



