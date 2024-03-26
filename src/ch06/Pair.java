package ch06;

public class Pair<E extends Comparable<E>> {

    private E first;
    private E second;

    public Pair(E first, E second){
        this.first = first;
        this.second = second;
    }

    public E getFirst(){ return this.first;}
    public E getSecond(){ return this.second;}

    public E max(){

        if(first.compareTo(this.second) > 0){
            return first;
        }
        return second;
    }

    public E min(){
        if(first.compareTo(this.second) < 0){
            return first;
        }
        return second;
    }


}
