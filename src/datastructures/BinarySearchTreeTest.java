package datastructures;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private BinarySearchTree binarySearchTree1;
    private BinarySearchTree binarySearchTree2;
    ArrayList<Double> bst1Expected;
    ArrayList<Double> bst2Expected;

    @Before
    public void setup(){
        double[] bst1Values = {7, 11, 6, 8, 20, 1, 9, 14, 22};  // root value 10
        double[] bst2Values = {10, 65, -6, 12, 43, 256};  // root value 20
        
        binarySearchTree1 = new BinarySearchTree(10d);
        binarySearchTree2 = new BinarySearchTree(20d);

        Arrays.stream(bst1Values).forEach(binarySearchTree1::insert);
        Arrays.stream(bst2Values).forEach(binarySearchTree2::insert);

        bst1Expected = new ArrayList<>();
        bst2Expected = new ArrayList<>();
    }

    @Test
    public void preorderTraversal(){
        double[] expected1 = {10, 7, 6, 1, 8, 9, 11, 20, 14, 22};
        double[] expected2 = {20, 10, -6, 12, 65, 43, 256};

        setBST1Expected(expected1);
        setBST2Expected(expected2);

        assertEquals(binarySearchTree1.preorderTraversal(), bst1Expected);
        assertEquals(binarySearchTree2.preorderTraversal(), bst2Expected);
    }

    @Test
    public void inorderTraversal(){
        double[] expected1 = {1, 6, 7, 9, 8, 10, 14, 20, 22, 11};
        double[] expected2 = {-6, 10, 12, 20, 43, 65, 256};

        setBST1Expected(expected1);
        setBST2Expected(expected2);

        assertEquals(binarySearchTree1.inorderTraversal(), bst1Expected);
        assertEquals(binarySearchTree2.inorderTraversal(), bst2Expected);
    }

    @Test
    public void postorderTraversal(){
        double[] expected1 = {1, 6, 9, 8, 7, 14, 22, 20, 11, 10};
        double[] expected2 = {-6, 12, 10, 43, 256, 65, 20};

        setBST1Expected(expected1);
        setBST2Expected(expected2);

        assertEquals(binarySearchTree1.postorderTraversal(), bst1Expected);
        assertEquals(binarySearchTree2.postorderTraversal(), bst2Expected);
    }

    @Test
    public void search(){
        assertTrue(binarySearchTree1.search(22));
        assertFalse(binarySearchTree1.search(3.14));

        assertTrue(binarySearchTree2.search(12));
        assertFalse(binarySearchTree2.search(-3.14));
    }


    /**
     * Sets the expected value for binarySearchTree1
     * @param expected_values the expected values of binarySearchTree1 (a double array)
     */
    public void setBST1Expected(double[] expected_values){
        for(double x : expected_values){
            bst1Expected.add(x);
        }
    }

    /**
     * Sets the expected value for binarySearchTree2
     * @param expected_values the expected values of binarySearchTree2 (a double array)
     */
    public void setBST2Expected(double[] expected_values){
        for(double y : expected_values){
            bst2Expected.add(y);
        }
    }

}
