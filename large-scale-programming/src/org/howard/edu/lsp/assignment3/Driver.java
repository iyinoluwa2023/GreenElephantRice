package org.howard.edu.lsp.assignment3;

import java.util.Random;


class Driver {
  public static String BEFORE = "Before";
  public static String AFTER = "After";
  public static String SETA = "Set A";
  public static String SETB = "Set B";
  public static String SET = "Set";

  public static void test(String testString, int n) {
    System.out.println(
        "------------------------------------------------" + "\n" + testString + " Method: Test " + n + "\n");
  }

  public static void printIntegerSet(String tag, IntegerSet integerSet) {
    System.out.println(tag + ": " + integerSet.toString());
  }

  public static void printOperationResult(String operation, boolean result) {
    System.out.println("IntegerSet." + operation + "(): " + result);
  }

  public static void printOperationResult(String operation, int result) {
    System.out.println("IntegerSet." + operation + "(): " + result);
  }

  public static void operation(String tag) {
    System.out.println("Operation: IntegerSet." + tag + "()" + " ----");
  }

  public static void populateSet(IntegerSet testSet, int n) {
    for (int i = 0; i < n; i++) {
      testSet.add(i);
    }
  }

  public static void populateSetRandom(IntegerSet testSet, int n) {
    Random rand = new Random();
    for (int i = 0; i < 7; i++) {
      testSet.add(rand.nextInt(100));
    }
  }

  public static void clearTest() {
    // tests method 3 times
    for (int i = 0; i < 3; i++) {
      IntegerSet testSet = new IntegerSet();
      Random rand =  new Random();
      test("Clear", i + 1);
      // adds to IntegerSet
      testSet.add(rand.nextInt(100));
      printIntegerSet(BEFORE, testSet);
      // clears IntegerSet
      testSet.clear();
      printIntegerSet(AFTER, testSet);
    }
  }

  public static void lengthTest() {
    // tests method 3 times
    for (int i = 0; i < 3; i++) {
      IntegerSet testSet = new IntegerSet();
      Random rand = new Random();
      test("Length", i + 1);
      // creates randomly sized integer set not to exceed length of 5
      for (int j = rand.nextInt(5) - 1; j >= 0; j--) {
        testSet.add(j);
      }
      printIntegerSet(BEFORE, testSet);
      printOperationResult("length", testSet.length());
    }
  }

  public static void equalsSubTest(IntegerSet testSetA, IntegerSet testSetB) {
    printIntegerSet(SETA, testSetA);
    printIntegerSet(SETB, testSetB);
    printOperationResult("equals", testSetA.equals(testSetB));
  }

  public static void equalsTest() {
    IntegerSet testSetA;
    IntegerSet testSetB;
    Random rand = new Random();
    // tests with one populated set and one empty set (not equal)
    testSetA = new IntegerSet();
    testSetB = new IntegerSet();
    test("Equals",  1);
    populateSet(testSetA, 7);
    equalsSubTest(testSetA, testSetB);
    // tests with two empty sets (equal)
    testSetA.clear();
    testSetB.clear();
    test("Equals",  2);
    equalsSubTest(testSetA, testSetB);
    // tests with two populated sets (not equal)
    testSetA.clear();
    testSetB.clear();
    test("Equals",  3);
    populateSetRandom(testSetA, 7);
    populateSetRandom(testSetB, 7);
    equalsSubTest(testSetA, testSetB);
    // tests with two populated sets (equal)
    testSetA.clear();
    testSetB.clear();
    test("Equals", 4);
    populateSet(testSetA, 7);
    populateSet(testSetB, 7);
    equalsSubTest(testSetA, testSetB);
  }

  public static void containsTest() {
    IntegerSet testSet = new IntegerSet();
    Random rand = new Random();
    // populated set contains random integer (true)
    test("Contains", 1);
    // populates set with numbers
    populateSetRandom(testSet, 100);
    // adds random number to set
    int randomNumber = rand.nextInt(500);
    testSet.add(randomNumber);
    printIntegerSet(SET, testSet);
    System.out.println("Test Integer: " + randomNumber);
    printOperationResult("contains", testSet.contains(randomNumber));
    // populated set doesn't contain random integer (false)
    test("Contains", 2);
    testSet.clear();
    // populates set with numbers
    populateSetRandom(testSet, 100);
    printIntegerSet(SET, testSet);
    randomNumber = -1;
    System.out.println("Test Integer: " + randomNumber);
    printOperationResult("contains", testSet.contains(randomNumber));
    // empty set doesn't contain random integer (false)
    test("Contains", 3);
    testSet.clear();
    printIntegerSet(SET, testSet);
    randomNumber = -1;
    System.out.println("Test Integer: " + randomNumber);
    printOperationResult("contains", testSet.contains(randomNumber));
  }

