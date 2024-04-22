/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 *
 * Description: TestDLLApp is a Java application that demonstrates the usage of the DoublyLinkedList class.
 * It creates a doubly-linked list, performs various operations such as insertion, deletion, and traversal,
 * and showcases the functionality of the linked list data structure.
 */

class TestDLLApp {
    public static void main(String[] args) {
        DoublyLinkedList newLL = new DoublyLinkedList();

        /* Insert elements at the front */
        newLL.insertFirst(22);
        newLL.insertFirst(44);
        newLL.insertFirst(74);
        newLL.insertFirst(97);

        /* Insert elements at the rear */
        newLL.insertLast(9);
        newLL.insertLast(33);
        newLL.insertLast(55);

        /* Display data from first to last */
        System.out.print("Linked List [From first to last]: ");
        newLL.printForwards();

        /* Display data from last to first */
        System.out.print("Linked List [From last to first]: ");
        newLL.printBackwards();

        /* Delete first item */
        newLL.deleteFirstNode();

        /* Delete last item */
        newLL.deleteLastNode();

        /* Delete item with number 9 */
        Node deletedNode = newLL.searchAndDelete(9);
        if (deletedNode != null) {
            /*
             * Uncomment the following line to print the deleted node's value:
             * System.out.println("Deleted node with value " + deletedNode.mData);
             */
        } else {
            System.out.println("Node not found.");
        }

        /* Display data from first to last */
        System.out.print("Linked List [From first to last]: ");
        newLL.printForwards();

        /* Insert 69 after 22 */
        newLL.insertAfter(22, 69);

        /* Insert 88 after 33 */
        newLL.insertAfter(33, 88);

        /* Display data from first to last */
        System.out.print("Linked List [From first to last]: ");
        newLL.printForwards();
    }
}
