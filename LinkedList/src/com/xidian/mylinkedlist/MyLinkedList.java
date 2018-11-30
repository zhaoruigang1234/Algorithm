package com.xidian.mylinkedlist;

public class MyLinkedList {
    private ListNode head;
    private Integer size = 0;
    public MyLinkedList(ListNode head) {
        this.head = head;
    }

    public MyLinkedList(){
        this.head = new ListNode(0);
    }

    public ListNode getHead() {
        return head;
    }

    public void setHead(ListNode head) {
        this.head = head;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //                                              常用方法区                                                      //
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public void add(ListNode obj){
        if(head.getNext()==null){
            head.setNext(obj);
        }
        ListNode pos = head;
        while(pos.getNext()!=null){
            pos = pos.getNext();
        }
        pos.setNext(obj);
        pos.getNext().setNext(null);
        size++;
    }

    public ListNode peek(){
        if(head.getNext()==null){
            throw  new IllegalArgumentException();
        }
        ListNode res = head.getNext();
        return res;
    }

    public ListNode poll(){
        ListNode res = null;
        if(head.getNext()==null){
            throw  new IllegalArgumentException();
        }
        ListNode node = head.getNext();
        head.setNext(node.getNext());
        size--;
        return node;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(new ListNode(5));
        list.add(new ListNode(2));
        list.add(new ListNode(3));
    }
}
