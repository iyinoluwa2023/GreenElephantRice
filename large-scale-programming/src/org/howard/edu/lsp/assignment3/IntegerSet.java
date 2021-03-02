package org.howard.edu.lsp.assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerSet {
    private List<Integer> set;
    {
        set = new ArrayList<>();
    }
    public IntegerSet(IntegerSet another) { this.set = another.set; }
    public IntegerSet() { }
    public void sort() {
        Collections.sort(set);
    }
    public void clear() {
        set = new ArrayList<>();
    }
    public int length() {
        return set.size();
    }
    public boolean equals(IntegerSet b) {
        return set == b.set;
    }
    public boolean contains(int value) {
        for (int integer : set) {
            if (value == integer) return true;
        }
        return false;
    }
    public int largest() throws IntegerSetException {
        try {
            if (this.length() == 0) {
                throw new IntegerSetException("Empty integer set");
            }
            int max = 0;
            for (int integer : set) {
                if (integer > max) {
                    max = integer;
                }
            }
            return max;
        }
        catch (IntegerSetException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public int smallest() throws IntegerSetException {
        try {
            if (this.length() == 0) {
                throw new IntegerSetException("Empty integer set");
            }
            int min = this.largest();
            for (int integer : set) {
                if (integer < min) {
                    min = integer;
                }
            }
            return min;
        }
        catch (IntegerSetException e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }
    public void add(int item) {
        if (!set.contains(item)) set.add(item);
    }
    public void remove(int item) {
        for (int i = this.length() - 1; i >= 0; i--) {
            if (set.get(i) != item) continue;
            set.remove(i);
        }
    };
    public void union(IntegerSet setB) {
        for (int integerB : setB.set) {
            this.add(integerB);
        }
    }
    public void intersect(IntegerSet setB) {
        IntegerSet intersectSet = new IntegerSet();
        for (int integerB : setB.set) {
            if (this.contains(integerB)) {
                intersectSet.add(integerB);
            }
        }
        this.set = intersectSet.set;
    }

    public void diff(IntegerSet setB) // set difference, i.e. s1 - s2
    {
        for (int integerB : setB.set) {
            if (!this.contains(integerB)) {
                continue;
            }
            this.remove(integerB);
        }
    }

    // Returns true if the set is empty, false otherwise
    public boolean isEmpty() {
        ArrayList<Integer> empty = new ArrayList<>();
        return set.equals(empty);
    }
    public String toString() {
        return set.toString();
    }

}
