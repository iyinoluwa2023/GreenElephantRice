package org.howard.edu.lsp.exam.question41;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Random;

class RemoveZeroOperationTest {
    static class removeZerosTest {

        ArrayList<Integer> testList = new ArrayList<Integer>();
        Random random = new Random();

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

        @AfterEach
        void tearDown() {
            testList.clear();
            System.out.println('\n');
        }

        @RepeatedTest(5)
        @DisplayName("Tests removeZeros randomly created ArrayLists with n number of 0s ")
        void testRemoveZeroes() {
            RemoveZeroOperation.removeZeros(testList);
            System.out.println("ArrayList After:  " + testList.toString());
            Assertions.assertFalse(testList.contains(0));
        }

        @Test
        @DisplayName("Tests removeZeros on ArrayList with no 0s ")
        void testRemoveNoZeroes() {
            RemoveZeroOperation.removeZeros(testList);
            System.out.println("ArrayList After:  " + testList.toString());
            RemoveZeroOperation.removeZeros(testList);
            System.out.println("Duplicated operation: " + testList.toString());
            Assertions.assertFalse(testList.contains(0));
        }
    }
}