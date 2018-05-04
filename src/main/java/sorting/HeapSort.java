package sorting;

public class HeapSort {

    public static void main(String[] args) {
        int arr[] = new int[]{2, 5, 7, 2, 1, 5, 9, 0, 6};

        HeapSort heapSort = new HeapSort();
        heapSort.minSort(arr);
    }

    public int[] minSort(int arr[]) {

        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }

        for (int i = 0; i < arr.length; i ++) {
            int temp = arr[0];
            System.out.print(temp + " ");
            arr[0] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
            heapify(arr, arr.length - i - 1, 0);
        }
        return arr;

    }

    private void heapify(int arr[], int l, int root) {
        int lchid = root * 2 + 1;
        int rchild = root * 2 + 2;
        int smallest = root;

        if (lchid < l && arr[smallest] > arr[lchid]) {
            smallest = lchid;
        }

        if (rchild < l && arr[smallest] > arr[rchild]) {
            smallest = rchild;
        }
        if (root < smallest) {
            int temp = arr[root];
            arr[root] = arr[smallest];
            arr[smallest] = temp;
            heapify(arr, l, smallest);
        }
    }
}
