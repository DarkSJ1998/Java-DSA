package datastructures.linkedlist;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(10);

        // Basic information related to the LinkedList.
        linkedList.getHead();
        linkedList.getTail();
        linkedList.getLength();

        // Append operations.
        System.out.println("\n-- APPEND OPERATIONS STARTING --");
        linkedList.append(20);
        linkedList.append(30);
        linkedList.printList(); // [ 10 20 30 ]

        // Removing the last element(s).
        System.out.println("\n-- REMOVE LAST OPERATIONS STARTING --");
        System.out.println("Removing the last element: " + linkedList.removeLast().value); // Returns 30, new length = 2.
        linkedList.printList(); // [ 10 20 ]

        System.out.println("Removing the last element: " + linkedList.removeLast().value); // Returns 20, new length = 1.
        linkedList.printList(); // [ 10 ]

        System.out.println("Removing the last element: " + linkedList.removeLast().value); // Returns 10, new length = 0.
        linkedList.printList(); // [ ]

        System.out.println("Removing the last element: " + linkedList.removeLast()); // Returns null, new length = 0.
        linkedList.printList(); // [ ]

        // Prepend operations.
        System.out.println("\n-- PREPEND OPERATIONS STARTING --");
        linkedList.prepend(30);
        linkedList.printList(); // [ 30 ]

        linkedList.prepend(20);
        linkedList.prepend(10);
        linkedList.printList(); // [ 10 20 30 ]

        // Removing the first element(s).
        System.out.println("\n-- REMOVE FIRST OPERATIONS STARTING --");
        System.out.println("Removing the first element: " + linkedList.removeFirst().value); // Returns 30, new length = 2.
        linkedList.printList(); // [ 20 30 ]

        System.out.println("Removing the first element: " + linkedList.removeFirst().value); // Returns 20, new length = 1.
        linkedList.printList(); // [ 30 ]

        System.out.println("Removing the first element: " + linkedList.removeFirst().value); // Returns 10, new length = 0.
        linkedList.printList(); // [ ]

        System.out.println("Removing the first element: " + linkedList.removeFirst()); // Returns null, new length = 0.
        linkedList.printList(); // [ ]

        System.out.println("\n-- GET OPERATIONS STARTING --");
        System.out.println("Getting the element at index 2: " + linkedList.get(2)); // Returns null since LL is empty.
        System.out.println("Repopulating the list with [ 10, 20 ]...");
        linkedList.append(10);
        linkedList.append(20);
        linkedList.printList(); // [ 10 20 ]
        System.out.println("Getting the element at index -1: " + linkedList.get(-1)); // Returns null since index is negative.
        System.out.println("Getting the element at index 2: " + linkedList.get(2)); // Returns null since index > length.
        System.out.println("Getting the element at index 0: " + linkedList.get(0).value); // Returns 10.

        System.out.println("\n-- SET OPERATIONS STARTING --");
        System.out.println("Setting value as 100 at index: -1... " + (linkedList.set(-1, 100) ? "Successful!" : "Failed!"));
        linkedList.printList(); // [ 10 20 ]

        System.out.println("Setting value as 100 at index: 0... " + (linkedList.set(0, 100) ? "Successful!" : "Failed!"));
        linkedList.printList(); // [ 100 20 ]

        System.out.println("Setting value as 200 at index: 1... " + (linkedList.set(1, 200) ? "Successful!" : "Failed!"));
        linkedList.printList(); // [ 100 200 ]

        System.out.println("Setting value as 300 at index: 2... " + (linkedList.set(2, 300) ? "Successful!" : "Failed!"));
        linkedList.printList(); // [ 100 200 ]

        System.out.println("\n-- INSERT OPERATIONS STARTING --");
        System.out.println("Inserting value as 90 at index: -1... " + (linkedList.insert(-1, 90) ? "Successful!" : "Failed!"));
        linkedList.printList(); // [ 100 200 ]

        System.out.println("Inserting value as 300 at index: 3... " + (linkedList.insert(3, 300) ? "Successful!" : "Failed!"));
        linkedList.printList(); // [ 100 200 ]

        System.out.println("Inserting value as 50 at index: 0... " + (linkedList.insert(0, 50) ? "Successful!" : "Failed!"));
        linkedList.printList(); // [ 50 100 200 ]

        System.out.println("Inserting value as 250 at index: 3... " + (linkedList.insert(3, 250) ? "Successful!" : "Failed!"));
        linkedList.printList(); // [ 50 100 200 250 ]

        System.out.println("Inserting value as 150 at index: 2... " + (linkedList.insert(2, 150) ? "Successful!" : "Failed!"));
        linkedList.printList(); // [ 50 100 150 200 250 ]

        System.out.println("\n-- REMOVE OPERATIONS STARTING --");
        System.out.println("Removing the element at index -1: " + linkedList.remove(-1)); // Returns null, since index is negative.
        linkedList.printList(); // [ 50 100 150 200 250 ]

        System.out.println("Removing the element at index 5: " + linkedList.remove(5)); // Returns null since index > length.
        linkedList.printList(); // [ 50 100 150 200 250 ]

        System.out.println("Removing the element at index 0: " + linkedList.remove(0).value); // Returns 50.
        linkedList.printList(); // [ 100 150 200 250 ]

        System.out.println("Removing the element at index 3: " + linkedList.remove(3).value); // Returns 250.
        linkedList.printList(); // [ 100 150 200 ]

        System.out.println("Removing the element at index 1: " + linkedList.remove(1).value); // Returns 150.
        linkedList.printList(); // [ 100 200 ]

        System.out.println("\n-- REVERSE OPERATIONS STARTING --");
        System.out.println("Repopulating the list with some more elements...");
        linkedList.insert(1, 150);
        linkedList.insert(3, 250);
        linkedList.insert(0, 50);
        linkedList.printList(); // [ 50 100 150 200 250 ]

        System.out.println("Reversing the list...");
        linkedList.reverse();
        linkedList.printList(); // [ 250 200 150 100 50 ]

        System.out.println("Reversing the list...");
        linkedList.reverse();
        linkedList.printList(); // [ 50 100 150 200 250 ]
    }
}