package ch02.sec02;

public class Queue {
    Node head;
    Node tail;

    public Queue(){
        head = tail = null;
    }

    public static class Node{
        final String value;
        public Node(String val){
            this.value = val;
        }
        Node prev;
        Node next;
    }

    public void add(Node newNode){
        if(this.head == null && this.tail == null){
            this.head = this.tail = newNode;
        }else{

            this.tail.next = newNode;
            newNode.prev = this.tail;
            this.tail = newNode;
        }
    }

    public Node remove(){
        Node prevHead = this.head;
        prevHead.next.prev = null;
        this.head = prevHead.next;
        prevHead.next = null;
        return prevHead;
    }
}
