package ch04.ex;

public sealed interface StringList permits EmptyListString, NonEmptyListString{
    default public int size(StringList list){
        return switch(list){
            case EmptyListString e -> 0;
            case NonEmptyListString n -> n.size();
        };
    }
    default public StringNode append(StringList list, String val){
        return switch(list){
            case NonEmptyListString n -> n.append(val);
            case EmptyListString e -> null;
        };
    }

}
