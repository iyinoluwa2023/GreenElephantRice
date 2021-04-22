package org.howard.edu.lsp.exam.question41;

import java.util.ArrayList;

/**
 * A class for the function to remove zeros from an ArrayList
 */
public class RemoveZeroesOperation {
    /**
     * Function to remove all zeros from an ArrayList of Integers.
     * @param integers and ArrayList of integers
     */
    public static void removeZeroes(ArrayList<Integer> integers) {
        ArrayList<Integer> clone = new ArrayList<Integer>(integers);
        for (int i : clone) {
            if (i == 0) {
                integers.remove((Integer) i);
            }
        }
    }
}
