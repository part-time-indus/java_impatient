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

    public void setValue(V value){
        this.value = value;
    }

    public K getKey() {return key;}

    public V getValue() {return value;}

}



