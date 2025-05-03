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
}
