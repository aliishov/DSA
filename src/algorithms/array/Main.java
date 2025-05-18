package algorithms.array;

import java.util.Arrays;

public class Main {
    // Remove Element
    public static int removeElement(int[] nums, int val) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i; j < nums.length-1; j++) {
                    nums[j] = nums[j+1];
                }
                nums[nums.length-1] = val;
            }
        }

        int k;
        for (k = nums.length - 1; k > 0; k--) {
            if (nums[k] != val) {
                break;
            }
        }

        return k + 1;
    }

    public static void main(String[] args) {

        // removeElement Test case
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int val1 = 1;
        int newLength1 = removeElement(nums1, val1);
        System.out.println("Test case 1: Modified array: " +
                Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)) +
                "\nNew length: " + newLength1);


    }
}
