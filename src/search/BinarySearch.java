package search;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[] arr = new int[] { 2, 4, 1, 6, 8, 5, 3, 7 };
		Arrays.sort(arr);
		int pos = search(arr, 11);
		if (pos == -1)
			System.out.println("Sorry number not found");
		else
			System.out.println("Number found");

	}

	static int search(int[] arr, int num) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + high / 2;
			if (arr[mid] == num)
				return mid;
			else if (arr[mid] > num) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}
