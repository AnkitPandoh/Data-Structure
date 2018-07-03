package sorting;

/**
 * https://www.youtube.com/watch?v=TzeBrDU-JaY&list=
 * PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=5
 * 
 * @author Ankit
 *
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] arr = new int[] { 2, 4, 1, 6, 8, 5, 3, 7 };
		System.out.print("Unsorted Array : ");
		for (int i : arr)
			System.out.print(i + " ");
		System.out.println();
		MergeSort sort = new MergeSort();
		sort.mergeSort(arr, 0, arr.length - 1);
		System.out.print("Sorted Array : ");
		for (int i : arr)
			System.out.print(i + " ");
	}

	void mergeSort(int[] arr, int low, int high) {
		if (low == high) {
			return;
		}
		int mid = (low + high) / 2;
		mergeSort(arr, low, mid);
		mergeSort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

	void merge(int[] arr, int start, int mid, int end) {
		int[] aux = new int[end - start + 1];
		int p = start;
		int q = mid + 1;
		int k = 0;
		for (int i = start; i <= end; i++) {
			if (p > mid) {
				aux[k++] = arr[q++];
			} else if (q > end) {
				aux[k++] = arr[p++];
			} else if (arr[p] <= arr[q]) {
				aux[k++] = arr[p++];
			} else {
				aux[k++] = arr[q++];
			}
		}
		for (int i = 0; i < k; i++) {
			arr[start++] = aux[i];
		}
	}
}
