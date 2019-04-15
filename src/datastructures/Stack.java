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
     * Adds an element to the stack.
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
        if(isEmpty()){
            System.out.println("Stack Empty");
            return null;
        } else {
            int lastIndex = stack.size() - 1;
            T result = stack.get(lastIndex);
            stack.remove(lastIndex);
            System.out.println(result + " popped from stack");
            print();
            return result;
        }
    }

    /**
     * Prints the stack.
     */
    public void print(){
        StringBuilder stack = new StringBuilder();
        for(T element : this.stack){
            stack.append(element);
            stack.append(", ");
        }
        stack.delete(stack.length() - 2, stack.length());
        System.out.println( "STACK: [" + stack + "]\n");
    }

    /**
     * Determines whether the stack has no elements (is empty).
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty(){
        if(stack.size() == 0){
            return true;
        } else {
            return false;
        }
    }

}
