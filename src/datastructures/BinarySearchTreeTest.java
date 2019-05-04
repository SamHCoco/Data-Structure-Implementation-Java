package datastructures;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    private BinarySearchTree binarySearchTree1;
    private BinarySearchTree binarySearchTree2;
    ArrayList<Double> bst_1_expected;
    ArrayList<Double> bst_2_expected;

    @Before
    public void setup(){
        double[] bst_1_values = {7, 11, 6, 8, 20, 1, 9, 14, 22};  // root value 10
        double[] bst_2_values = {10, 65, -6, 12, 43, 256};  // root value 20
        binarySearchTree1 = new BinarySearchTree(10d);
        binarySearchTree2 = new BinarySearchTree(20d);
        for(double x : bst_1_values){
            binarySearchTree1.insert(x);
        }
        for(double y : bst_2_values){
            binarySearchTree2.insert(y);
        }
        bst_1_expected = new ArrayList<>();
        bst_2_expected = new ArrayList<>();
    }

    @Test
    public void preorderTraversal(){
        double[] expected_1 = {10, 7, 6, 1, 8, 9, 11, 20, 14, 22};
        double[] expected_2 = {20, 10, -6, 12, 65, 43, 256};
        setBst_1_Expected(expected_1);
        setBst_2_Expected(expected_2);
        assertEquals(binarySearchTree1.preorderTraversal(), bst_1_expected);
        assertEquals(binarySearchTree2.preorderTraversal(), bst_2_expected);
    }

    @Test
    public void inorderTraversal(){
        double[] expected_1 = {1, 6, 7, 9, 8, 10, 14, 20, 22, 11};
        double[] expected_2 = {-6, 10, 12, 20, 43, 65, 256};
        setBst_1_Expected(expected_1);
        setBst_2_Expected(expected_2);
        assertEquals(binarySearchTree1.inorderTraversal(), bst_1_expected);
        assertEquals(binarySearchTree2.inorderTraversal(), bst_2_expected);
    }

    @Test
    public void postorderTraversal(){
        double[] expected_1 = {1, 6, 9, 8, 7, 14, 22, 20, 11, 10};
        double[] expected_2 = {-6, 12, 10, 43, 256, 65, 20};
        setBst_1_Expected(expected_1);
        setBst_2_Expected(expected_2);
        assertEquals(binarySearchTree1.postorderTraversal(), bst_1_expected);
        assertEquals(binarySearchTree2.postorderTraversal(), bst_2_expected);
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
    public void setBst_1_Expected(double[] expected_values){
        for(double x : expected_values){
            bst_1_expected.add(x);
        }
    }

    /**
     * Sets the expected value for binarySearchTree2
     * @param expected_values the expected values of binarySearchTree2 (a double array)
     */
    public void setBst_2_Expected(double[] expected_values){
        for(double y : expected_values){
            bst_2_expected.add(y);
        }
    }

}
