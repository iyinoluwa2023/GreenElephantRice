package org.howard.edu.lsp.assignment3;

import java.util.ArrayList;
import java.util.List;

public class IntegerSet {
    private List<Integer> set = new ArrayList<Integer>();

    public void clear() {
        set = new ArrayList<Integer>();
    }
    public int length() {
        return set.size();
    }
    public boolean equals(IntegerSet b) {
        return false;
    }
    // Returns true if the set contains the value, otherwise false
    public boolean contains(int value) {
        return false;
    }

//    // Returns the largest item in the set; Throws a IntegerSetException if the set is empty
//    public int largest() throws IntegerSetException {…};
//
//    // Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
//    public int smallest() throws IntegerSetException;
//
    // Adds an item to the set or does nothing it already there
    public void add(int item) {
        set.add(item);
    }; // adds item to s or does nothing if it is in set
//
//    // Removes an item from the set or does nothing if not there
//    public void remove(int item) {…};
//
//    // Set union
//    public static void union(IntegerSet intSetb) {…};
//
//    // Set intersection
//    public static public intSet intersect(IntegerSet intSetb) {…};
//
//    // Set difference, i.e., s1 –s2
//    public static intSet diff(IntegerSet intSetb); // set difference, i.e. s1 - s2
//
//    // Returns true if the set is empty, false otherwise
//    boolean isEmpty();
//
    // Return String representation of your set
    public String toString() {
        return set.toString();
    };	// return String representation of your set

}
