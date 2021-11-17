/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Linked List assignment

Purpose of this file/class is to act as a linked list superclass that will be extended to
a stack and queue subclasses
*/
public class List {

    // setting local var head null by default
    Node head = null;

    // making a Node inner class that will be used by list to work with Nodes
    private class Node {
        public Object data = null;
        public Node next = null;

        private Node(Object d, Node n) {
            data = d;
            next = n;
        }
    }

    public void insert(Object next, int index) {
        // We set up all of the else if's so we only hit one statement
        // no possible way for the index to be less than 0, so check for this first and
        // throw error if it is the case
        if (index < 0) {
            System.out.println("Throw exception temp holder");
        }

        // ****Come back to this once I have size built out****
        // Makes sure that the size is smaller than the index
        // else if( size() < index ) {
        // System.out.println("Throw exception temp holder");
        // }

        // ****Section that checks for an empty list****
        // first we check if the list is null and if the index is over 0
        else if (head == null && index > 0) {
            System.out.println("Throws exception temp holder");
            // Checks if the list is empty, if it is we add to the start of the List
        } else if (head == null && index == 0) {
            Node newNode = new Node(next, head);
            head = newNode;
        }

        // ****Section that checks a list of length a single length****
        // first checking if the list only has one element and if the index is greater
        // than 1, since that wouldn't be allowed
        else if (head.next == null && index > 1) {
            System.out.println("Throw exception temp holder");
        }
        // valid case of if there is one element and the desired index is 0, we replace
        // the head with next and have it point to the old head
        else if (head.next == null && index == 0) {
            Node prev = head;
            Node current = new Node(next, prev);
            head = current;
        }
        // Valid case of if there is one element and the desired index is 1, we insert
        // it after the head
        else if (head.next == null && index == 1) {
            Node newNode = new Node(next, null);
            head.next = newNode;
        }

        // ****Section that checks a list of any length greater than 1 ****
        // Checks to see if we are updating the head
        else if (index == 0) {
            Node prev = head;
            Node current = new Node(next, prev);
            head = current;
        }
        // finally we can insert a new node holding "next" at the specified index
        else {
            Node prev = head;
            Node nextIndexHolder = head.next;
            for (int i = 1; i < index; i++) {
                prev = prev.next;
                nextIndexHolder = nextIndexHolder.next;
            }
            Node newNode = new Node(next, nextIndexHolder);
            prev.next = newNode;
        }

    }

    public String toString() {
        Node current = head;
        String retValue = "";

        while(current != null) {
            retValue += current.data.toString() + " ";
            current = current.next;
        }
        return retValue;

    }

    public static void main(String[] args) {
        List empty = new List();
        List one = new List();
        List multiple = new List();
        // try {
        one.insert(5, 0);
        multiple.insert(10, 0);
        multiple.insert(20, 0);
        multiple.insert(30, 0);
        multiple.insert(7, 1);
        multiple.insert(8, 3);
        System.out.println("Empty:" + empty);
        System.out.println("One:" + one);
        System.out.println("Multiple:" + multiple);
        // one.remove(0);
        // multiple.remove(1);
        // System.out.println("One (upon remove 1):" + one);
        // System.out.println("Multiple (upon remove):" + multiple);
        // one.insert(600, 1);
        // multiple.insert(400, 2);
        // System.out.println("One (on insert at 1):" + one);
        // System.out.println("Multiple(on insert at 2):" + multiple);
        // // test error
        // // empty.remove(3);
        // } catch (LinkedListException e) {
        // System.out.println(e.getMessage());
        // }
    }

}