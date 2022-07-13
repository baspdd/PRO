
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class BinarySearchTree<T extends Comparable<T>> {

    private BinaryNode<T> root;

    public boolean isEmpty() {
        return root == null;
    }

    public void add(T data) {
        if (isEmpty()) {
            root = new BinaryNode<T>(data);
            return;
        }
        BinaryNode<T> node = root;
        while (true) {
            if (node.getData().compareTo(data) < 0) //re phai
            {
                if (node.getRight() != null) //re phai dc
                {
                    node = node.getRight();
                } else//ko re phai dc -> dua luon x vao node ben phai cua f
                {
                    node.setRight(new BinaryNode<>(data));
                    return;
                }
            } else //re trai
            if (node.getLeft() != null) //re trai dc
            {
                node = node.getLeft();
            } else//ko re trai dc -> dua luon x vao node ben trai cua f
            {
                node.setLeft(new BinaryNode<>(data));
                return;
            }
        }
    }

    private BinaryNode<T> search(T data) {
        BinaryNode<T> node = root;
        while (node != null) {
            if (node.getData().compareTo(data) < 0) {
                node = node.getRight();
            } else if (node.getData().compareTo(data) > 0) {
                node = node.getLeft();
            } else {
                return node;
            }
        }
        return null;
    }

    public T get(T data) {
        BinaryNode<T> node = search(data);
        return node != null ? node.getData() : null;
    }

    public List<T> getList() {
        List<T> dataList = new LinkedList<>();
        List<BinaryNode<T>> queue = new LinkedList<>();
        if (!isEmpty()) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            BinaryNode<T> node = queue.remove(0);
            dataList.add(node.getData());
            if (node.getLeft()!=null) {
                queue.add(node.getLeft());
            }
            if (node.getRight()!=null) {
                queue.add(node.getRight());
            }
        }
        return dataList;
    }
    
     void visitBFS(BinaryNode<T> node) {
        System.out.println(node.getData() + " ");
    }

    public void BFS() {
        if (isEmpty()) {
            System.out.println("Empty ! ");
            return;
        }
        List<BinaryNode<T>> queue = new LinkedList<>();
        queue.add(root);
        System.out.println("Breadth-First Traversal  : ");
        while (!queue.isEmpty()) {
            BinaryNode<T> node = queue.remove(0);
            if (node == null) {
                return;
            }
            visitBFS(node);
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }
    

}
