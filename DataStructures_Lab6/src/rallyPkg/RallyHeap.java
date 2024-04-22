/**
 * CET - CS Academic Level 3
 * Declaration: I declare that this is my own original work and is free from Plagiarism
 * Student Name: Mansi Joshi
 * Student Number: 041091664
 * Section #: 302
 * Course: CST8130 - Data Structures
 * Professor: James Mwangi PhD.
 *
 */
package rallyPkg;

import java.util.List;

public class RallyHeap<T extends Comparable<T>> {
    public void heapSort(List<T> list) {
        int n = list.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            T temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);

            heapify(list, i, 0);
        }
    }

    private void heapify(List<T> list, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && list.get(left).compareTo(list.get(largest)) > 0) {
            largest = left;
        }

        if (right < n && list.get(right).compareTo(list.get(largest)) > 0) {
            largest = right;
        }

        if (largest != i) {
            T swap = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, swap);

            heapify(list, n, largest);
        }
    }
}
