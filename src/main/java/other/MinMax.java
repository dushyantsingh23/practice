package other;

import java.util.Scanner;

public class MinMax {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        findMaxDiff(arr, n);
    }

    public static void findMaxDiff(int [] arr, int n) {
        int max = 0;

        for (int i = 0; i < n; i++) {
            int right_small = 0;
            int left_big = 0;

            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    left_big ++;
                }
            }

            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    right_small ++;
                }
            }

            max = Integer.max(max, Math.abs(right_small - left_big));
        }
        System.out.println(max);
    }
}
