package sorting;

public class MergeSort {

    public static void main(String[] args) {
        int arr[] = new int[] {3, 4, 5, 1, 6, 0, -1, -2, 10, 7};

        MergeSort mergeSort = new MergeSort();
        mergeSort.print(arr);
        mergeSort.sort(arr);
        System.out.println("Sorted array");
        mergeSort.print(arr);
    }

    private void print(int arr[]) {
        for (int a : arr) {
            System.out.print(a + "  ");
        }
        System.out.println();
    }

    private void sort(int arr[]) {
        int len = arr.length;
        mergeSort(arr, 0, len -1);
    }

    private int[] mergeSort(int arr[], int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);

            merge(arr, l, mid, r);
        }
        return arr;
    }

    private int[] merge(int arr[], int l, int m, int r) {
        int l1 = m - l + 1;
        int l2 = r - m;

        int a1[] = new int[l1];
        int a2[] = new int[l2];

        for (int i = 0; i < l1; i++) {
            a1[i] = arr[l + i];
        }

        for (int i = 0; i < l2; i++) {
            a2[i] = arr[m + 1 + i];
        }

        int i = 0, j = 0, k = l;

        while (i < l1 && j < l2) {
            if (a1[i] <= a2[j]) {
                arr[k] = a1[i];
                i++;
            } else {
                arr[k] = a2[j];
                j++;
            }
            k++;
        }

        while (i < l1) {
            arr[k] = a1[i];
            i++;
            k++;
        }

        while (j < l2) {
            arr[k] = a2[j];
            j++;
            k++;
        }
        return arr;
    }
}
