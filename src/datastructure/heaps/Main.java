package datastructure.heaps;

import java.util.*;

public class Main {
    public static void main(String[] args) {
    }

    // Kth Smallest Element in an Array 1
    public static int findKthSmallest1(int[] nums, int k) {
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

    // Maximum Element in a Stream 1
    public static List<Integer> streamMax1(int[] nums) {
        Heap heap = new Heap();
        List<Integer> maxStream = new ArrayList<>();

        for (int num : nums) {
            heap.insert(num);
            maxStream.add(heap.getHeap().getFirst());
        }
        return maxStream;
    }
    // Maximum Element in a Stream 2
    public static List<Integer> streamMax2(int[] nums) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> maxStream = new ArrayList<>();

        for (int num : nums) {
            maxHeap.add(num);
            maxStream.add(maxHeap.peek());
        }
        return maxStream;
    }

}
