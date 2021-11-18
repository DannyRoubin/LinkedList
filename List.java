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

    public int size() {
        if (head == null) {
            return 0;
        }
        int count = 0;

        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;

    }

    public String toString() {
        Node current = head;
        String retValue = "";

        while (current != null) {
            retValue += current.data.toString() + " ";
            current = current.next;
        }
        return retValue;

    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        List empty = new List();
        List one = new List();
        List multiple = new List();

        // testing inserting
        // trying out inserting at start
        System.out.println("*********Testing all cases with inserting*********");
        System.out.println("");
        one.insert(5, 0);
        System.out.println("list One after a single insert at index 0, expecting 5 :" + one);

        // trying out inserting multiple nodes to the front
        System.out.println("Multiple list prior to any changes, expecting empty :" + multiple);
        multiple.insert(10, 0);
        multiple.insert(20, 0);
        multiple.insert(30, 0);
        System.out.println("Multiple list post inserting multiple nodes in the beginning, expecting 30 20 10 :" + multiple);
        // trying out inserting in the middle
        multiple.insert(7, 1);
        multiple.insert(8, 3);
        System.out.println("Multiple list post inserting multiple nodes at index 1 and index 3 in the list, expecting 30 7 20 8 10 :" + multiple);
        // testing edge case with adding
        multiple.insert(9, 5);
        System.out.println("Multiple list post testing edge case with adding 9 as the new tail for the linked list, expecting 30 7 20 8 10 9 :" + multiple);
        // testing out of bounds by 1 case
        System.out.println("Multiple list testing adding a new node 1 index too far out of bounds, expecting error on next line :" );
        multiple.insert(3, 7);
        // testing inserting at ta negative index
        System.out.println("Multiple list testing adding a new node at a negative index, expecting error on next line :" );
        multiple.insert(3, -1);

        System.out.println("Relisting the three lists we have to document them prior to any removal testing is done" );
        System.out.println("List Empty, expecting empty :" + empty);
        System.out.println("List One, expecting 5 :" + one);
        System.out.println("List Multiple, expecting 30 7 20 8 10 9 :" + multiple);

        System.out.println("");
        System.out.println("*********Testing all cases with removing*********");
        System.out.println("");

        // testing fail cases first this time around
        // first testing if we are able to remove at a negative index
        System.out.println("Multiple list testing removing a node at a negative index, expecting error on next line :" );
        multiple.remove(-1);
        // testing if we are able to remove at an out of bounds index
        System.out.println("Multiple list testing removing a node at an out of bounds index, expecting error on next line :" );
        multiple.remove(15);

        // removal of first and only node
        one.remove(0);
        // removing first case again
        multiple.remove(0);
        // removing in the center
        multiple.remove(1);
        // removing end case
        multiple.remove(4);

        System.out.println("One (upon remove 1):" + one);
        System.out.println("Multiple (upon remove):" + multiple);

        multiple.insert(400, 2);
        System.out.println("One (on insert at 1):" + one);
        System.out.println("Multiple(on insert at 2):" + multiple);
        // test error
        empty.remove(3);
        // tripping error on inputting out of bounds
        System.out.println("Next line will be an error");
        one.insert(600, 1);
        // tripping an error by inserting at a negative position
        one.insert(26, -7);
        // tripping an error by removing a negative position
        empty.remove(-9);
        // } catch (LinkedListException e) {
        // System.out.println(e.getMessage());
        // }
    }

}