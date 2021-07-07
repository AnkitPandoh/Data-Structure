package tree;

/**
 * Build a segment tree that can be used to query the range sum, range minimum
 * and maximum. This example is for querying range minimum.
 * 
 * @author Ankit Pandoh
 * 
 *         https://www.youtube.com/watch?v=BuoG-1KC4qs
 *         https://www.youtube.com/watch?v=ZBHKZF5w4YU
 *         https://leetcode.com/articles/a-recursive-approach-to-segment-trees-range-sum-queries-lazy-propagation/
 *
 */
public class SegmentTree {

	public static void main(String[] args) {
		int arr[] = new int[] { -1, 2, 4, 0 };
		int segArr[] = new int[4 * arr.length];
		buildSegmentTree(arr, segArr, 0, arr.length - 1, 0);

		System.out.println("***Segment Tree***");
		for (int i = 0; i < segArr.length; i++) {
			System.out.print(segArr[i] + " ");
		}
		System.out.println();
		System.out.println("Min value for range 1 to 4 : " + rangeMinQuery(segArr, 0, 3, 0, arr.length - 1, 0));

	}

	static void buildSegmentTree(int[] arr, int[] segArr, int low, int high, int pos) {
		// base case when reaches to leaf node
		if (low == high) {
			segArr[pos] = arr[low];
			return;
		}
		int mid = (low + high) / 2;

		// for left child
		buildSegmentTree(arr, segArr, low, mid, 2 * pos + 1);

		// for right child
		buildSegmentTree(arr, segArr, mid + 1, high, 2 * pos + 2);

		// when both left and child gives back result, parent will store their
		// minimum
		segArr[pos] = Math.min(segArr[2 * pos + 1], segArr[2 * pos + 2]);
	}

	static int rangeMinQuery(int[] segArr, int qlow, int qhigh, int low, int high, int pos) {

		// Total overlap
		if (qlow <= low && qhigh >= high) {
			return segArr[pos];
		} else if (qlow > high || qhigh < low) { // No Overlap
			return Integer.MAX_VALUE;
		}
		// Partial Overlap
		int mid = (low + high) / 2;
		return Math.min(rangeMinQuery(segArr, qlow, qhigh, low, mid, 2 * pos + 1),
				rangeMinQuery(segArr, qlow, qhigh, mid + 1, high, 2 * pos + 2));
	}
}
