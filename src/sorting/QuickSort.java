package sorting;

public class QuickSort {

    public static void sort(int[] arr, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(arr, start, end);
            sort(arr, start, partitionIndex - 1);
            sort(arr, partitionIndex + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int i = start;
        for (int j = start; j < end; j++) {
            if (arr[j] < arr[end]) {
                swap(arr, j, i);
                i++;
            }
        }
        swap(arr, i, end);
        return i;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 9, 2, 5, 1, 19, -13, 4};
        sort(arr, 0, arr.length - 1);
        for (int i : arr)
            System.out.print(i + " ");

    }
}
