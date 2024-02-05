package ch03.ex;

public class IntSequence {
    private int[] seq;
    public IntSequence(int[] seq){
        this.seq = seq;
    }

    public static IntSequence of(int... args){
        return new IntSequence(args);
    }

}
