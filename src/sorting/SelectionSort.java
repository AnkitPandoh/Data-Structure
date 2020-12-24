package sorting;

public class SelectionSort {
    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 9, 2, 5, 1, 19, -13, 4};
        sort(arr);
        for (int i : arr)
            System.out.print(i + " ");

    }
}
