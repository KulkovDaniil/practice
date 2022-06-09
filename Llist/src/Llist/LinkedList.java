package Llist;

import java.util.Scanner;

class Llist {

    private Node head ;
    private Node root ;
    private int size = 0;


    public  void add(Object val) {
        ++size;
        if(head == null) {
            root = new Node(val);
            head = root;
        }
        else{
            head.next = new Node(val);
            head = head.next;
        }
    }

    public Object get(int pos) {
        Node node = getNode(pos);
        if (node == null){
            return null;
        }
        return node.data;
    }

    private Node getNode(int pos) {
        int index = 0;
        if (pos >= 0 && pos < this.getSize()) {
            Node temp = root;
            while (index < pos) {
                temp = temp.next;
                index++;
            }
            return temp;
        }
        return null;
    }

    public Object remove(int pos){
        if(head == null) {
            return null;
        }
        if(pos == 0){
            if( root.next == null){
                Object data = root.data;
                root=null;
                head=null;
                size=0;
                return data;
            }
            else{
                Object data = root.data;
                root=root.next;
                --size;
                return data;
            }
        }
        if(pos == (this.getSize()-1)) {
            Object data = head.data;
            head = getNode(pos-1);
            head.next=null;
            --size;
            return data;
        }
        Node node = getNode(pos-1);
        if (node == null) {
            return null;
        }
        Object data = node.next.data;
        node.next = node.next.next;
        --size;
        return data;

    }


    public int getSize() {
        return size;
    }

    static class Node {
        Object data;
        Node next = null;

        public Node(Object data) {
            this.data = data;
        }

        public Node() {
        }

        public void print() {
            System.out.print(this.data + "");
        }

    }

}


