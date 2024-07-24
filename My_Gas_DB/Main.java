class Node {
    public Node next;
    public Node prev;
    private int key;

    public Node(int key) {
        this.key = key;
    }

    public int key() {
        return this.key;
    }

    public void print(String pre, String post) {
        System.out.print(pre + this.key + post);
    }
}

class List {
    private Node head;
    private Node tail;

    public List() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
    }

    public void insertFirst(int key) {
        Node tmp = new Node(key);

        tmp.prev = head;
        tmp.next = head.next;

        head.next = tmp;
        tmp.next.prev = tmp;
    }

    public List copy() {
        List list = new List();
        Node node = this.tail.prev;
        while (node != this.head) {
            list.insertFirst(node.key());
            node = node.prev;
        }
        return list;
    }

    public void print() {
        Node current = this.head.next;
        System.out.print("[");
        while (current != this.tail) {
            current.print(" ", ",");
            current = current.next;
        }
        System.out.println(" ]");
    }

    public List filter(List list) {
        List result = new List();
        Node nodeThis = this.head.next;

        while (nodeThis != this.tail) {
            Node nodeOther = list.head.next;

            while (nodeOther != list.tail) {
                if (nodeThis.key() == nodeOther.key()) {
                    result.insertFirst(nodeThis.key());
                    break;
                }

                nodeOther = nodeOther.next;
            }

            nodeThis = nodeThis.next;
        }

        return result;
    }

    public List mergeWith(List list) {
        List mergedList = new List();
        Node nodeThis = this.head.next;
        Node nodeOther = list.head.next;
    
        while (nodeThis != this.tail && nodeOther != list.tail) {
            if (nodeThis.key() < nodeOther.key()) {
                mergedList.insertSorted(nodeThis.key());  // Insert in sorted order
                nodeThis = nodeThis.next;
            } else if (nodeThis.key() > nodeOther.key()) {
                mergedList.insertSorted(nodeOther.key());  // Insert in sorted order
                nodeOther = nodeOther.next;
            } else {
                // Duplicate keys, add only once
                mergedList.insertSorted(nodeThis.key());  // Insert in sorted order
                nodeThis = nodeThis.next;
                nodeOther = nodeOther.next;
            }
        }
    
        // Add remaining elements from both lists
        while (nodeThis != this.tail) {
            mergedList.insertSorted(nodeThis.key());  // Insert in sorted order
            nodeThis = nodeThis.next;
        }
    
        while (nodeOther != list.tail) {
            mergedList.insertSorted(nodeOther.key());  // Insert in sorted order
            nodeOther = nodeOther.next;
        }
    
        return mergedList;
    }
    
    // Helper method to insert in sorted order
    private void insertSorted(int key) {
        Node tmp = new Node(key);
        Node current = head.next;
    
        while (current != tail && key > current.key()) {
            current = current.next;
        }
    
        // Insert before current
        tmp.prev = current.prev;
        tmp.next = current;
        current.prev.next = tmp;
        current.prev = tmp;
    }


    public List largest(int k) {
        List result = new List();
        Node node = this.tail.prev;
    
        for (int i = 0; i < k && node != this.head; i++) {
            result.insertFirst(node.key());
            node = node.prev;
        }
    
        return result;
    }


    public static List insertionSort(List list) {
        List sortedList = new List();
        Node current = list.head.next;
    
        while (current != list.tail) {
            Node keyNode = current;
            int key = keyNode.key();
            Node prev = keyNode.prev;
    
            // Move elements of list[0..i-1] that are greater than key to one position ahead of their current position
            while (prev != list.head && prev.key() > key) {
                prev.next = keyNode.next;
                keyNode.next.prev = prev;
    
                keyNode.next = prev;
                prev.prev.next = keyNode;
    
                keyNode.prev = prev.prev;
                prev.prev = keyNode;
    
                prev = keyNode.prev;
            }
    
            // Move to the next element in the unsorted part of the list
            current = current.next;
        }
    
        // Build the sorted list
        Node sortedCurrent = list.head.next;
        while (sortedCurrent != list.tail) {
            sortedList.insertFirst(sortedCurrent.key());
            sortedCurrent = sortedCurrent.next;
        }
    
        return sortedList;
    }
}

public class Main {
    public static void main(String[] args) {
        // Test the List class
        List list1 = new List();
        list1.insertFirst(8);
        list1.insertFirst(10);
        list1.insertFirst(2);
        list1.insertFirst(12);

        System.out.println("Original List 1:");
        list1.print();

        // Test copy
        List copiedList = list1.copy();
        System.out.println("\nCopied List:");
        copiedList.print();

        // Test filter
        List list2 = new List();
        list2.insertFirst(10);
        list2.insertFirst(12);
        list2.insertFirst(2);
        list2.insertFirst(6);
        System.out.println("Original List 2:");
        list2.print();

        List filteredList = list1.filter(list2);
        System.out.println("\nFiltered List (common elements between List 1 and List 2):");
        filteredList.print();

        // Test mergeWith
        List mergedList = list1.mergeWith(list2);
        System.out.println("\nMerged List (List 1 merged with List 2):");
        mergedList.print();

        // Test largest
        int k = 2;
        List largestList = list1.largest(k);
        System.out.println("\nLargest " + k + " elements in List 1:");
        largestList.print();

        // Test insertionSort
        System.out.println("\nApplying Insertion Sort to List 1:");
        List sortedList = List.insertionSort(list1);
        list1.print();
    }
}
