package datastructures;

import java.util.ArrayList;

public class Queue<T> {
    private ArrayList<T> queue;

    /**
     * Creates new queue instance using ArrayList.
     */
    public Queue(){
        queue = new ArrayList<>();
    }

    /**
     * Adds an element to the rear of the queue.
     * @param element - the element to be added to the queue
     */
    public void enqueue(T element){
        queue.add(element);
    }

    /**
     * Returns and removes the element at the front of the queue.
     * @return - the element at the front of the queue
     */
    public T dequeue(){
        if(isEmpty()){
            System.out.println("Queue Empty");
            return null;
        } else {
            T element = queue.get(0);
            queue.remove(0);
            System.out.println(element + " removed from queue");
            print();
            return element;
        }
    }

    /**
     * Prints the queue.
     */
    public void print(){
        StringBuilder queue = new StringBuilder();
        if(!isEmpty()){
            for(T element : this.queue){
                queue.append(element);
                queue.append(", ");
            }
            queue.delete(queue.length() - 2, queue.length());
            System.out.println("QUEUE: [" + queue + "]\n");
        }
    }

    public boolean isEmpty(){
        if(queue.size() == 0){
            return true;
        } else {
            return false;
        }
    }



}
