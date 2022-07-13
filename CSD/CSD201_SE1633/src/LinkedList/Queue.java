/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import LinkedList.*;

/**
 *
 * @author Admin
 */
public class Queue<T> {

    private SingleLinkedList<T> queue = new SingleLinkedList<T>();

    public boolean isEmpty() {
        if (queue.isEmpty()) {
            return true;
        }
        if (queue.getHead() == null) {
            return true;
        }
        return false;
    }

    public void Clear() {
        queue.Clear();
    }

    public void Run() {
        queue.Traverse();
    }

    public T top() {
        if (isEmpty()) {
            return null;
        }
        return queue.getHead().getData();
    }

    public void Enqueue(T x) {
        queue.AddNodeToTail(x);
    }

    public T Dequeue() {
        if (queue.isEmpty()) {
            return null;
        }
        T ret = queue.getHead().getData();
        queue.RemoveHead();
        return ret;
    }

}
