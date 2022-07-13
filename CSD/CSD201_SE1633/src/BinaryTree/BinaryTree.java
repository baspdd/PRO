/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinaryTree;

/**
 *
 * @author Admin
 */
import LinkedList.Queue;

public class BinaryTree<T> {

    private BinaryNode<T> root;

    public BinaryTree() {
    }

    public BinaryTree(T x) {
        root = new BinaryNode<>(x);
    }

    public BinaryNode<T> getRoot() {
        return root;
    }

    public void setRoot(BinaryNode<T> root) {
        this.root = root;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public void addNode(BinaryNode<T> Father, boolean isLeft, T data) {
        if (Father == null || (isLeft && Father.getLeft() != null) || (!isLeft && Father.getRight() != null)) {
            System.out.println("Can not add");
            return;
        }
        BinaryNode<T> insert = new BinaryNode<>(data);
        if (isLeft) {
            Father.setLeft(insert);
        } else {
            Father.setRight(insert);
        }
    }

    void visitBFS(BinaryNode<T> node) {
        System.out.print(node.getData() + " ");
    }

    public void BFS() {
        if (isEmpty()) {
            System.out.println("Empty ! ");
            return;
        }
        Queue<BinaryNode<T>> queue = new Queue<>();
        queue.Enqueue(root);
        System.out.println("Breadth-First Traversal  : ");
        while (true) {
            BinaryNode<T> node = queue.Dequeue();
            if (node == null) {
                return;
            }
            visitBFS(node);
            if (node.getLeft() != null) {
                queue.Enqueue(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.Enqueue(node.getRight());
            }
        }
    }

    public void inOrderVisit(BinaryNode<T> node) {
        if (node == null) {
            return;
        }
        inOrderVisit(node.getLeft());
        System.out.print(node.getData() + " ");
        inOrderVisit(node.getRight());
    }

    public void inOrderTraverse() {
        System.out.println("");
        System.out.println("Depth-First Traversal");
        System.out.println("\tinOrder : ");
        inOrderVisit(root);
    }

    public void preOrderVisit(BinaryNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + " ");
        preOrderVisit(node.getLeft());
        preOrderVisit(node.getRight());
    }

    public void preOrderTraverse() {
        System.out.println("PreOrder traverse: ");
        preOrderVisit(root);
    }

    public void postOrderVisit(BinaryNode<T> node) {
        if (node == null) {
            return;
        }
        postOrderVisit(node.getLeft());
        postOrderVisit(node.getRight());
        System.out.print(node.getData() + " ");
    }

    public void postOrderTraverse() {
        System.out.println("PosOrder traverse: ");
        postOrderVisit(root);
    }
}
