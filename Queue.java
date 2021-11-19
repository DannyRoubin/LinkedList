/*
Name: Danny Roubin
Class: CSS 143 Sec B
Assignment: Linked List assignment

Purpose of this file/class is to act as a Queue by extending from our list Class
*/

public class Queue extends List {
    

    // adds an object to the end of the list 
    public void enqueue(Object obj) throws LinkedListException{
        super.insert(obj,super.size());
    }

    // removes and returns the object found at the front of the list
    public Object dequeue() throws LinkedListException{
        return super.remove(0);

    }

    // overriding the original insert method so it auto transforms their input into
    // our enqueue method
    @Override
    public void insert(Object obj, int index) throws LinkedListException {
        enqueue(obj);
    }

    // overriding the original remove method so it auto transforms their input into
    // our dequeue method
    @Override
    public Object remove(int index) throws LinkedListException {
        return dequeue();
    }

    // main method used for testing every possible output
    public static void main(String[] args) {
        try {
            Queue q = new Queue();
            System.out.println("*********Testing all cases with pushing*********");
            System.out.println("");
            // trying to enqueue a couple of valid inputs
            q.enqueue('A');
            q.enqueue('B');
            // testing to see if our override of insert worked
            q.insert('C',231);

            System.out.println("Testing enqueue with passing in A,B,C, expected output ABC  " +q);

            System.out.println("");
            System.out.println("*********Testing all cases with pushing*********");
            System.out.println("");

            System.out.println("Testing dequeue with the queue CBA expecting A will be returned from the dequeue because of LIFO : " +q.dequeue());
            System.out.println("Testing dequeue with the queue BA expecting B will be returned from the dequeue because of LIFO : " +q.dequeue());
            System.out.println("Testing dequeue with the queue A expecting C will be returned from the dequeue because of LIFO : " +q.remove(54234645));
            System.out.println("Testing dequeue with an empty queue, expecting an error message on the next line : ");
            q.dequeue();


        } catch (LinkedListException e) {
            System.out.println(e.getMessage());
        }
    }


}
