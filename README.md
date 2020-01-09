# Data Structures: Java Implementations

## Content Overview:
Below is an overview of some Abstract Data Types (ADTs) and my implementations of them using Java, including a summary of their worst case Time Complexities.

## Introduction:
Data structures provide ways of storing and organizing data in computer memory and fall into two broad categories: Linear and Non-Linear.

## Linear Data Structures:

* ## Queue
Queues are a collection (or sequence) type data structure, meaning they hold collections of objects, organized along the **First-In-First-Out (F.I.F.O)** principle. The element at the front of the queue is the one that is returned. This happens successively until the last element is extracted from the back of the queue, similar to how human queues for customer service operate.
**Queues have 2 defining methods**:  

 * **enqueue(e)** - Adds element e the back of the queue.
 * **dequeue()** - Returns and removes the element currently at the front of the queue.

My implementation of a Queue uses Java's built in *ArrayList* data structure:
 ```Java
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
 }
 ```
NOTE: The print() method is not included in this code sample but can be found in the source code.

 ### Time Complexity (Worst Case)
 * **Access (dequeue)**:
    * **O(1)** - Constant time if the element being accessed is at the front of the queue.
    * **O(n)** - It takes linear time to access an arbitrary element in the queue not at the front. For example, in the worst case, to access the last element in a queue of *n* elements, the dequeue operation would have to be applied *n* times.
 * **Insertion (enqueue):**
   * **O(1)** - Constant time. A strength of Queues: no matter how large the elements in the queue, inserting any element into a queue will take constant time.  


* ## Stack
Stacks are another collection type data structure but are organized along the **Last-In-First-Out (L.I.F.O)** principle. Akin to a stack of plates, the last element added is the first to be removed from the stack. **Stacks have 2 defining methods**:

 * **push(e)** - Adds element *e* to the top of the stack.
 * **pop()** - Returns and removes the element at the top of the stack.  

My implementation of a Stack using Java's built in *ArrayList* data structure:
```Java
public class Stack<T> {
    private ArrayList<T> stack;

    /**
     * Creates new stack instance using an ArrayList.
     */
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
}
```
NOTE: The print() method is not included in this code sample but can be found in the source code.


### Time Complexity (Worst Case)
* **Access (pop)**:
   * **O(1)** - Constant time if the element being accessed is at the top of the stack.
   * **O(n)** - It takes linear time to access an arbitrary element not at the top of the stack. For example, in the worst case, to access the last element in a stack of *n* elements the pop operation would have to be applied *n* times.
* **Insertion (push):**
  * **O(1)** - Constant time. A strength of Stacks: no matter how large the stack, adding an element the top of a stack will always take constant time.  

* ## LinkedList
LinkedLists are data structures made up of **nodes** which contain data and pointers which point to the next node in the data structure. The first node, called the **head-node**, contains the first element while the last node points to null indicating the end of the linkedlist. **LinkedLists have 4 key methods:**

 * **add(e)** - Adds element e to the linkedlist.
 * **remove(index)** - Removes the element at the specified index from the linkedlist.
 * **get(index)** - Returns the element at the specified index.
 * **search(element)** - Finds whether specified element is in the linkedlist.

My implementation of the **Singly LinkedList** data structure using Java's ArrayList:
```Java
public class LinkedList<T>{
    private Node head;
    private int size;

    /**
     * Inner class defining linkedlist nodes
     */
    private class Node {
        T data;
        Node nextNode;
    }

    /**
     * Constructor for singly linkedlist.
     */
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
                if(!isEmpty()){
                    Node currentNode = head;
                    int position = 0;
                    while(position != index){
                        currentNode = currentNode.nextNode;
                        position++;
                    }
                    System.out.println("LinkedList[" + index + "] = " + currentNode.data);
                    return currentNode.data;
                }
            }
            return null;
    }


    /**
     * Removes the element at the specified index from the linkedlist.
     * @param index - the index of the element to be removed
     */
    public void remove(int index){
        if(isIndexValid(index)){
            Node currentNode = head;
            int position = 0;
            if(!isEmpty()){
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

    /**
     * Searches for the specified element in the linkedlist and returns
     * the index of its first occurrence in the linkedlist.
     * @param element - the element to be found
     * @return the index of the element if it is found, null if not found
     */
    public Integer search(T element){
        Node currentNode = head;
        boolean found = false;
        int index  = 0;
        while(!found){
            if(currentNode.data == element){
                System.out.println(element + " found at index[" + index + "]");
                return index;
            }

            if(currentNode.nextNode == null){
                System.out.println(element + " not found");
                break;
            } else {
                currentNode = currentNode.nextNode;
                index++;
            }
        }
        return null;
    }
}
```
NOTE: The isIndexValid() and isEmpty() methods are not included in this sample code but can be found in the LinkedList class source code.

### Time Complexity (Worst Case)
* **Access**:
   * **O(n)** - In the worst case, it takes linear time to access an arbitrary element of a linkedlist as the nodes must be traversed to get to the desired element. To reach the last node in a linkedlist of *n* nodes, *n* nodes have to be traversed.
* **Insertion (add):**
  * **O(n)** -  Inserting an element into a linkedlist takes linear time in the time worst case. The insertion itself takes *O(1)* constant time but having to traverse nodes to access the node required to complete the insertion takes *O(n)* linear time.

## Non-Linear Data Structures:
 * ## Binary Search Tree
 Binary Search Trees are tree data structures which satisfy the following conditions:
  * Any node can either have **no children or up to a maximum of 2 children** (i.e. any given node can have 0, 1 or 2 children), with the top node being the **root node**.
  * The left subtree of any node must have values which are less than the value of that node, while the right subtree of the node has values which are greater. More simply, this means that **the left child of any node is always less than its parent and the right child greater than its parent**.  

  Binary Search Trees have **3 basic methods**:
  * **insert(value)**
  * **search(value)**
  * **delete(value)**

My implementation of a Binary Search Tree using a linked data structure approach:
```Java
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
}
```
*NOTE: Deletion method to be implemented*

### Time Complexity (Worst Case)
* **Insert**:
  * **O(n)** - Insertion into a BST takes linear time in the worst case.
* **Search**:
  * **O(n)** - Search into a BST takes linear time in the worst case.
* **Delete**:
  * **O(n)** - Deletion of a node in a BST takes linear time in the worst case.

  ## Binary Search Tree Traversal
  There are 3 generally used approaches to traversing trees (visiting all nodes and reading the data they contain):

  #### **Preorder**
  With *preorder* traversal, nodes are visited in the following order:
  1. *Root*
  2. *Left subtree* - traversed in a preorder fashion.
  3. *Right subtree* - traversed in a preorder fashion.

```Java
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
```
  #### **Inorder**
  With *inorder* traversal, nodes are visited in the following order:
  1. *Left subtree* - traversed in an inorder fashion.
  2. *Root*
  3. *Right subtree* - traversed in an inorder fashion.

```Java
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
      if(counter == size){
          traversed = true;
      }
  }
  System.out.println("BST INORDER TRAVERSAL: " + traverseValues);
  return traverseValues;
}
```

 #### **Postorder**
  With *postorder* traversal, nodes are visited in the following order:
  1. *Left subtree* - traversed in postorder fashion.
  2. *Right subtree* - traversed in an postorder fashion.
  3. *Root*

```Java
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
```
