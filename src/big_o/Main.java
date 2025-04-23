package big_o;

public class Main {
    public static void main(String[] args) {
        int n = 10;

        printItems(n);
        printItems2(n);
        printItems3(n);

        System.out.println(addItems(n));
        System.out.println();

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        int key = 8;
        System.out.println(binarySearch(arr, key));
        System.out.println();
    }

    public static void printItems(int n) { // O(n)
        for (int i = 0; i < n; i++) {
            System.out.println(i);
        }

        for (int j = 0; j < n; j++) {
            System.out.println(j);
        }

        System.out.println();
    }

    public static void printItems2(int n) { // O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + " " + j);
            }
        }

        System.out.println();
    }

    public static void printItems3(int n) { // O(n^2)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(i + " " + j);
            }
        }

        for (int k = 0; k < n; k++) {
            System.out.println(k);
        }

        System.out.println();
    }

    public static int addItems(int n) { // O(1)
        return n + n + n;
    }

    public static int binarySearch(int[] arr, int key) { // O(log n)
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (arr[mid] < key) {
                low = mid + 1;
            }
            if (arr[mid] > key) {
                high = mid - 1;
            }
        }
        return low;
    }
}