package ch03.ex;

import java.math.BigInteger;

public class SquareSequence implements Sequence<BigInteger> {
    private BigInteger i = new BigInteger("0");
    public boolean hasNext(){
        return true;
    }



    public BigInteger next(){
        i = i.add(new BigInteger("1"));
        return i.multiply(i);

    }
}
