package ch04.ex;

public class StringNode {
    String value;
    StringNode next;
    StringNode prev;

    public StringNode(String value, StringNode next, StringNode prev){
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
