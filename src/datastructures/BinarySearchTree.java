package datastructures;

import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTree{
    private Node root;
    private int size = 0;
    /**
     * Inner class defining Binary Search Tree nodes.
     */
    private class Node {
        Double data;
        Node leftChild;
        Node rightChild;

        /**
         * Constructor for nodes.
         * @param data - the value of the node's data (Double)
         */
        private Node(Double data){
            this.data = data;
        }
    }

    /**
     * Constructor for Binary Search Tree. It also sets the root node value.
     * @param data - the value of the root node (Double)
     */
    public BinarySearchTree(Double data){
        root = new Node(data);
        size++;
    }

    /**
     * Inserts a value into the Binary Search Tree.
     * @param data - the value to be inserted (Double)
     */
    public void insert(Double data) {
        Node currentNode = root;
        boolean inserted = false;
        while (!inserted) {
            if (data > currentNode.data && currentNode.rightChild == null) {
                currentNode.rightChild = new Node(data);
                size++;
                inserted = true;
            } else if (data < currentNode.data && currentNode.leftChild == null) {
                currentNode.leftChild = new Node(data);
                size++;
                inserted = true;
            } else if (data.equals(currentNode.data) && currentNode.leftChild == null) {
                currentNode.leftChild = new Node(data);
                size++;
                inserted = true;
            } else if (data > currentNode.data && currentNode.rightChild != null) {
                currentNode = currentNode.rightChild;
            } else if (data < currentNode.data && currentNode.leftChild != null) {
                currentNode = currentNode.leftChild;
            }
        }
    }

    /**
     * Searches Binary Search Tree for specified value.
     * @param searchValue - the value to be found in the BST
     * @return True if found, false otherwise
     */
    public boolean search(double searchValue){
        Node currentNode = root;
        boolean found = false;
        while(!found){
            if(currentNode.data == searchValue){
                found = true;
            } else if(searchValue > currentNode.data){
                currentNode = currentNode.rightChild;
            } else if(searchValue < currentNode.data){
                currentNode = currentNode.leftChild;
            }
            if(currentNode == null){
                System.out.println(searchValue + " not found in Binary Search Tree");
                return false;
            }
        }
        System.out.println(searchValue + " found in Binary Search Tree");
        return true;
    }

    /**
     * Traverses Binary Search Tree in preorder fashion (root, left, right) and returns the result.
     * @return An ArrayList containing preorder traversal values for the Binary Search Tree.
     */
    public ArrayList<Double> preorderTraversal(){
        Node currentNode = root;
        ArrayList<Double> traverseValues = new ArrayList<>();
        Stack<Node> binaryNodes = new Stack<>();
        boolean traversed = false;
        int counter = 0;
        while(!traversed){
            if(currentNode.leftChild != null && currentNode.rightChild != null){
                if(!binaryNodes.contains(currentNode)){
                    binaryNodes.push(currentNode);
                    traverseValues.add(currentNode.data);
                    counter++;
                    currentNode = currentNode.leftChild;
                } else {
                    currentNode = currentNode.rightChild;
                    binaryNodes.pop();
                }
            } else if(currentNode.leftChild != null && currentNode.rightChild == null){
                traverseValues.add(currentNode.data);
                counter++;
                currentNode =currentNode.leftChild;
            } else if(currentNode.leftChild == null && currentNode.rightChild != null){
                traverseValues.add(currentNode.data);
                counter++;
                currentNode = currentNode.rightChild;
            } else if(currentNode.leftChild == null && currentNode.rightChild == null){
                traverseValues.add(currentNode.data);
                counter++;
                if(!binaryNodes.empty()){
                    currentNode = binaryNodes.peek();
                }
            }
            if(counter == size){
                traversed = true;
            }
        }
        System.out.println("BST PREORDER TRAVERSAL: " + traverseValues);
        return traverseValues;
    }

    /**
     * Traverses Binary Search Tree in inorder fashion (left, root, right) and returns the result.
     * @return An ArrayList containing inorder traversal values for the Binary Search Tree.
     */
    public ArrayList<Double> inorderTraversal(){
        Node currentNode = root;
        ArrayList<Double> traverseValues = new ArrayList<>();
        Stack<Node> binaryNodes = new Stack<>();
        Stack<Node> traversedNodes = new Stack<>();
        Stack<Integer> popCounterStack = new Stack<>();
        int popCounter = 0;
        boolean traversed = false;
        int counter = 0;
        while(!traversed){
            if(currentNode.leftChild != null && currentNode.rightChild != null){
                if(popCounter != 0){
                    popCounterStack.push(popCounter);
                    popCounter = 0;
                }
                if(!binaryNodes.contains(currentNode)){
                    binaryNodes.add(currentNode);
                    currentNode = currentNode.leftChild;
                } else {
                    traverseValues.add(currentNode.data);
                    counter++;
                    currentNode = currentNode.rightChild;
                    binaryNodes.pop();
                }

            } else if(currentNode.leftChild != null && currentNode.rightChild == null){
                traversedNodes.add(currentNode);
                popCounter++;
                currentNode = currentNode.leftChild;

            } else if(currentNode.leftChild == null && currentNode.rightChild != null){
                traversedNodes.add(currentNode);
                popCounter++;
                currentNode = currentNode.rightChild;

            } else if(currentNode.leftChild == null && currentNode.rightChild == null){
                traversedNodes.add(currentNode);
                popCounter++;
                popCounterStack.push(popCounter);
                popCounter = 0;
                if(!binaryNodes.empty()){
                    currentNode = binaryNodes.peek();
                    for(int i = 0; i < popCounterStack.peek(); i++){
                        traverseValues.add(traversedNodes.pop().data);
                        counter++;
                    }
                    popCounterStack.pop();
                } else {
                    while(!popCounterStack.empty()){
                        for(int i = 0; i < popCounterStack.peek(); i++){
                            traverseValues.add(traversedNodes.pop().data);
                            counter++;
                        }
                        popCounterStack.pop();
                    }
                }
            }
            if(counter == size){
                traversed = true;
            }
        }
        System.out.println("BST INORDER TRAVERSAL: " + traverseValues);
        return traverseValues;
    }

    /**
     * Traverses Binary Search Tree in preorder fashion (left, right, root) and returns the result.
     * @return An ArrayList containing preorder traversal values for the Binary Search Tree.
     */
    public ArrayList<Double> postorderTraversal(){
        Node currentNode = root;
        ArrayList<Double> traverseValues = new ArrayList<>();
        Stack<Node> traversedNodes = new Stack<>();
        Stack<Node> binaryNodes = new Stack<>();
        Stack<Integer> popCounterStack = new Stack<>();
        int popCounter = 0;
        boolean traversed = false;
        int counter = 0;
        while(!traversed){
            if(currentNode.leftChild != null && currentNode.rightChild != null){
                if(popCounter != 0){
                    popCounterStack.push(popCounter);
                    popCounter = 0;
                }
                if(!binaryNodes.contains(currentNode)){
                    binaryNodes.add(currentNode);
                    currentNode = currentNode.leftChild;
                } else {
                    traversedNodes.push(currentNode);
                    popCounter++;
                    currentNode = currentNode.rightChild;
                    binaryNodes.pop();
                }

            } else if(currentNode.leftChild != null && currentNode.rightChild == null){
                traversedNodes.add(currentNode);
                popCounter++;
                currentNode = currentNode.leftChild;

            } else if(currentNode.leftChild == null && currentNode.rightChild != null){
                traversedNodes.add(currentNode);
                popCounter++;
                currentNode = currentNode.rightChild;

            } else if(currentNode.leftChild == null && currentNode.rightChild == null){
                traversedNodes.add(currentNode);
                popCounter++;
                popCounterStack.push(popCounter);
                popCounter = 0;
                if(!binaryNodes.empty()){
                    currentNode = binaryNodes.peek();
                    for(int i = 0; i < popCounterStack.peek(); i++){
                        traverseValues.add(traversedNodes.pop().data);
                        counter++;
                    }
                    popCounterStack.pop();
                } else {
                    while(!popCounterStack.empty()){
                        for(int i = 0; i < popCounterStack.peek(); i++){
                            traverseValues.add(traversedNodes.pop().data);
                            counter++;
                        }
                        popCounterStack.pop();
                    }
                }
            }
            if(counter == size){
                traversed = true;
            }
        }
        System.out.println("BST POSTORDER TRAVERSAL: " + traverseValues);
        return traverseValues;
    }

}
