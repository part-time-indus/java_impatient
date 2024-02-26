package ch04.ex;

public final class NonEmptyListString implements StringList {
    StringNode head;
    StringNode tail;


    public NonEmptyListString(){
        head = tail = null;
    }

    public int size(){
        int count = 0;
        StringNode curNode = head;
        while(curNode != null){
            count++;
            curNode = curNode.next;
        }
        return count;
    }

    public StringNode append(String val){
        StringNode newNode;
        if(head == null){
            newNode = new StringNode(val, null, null);
            head = tail = newNode;
        }else{
            StringNode lastNode = tail;
            newNode = new StringNode(val,null, lastNode);
            lastNode.next = newNode;
            lastNode = newNode;
        }
        return newNode;
    }


}
