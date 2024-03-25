package ch06;

import java.util.ArrayList;

public class TableWithInnerEntry<K,V> {
    public class Entry<S,T>{
        private S key;
        private T value;

        public Entry(S key, T value){
            this.key = key;
            this.value = value;
        }


        public static <T> void swap(T[] arr, int i, int j){
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public void setValue(T value){
            this.value = value;
        }

        public S getKey() {return key;}

        public T getValue() {return value;}


    }
    ArrayList<Entry<K,V>> data;

    public TableWithInnerEntry(){
        data = new ArrayList<>();
    }

    public V get(K key){
        for(Entry<K,V> e: data){
            if(e.getKey().equals(key)){
                return e.getValue();
            }
        }
        return null;

    }

    public void put(K key, V value){
        for(Entry<K,V> e: data){
            if(e.getKey().equals(key)){
                e.setValue(value);
            }
        }
        data.add(new Entry<>(key, value));
    }

    public Entry<K,V> remove(K key){
        Entry<K,V> item = null;
        for(Entry<K,V> e: data){
            if(e.getKey() == key){
                item = e;
                data.remove(e);
            }
        }
        return item;
    }


}
