package sorting;

import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
    }

    private void sort(int[] arr) {
        int length = arr.length;
    }

    private void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }
}
