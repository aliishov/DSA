package datastructure.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedList {

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            tail = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;

        Node temp = head;
        Node pre = head;
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public Node removeFirst() {
        if (length == 0) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0) {
            tail = null;
        }

        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;

        Node temp = head;
        int currentIndex = 0;

        while (currentIndex < index) {
            temp = temp.next;
            currentIndex++;
        }

//        for (int i = 0; i < index; i++) {
//            temp = temp.next;
//        }

        return temp;

    }

    public boolean set(int index, int value) {
        Node temp = get(index);

        if (temp != null) {
            temp.value = value;
            return true;
        }

        return false;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length - 1) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node temp = get(index - 1);

        newNode.next = temp.next;
        temp.next = newNode;
        length++;

        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

    public void reverse() {
        Node temp = head;
        head = tail;
        tail = temp;

        Node after;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
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

    public void printList() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    // Find Middle Node
    public Node findMiddleNode() {
        if (head == null) return null;
        if (head == tail) return head;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Hash Loop
    public boolean hasLoop() {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }

    // Find Kth Node From End
    public Node findKthFromEnd(int k) {
        Node slow = head;
        Node fast = head;

        for (int i = 0; i < k; i++) {
            if (fast == null) return null;
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    // Partition List
    public void partitionList(int x) {
        if (head == null) return;

        Node temp = head;
        Node largerFirst = null;
        Node largerLast = null;

        Node smallerLast = null;
        Node smallerFirst = null;

        while (temp != null) {
            Node newNode = temp.next;
            temp.next = null;

            if (temp.value < x) {
                if (smallerFirst == null) {
                    smallerFirst = temp;
                    smallerLast = temp;
                } else {
                    smallerLast.next = temp;
                    smallerLast = smallerLast.next;
                }
            } else {
                if (largerFirst == null) {
                    largerFirst = temp;
                    largerLast = temp;
                } else {
                    largerLast.next = temp;
                    largerLast = largerLast.next;
                }
            }
            temp = newNode;
        }

        if (smallerFirst == null) {
            head = largerFirst;
        } else {
            head = smallerFirst;
            smallerLast.next = largerFirst;
        }
    }

    // Remove duplicates
    public void removeDuplicates() {
        if (head == null) return;

        Node current = head;
        Node prev = null;

        Set<Integer> set = new HashSet();

        while (current != null && current.next != null) {
            if (set.contains(current.value)) {
                prev.next = current.next;
            } else {
                set.add(current.value);
                prev = current;
            }

            current = current.next;
        }
    }

    // Binary To Decimal
    public int binaryToDecimal() {
        Node current = head;
        int num = 0;

        while (current != null) {
            num = num * 2 + current.value;
            current = current.next;
        }

        return num;
    }

    // Reverse Between
    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) return;

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }

        Node currentNode = previousNode.next;

        for(int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }

        head = dummyNode.next;

    }

}
