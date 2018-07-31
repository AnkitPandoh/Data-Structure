package heap;

/**
 * for any Binary sub tree, property of min heap should be satisfied which is;
 * Parent should be smaller than the both left and right sub child
 *
 */
public class MinHeap {
	public static void main(String[] args) {
		int arr[] = new int[] { 18, 6, 9, 1, 4, 15, 12, 5, 7, 11, 3 };
		MinHeap heap = new MinHeap();
		heap.buildMinHeap(arr, arr.length);
		for (int i : arr)
			System.out.print(i + " ");
		heap.sort(arr, arr.length - 1);
		System.out.println("\n" + "Sorted Array:");
		for (int i : arr)
			System.out.print(i + " ");
	}
	
	private void sort(int[] arr, int n) {
		for (int i = n; i >= 0; i--) {
			swap(arr, 0, i);
			n = n - 1;
			minHeapify(arr, 0, n);
		}
	}

	private void buildMinHeap(int[] arr, int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			minHeapify(arr, i, n);
		}
	}

	private void minHeapify(int[] arr, int root, int n) {
		int left = 2 * root + 1;
		int right = 2 * root + 2;
		int min;
		if (left < n && arr[left] < arr[root]) {
			min = left;
		} else {
			min = root;
		}

		if (right < n && arr[right] < arr[min]) {
			min = right;
		}

		if (min != root) {
			swap(arr, min, root);
			minHeapify(arr, min, n);
		}
	}

	private void swap(int[] arr, int min, int root) {
		int temp = arr[min];
		arr[min] = arr[root];
		arr[root] = temp;
	}
}
