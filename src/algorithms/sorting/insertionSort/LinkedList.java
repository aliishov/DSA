package algorithms.sorting.insertionSort;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public void insertionSort() {
        if (length < 2) return;

        Node sortedListHead = head;
        Node unsortedListHead = head.next;
        sortedListHead.next = null;

        while (unsortedListHead != null) {
            Node next = unsortedListHead.next;

            if (unsortedListHead.value < sortedListHead.value) {
                unsortedListHead.next = sortedListHead;
                sortedListHead = unsortedListHead;
            } else {
                Node searchPointer = sortedListHead;

                while (searchPointer.next != null && searchPointer.next.value < unsortedListHead.value) {
                    searchPointer = searchPointer.next;
                }

                unsortedListHead.next = searchPointer.next;
                searchPointer.next = unsortedListHead;
            }

            unsortedListHead = next;
        }

        head = sortedListHead;
        Node tailFinder = head;
        while (tailFinder.next != null) {
            tailFinder = tailFinder.next;
        }
        tail = tailFinder;
    }
}
