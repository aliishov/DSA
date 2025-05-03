package datastructure.hashtable;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }

    // Item In Common
    public static boolean itemInCommon(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> myHashMap = new HashMap<>();

        for (int i : array1) {
            myHashMap.put(i, true);
        }

        for (int j : array2) {
            if (myHashMap.get(j) != null) return true;
        }
        return false;
    }

    // Find Duplicates 1
    public static List<Integer> findDuplicates1(int[] array) {
        HashMap<Integer, Integer> myHashMap = new HashMap<>();

        for (int i : array) {
            myHashMap.merge(i, 1, Integer::sum);
        }

        List<Integer> duplicates = new ArrayList<>();

        for (int i : myHashMap.keySet()) {
            if (myHashMap.get(i) > 1) duplicates.add(i);
        }

        return duplicates;
    }

    // Find Duplicates 2
    public static List<Integer> findDuplicates2(int[] array) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        List<Integer> duplicates = new ArrayList<>();

        for (int i : array)
            if (!uniqueNumbers.add(i))
                if (!duplicates.contains(i))
                    duplicates.add(i);

        return duplicates;
    }

    // First Non-Repeating Character
    public static Character firstNonRepeatingChar(String str) {
        HashMap<Character, Integer> myHashMap = new HashMap<>();

        for (char c : str.toCharArray()) {
            myHashMap.merge(c, 1, Integer::sum);
        }

        for (char c : str.toCharArray()) {
            if (myHashMap.get(c) == 1) return c;
        }

        return null;
    }

    // Group Anagrams
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            if (!res.containsKey(sortedString)) {
                res.put(sortedString, new ArrayList<>());
            }
            res.get(sortedString).add(s);
        }
        return new ArrayList<>(res.values());
    }

    // Two Sum O(n^2)
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++)
            for (int j = i + 1; j < nums.length; j++)
                if (nums[i] + nums[j] == target)
                    return new int[]{i, j};

        return new int[0];
    }

    // Two Sum O(n)
    public static int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int complement = target - num;

            if (numMap.containsKey(complement)) {
                return new int[]{numMap.get(complement), i};
            }
            numMap.put(num, i);
        }
        return new int[]{};
    }

    // Subarray Sum
    public static int[] subarraySum(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        numMap.put(0, -1);

        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if (numMap.containsKey(prefixSum - k)) {
                return new int[]{numMap.get(prefixSum - k) + 1, i};
            }
            numMap.putIfAbsent(prefixSum, i);
        }
        return new int[]{};
    }

    // Remove Duplicates 1
    public static List<Integer> removeDuplicates1(List<Integer> nums) {
        List<Integer> res = new ArrayList<>();

        for (int i : nums)
            if (!res.contains(i))
                res.add(i);

        return res;
    }

    // Remove Duplicates 2
    public static List<Integer> removeDuplicates2(List<Integer> nums) {
        return new ArrayList<>(new HashSet<>(nums));
    }

    // Has Unique Chars
    public static boolean hasUniqueChars(String str) {
        Set<Character> mySet = new HashSet<>();

        for (char c : str.toCharArray())
            if (!mySet.add(c))
                return false;

        return true;
    }

    // Find Pairs
    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target) {
        List<int[]> res = new ArrayList<>();
        Set<Integer> mySet = new HashSet<>();

        for (int i : arr1) {
            mySet.add(i);
        }

        for (int i : arr2) {
            if (mySet.contains(target - i)) {
                res.add(new int[]{target - i, i});
            }
        }
        return res;
    }

    // Longest Consecutive Sequence 1
    public int longestConsecutive1(int[] nums) {
        if (nums.length == 0)
            return 0;

        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        List<Integer> numbers = new ArrayList<>(set);

        int maxSequenceLength = 1;
        int currentSequenceLength = 1;

        for (int i = 1; i < numbers.size(); i++) {
            int currentNum = numbers.get(i);
            if (numbers.get(i - 1) + 1 == currentNum) {
                currentSequenceLength++;
            } else {
                maxSequenceLength = Math.max(maxSequenceLength, currentSequenceLength);
                currentSequenceLength = 1;
            }
        }

        maxSequenceLength = Math.max(maxSequenceLength, currentSequenceLength);

        return maxSequenceLength;
    }

    // Longest Consecutive Sequence 2
    public int longestConsecutive2(int[] nums) {
        if (nums.length == 0)
            return 0;

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestSequence = 0;
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentSequence = 1;
                int currentNum = num;
                while (numSet.contains(currentNum + 1)) {
                    currentSequence++;
                    currentNum++;
                }
                longestSequence = Math.max(longestSequence, currentSequence);
            }
        }

        return longestSequence;
    }
}
