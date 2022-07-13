
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class PT1 {

    static void display(int a[], int n, String mess) {
        System.out.print(mess);
        for (int i = 0; i < n - 1; i++) {
            System.out.print(a[i] + ", ");
        }
        System.out.print(a[n - 1] + "]");
    }

    static void swap(int a[], int x, int y) {
        int temp;
        temp = a[x];
        a[x] = a[y];
        a[y] = temp;
    }

    static void BubblSort(int a[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a, j, j + 1);
                }
            }
        }
    }

    static void SelectionSort(int a[], int n) {
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < a[idx]) {
                    idx = j;
                }
            }
            if (idx != i) {
                swap(a, i, idx);
            }
        }
    }

    static void InsertionSort(int a[], int n) {
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j = j - 1;
            }
            a[j + 1] = key;
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    static void QuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            QuickSort(arr, low, pi - 1);
            QuickSort(arr, pi + 1, high);
        }
    }

    static void BucketSort(double arr[], int n) {
        List<Double>[] buckets = new List[10];
        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<Double>();
        }
        for (int i = 0; i < n; i++) {
            double idx = arr[i] * 10;
            buckets[(int) idx].add(arr[i]);
        }
        int index = 0;
        for (List<Double> bucket : buckets) {
            Collections.sort(bucket);
            for (int i = 0; i < bucket.size(); i++) {
                arr[index++] = bucket.get(i);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    static void shellsort(int arr[], int n) {
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i += 1) {
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
                    arr[j] = arr[j - gap];
                }
                arr[j] = temp;
            }
        }

    }

    public static void main(String[] args) {

        int a[] = new int[6];
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            a[i] = r.nextInt(2 * 10 + 1) - 10;  //random elements
        }

        display(a, a.length, "Unsorted array: [");
//        InsertionSort(a, a.length);
     QuickSort(a, 0, a.length - 1);
//        shellsort(a, a.length);
        display(a, a.length, "\nSorted array: [");
        System.out.println("");
        double arr[] = {0.897, 0.565, 0.656, 0.1234, 0.665, 0.3434};
        BucketSort(arr, arr.length);
    }
    0
    1   0.1234
    2
    3   0.3434
    4
    5   0.565
    6   0.656 0.665   
    7
    8 0.897
    9
     0.1234
}
