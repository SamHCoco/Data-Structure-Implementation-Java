# Data Structures: Java Implementations

## Content Overview:
Below is an overview of some Abstract Data Types (ADTs) and my implementations of them using Python, including a summary of their worst case Time Complexities.

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
 * **Access (deque)**:
    * **O(1)** - Constant time if the element being accessed is at the front of the queue.
    * **O(n)** - It takes linear time to access an arbitrary element in the queue not at the front. For example, in the worst case, to access the last element in a queue of *n* elements the deque operation would have to be applied *n* times.
 * **Insertion (enqueue):**
   * **O(1)** - Constant time. A strength of Queues: no matter how large the elements in the queue, inserting any element into a queue will take constant time.  


* ## Stack
Stacks are another collection type data structure but are organized along the **Last-In-First-Out (L.I.F.O)** principle. Akin to a stack of plates, the last element added is the first to be removed from the stack. **Stacks have 2 defining methods**:

 * **push(e)** - Adds element e to the top of the stack.
 * **pop()** - Returns and removes the element at the top of the stack.  

My implementation of a Stack uses Java's built in *ArrayList* data structure:
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
