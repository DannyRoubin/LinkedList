/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Linked List assignment

Purpose of this file/class is to act as a linked list superclass that will be extended to
a stack and queue subclasses
*/

//************Before finishing make sure I go through and test every single possibility for insert and remove */

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

        // Makes sure that the size is smaller than the index
        else if (size() < index) {
            System.out.println("Throw exception temp holder");
        }

        // ****Section that checks for an empty list****
        // first we check if the list is null and if the index is over 0
        else if (head == null && index > 0) {
            System.out.println("Throws exception temp holder");
            // Checks if the list is empty, if it is we add to the start of the List
        } else if (head == null && index == 0) {
            Node newNode = new Node(next, head);
            head = newNode;
        }

        // ****Section that checks a list that only has a single Node****
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

    public Object remove(int index) {
        // We set up all of the else if's so we only hit one statement
        // no possible way for the index to be less than 0, so check for this first and
        // throw error if it is the case
        if (index < 0) {
            System.out.println("Throw exception temp holder");
        }

        // Makes sure that the size is smaller than the index
        else if (size() < index) {
            System.out.println("Throw exception temp holder");
        }

        // ****Section that checks for an empty list****
        // first we check if the list is empty and throw exception since that wont work
        // with us
        else if (head == null) {
            System.out.println("Throws exception temp holder");
        }
        // ****Section that checks a list that only has a single Node****
        // first checking if the list only has one element and if the index is greater
        // than 1, since that wouldn't be allowed
        else if (head.next == null && index > 0) {
            System.out.println("Throw exception temp holder");
        }
        // valid case of if there is one element and the desired index is 0, we replace
        // the head with next and have it point to the old head
        else if (head.next == null && index == 0) {
            Object temp = head.data;
            head = null;
            return temp;
        }
        // ****Section that checks a list of any length greater than 1 ****
        // Checks to see if we are updating the head
        else if (index == 0) {
            Object temp = head.data;
            Node newHead = head.next;
            head = newHead;
            return temp;
        }

        // Next we can check if we are deleting the last index
        else if (index == size()) {
            Node prev = head;
            Node nextIndexHolder = head.next;
            while (nextIndexHolder.next != null) {
                prev = prev.next;
                nextIndexHolder = nextIndexHolder.next;
            }
            Object temp = nextIndexHolder.data;
            prev.next = null;
            return temp;
        }
        // finally we can remove a specified index
        else {
            Node prev = head;
            Node nextIndexHolder = head.next;
            for (int i = 1; i < index; i++) {
                prev = prev.next;
                nextIndexHolder = nextIndexHolder.next;
            }
            Object temp = nextIndexHolder.data;
            prev.next = nextIndexHolder.next;
            return temp;
        }
        return null;

    }

    // method that finds out the size of the linked list
    public int size() {
        if (head == null) {
            return 0;
        }
        // starts counter at 0 to act as an array
        int count = 0;

        Node current = head;

        // increment through the list while current isn't null
        while (current != null) {
            // each time increment the count and assign current to the next node
            count++;
            current = current.next;
        }

        return count;

    }

    // returns the linked list in the form of a string for readability 
    public String toString() {
        Node current = head;
        String retValue = "";

        while (current != null) {
            retValue += current.data.toString() + " ";
            current = current.next;
        }
        return retValue;

    }

    // checks if the linked list is empty or not
    public boolean isEmpty() {
        // returns true if it is empty, false otherwise
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    // searches the linked list and attempts to find the index of the given target if it exists
    public int indexOf(Object target) {
        // if list is empty auto return -1
        if (isEmpty()) {
            return -1;
        } else {
            // otherwise loop through until the target matches the data of the node at the current index
            Node current = head;
            int indexTracker = 0;
            while (current != null) {
                if (target.equals(current.data)) {
                    return indexTracker;
                }
                current = current.next;
                indexTracker++;
            }
            // return -1 if the whole list has been searched without a find
            return -1;
        }
    }

    // adds to the end of the linked list by reusing the size and insert methods we created
    public void addToEnd(Object obj) {
        insert(obj,size());
    }

    // main method used for testing every possible output
    public static void main(String[] args) {
        List empty = new List();
        List one = new List();
        List multiple = new List();

        // testing inserting
        // trying out inserting at start
        System.out.println("*********Testing all cases with inserting*********");
        System.out.println("");
        one.insert(5, 0);
        System.out.println("list One after a single insert at index 0, expecting 5 : " + one);

        // trying out inserting multiple nodes to the front
        System.out.println("Multiple list prior to any changes, expecting empty : " + multiple);
        multiple.insert(10, 0);
        multiple.insert(20, 0);
        multiple.insert(30, 0);
        System.out.println("Multiple list post inserting multiple nodes in the beginning, expecting 30 20 10 : " + multiple);
        // trying out inserting in the middle
        multiple.insert(7, 1);
        multiple.insert(8, 3);
        System.out.println("Multiple list post inserting multiple nodes at index 1 and index 3 in the list, expecting 30 7 20 8 10 : " + multiple);
        // testing edge case with adding
        multiple.insert(9, 5);
        System.out.println("Multiple list post testing edge case with adding 9 as the new tail for the linked list, expecting 30 7 20 8 10 9 : " + multiple);
        // testing out of bounds by 1 case
        System.out.println("Multiple list testing adding a new node 1 index too far out of bounds, expecting error on next line : " );
        multiple.insert(3, 7);
        // testing inserting at a negative index
        System.out.println("Multiple list testing adding a new node at a negative index, expecting error on next line : " );
        multiple.insert(3, -1);

        System.out.println("Relisting the three lists we have to document them prior to any removal testing is done" );
        System.out.println("List Empty, expecting empty : " + empty);
        System.out.println("List One, expecting 5 : " + one);
        System.out.println("List Multiple, expecting 30 7 20 8 10 9 : " + multiple);
        

        System.out.println("");
        System.out.println("*********Testing all cases with removing*********");
        System.out.println("");

        // testing fail cases first this time around
        // first testing if we are able to remove at a negative index
        System.out.println("Multiple list testing removing a node at a negative index, expecting error on next line : " );
        multiple.remove(-1);
        // testing if we are able to remove at an out of bounds index
        System.out.println("Multiple list testing removing a node at an out of bounds index, expecting error on next line : " );
        multiple.remove(15);
        // removal of node from an empty list
        System.out.println("Empty list testing removing a node from an empty, expecting an error on the next line : " );
        empty.remove(0);

        // removal of first and only node
        one.remove(0);
        System.out.println("One list testing removing a node from a list with a single index, expecting an empty list : " + one );
        // removing first case again
        multiple.remove(5);
        System.out.println("multiple list testing removing the last node(the tail) from a list, expecting 30 7 20 8 10: " + multiple );
        // removing in the center
        multiple.remove(1);
        System.out.println("multiple list testing removing a node from the middle of a list, expecting 30 20 8 10: " + multiple );
      
        System.out.println("");
        System.out.println("*********Testing all cases for the method indexOf*********");
        System.out.println("");
     
        System.out.println("Relisting the list multiple so we can document it prior to any testing is done" );
        System.out.println("List Multiple, expecting 30 20 8 10  : " + multiple);
        System.out.println("");

        // working on finding a point in the middle of the list
        System.out.println("Multiple list testing finding something in the middle of the list by finding the indexOf 8, expecting 2 : " + multiple.indexOf(8));
        // working on finding a point at the beginning of a list
        System.out.println("Multiple list testing finding something at the beginning of the list by finding the indexOf 30, expecting 0 : " + multiple.indexOf(30));
        // working on finding a point at the end of a list
        System.out.println("Multiple list testing finding something at the end of the list by finding the indexOf 10, expecting 3 : " + multiple.indexOf(10));
        // working on finding a point that is non existent in the list
        System.out.println("Multiple list testing finding something that doesn't exist in the list by finding the indexOf 5400, expecting -1 : " + multiple.indexOf(5400));
     
        System.out.println("");
        System.out.println("*********Testing all cases for the method addToEnd*********");
        System.out.println("");

        System.out.println("Relisting the list multiple so we can document it prior to any testing is done" );
        System.out.println("List Multiple, expecting 30 20 8 10  : " + multiple);
        System.out.println("List One, expecting empty : " + one);
        System.out.println("");

        // adding 22 to the end of the multiple list
        multiple.addToEnd(22);
        System.out.println("List Multiple after testing addToEnd, expecting 30 20 8 10 22  : " + multiple);
        // adding to the end of an empty list
        one.addToEnd(66);
        System.out.println("List one after testing addToEnd on an empty list, expecting 66  : " + one);
        // adding to the end of a list with a single index
        one.addToEnd(11);
        System.out.println("List one after testing addToEnd on a list with a single node, expecting 66 11  : " + one);

        System.out.println("");
        System.out.println("*********Testing all cases for the methods size and isEmpty*********");
        System.out.println("");

        System.out.println("Relisting the list multiple so we can document it prior to any testing is done" );
        System.out.println("List Empty, expecting empty : " + empty);
        System.out.println("List Multiple, expecting 30 20 8 10 22 : " + multiple);
        System.out.println("List One, expecting 66 11 : " + one);
        System.out.println("");

        
        System.out.println("Testing size method on list one which has a size of 2 expecting 2  : " + one.size());
        System.out.println("Testing size method on list multiple which has a size of 5 expecting 5  : " + multiple.size());
        System.out.println("Testing size method on the empty list expecting 0  : " + empty.size());
        System.out.println("Testing isEmpty method on the empty list expecting true  : " + empty.isEmpty());
        System.out.println("Testing isEmpty method on the list one which has2 nodes in it, expecting false  : " + one.isEmpty());

    }

}