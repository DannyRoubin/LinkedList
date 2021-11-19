/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Linked List assignment

Purpose of this file/class is to act as a stack by extending from our list Class
*/

public class Stack extends List{

    // inserts the new object node to the front of the list every time
    public void push (Object obj) throws LinkedListException {
        super.insert(obj, 0);
    }

    // inserts the new object node to the front of the list every time
    public Object pop () throws LinkedListException {
        return super.remove(0);
    }

    // overriding the original insert method so it auto transforms their input into our push method
    @Override
    public void insert (Object obj, int index) throws LinkedListException {
        push(obj);
    }

    // overriding the original remove method so it auto transforms their input into our pop method
    @Override
    public Object remove ( int index) throws LinkedListException {
        return pop();
    }
    
}
