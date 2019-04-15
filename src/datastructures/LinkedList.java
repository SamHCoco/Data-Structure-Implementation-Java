package datastructures;

public class LinkedList<T>{
    private Node head;
    private int size;

    // inner node class
    private class Node {
        T data;
        Node nextNode;
    }

    // linkedlist constructor
    public LinkedList(){
        head = new Node();
        size = 0; // the number of elements in linkedlist
    }

    /**
     * Adds data to the linkedlist.
     * @param data - the data (element) to be added to the linkedlist
     */
    public void add(T data){
            Node currentNode = head;
            if(head.data == null){
                head.data = data;
                size++;
            } else {
                while(currentNode.nextNode != null){
                    currentNode = currentNode.nextNode;
                }
                currentNode.nextNode = new Node();
                currentNode.nextNode.data = data;
                size++;
            }
        }

    /**
     * Gets element, at the specified index, of the linkedlist.
     * @param index - the index of the desired element in the linkedlist
     * @return the element at index, or null if index out of range
     */
    public T get(int index){
            if(isIndexValid(index)){
                Node currentNode = head;
                int position = 0;
                while(position != index){
                    currentNode = currentNode.nextNode;
                    position++;
                }
                System.out.println("LinkedList[" + index + "] = " + currentNode.data);
                return currentNode.data;
            } else {
                return null;
            }
    }

    /**
     * Prevents index out of bounds errors by checking for valid index
     * @param index - the index inputted by user, to be checked for validity
     * @return true if index valid, false otherwise
     */
    public boolean isIndexValid(int index){
        if(index >= 0 && index < size){
            return true;
        } else {
            System.out.println("ERROR: index " + index + "does not exist");
            return false;
        }
    }

    /**
     * Removes the element at the specified index from the linkedlist.
     * @param index - the index of the element to be removed
     */
    public void remove(int index){
        if(isIndexValid(index)){
            Node currentNode = head;
            int position = 0;

            // conditionals: index = 0, index = last index, index = any index but first and last
            if(index == 0){
                head = head.nextNode;
                size--;
            } else if(index == size - 1){
                while(position != size - 2){ // size - 2 to get to node preceding node to be deleted
                    currentNode = currentNode.nextNode;
                    position++;
                }
                currentNode.nextNode = null;
                size--;
            } else {
                while(position != index - 1){
                    currentNode = currentNode.nextNode;
                    position++;
                }
                currentNode.nextNode = currentNode.nextNode.nextNode;
                size--;
            }
        }
    }
}
