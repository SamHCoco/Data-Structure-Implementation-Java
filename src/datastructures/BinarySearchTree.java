package datastructures;

public class BinarySearchTree{
    private Node root;

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
                inserted = true;
            } else if (data < current_node.data && current_node.leftChild == null) {
                current_node.leftChild = new Node(data);
                inserted = true;
            } else if (data.equals(current_node.data) && current_node.leftChild == null) {
                current_node.leftChild = new Node(data);
                inserted = true;
            } else if (data > current_node.data && current_node.rightChild != null) {
                current_node = current_node.rightChild;
            } else if (data < current_node.data && current_node.leftChild != null) {
                current_node = current_node.leftChild;
            }
        }
    }

}
