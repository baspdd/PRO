/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedList;

import LinkedList.SingleLinkedList;

/**
 *
 * @author Admin
 */
public class Stack<T> {

   private SingleLinkedList<T> stack = new SingleLinkedList<T>();

    boolean isEmpty() {
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }

    public void Clear() {
        stack.Clear();
    }

    public void Run() {
        stack.Traverse();
    }

    public void push(T x) {
        stack.AddNodeToHead(x);
    }

    public T pop() {
        if (stack.isEmpty()) {
            return null;
        }
        T ret = stack.getHead().getData();
        stack.RemoveHead();
        return ret;
    }
}
