package algorithms.sorting.insertionSort;

import java.util.Arrays;

public class InsertionSort {

    public static void insertionSort(int[] array) {
        for (int i = 1; i  < array.length; i++) {
            int temp = array[i];
            int j = i-1;
            while (j > -1 && array[j] > temp) {
                array[j + 1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 4, 2, 3, 5};
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
