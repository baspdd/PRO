/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Graph;

/**
 *
 * @author Admin
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import LinkedList.Queue;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author lephu
 */
public class WeightedGraph<T> {

    private ArrayList<T> vertices;
    private int[][] matrix;
    private boolean[] free;

    public void clearAllEdge() //danh dau do thi khong co bat cu canh nao
    {
        for (int i = 0; i < vertices.size(); i++) {
            Arrays.fill(matrix[i], Integer.MAX_VALUE);
        }
    }

    public WeightedGraph(T[] v) {
        vertices = new ArrayList<>();
        for (T item : v) {
            vertices.add(item);
        }
        matrix = new int[v.length][v.length];
        clearAllEdge();
    }

    public WeightedGraph(ArrayList v) {
        vertices = v;
        matrix = new int[v.size()][v.size()];
        clearAllEdge();
    }

    public void addEdge(T u, T v, int weight) {
        int uindex = vertices.indexOf(u);
        int vindex = vertices.indexOf(v);
        matrix[uindex][vindex] = weight;
        matrix[vindex][uindex] = weight;
    }

    private void clearFree() {
        free = new boolean[vertices.size()];
        Arrays.fill(free, true);
    }

    public void displayMatrix() {
        System.out.println("Weighted Matrix:");
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                System.out.format("%11d", matrix[i][j]);
            }
            System.out.println("");
        }
    }

    //duyet theo chieu rong bat dau tu dinh co index = u
    private void BFS(int u, boolean print) {
        Queue<Integer> queue = new Queue<>();
        queue.Enqueue(u);
        free[u] = false;
        while (!queue.isEmpty()) {
            int i = queue.Dequeue();
            //thuc hien tham dinh i
            if (print) {
                System.out.println(vertices.get(i) + " ");
            }
            //tim den tat ca cac dinh j ke voi i de dua j vao queue
            for (int j = 0; j < vertices.size(); j++) {
                if (free[j] && matrix[i][j] != Integer.MAX_VALUE) {
                    queue.Enqueue(j);
                    free[j] = false;
                }
            }
        }
    }

    public void BFS() {
        System.out.println("BFS:");
        clearFree();
        for (int i = 0; i < vertices.size(); i++) {
            if (free[i]) {
                System.out.println("Thanh phan lien thong bat dau tu dinh " + vertices.get(i) + ":");
                BFS(i, true);
            }
        }

    }

    private void DFS(int i) {
        free[i] = false;
        System.out.println(vertices.get(i) + " ");
        for (int j = 0; j < vertices.size(); j++) {
            if (free[j] && matrix[i][j] != Integer.MAX_VALUE) {
                DFS(j);
            }
        }
    }

    public void DFS() {
        System.out.println("DFS:");
        clearFree();
        for (int i = 0; i < vertices.size(); i++) {
            if (free[i]) {
                System.out.println("Thanh phan lien thong bat dau tu " + vertices.get(i) + ":");
                DFS(i);
            }
        }
    }

    public int getNumberOfConnectivityPart() {
        int count = 0;
        clearFree();
        for (int i = 0; i < vertices.size(); i++) {
            if (free[i]) {
                BFS(i, false);
                count++;
            }
        }
        return count;
    }

    public boolean isEmpty() {
        return (vertices.isEmpty());
    }

    public boolean isConnectivity() {
        clearFree();
        if (isEmpty()) {
            return true;
        }
        BFS(0, false);
        for (boolean item : free) {
            if (item == true) {
                return false;//neu con dinh free thi do thi ko lien thong.
            }
        }
        return true;
    }
}
