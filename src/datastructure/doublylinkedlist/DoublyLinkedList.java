package datastructure.doublylinkedlist;

import datastructure.linkedlist.LinkedList;

public class DoublyLinkedList {

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    private Node head;
    private Node tail;
    private int length;

    public DoublyLinkedList(int value) {
        head = new Node(value);
        tail = new Node(value);
        length = 1;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public Node removeLast() {
        if (length == 0) return null;

        Node temp = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
        }

        length--;
        return temp;
    }

    public Node removeFirst() {
        if (length == 0) return null;

        Node temp = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            temp.next = null;
        }

        length--;
        return temp;
    }

    public Node get(int index) {
        if (index < 0 || index >= length) return null;

        Node temp = head;
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else  {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }

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

        if (index == length) {
            append(value);
            return true;
        }

        Node newNode = new Node(value);
        Node before = get(index - 1);
        Node after = before.next;

        newNode.prev = before;
        newNode.next = after;
        before.next = newNode;
        after.prev = newNode;

        length++;
        return true;
    }

    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length - 1) return removeLast();

        Node temp = get(index);

        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        temp.prev = null;
        temp.next = null;

//        Node before = temp.prev;
//        Node after = temp.next;
//
//        after.prev = before;
//        before.next = after;

        length--;

        return temp;
    }

    // Swap First & Last Nodes
    public void swapFirstLast() {
        if (length < 2) return;

        int temp = head.value;
        head.value = tail.value;
        tail.value = temp;
    }

    // Reverse v1
    public void reverse() {
        if (length < 2) return;

        Node temp = head;

        Node after;
        Node before = null;

        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            temp.prev = after;
            before = temp;
            temp = after;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    // Reverse v2
    public void reverseV2() {
        if (length < 2) return;

        Node current = head;
        Node temp;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        temp = head;
        head = tail;
        tail = temp;
    }

    // Palindrome Checker
    public boolean isPalindrome() {
        if (length < 2) return true;

        Node left = head;
        Node right = tail;

        for (int i = 0; i < length / 2; i++) {
            if (left.value != right.value) return false;
            left = left.next;
            right = right.prev;
        }

        return true;
    }

    // Partition List
    public void partitionList(int x) {
        if (head == null || head.next == null) return;

        Node lessHead = new Node(0);
        Node greaterHead = new Node(0);
        Node less = lessHead;
        Node greater = greaterHead;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = null;
            current.prev = null;

            if (current.value < x) {
                less.next = current;
                current.prev = less;
                less = current;
            } else {
                greater.next = current;
                current.prev = greater;
                greater = current;
            }

            current = next;
        }

        if (greaterHead.next != null) {
            less.next = greaterHead.next;
            greaterHead.next.prev = less;
            tail = greater;
        } else {
            tail = less;
        }

        head = lessHead.next;
        if (head != null) head.prev = null;
        lessHead.next = null;
        greaterHead.next = null;
    }
}
