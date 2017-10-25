package dp;

import java.util.Scanner;

public class LIS {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 7;

        int arr[] = new int[]{3, 4, -1, 0, 6, 2, 8};

        printLis(arr, n);
    }

    private static int lisLength(int arr[], int n) {
        int lis[] = new int[n];
        for (int i = 0; i < n; i++) {
            lis[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    lis[i]  = Integer.max(lis[i], lis[j] + 1);
                }
            }
        }

        int max = 1;
        for (int i = 0; i < n; i++) {
            if (lis[i] > max) {
                max = lis[i];
            }
        }
        return max;
    }

    private static void printLis(int arr[], int n) {
        int record[] = new int[n];
        int lis[] = new int[n];

        for (int i = 0; i < n; i++) {
            record[i] = -1;
        }

        int length = findLis(arr, n, record, lis);

        System.out.println("Longest increasing subsequence length: " + length);

        int index = lis[length - 1];
        while (index != -1) {
            System.out.print(arr[index] + " ");
            index = record[index];
        }

        System.out.println();
    }

    private static int findLis(int arr[], int n, int record[], int lis[]) {
        lis[0] = 0;
        int maxLen = 0;

        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[lis[0]]) {
                lis[0] = i;
            } else if (arr[i] > arr[lis[maxLen]]) {
                maxLen++;
                lis[maxLen] = i;
                record[lis[maxLen]] = lis[maxLen - 1];
            } else {
                int ceilIndex = ceilIndex(arr, lis, n, arr[i], maxLen);
                lis[ceilIndex] = i;
                record[lis[ceilIndex]] = lis[ceilIndex - 1];
            }
        }
        return maxLen + 1;
    }

    private static int ceilIndex(int arr[], int lis[], int n, int s, int end) {
        int start = 0;
        int middle;
        int len = end;
        while(start <= end) {
            middle = (start + end)/2;
            if(middle < len && arr[lis[middle]] < s && s <= arr[lis[middle+1]]) {
                return middle+1;
            } else if(arr[lis[middle]] < s){
                start = middle+1;
            } else {
                end = middle-1;
            }
        }
        return -1;
    }
}
