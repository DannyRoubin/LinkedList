/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Linked List assignment

Purpose of this file/class is to be a custom Exception that is thrown if an
error comes up with our custom built linked list class
*/
public class LinkedListException extends Exception {
    // empty constructor since I don't want it to do anything
    public LinkedListException() {
    }

     // constructor that takes in the message
     public LinkedListException(String errorMsg) {
        // looks to the super constructor in the Exception class and passes the error
        // message over there to deal with
        super(errorMsg);

    }

}
