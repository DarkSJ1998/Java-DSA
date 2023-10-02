package datastructures.linkedlist;

public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public void printList() {
        System.out.print("LinkedList: [ ");
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
        System.out.println("]");
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void append(int value) {
        // Scenario 1: When the list is empty.
        // Scenario 2: When the list is not empty.

        Node newNode = new Node(value);

        if (length == 0 || head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    public Node removeLast() {
        // Scenario 1: When the list is empty.
        // Scenario 2: When the list is not empty.
        // Scenario 3: When the list has only 1 element.

        if (length == 0 || head == null) return null;

        Node prev = head, temp = head;
        while (temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        tail = prev;
        tail.next = null;
        length--;

        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;
    }

    public void prepend(int value) {
        // Scenario 1: When the list is empty.
        // Scenario 2: When the list is not empty.

        Node newNode = new Node(value);
        if (length == 0 || head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node removeFirst() {
        // Scenario 1: When the list is empty.
        // Scenario 2: When the list is not empty.
        // Scenario 3: When the list has only 1 element.

        if (length == 0 || head == null) return null;

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;

        if (length == 0) {
            tail = null; // head is already pointing to null (scenario 3).
        }

        return temp;
    }

    public Node get(int index) {
        // Scenario 1: When the index is negative or greater than the length of the list.
        // Scenario 2: When the index is in the range.

        if (index < 0 || index >= length) return null;

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index, int value) {
        // Scenario 1: When the index is negative or greater than the length of the list.
        // Scenario 2: When the index is in the range.

        Node temp = get(index);
        if (temp != null) {
            temp.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, int value) {
        // Scenario 1: When the index is negative or greater than the length of the list.
        // Scenario 2: When the index is 0 (inserting at the start).
        // Scenario 3: When the index is equal to the length (inserting at the end).
        // Scenario 4: When the index is greater than 0 and less than length.

        if (index < 0 || index > length) return false;

        if (index == 0) {
            prepend(value);
            return true;
        }

        if (index == length) {
            append(value);
            return true;
        }

        /**
         * Below is my approach.
         */
        /*Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }*/

        /**
         * Below is Scott Barrett's approach.
         */
        Node temp = get(index - 1);

        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public Node remove(int index) {
        // Scenario 1: When the index is negative or greater than/equal to the length of the list.
        // Scenario 2: When the index is 0 (removing the first).
        // Scenario 3: When the index is equal to the length - 1 (removing the last element).
        // Scenario 4: When the index is greater than 0 and less than length.

        if (index < 0 || index >= length) return null;

        if (index == 0) return removeFirst();

        if (index == length - 1) return removeLast();

        /**
         * Below is my approach.
         */
        /* Node prev = head, temp = head;
        for (int i = 0; i < index; i++) {
            prev = temp;
            temp = temp.next;
        }*/

        /**
         * Below is Scott Barrett's approach.
         */
        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }

    public void reverse() {
        // Reversing the head and tail...
        Node temp = head;
        head = tail;
        tail = temp;

        // Reversing the list...
        Node before = null, after = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

}