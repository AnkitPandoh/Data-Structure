package sorting;

public class BubbleSort {

    public static void sort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8, 9, 2, 5, 1, 19, -13, 4};
        sort(arr);
        for (int i : arr)
            System.out.print(i + " ");

    }
}
