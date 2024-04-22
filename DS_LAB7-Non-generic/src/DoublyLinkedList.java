/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 * Description: This code defines a DoublyLinkedList class for creating and manipulating doubly linked lists of integers. 
 * The DoublyLinkedList class provides methods for inserting, deleting, and searching for nodes within the list. 
 * It also allows for printing the list in both forward and backward directions.
 */

class Node {
    public int mData;
    public Node next;
    public Node previous;

    /**
     * Constructor to create a new Node with the specified integer data.
     *
     * @param d The integer data for the new Node.
     */
    public Node(int d) {
        mData = d;
    }

    /**
     * Display the data of the current Node.
     */
    public void displayNode() {
        System.out.print(mData + " ");
    }
}

/**
 * DoublyLinkedList is a class that defines a doubly linked list of integers.
 */
class DoublyLinkedList {
    private Node first;
    private Node last;

    /**
     * Constructor to initialize an empty doubly linked list.
     */
    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    /**
     * Check if the doubly linked list is empty.
     *
     * @return true if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Insert a new node with the given integer at the beginning of the list.
     *
     * @param num The integer to be inserted.
     */
    public void insertFirst(int num) {
        Node newNode = new Node(num);
        if (isEmpty()) {
            last = newNode;
        } else {
            first.previous = newNode;
        }
        newNode.next = first;
        first = newNode;
    }

    /**
     * Insert a new node with the given integer at the end of the list.
     *
     * @param num The integer to be inserted.
     */
    public void insertLast(int num) {
        Node newNode = new Node(num);
        if (isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
    }

    /**
     * Insert a new node with the given integer after a specific value in the list.
     *
     * @param numToFind  The value to find in the list.
     * @param newNumber  The new integer to be inserted.
     * @return true if the insertion is successful, false if the value to find is not in the list.
     */
    public boolean insertAfter(int numToFind, int newNumber) {
        Node current = first;
        while (current != null && current.mData != numToFind) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with value " + numToFind + " not found.");
            return false;
        } else {
            Node newNode = new Node(newNumber);
            if (current == last) {
                newNode.next = null;
                last = newNode;
            } else {
                newNode.next = current.next;
                current.next.previous = newNode;
            }
            newNode.previous = current;
            current.next = newNode;
            return true;
        }
    }

    /**
     * Delete the first node in the list.
     *
     * @return The deleted Node, or null if the list is empty.
     */
    public Node deleteFirstNode() {
        if (isEmpty()) {
            System.out.println("List is empty. Cannot delete.");
            return null;
        }

        Node temp = first;

        if (first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }

        first = first.next;
        return temp;
    }

    /**
     * Delete the last node in the list.
     *
     * @return The deleted Node, or null if the list is empty.
     */
    public Node deleteLastNode() {
        if (isEmpty()) {
            System.out.println("List is empty. Cannot delete.");
            return null;
        }

        Node temp = last;

        if (first.next == null) {
            first = null;
        } else {
            last.previous.next = null;
        }

        last = last.previous;
        return temp;
    }

    /**
     * Search for a node with a specific value in the list and delete it if found.
     *
     * @param number The value to search for and delete.
     * @return The deleted Node, or null if the value is not found in the list.
     */
    public Node searchAndDelete(int number) {
        Node current = first;
        while (current != null && current.mData != number) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Node with value " + number + " not found.");
            return null;
        } else {
            if (current == first) {
                return deleteFirstNode();
            } else if (current == last) {
                return deleteLastNode();
            } else {
                current.previous.next = current.next;
                current.next.previous = current.previous;
                return current;
            }
        }
    }

    /**
     * Print the list in forward direction.
     */
    public void printForwards() {
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    /**
     * Print the list in backward direction.
     */
    public void printBackwards() {
        Node current = last;
        while (current != null) {
            current.displayNode();
            current = current.previous;
        }
        System.out.println();
    }
}
