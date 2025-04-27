package datastructure.stack;

public class Stack {
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    private Node top;
    private int height;

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void push(int value) {
        Node newNode = new Node(value);
        if (height == 0) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }

    public Node pop() {
        if (height == 0) return null;

        Node popped = top;
        top = top.next;
        popped.next = null;
        height--;

        return popped;
    }


}
