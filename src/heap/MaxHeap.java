package heap;

/**
 * for any Binary sub tree, property of max heap should be satisfied which is;
 * Parent should be greater than the both left and right sub child
 * 
 * @author ankpando
 *
 */
public class MaxHeap {
	public static void main(String[] args) {
		int arr[] = new int[] { 18, 6, 9, 1, 4, 15, 12, 5, 7, 11, 3 };
		MaxHeap heap = new MaxHeap();
		heap.buildMaxHeap(arr, arr.length);
		for (int i : arr)
			System.out.print(i + " ");
		heap.sort(arr, arr.length - 1);
		System.out.println("\n" + "Sorted Array:");
		for (int i : arr)
			System.out.print(i + " ");
	}

	/**
	 * 1. Build Max heap which is already done above. This will bring Maximum
	 * element to root node. 
	 * 2. Now iterate over all the elements. 
	 * 3. Swap element which is at top with the last element. This way maximum element
	 * will reach to last position which is the correct position. 
	 * 4. Decrease
	 * size of heap by 1. 
	 * 5. maxifyHeap 
	 * 6. Repeat steps 2 to 5 until all the
	 * elements are not sorted.
	 * 
	 * @param arr
	 * @param n
	 */
	private void sort(int[] arr, int n) {
		for (int i = n; i >= 0; i--) {
			swap(arr, 0, i);
			n = n - 1;
			maxHeapify(arr, 0, n);
		}
	}

	/**
	 * This method has complexity of O(n)
	 * 
	 * @param arr
	 * @param n
	 */
	private void buildMaxHeap(int[] arr, int n) {
		for (int i = n / 2 - 1; i >= 0; i--) {
			maxHeapify(arr, i, n);
		}
	}

	/**
	 * This method has complexity of O(log(n)) where log(n) is the height of the
	 * tree.
	 * 
	 * @param arr
	 * @param i
	 * @param n
	 */
	private void maxHeapify(int[] arr, int i, int n) {
		int left = 2 * i + 1;
		int right = 2 * i + 2;
		int largest;
		if (left < n && arr[i] < arr[left]) {
			largest = left;
		} else {
			largest = i;
		}

		if (right < n && arr[largest] < arr[right]) {
			largest = right;
		}

		if (largest != i) {
			swap(arr, largest, i);
			maxHeapify(arr, largest, n);
		}
	}

	private void swap(int[] arr, int largest, int i) {
		int temp = arr[largest];
		arr[largest] = arr[i];
		arr[i] = temp;
	}
}
