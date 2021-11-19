/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Linked List assignment

Purpose of this file/class is to act as a stack by extending from our list Class
*/

public class Stack extends List {

    // inserts the new object node to the front of the list every time
    public void push(Object obj) throws LinkedListException {
        super.insert(obj, 0);
    }

    // inserts the new object node to the front of the list every time
    public Object pop() throws LinkedListException {
        return super.remove(0);
    }

    // overriding the original insert method so it auto transforms their input into
    // our push method
    @Override
    public void insert(Object obj, int index) throws LinkedListException {
        push(obj);
    }

    // overriding the original remove method so it auto transforms their input into
    // our pop method
    @Override
    public Object remove(int index) throws LinkedListException {
        return pop();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        try {
            System.out.println("*********Testing all cases with pushing*********");
            System.out.println("");
            // trying to push a couple of valid inputs
            stack.push('A');
            stack.push('B');
            // testing to see if our override of insert worked
            stack.insert('C',231);
            System.out.println("Testing push with passing in A,B,C, expected output CBA  " +stack);

            System.out.println("");
            System.out.println("*********Testing all cases with pushing*********");
            System.out.println("");

            System.out.println("Testing pop with the stack CBA expecting C will be returned from the pop because of FIFO : " +stack.pop());
            System.out.println("Testing pop with the stack BA expecting B will be returned from the pop because of FIFO : " +stack.pop());
            System.out.println("Testing pop with the stack A expecting A will be returned from the pop because of FIFO : " +stack.pop());
            System.out.println("Testing pop with an empty stack, expecting an error message on the next line : ");
            stack.pop();



        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }
    }
}
