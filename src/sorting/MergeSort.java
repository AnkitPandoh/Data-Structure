package sorting;

import java.util.*;

public class MergeSort {

    public void sort(int low, int high, int[] arr) {
        if (low == high)
            return;

        int mid = (low + high) / 2;

        sort(low, mid, arr);
        sort(mid + 1, high, arr);

        merge(arr, low, mid, high);
    }

    public void merge(int[] arr, int low, int mid, int high) {
        int[] aux = new int[low + high + 1];
        int i = low, j = mid + 1, k = 0;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                aux[k++] = arr[i++];
            } else {
                aux[k++] = arr[j++];
            }
        }
        while (i <= mid) {
            aux[k++] = arr[i++];
        }
        while (j <= high) {
            aux[k++] = arr[j++];
        }
        k = 0;
        for (i = low; i <= high; i++) {
            arr[i] = aux[k++];
        }
    }

    public static void main(String[] args) {
        MergeSort msort = new MergeSort();
        int[] arr = new int[]{19, 8, 13, 2, -5, 4, 100, 30};
        Arrays.sort(arr);
        msort.sort(0, arr.length - 1, arr);
        for (int i : arr)
            System.out.print(i + " ");
    }
}
