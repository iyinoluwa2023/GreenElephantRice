package org.howard.edu.lsp.exam.question41;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Random;

class removeZerosTest {

    ArrayList<Integer> testList = new ArrayList<Integer>();
    Random random = new Random();

    /**
     * Assigns an ArrayList with random numbers
     */
    @BeforeEach
    void setUp() {
        // adds random number of zeros to test ArrayList
        int numZeros = random.nextInt(7 - 2) + 2;
        for (int i = 0; i < numZeros; i++) {
            testList.add(0);
        }

        // fills the rest of the ArrayList with random numbers
        for (int i = 0; i < (10 - numZeros); i++) {
            testList.add(random.nextInt(20));
        }

        System.out.println("==========================");
        System.out.println("ArrayList Before: " + testList.toString());
    }

    /**
     * Clears the ArrayList after each test
     */
    @AfterEach
    void tearDown() {
        testList.clear();
        System.out.println('\n');
    }

    /**
     * Testing that the removeZeroes method removes the zeroes from the ArrayList
     */
    @RepeatedTest(5)
    @DisplayName("Tests removeZeroes randomly created ArrayLists with n number of 0s ")
    void testRemoveZeroes() {
        RemoveZeroesOperation.removeZeroes(testList);
        System.out.println("ArrayList After:  " + testList.toString());
        Assertions.assertFalse(testList.contains(0));
    }

    /**
     * Testing that the removesZeroes method doesn't remove any terms from an ArrayList with no zeroes
     */
    @Test
    @DisplayName("Tests removeZeroes on ArrayList with no 0s ")
    void testRemoveNoZeroes() {
        RemoveZeroesOperation.removeZeroes(testList);
        System.out.println("ArrayList After:  " + testList.toString());
        RemoveZeroesOperation.removeZeroes(testList);
        System.out.println("Duplicated operation: " + testList.toString());
        Assertions.assertFalse(testList.contains(0));
    }
}
