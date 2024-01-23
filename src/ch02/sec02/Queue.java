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

    public class Iterator{
        Queue.Node currNode;
        public Iterator(){
            currNode = null;
        }
        public Node next(){
            if(hasNext()) {
                return currNode;
            }
            return null;
        }

        private boolean hasNext(){
            if(currNode == null ){
                currNode = Queue.this.head;
                return currNode != null;
            }
            if(currNode.next != null){
                currNode = currNode.next;
                return true;
            }
            return false;
        }
    }

    public Iterator iterator(){
        return new Iterator();
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
