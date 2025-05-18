package algorithms.array;

import java.util.Arrays;

public class Main {
    // Remove Element 1
    public static int removeElement1(int[] nums, int val) {
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

    // Remove Element 2
    public static int removeElement2(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    // Find Max Min
    public static int[] findMaxMin(int[] myList) {
        int max = myList[0];
        int min = myList[0];

        for (int i = 1; i < myList.length; i++) {
            if (myList[i] > max) {
                max = myList[i];
            }
            if (myList[i] < min) {
                min = myList[i];
            }
        }

        return new int[] {max, min};
    }

    // Find Longest String
    public static String findLongestString(String[] stringList) {
        String longestString = "";

        for (String s : stringList) {
            if (s.length() > longestString.length()) {
                longestString = s;
            }
        }

        return longestString;
    }

    // Remove Duplicates
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {

        // removeElement Test case
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int val1 = 1;
        int newLength1 = removeElement1(nums1, val1);
        System.out.println("Test case 1: Modified array: " +
                Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)) +
                "\nNew length: " + newLength1 + "\n");

        // removeElement Test case
        int[] nums3 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int val3 = 1;
        int newLength3 = removeElement1(nums3, val3);
        System.out.println("Test case 1: Modified array: " +
                Arrays.toString(Arrays.copyOfRange(nums3, 0, newLength3)) +
                "\nNew length: " + newLength3 + "\n");

        // findMaxMin Test case
        int[] myList1 = {5, 3, 8, 1, 6, 9};
        int[] result1 = findMaxMin(myList1);
        System.out.println("Test case 1: MaxMin: " + Arrays.toString(result1) + "\n"); // prints "[9, 1]"

        // findLongestString Test case
        String[] stringList1 = {"apple", "banana", "kiwi", "pear"};
        String longest1 = findLongestString(stringList1);
        System.out.println("Test case 1: Longest string: " + longest1 + "\n");  // prints "banana"

        // removeDuplicates Test case
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int newLength2 = removeDuplicates(nums2);
        System.out.println("Test case 1: New length: " + newLength2);
        System.out.println("Test case 1: Unique values in list: " + Arrays.toString(Arrays.copyOfRange(nums2, 0, newLength2)));
    }
}
