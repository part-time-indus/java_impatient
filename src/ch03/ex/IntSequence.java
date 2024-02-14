package ch03.ex;

import java.util.Random;
import java.util.random.RandomGenerator;

public interface IntSequence {
    class RandomSequence implements IntSequence{
        RandomGenerator generator = new Random();
        int low;
        int high;
        public RandomSequence(int low, int high){
            this.low  = low;
            this.high = high;
        }
        @Override
        public int next(){
            return this.low + generator.nextInt(this.high - this.low + 1);
        }


    }
    default boolean hasNext(){
        return true;
    }

    int next();

    static IntSequence of(int... args){
        return new IntSequence(){
            private int index = 0;

            @Override
            public boolean hasNext(){
                return this.index < args.length;
            }

            @Override
            public int next(){
                int result = args[index];
                this.index++;
                return result;
            }
        };

    }

    static IntSequence constant(int n){
        return () -> n;
    }


}
