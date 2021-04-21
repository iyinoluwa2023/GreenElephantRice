package org.howard.edu.lsp.exam.question41;

import java.util.ArrayList;

public class RemoveZeroOperation {
    public static void removeZeros(ArrayList<Integer> integers) {
        ArrayList<Integer> clone = new ArrayList<Integer>(integers);
        for (int i : clone) {
            if (i == 0) {
                integers.remove((Integer) i);
            }
        }
    }
}
