package datastructure.heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Test case 1
        int[] nums1 = {7, 10, 4, 3, 20, 15};
        int k1 = 3;
        System.out.println("Test case 1:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallest2(nums1, k1));
        System.out.println();

        // Test case 2
        int[] nums2 = {2, 1, 3, 5, 6, 4};
        int k2 = 2;
        System.out.println("Test case 2:");
        System.out.println("Expected output: 2");
        System.out.println("Actual output: " + findKthSmallest2(nums2, k2));
        System.out.println();

        // Test case 3
        int[] nums3 = {9, 3, 2, 11, 7, 10, 4, 5};
        int k3 = 5;
        System.out.println("Test case 3:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallest2(nums3, k3));
        System.out.println();
    }

    // Kth Smallest Element in an Array 1
    public static int findKthSmallest(int[] nums, int k) {
        Heap heap = new Heap();
        for (int num : nums) {
            heap.insert(num);
            if (heap.getHeap().size() > k) heap.remove();
        }
        return heap.remove();
    }

    // Kth Smallest Element in an Array 2
    public static int findKthSmallest2(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int num : nums) {
            maxHeap.add(num);
            if (maxHeap.size() > k) maxHeap.remove();
        }
        return maxHeap.remove();
    }
}
