package org.howard.edu.lsp.assignment3.implementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The Integer Set class, an ArrayList of Integers.
 */
public class IntegerSet {
  private List<Integer> set = new ArrayList<>();

  /**
   * Sorts the IntegerSet for testing clarity.
   */
  public void sort() {
    Collections.sort(set);
  }

  /**
   * Clears the IntegerSet
   */
  public void clear() {
    set = new ArrayList<>();
  }

  /**
   * Determines length of the IntegerSet.
   *
   * @return the length of the IntegerSet
   */
  public int length() {
    return set.size();
  }

  /**
   * Determines if the IntegerSet object is equal to another.
   *
   * @param b the second IntegerSet which you compare to the first
   * @return true, if the IntegerSets are equal
   */
  public boolean equals(IntegerSet b) {
    return set.equals(b.set);
  }

  /**
   * Determines if the IntegerSet contains a certain value.
   *
   * @param value the inquired value
   * @return true, if the value is in the IntegerSet set
   */
  public boolean contains(int value) {
    // for each integer in set, if the integer is equal to value return true
    for (int integer : set) {
      if (value == integer) {
        return true;
      }
    }
    return false;
  }

  /**
   * Determines the largest integer in the IntegerSet.
   *
   * @return the largest integer in the set
   * @throws IntegerSetException the integer set exception if the set is empty
   */
  public int largest() throws IntegerSetException {
    try {
      // checks if the IntegerSet is empty, throws IntegerSetException if it is
      if (this.length() == 0) {
        throw new IntegerSetException("IntegerSet EXCEPTION: Empty integer set");
      }
      int max = -2147483648;
      // for each integer in set, if integer is larger than max then max is replaced with that integer
      for (int integer : set) {
        if (integer > max) {
          max = integer;
        }
      }
      return max;
    } catch (IntegerSetException e) {
      System.out.println(e.getMessage());
    }
    return 0;
  }

  /**
   * Determines the smallest integer in the IntegerSet.
   *
   * @return the smallest integer in the set
   * @throws IntegerSetException the integer set exception if the set is empty
   */
  public int smallest() throws IntegerSetException {
    try {
      // checks if the IntegerSet is empty, throws IntegerSetException if it is
      if (this.length() == 0) {
        throw new IntegerSetException("IntegerSet EXCEPTION: Empty integer set");
      }
      // finds largest integer in set
      int min = this.largest();
      // for each integer in set, if the integer is smaller than the min variable, than min is replaced with that integer
      for (int integer : set) {
        if (integer < min) {
          min = integer;
        }
      }
      return min;
    } catch (IntegerSetException e) {
      System.out.println(e.getMessage());
    }
    return 0;
  }

  /**
   * Adds an integer to the set, does nothing if its already in the set.
   *
   * @param item the item being added to the set
   */
  public void add(int item) {
    // if the set does not contain item, then the item is added to the set
    if (!set.contains(item)) {
      set.add(item);
    }
  }

  /**
   * Removes an integer from the set, if its present in the set.
   *
   * @param item the item being removed from the set
   */
  public void remove(int item) {
    // for each integer in the set, if it equal to item, then item is removed
    for (int i = this.length() - 1; i >= 0; i--) {
      if (set.get(i) != item) {
        continue;
      }
      set.remove(i);
    }
  }

  /**
   * Determines the union of two sets, all integers from setA or setB.
   *
   * @param setB the second set you are comparing to
   */
  public void union(IntegerSet setB) {
    // for each integer in setB, add integer to setA
    for (int integerB : setB.set) {
      this.add(integerB);
    }
  }

  /**
   * Determines the intersection of two sets, all integers from setA and setB.
   *
   * @param setB the second set you are comparing to
   */
  public void intersect(IntegerSet setB) {
    IntegerSet intersectSet = new IntegerSet();
    // for each integer in setB, if setA contains the integer then its added to the final set
    for (int integerB : setB.set) {
      if (this.contains(integerB)) {
        intersectSet.add(integerB);
      }
    }
    // intersection is saved to the instance
    this.set = intersectSet.set;
  }

  /**
   * Determines the difference of two sets, all integers from just setA and not in setB.
   *
   * @param setB the second set you are comparing to
   */
  public void diff(IntegerSet setB) {
    // for each integer in setB, if setA contains that integer than its removed from setA
    for (int integerB : setB.set) {
      if (!this.contains(integerB)) {
        continue;
      }
      this.remove(integerB);
    }
  }

  /**
   * Checks if the IntegerSet is empty.
   *
   * @return true, if the set is empty
   */
  public boolean isEmpty() {
    // returns true if the set's size is 0
    return (set.size() == 0);
  }

  /**
   * Converts IntegerSet to string.
   *
   * @return the IntegerSet version of the string
   */
  public String toString() {
    return set.toString();
  }
}
