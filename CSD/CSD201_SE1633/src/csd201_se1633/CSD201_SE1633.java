/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csd201_se1633;

import LinkedList.Stack;
import LinkedList.Queue;
import LinkedList.*;
import BinaryTree.*;
import Graph.WeightedGraph;

public class CSD201_SE1633 {

    public static void main(String[] args) {
        DemoGraph();
    }

    public static void DemoGraph() {
        String[] v = {"A", "B", "C", "D", "E", "F", "G", "K", "I", "U"};
        WeightedGraph<String> graph = new WeightedGraph<>(v);
        graph.addEdge("A", "E", 1);
        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "D", 7);
        graph.addEdge("B", "C", 3);
        graph.addEdge("C", "D", 1);
        graph.addEdge("D", "E", 10);
        graph.addEdge("F", "G", 5);
        graph.addEdge("K", "C", 1);
        graph.addEdge("U", "C", 5);
        graph.addEdge("K", "I", 5);
        graph.BFS();
        System.out.println(graph.getNumberOfConnectivityPart());
        if (graph.isConnectivity()) {
            System.out.println("tru");
        }
    }

    static void DemoBinarySearchTree() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Integer[] list = {7, 10, 2, 5, 6, 1, 8, 9, 15, 13};
        tree.buildTree(list);
        tree.bfsTraverse();
        tree.preOrderTraverse();
        tree.delete(2);
        tree.preOrderTraverse();
        
    }

    static void runBinaryTree() {

        BinaryTree<Character> tree = new BinaryTree<Character>('A');
        tree.addNode(tree.getRoot(), true, 'B');
        tree.addNode(tree.getRoot(), false, 'C');
        BinaryNode<Character> nodeB = tree.getRoot().getLeft();
        BinaryNode<Character> nodeC = tree.getRoot().getRight();

        tree.addNode(nodeB, true, 'D');
        tree.addNode(nodeB, false, 'E');
        tree.addNode(nodeC, true, 'F');
        tree.addNode(nodeC, false, 'G');

        BinaryNode<Character> nodeE = tree.getRoot().getLeft().getRight();
        tree.addNode(nodeE, true, 'H');
        tree.addNode(nodeE, false, 'I');

        tree.BFS();
        tree.inOrderTraverse();

    }

    static void runStack() {
        Stack<String> list = new Stack<>();

        list.push("12");
        list.push("23");
        list.push("+");
        list.push("1");
        System.out.println(list.pop());
        list.Run();
    }

    static void runQueue() {
        Queue<String> List = new Queue<>();
        List.Enqueue("1");
        List.Enqueue("8");
        List.Enqueue("-");
        List.Enqueue("3");
        List.Dequeue();
        List.Run();
    }

    static void runList() {

        SingleLinkedList<Integer> myList = new SingleLinkedList<>();

        myList.AddNodeToHead(10);
        myList.AddNodeToTail(11);
        myList.AddNodeToTail(12);
        myList.AddNodeToTail(11);
        myList.AddNodeAfter(myList.getTail(), 5);
        myList.AddNodeAfter(5, 12);
        myList.Traverse();

    }

    static void runDList() {
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>();

        list.TraverseFromHead();
        list.addToHead(1);
        list.addToHead(2);
        list.addToTail(3);
        list.addToTail(4);
        list.addNodeAfter(list.getHead().getNext(), 6);
        list.addNodeAfter(list.getHead(), 7);
        list.addNodeBefore(list.getTail(), 5);
        list.AddNodeAfter(3, 8);
        list.AddNodeBefore(6, 9);
        list.TraverseFromHead();
        list.removeHead();
        list.removeTail();
        list.removeNode(list.getHead().getNext());
        list.TraverseFromHead();
        list.TraverseFromTail();

    }

}
