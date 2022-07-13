/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

public class SingleLinkedList<T> {

    private Node<T> head, tail;

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public SingleLinkedList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void Clear() {
        head = tail = null;
    }

    public void AddNodeToHead(T x) {
        Node<T> n = new Node<T>(x);
        if (isEmpty()) {
            head = tail = n;
        } else {
            n.setNext(head);
            head = n;
        }
    }

    public void AddNodeToTail(T x) {
        Node<T> n = new Node<T>(x);
        if (isEmpty()) {
            head = tail = n;
        } else {
            tail.setNext(n);
            tail = n;
        }
    }

    public void AddNodeAfter(Node<T> p, T x) {
        if (p == null) {
            return;
        }
        if (p == tail) {
            AddNodeToTail(x);
        } else {
            Node<T> n = new Node<T>(x);
            n.setNext(p.getNext());
            p.setNext(n);
        }
    }

    //add 1 node moi co gia tri x vao sau node dau tien co gia tri px
    public void AddNodeAfter(T px, T x) {
        Node<T> p = Search(px);
        AddNodeAfter(p, x);
    }

    public Node<T> Search(T x) {
        if (isEmpty()) {
            return null;
        }
        Node<T> p = head;
        while (p != null) {
            if (p.getData().equals(x)) {
                return p;
            }
            p = p.getNext();
        }
        return null;
    }
// tìm giá trị trong linkedlist

    public boolean Contains(T x) {
        if (isEmpty()) {
            return false;
        }
        Node<T> p = head;
        while (p != null) {
            if (p.getData().equals(x)) {
                return true;
            }
            p = p.getNext();
        }
        return false;
    }

    public void RemoveHead() {
        if (head == tail) {
            Clear();
        } else {
            head = head.getNext();
        }
    }

    public void RemoveTail() {
        if (head == tail) {
            Clear();
            return;
        }
        Node<T> p = head;
        while (p.getNext() != tail) {
            p = p.getNext();
        }
        p.setNext(null);
        tail = p;
    }

    public void RemoveNode(T x) {
        if (isEmpty()) {
            return;
        }
        if (head.getData() == x) {
            RemoveHead();
            return;
        }
        Node<T> p = head;
        while (p != tail && p.getNext().getData() != x) {
            p = p.getNext();
        }
        if (p != tail) {
            p.setNext(p.getNext().getNext());
        }
    }

    public void Traverse() {
        System.out.println("Single Linked List:");

        if (isEmpty()) {
            System.out.println("Danh sach rong");
            return;
        }
        Node<T> p = head;
        while (p != null) {
            System.out.print(p.getData() + " ");
            p = p.getNext();
        }
    }
}
