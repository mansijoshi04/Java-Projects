/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism.
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 *
 * Description: The GenericDoublyLinkedList class represents a generic doubly-linked list.
 * It provides methods for inserting, deleting, searching, and printing elements in the list.
 * The list consists of GenericNode objects, where each node contains data of type T.
 *
 * @param <T> The type of data stored in the linked list.
 */
class GenericNode<T> {
    public T data;
    public GenericNode<T> next;
    public GenericNode<T> previous;

    /**
     * Constructs a GenericNode with the provided data.
     *
     * @param d The data to be stored in the node.
     */
    public GenericNode(T d) {
        data = d;
    }

    /**
     * Display the data of the node.
     */
    public void displayNode() {
        System.out.print(data + " ");
    }
}

/**
 * The GenericDoublyLinkedList class represents a generic doubly-linked list.
 *
 * @param <T> The type of data stored in the linked list.
 */
class GenericDoublyLinkedList<T> {
    private GenericNode<T> first;
    private GenericNode<T> last;

    /**
     * Constructs an empty GenericDoublyLinkedList.
     */
    public GenericDoublyLinkedList() {
        setFirst(null);
        last = null;
    }

    /**
     * Check if the linked list is empty.
     *
     * @return true if the linked list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return getFirst() == null;
    }

    /**
     * Inserts an element at the beginning of the linked list.
     *
     * @param element The element to be inserted.
     */
    public void insertFirst(T element) {
        GenericNode<T> newNode = new GenericNode<>(element);
        if (isEmpty()) {
            last = newNode;
        } else {
            getFirst().previous = newNode;
        }
        newNode.next = getFirst();
        setFirst(newNode);
    }

    /**
     * Inserts an element at the end of the linked list.
     *
     * @param element The element to be inserted.
     */
    public void insertLast(T element) {
        GenericNode<T> newNode = new GenericNode<>(element);
        if (isEmpty()) {
            setFirst(newNode);
        } else {
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
    }

    /**
     * Inserts a new element after a specific element in the linked list.
     *
     * @param elementToFind The element to search for.
     * @param newElement    The new element to insert after the found element.
     * @return true if the elementToFind is found and the newElement is inserted, false otherwise.
     */
    public boolean insertAfter(T elementToFind, T newElement) {
        GenericNode<T> current = getFirst();
        while (current != null && !current.data.equals(elementToFind)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Element not found.");
            return false;
        } else {
            GenericNode<T> newNode = new GenericNode<>(newElement);
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
     * Deletes the first node in the linked list.
     *
     * @return The deleted node.
     */
    public GenericNode<T> deleteFirstNode() {
        if (isEmpty()) {
            System.out.println("List is empty. Cannot delete.");
            return null;
        }

        GenericNode<T> temp = getFirst();

        if (getFirst().next == null) {
            last = null;
        } else {
            getFirst().next.previous = null;
        }

        setFirst(getFirst().next);
        return temp;
    }

    
    /**
     * Deletes the last node in the linked list.
     *
     * @return The deleted node.
     */
    public GenericNode<T> deleteLastNode() {
        if (isEmpty()) {
            System.out.println("List is empty. Cannot delete.");
            return null;
        }

        GenericNode<T> temp = last;

        if (getFirst().next == null) {
            setFirst(null);
        } else {
            last.previous.next = null;
        }

        last = last.previous;
        return temp;
    }

    

    /**
     * Searches for an element in the linked list and deletes the first occurrence.
     *
     * @param element The element to search for and delete.
     * @return The deleted node, or null if the element is not found.
     */
    public GenericNode<T> searchAndDelete(T element) {
        GenericNode<T> current = getFirst();
        while (current != null && !current.data.equals(element)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Element not found.");
            return null;
        } else {
            if (current == getFirst()) {
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
     * Prints the elements in the linked list from the first node to the last node.
     */
    public void printForwards() {
        GenericNode<T> current = getFirst();
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println();
    }

    
    /**
     * Prints the elements in the linked list from the last node to the first node.
     */
    public void printBackwards() {
        GenericNode<T> current = last;
        while (current != null) {
            current.displayNode();
            current = current.previous;
        }
        System.out.println();
    }

    
    /**
     * Get the first node of the linked list.
     *
     * @return The first node.
     */
	public GenericNode<T> getFirst() {
		return first;
	}

	

    /**
     * Set the first node of the linked list.
     *
     * @param first The new first node.
     */
	public void setFirst(GenericNode<T> first) {
		this.first = first;
	}
}
