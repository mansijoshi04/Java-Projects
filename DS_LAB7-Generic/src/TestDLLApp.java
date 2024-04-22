/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 * Description: This TestDLLApp class demonstrates the usage of a 
 * GenericDoublyLinkedList, a data structure that represents a doubly linked 
 * list of generic elements (in this case, integers). It showcases various 
 * operations on the linked list, such as inserting elements at the front and rear, 
 * displaying the list in both forward and backward order, deleting nodes, and 
 * inserting elements after specific values. Additionally, it creates a copy of the original list.
 *
 */
public class TestDLLApp {
    public static void main(String[] args) {
        GenericDoublyLinkedList<Integer> genericIntList = new GenericDoublyLinkedList<>();
        GenericDoublyLinkedList<Integer> genericIntListCopy = new GenericDoublyLinkedList<>();
        
        /* Insert elements at the front */
        genericIntList.insertFirst(22);
        genericIntList.insertFirst(44);
        genericIntList.insertFirst(74);
        genericIntList.insertFirst(97);

        /* Insert elements at the rear */
        genericIntList.insertLast(9);
        genericIntList.insertLast(33);
        genericIntList.insertLast(55);

        /* Display data from first to last */
        System.out.print("Linked List [From first to last]: ");
        genericIntList.printForwards();

        /* Display data from last to first */
        System.out.print("Linked List [From last to first]: ");
        genericIntList.printBackwards();

        /* Delete first item */
        genericIntList.deleteFirstNode();

        /* Delete last item */
        genericIntList.deleteLastNode();

        /* Delete item with number 9 */
        GenericNode<Integer> deletedNode = genericIntList.searchAndDelete(9);
        if (deletedNode != null) {
            // System.out.println("Deleted node with value " + deletedNode.data);
        } else {
            System.out.println("Node not found.");
        }

        /* Display data from first to last */
        System.out.print("Linked List [From first to last]: ");
        genericIntList.printForwards();

        /* Insert 69 after 22 */
        genericIntList.insertAfter(22, 69);

        /* Insert 88 after 33 */
        genericIntList.insertAfter(33, 88);

        /* Display data from first to last */
        System.out.print("Linked List [From first to last]: ");
        genericIntList.printForwards();

        /* Create a copy of the list */
        GenericNode<Integer> current = genericIntList.getFirst();
        while (current != null) {
            genericIntListCopy.insertLast(current.data);
            current = current.next;
        }
    }
}