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
    }

    /**
     * Inserts a value into the Binary Search Tree.
     * @param data - the value to be inserted (Double)
     */
    public void insert(Double data) {
        Node current_node = root;
        boolean inserted = false;
        while (!inserted) {
            if (data > current_node.data && current_node.rightChild == null) {
                current_node.rightChild = new Node(data);
                size++;
                inserted = true;
            } else if (data < current_node.data && current_node.leftChild == null) {
                current_node.leftChild = new Node(data);
                size++;
                inserted = true;
            } else if (data.equals(current_node.data) && current_node.leftChild == null) {
                current_node.leftChild = new Node(data);
                size++;
                inserted = true;
            } else if (data > current_node.data && current_node.rightChild != null) {
                current_node = current_node.rightChild;
            } else if (data < current_node.data && current_node.leftChild != null) {
                current_node = current_node.leftChild;
            }
        }
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
            if(counter == size + 1){
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
        Stack<Integer> zeroOneArray = new Stack<>();
        Integer zeroOneCount = 0;
        boolean traversed = false;
        int counter = 0;
        while(!traversed){
            if(currentNode.leftChild != null && currentNode.rightChild != null){
                if(zeroOneCount != 0){
                    zeroOneArray.push(zeroOneCount);
                    zeroOneCount = 0;
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
                zeroOneCount++;
                currentNode = currentNode.leftChild;

            } else if(currentNode.leftChild == null && currentNode.rightChild != null){
                traversedNodes.add(currentNode);
                zeroOneCount++;
                currentNode = currentNode.rightChild;

            } else if(currentNode.leftChild == null && currentNode.rightChild == null){
                traversedNodes.add(currentNode);
                zeroOneCount++;
                zeroOneArray.push(zeroOneCount);
                zeroOneCount = 0;
                if(!binaryNodes.empty()){
                    currentNode = binaryNodes.peek();
                    for(int i = 0; i < zeroOneArray.peek(); i++){
                        traverseValues.add(traversedNodes.pop().data);
                        counter++;
                    }
                    zeroOneArray.pop();
                } else {
                    while(!zeroOneArray.empty()){
                        for(int i = 0; i < zeroOneArray.peek(); i++){
                            traverseValues.add(traversedNodes.pop().data);
                            counter++;
                        }
                        zeroOneArray.pop();
                    }
                }
            }
            if(counter == size + 1){
                traversed = true;
            }
        }
        System.out.println("BST INORDER TRAVERSAL: " + traverseValues);
        return traverseValues;
    }
}