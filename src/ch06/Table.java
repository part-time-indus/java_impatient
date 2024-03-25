package ch06;
import java.util.*;
public class Table<K,V> {

    ArrayList<Entry<K,V>> data;

    public Table(){
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
