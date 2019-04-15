package datastructures;

import java.util.ArrayList;

public class Stack<T> {
    private ArrayList<T> stack;

    /**
     * Creates new stack instance using an ArrayList.
     */
    public Stack(){
        stack = new ArrayList<>();
    }

    /**
     * Adds an element the stack.
     * @param element - the element to be added to the stack
     */
    public void push(T element){
        stack.add(element);
    }

    /**
     * Removes an element from the stack.
     * @return the element at the top of the stack, or null if stack empty
     */
    public T pop(){
        if(stack.size() != 0){
            int lastIndex = stack.size() - 1;
            T result = stack.get(lastIndex);
            stack.remove(lastIndex);
            System.out.println(result + " popped from stack");
            print();
            return result;
        } else {
            System.out.println("Stack Empty");
            return null;
        }
    }

    /**
     * Prints the stack.
     */
    public void print(){
        String stack = "";
        for(int i = 0; i < this.stack.size(); i++){
            stack = stack + this.stack.get(i) + ", ";
        }
        stack  = stack.substring(0, stack.length() - 2);
        System.out.println( "LINKEDLIST: [" + stack + "]\n");
    }

}
