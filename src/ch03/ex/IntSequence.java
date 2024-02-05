package ch03.ex;

public interface IntSequence {
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

}