  public static void largestTest() throws IntegerSetException {
    // tests method 3 times
    for (int i = 0; i < 3; i++) {
      test("Largest", i + 1);
      IntegerSet testSet = new IntegerSet();
      // populates random set
      populateSetRandom(testSet, 7);
      // sorts set to clarify largest number
      testSet.sort();
      printIntegerSet(SET, testSet);
      printOperationResult("largest", testSet.largest());
    }
  }

  public static void smallestTest() throws IntegerSetException {
    for (int i = 0; i < 3; i++) {
      test("Smallest", i + 1);
      IntegerSet testSet = new IntegerSet();
      // populates random set
      populateSetRandom(testSet, 7);
      // sorts set to clarify largest number
      testSet.sort();
      printIntegerSet(SET, testSet);
      printOperationResult("smallest", testSet.smallest());
    }
  }


  public static void main(String[] args) throws IntegerSetException {
    clearTest();
    lengthTest();
    equalsTest();
    containsTest();
    largestTest();
    smallestTest();
  }


//  public static void testAdd(IntegerSet testSet) {
//    Random rand = new Random();
//    int randomInt = rand.nextInt(100);
//    printTest("Add Method");
//    System.out.println(testSet.toString() + "\n");
//    System.out.println("Adds: " + randomInt);
//    testSet.add(randomInt);
//    System.out.println(testSet.toString() + "\n");
//    System.out.println("Adds number again: " + randomInt);
//    testSet.add(randomInt);
//    System.out.println(testSet.toString() + "\n");
//    System.out.println("Expected length: " + 1);
//    System.out.println("Actual length: " + testSet.length());
//  }
//
//  public static void testRemove(IntegerSet testSet) {
//    Random rand = new Random();
//
//    int[] randomInts = {rand.nextInt(100), rand.nextInt(100)};
//    for (int i = 0; i < 2; i++) testSet.add(randomInts[i]);
//    printTest("Remove method");
//    System.out.println(testSet.toString() + "\n");
//    System.out.println("Removing: " + randomInts[1]);
//    testSet.remove(randomInts[1]);
//    System.out.println(testSet.toString() + "\n");
//    System.out.println("Tries to remove previously removed integer: " + randomInts[1]);
//    testSet.remove(randomInts[1]);
//    System.out.println(testSet.toString());
//
//    printTest("Remove Method - One Integer In Set");
//    testSet.clear();
//    int randomInt = rand.nextInt(100);
//    testSet.add(randomInt);
//    System.out.println(testSet.toString() + "\n");
//    System.out.println("Removing: " + randomInt);
//    testSet.remove(randomInt);
//    System.out.println(testSet.toString());
//
//    printTest("Remove Method - Empty Set");
//    testSet.clear();
//    System.out.println(testSet.toString() + "\n");
//    randomInt = rand.nextInt(100);
//    System.out.println("Tries to remove: " + randomInt);
//    testSet.remove(randomInt);
//    System.out.println(testSet.toString());
//  }
//
//  public static void testUnion(IntegerSet testSet, int n) {
//    IntegerSet testSetB = new IntegerSet();
//    Random rand = new Random();
//    printTest("Union Method");
//    testSet.add(5);
//    testSetB.add(10);
//    System.out.println("testSet: " + testSet.toString());
//    System.out.println("testSetB: " + testSetB.toString());
//    testSet.union(testSetB);
//    System.out.println("\nUnion: " + testSet.toString());
//
//    testSet.clear();
//    testSetB.clear();
//    printTest("Union Method");
//    for (int i = 0; i < n; i++) testSet.add(rand.nextInt(100));
//    for (int i = 0; i < n; i++) testSetB.add(rand.nextInt(100));
//    System.out.println("testSet: " + testSet.toString());
//    System.out.println("testSetB: " + testSetB.toString());
//    testSet.union(testSetB);
//    System.out.println("\nUnion: " + testSet.toString());
//
//    testSet.clear();
//    testSetB.clear();
//    printTest("Union Method");
//    for (int i = 0; i < n; i++) testSet.add(rand.nextInt(100));
//    System.out.println("testSet: " + testSet.toString());
//    System.out.println("testSetB: " + testSetB.toString());
//    testSet.union(testSetB);
//    System.out.println("\nUnion: " + testSet.toString());
//
//    testSet.clear();
//    testSetB.clear();
//    printTest("Union Method");
//    System.out.println("testSet: " + testSet.toString());
//    System.out.println("testSetB: " + testSetB.toString());
//    testSet.union(testSetB);
//    System.out.println("\nUnion: " + testSet.toString());
//  }
//
//  public static void testIntersection(IntegerSet testSet) {
//    IntegerSet testSetB = new IntegerSet();
//    Random rand = new Random();
//    for (int i = 0; i < 5; i++) {
//      testSetB.add(i);
//    }
//    for (int i = 2; i < 7; i++) {
//      testSet.add(i);
//    }
//    printTest("Intersection Method");
//    testSet.sort();
//    testSetB.sort();
//    System.out.println("testSet: " + testSet.toString());
//    System.out.println("testSetB: " + testSetB.toString());
//    testSet.intersect(testSetB);
//    System.out.println("\nIntersection: " + testSet.toString());
//
//    testSet.clear();
//    testSetB.clear();
//    for (int i = 0; i < 25; i++) {
//      testSetB.add(rand.nextInt(100));
//    }
//    for (int i = 0; i < 25; i++) {
//      testSet.add(rand.nextInt(100));
//    }
//    printTest("Intersection Method");
//    testSet.sort();
//    testSetB.sort();
//    System.out.println("testSet: " + testSet.toString());
//    System.out.println("testSetB: " + testSetB.toString());
//    testSet.intersect(testSetB);
//    System.out.println("\nIntersection: " + testSet.toString());
//
//    testSet.clear();
//    testSetB.clear();
//    printTest("Intersection Method");
//    testSet.sort();
//    testSetB.sort();
//    System.out.println("testSet: " + testSet.toString());
//    System.out.println("testSetB: " + testSetB.toString());
//    testSet.intersect(testSetB);
//    System.out.println("\nIntersection: " + testSet.toString());
//  }
//
//  public static void testDifference(IntegerSet testSet) {
//    IntegerSet testSetB = new IntegerSet();
//    Random rand = new Random();
//    for (int i = 0; i < 5; i++) {
//      testSetB.add(i);
//    }
//    for (int i = 2; i < 7; i++) {
//      testSet.add(i);
//    }
//    printTest("Difference Method");
//    System.out.println("testSet: " + testSet.toString());
//    System.out.println("testSetB: " + testSetB.toString());
//    testSet.diff(testSetB);
//    System.out.println("\nDifference: " + testSet.toString());
//
//    testSet.clear();
//    testSetB.clear();
//    for (int i = 0; i < 10; i++) {
//      testSetB.add(rand.nextInt(100));
//    }
//    for (int i = 0; i < 10; i++) {
//      testSet.add(rand.nextInt(100));
//    }
//    printTest("Difference Method");
//    testSet.sort();
//    testSetB.sort();
//    System.out.println("testSet: " + testSet.toString());
//    System.out.println("testSetB: " + testSetB.toString());
//    testSet.diff(testSetB);
//    System.out.println("\nDifference: " + testSet.toString());
//
//    testSet.clear();
//    testSetB.clear();
//    printTest("Difference Method");
//    testSet.sort();
//    testSetB.sort();
//    System.out.println("testSet: " + testSet.toString());
//    System.out.println("testSetB: " + testSetB.toString());
//    testSet.diff(testSetB);
//    System.out.println("\nDifference: " + testSet.toString());
//  }
//
//  public static void testEmpty() {
//    IntegerSet testSet = new IntegerSet();
//    for (int i = 0; i < 5; i++) {
//      testSet.add(i);
//    }
//    IntegerSet testSetB = new IntegerSet();
//    printTest("Empty Test");
//    System.out.println(
//        "testSet.isEmpty for testSet " + testSet.toString() + ": " + testSet.isEmpty());
//    System.out.println(
//        "testSetB.isEmpty() for testSetB " + testSetB.toString() + ": " + testSetB.isEmpty());
//  }

}
