/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

/**
 *
 * @author Admin
 */
public class DoubleLinkedList<T> {

    private DNode<T> head, tail;

    public DNode<T> getHead() {
        return head;
    }

    public void setHead(DNode<T> head) {
        this.head = head;
    }

    public DNode<T> getTail() {
        return tail;
    }

    public void setTail(DNode<T> tail) {
        this.tail = tail;
    }

    public DoubleLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void TraverseFromHead() {

        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        System.out.println();
        System.out.println("Double Linked List :");
        DNode<T> start = head;
        while (start != null) {
            System.out.print(start.getData() + " ");
            start = start.getNext();
        }
    }

    public void TraverseFromTail() {

        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        System.out.println();
        System.out.println("Double Linked List :");
        DNode<T> start = tail;
        while (start != null) {
            System.out.print(start.getData() + " ");
            start = start.getPre();
        }
    }

    public void addToHead(T x) {
        DNode<T> insert = new DNode<>(x);
        if (isEmpty()) {
            head = tail = insert;
            return;
        }
        insert.setNext(head);
        head.setPre(insert);
        head = insert;
    }

    public void addToTail(T x) {
        DNode<T> insert = new DNode<>(x);
        if (isEmpty()) {
            head = tail = insert;
            return;
        }
        tail.setNext(insert);
        insert.setPre(tail);
        tail = insert;
    }

    public void addNodeBefore(DNode<T> p, T x) {
        if (p == null || isEmpty()) {
            System.out.println("Cannot insert");
            return;
        }
        if (p == head) {
            addToHead(x);
            return;
        }
        DNode<T> insert = new DNode<>(x);
        insert.setNext(p);
        insert.setPre(p.getPre());

        if (p.getPre() != null) {
            p.getPre().setNext(insert);
        }
        p.setPre(insert);

    }

    public void addNodeAfter(DNode<T> p, T x) {
        if (p == null || isEmpty()) {
            System.out.println("Cannot insert");
            return;
        }
        if (p == tail) {
            addToTail(x);
            return;
        }
        DNode<T> insert = new DNode<>(x);
        insert.setNext(p.getNext());
        insert.setPre(p);

        if (p.getNext() != null) {
            p.getNext().setPre(insert);
        }
        p.setNext(insert);

    }

    DNode<T> search(T x) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return null;
        }
        DNode<T> start = head;
        while (start != null) {
            if (start.getData().equals(x)) {
                return start;
            }
            start = start.getNext();
        }
        return null;
    }

    public void AddNodeAfter(T px, T x) {
        addNodeAfter(search(px), x);
    }

    public void AddNodeBefore(T px, T x) {
        addNodeBefore(search(px), x);
    }

    public void removeHead() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            clear();
            return;
        }
        head = head.getNext();
        head.setPre(null);
    }

    public void removeTail() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            clear();
            return;
        }
        tail = tail.getPre();
        tail.setNext(null);
    }

    public void removeNode(DNode<T> p) {
        if (p == null) {
            return;
        }
        if (p == head) {
            removeHead();
            return;
        }
        if (p == tail) {
            removeTail();
            return;
        }
        p.getPre().setNext(p.getNext());
        p.getNext().setPre(p.getPre());
    }
    

}
