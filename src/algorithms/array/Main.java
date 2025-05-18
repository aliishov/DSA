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

    public static void main(String[] args) {

        // removeElement Test case
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int val1 = 1;
        int newLength1 = removeElement(nums1, val1);
        System.out.println("Test case 1: Modified array: " +
                Arrays.toString(Arrays.copyOfRange(nums1, 0, newLength1)) +
                "\nNew length: " + newLength1 + "\n");

        // findMaxMin Test case
        int[] myList1 = {5, 3, 8, 1, 6, 9};
        int[] result1 = findMaxMin(myList1);
        System.out.println("Test case 1: MaxMin: " + Arrays.toString(result1) + "\n"); // prints "[9, 1]"

        // findLongestString Test case
        String[] stringList1 = {"apple", "banana", "kiwi", "pear"};
        String longest1 = findLongestString(stringList1);
        System.out.println("Test case 1: Longest string: " + longest1 + "\n");  // prints "banana"
    }
}
