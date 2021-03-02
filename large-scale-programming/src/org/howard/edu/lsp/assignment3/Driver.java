package org.howard.edu.lsp.assignment3;

import java.util.Random;

public class Driver {
    public static void printTest(String testString){
        System.out.println("------------------------------------------------" + "\n" + testString + "\n");
    }
    public static void testClear(IntegerSet testSet){
        // clear test
        testSet.add(5);
        printTest("Clear Method");
        System.out.println("Before: \n" + testSet.toString());
        testSet.clear();
        System.out.println("After: \n" + testSet.toString());
    }
    public static void testLength(IntegerSet testSet, int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) testSet.add(rand.nextInt(100));
        printTest("Length Method");
        System.out.println("Expected: " + n);
        System.out.println(testSet.toString() + "\n");
        System.out.println("testSet.length(): " + testSet.length());
    }
    public static void testEquals(IntegerSet testSet, int n) {
        Random rand = new Random();
        // Cloned testSet into testSetB
        IntegerSet testSetB = new IntegerSet(testSet);
        printTest("Equals Method");
        System.out.println("testSet: " + testSet.toString());
        System.out.println("testSetB: " + testSetB.toString() );
        System.out.println("\ntestSet.equals(): " + testSet.equals(testSetB));

        for (int i = 0; i < n; i++) testSet.add(rand.nextInt(100));
        testSetB.clear();
        for (int i = 0; i < n; i++) testSetB.add(rand.nextInt(100));
        System.out.println("\ntestSet: " + testSet.toString());
        System.out.println("testSetB: " + testSetB.toString() );
        System.out.println("\ntestSet.equals(): " + testSet.equals(testSetB));
        testSet.clear();

        for (int i = 0; i < n; i++) testSet.add(rand.nextInt(100));
        testSetB = new IntegerSet(testSet);
        testSet.add(5);
        System.out.println("\ntestSet: " + testSet.toString());
        System.out.println("testSetB: " + testSetB.toString() );
        System.out.println("\ntestSet.equals(): " + testSet.equals(testSetB));
    }
    public static void testContains(IntegerSet testSet, int n) {
        Random rand = new Random();
        for (int i = 0; i < n; i++) testSet.add(rand.nextInt(100));
        int given = 5;
        int notGiven = -1;
        testSet.add(given);
        printTest("Contains Method");
        System.out.println(testSet.toString() + "\n");
        System.out.println("testSet.contains() for value " + given + ": " + testSet.contains(given));
        System.out.println("testSet.contains() for value " + notGiven + ": " + testSet.contains(notGiven));

    }
    public static void testLargest(IntegerSet testSet, int n) throws IntegerSetException {
        Random rand = new Random();
        for (int i = 0; i < n; i++) testSet.add(rand.nextInt(100));
        printTest("Largest Method");
        int max = testSet.largest();
        System.out.println(testSet.toString() + "\n");
        System.out.println("testSet.largest(): " + max);
    }
    public static void testSmallest(IntegerSet testSet, int n) throws IntegerSetException {
        Random rand = new Random();
        for (int i = 0; i < n; i++) testSet.add(rand.nextInt(100));
        printTest("Smallest Method");
        int min = testSet.smallest();
        System.out.println(testSet.toString() + "\n");
        System.out.println("testSet.smallest(): " + min);
    }
    public static void testAdd(IntegerSet testSet) {
        Random rand = new Random();
        int randomInt = rand.nextInt(100);
        printTest("Add Method");
        System.out.println(testSet.toString() + "\n");
        System.out.println("Adds: " + randomInt);
        testSet.add(randomInt);
        System.out.println(testSet.toString() + "\n");
        System.out.println("Adds number again: " + randomInt);
        testSet.add(randomInt);
        System.out.println(testSet.toString() + "\n");
        System.out.println("Expected length: " + 1);
        System.out.println("Actual length: " + testSet.length());
    }
    public static void testRemove(IntegerSet testSet) {
        Random rand = new Random();

        int[] randomInts = {rand.nextInt(100), rand.nextInt(100)};
        for (int i = 0; i < 2; i++) testSet.add(randomInts[i]);
        printTest("Remove method");
        System.out.println(testSet.toString() + "\n");
        System.out.println("Removing: " + randomInts[1]);
        testSet.remove(randomInts[1]);
        System.out.println(testSet.toString() + "\n");
        System.out.println("Tries to remove previously removed integer: " + randomInts[1]);
        testSet.remove(randomInts[1]);
        System.out.println(testSet.toString());

        printTest("Remove Method - One Integer In Set");
        testSet.clear();
        int randomInt = rand.nextInt(100);
        testSet.add(randomInt);
        System.out.println(testSet.toString() + "\n");
        System.out.println("Removing: " + randomInt);
        testSet.remove(randomInt);
        System.out.println(testSet.toString());

        printTest("Remove Method - Empty Set");
        testSet.clear();
        System.out.println(testSet.toString() + "\n");
        randomInt = rand.nextInt(100);
        System.out.println("Tries to remove: " + randomInt);
        testSet.remove(randomInt);
        System.out.println(testSet.toString());
    }
    public static void testUnion(IntegerSet testSet, int n) {
        IntegerSet testSetB = new IntegerSet();
        Random rand = new Random();
        printTest("Union Method");
        testSet.add(5);
        testSetB.add(10);
        System.out.println("testSet: " + testSet.toString());
        System.out.println("testSetB: " + testSetB.toString());
        testSet.union(testSetB);
        System.out.println("\nUnion: " + testSet.toString());

        testSet.clear();
        testSetB.clear();
        printTest("Union Method");
        for (int i = 0; i < n; i++) testSet.add(rand.nextInt(100));
        for (int i = 0; i < n; i++) testSetB.add(rand.nextInt(100));
        System.out.println("testSet: " + testSet.toString());
        System.out.println("testSetB: " + testSetB.toString());
        testSet.union(testSetB);
        System.out.println("\nUnion: " + testSet.toString());

        testSet.clear();
        testSetB.clear();
        printTest("Union Method");
        for (int i = 0; i < n; i++) testSet.add(rand.nextInt(100));
        System.out.println("testSet: " + testSet.toString());
        System.out.println("testSetB: " + testSetB.toString());
        testSet.union(testSetB);
        System.out.println("\nUnion: " + testSet.toString());

        testSet.clear();
        testSetB.clear();
        printTest("Union Method");
        System.out.println("testSet: " + testSet.toString());
        System.out.println("testSetB: " + testSetB.toString());
        testSet.union(testSetB);
        System.out.println("\nUnion: " + testSet.toString());
    }
    public static void testIntersection(IntegerSet testSet) {
        IntegerSet testSetB = new IntegerSet();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) { testSetB.add(i); }
        for (int i = 2; i < 7; i++) { testSet.add(i); }
        printTest("Intersection Method");
        testSet.sort();
        testSetB.sort();
        System.out.println("testSet: " + testSet.toString());
        System.out.println("testSetB: " + testSetB.toString());
        testSet.intersect(testSetB);
        System.out.println("\nIntersection: " + testSet.toString());

        testSet.clear();
        testSetB.clear();
        for (int i = 0; i < 25; i++) { testSetB.add(rand.nextInt(100)); }
        for (int i = 0; i < 25; i++) { testSet.add(rand.nextInt(100)); }
        printTest("Intersection Method");
        testSet.sort();
        testSetB.sort();
        System.out.println("testSet: " + testSet.toString());
        System.out.println("testSetB: " + testSetB.toString());
        testSet.intersect(testSetB);
        System.out.println("\nIntersection: " + testSet.toString());

        testSet.clear();
        testSetB.clear();
        printTest("Intersection Method");
        testSet.sort();
        testSetB.sort();
        System.out.println("testSet: " + testSet.toString());
        System.out.println("testSetB: " + testSetB.toString());
        testSet.intersect(testSetB);
        System.out.println("\nIntersection: " + testSet.toString());
    }
    public static void testDifference(IntegerSet testSet) {
        IntegerSet testSetB = new IntegerSet();
        Random rand = new Random();
        for (int i = 0; i < 5; i++) { testSetB.add(i); }
        for (int i = 2; i < 7; i++) { testSet.add(i); }
        printTest("Difference Method");
        System.out.println("testSet: " + testSet.toString());
        System.out.println("testSetB: " + testSetB.toString());
        testSet.diff(testSetB);
        System.out.println("\nDifference: " + testSet.toString());

        testSet.clear();
        testSetB.clear();
        for (int i = 0; i < 10; i++) { testSetB.add(rand.nextInt(100)); }
        for (int i = 0; i < 10; i++) { testSet.add(rand.nextInt(100)); }
        printTest("Difference Method");
        testSet.sort();
        testSetB.sort();
        System.out.println("testSet: " + testSet.toString());
        System.out.println("testSetB: " + testSetB.toString());
        testSet.diff(testSetB);
        System.out.println("\nDifference: " + testSet.toString());

        testSet.clear();
        testSetB.clear();
        printTest("Difference Method");
        testSet.sort();
        testSetB.sort();
        System.out.println("testSet: " + testSet.toString());
        System.out.println("testSetB: " + testSetB.toString());
        testSet.diff(testSetB);
        System.out.println("\nDifference: " + testSet.toString());
    }
    public static void testEmpty() {
        IntegerSet testSet = new IntegerSet();
        for (int i = 0; i < 5; i++) { testSet.add(i); }
        IntegerSet testSetB = new IntegerSet();
        printTest("Empty Test");
        System.out.println("testSet.isEmpty for testSet " + testSet.toString() + ": " + testSet.isEmpty());
        System.out.println("testSetB.isEmpty() for testSetB " + testSetB.toString() + ": " + testSetB.isEmpty());
    }
    public static void main(String[] args) throws IntegerSetException {
        IntegerSet testSet = new IntegerSet();
        // IntegerSet.clear()
        testClear(testSet);
        // IntegerSet.length()
        testLength(testSet, 5);
        testSet.clear();
        // IntegerSet.equals()
        testEquals(testSet, 5);
        testSet.clear();
        // IntegerSet.largest()
        testLargest(testSet, 15);
        testSet.clear();
        // IntegerSet.smallest()
        testSmallest(testSet, 15);
        testSet.clear();
        // IntegerSet.contains()
        testContains(testSet, 5);
        testSet.clear();
        // IntegerSet.add()
        testAdd(testSet);
        testSet.clear();
        // Integer.remove()
        testRemove(testSet);
        testSet.clear();
        // Integer.union()
        testUnion(testSet, 5);
        testSet.clear();
        // Integer.intersection()
        testIntersection(testSet);
        testSet.clear();
        // Integer.diff()
        testDifference(testSet);
        testSet.clear();
        // Integer.isEmpty()
        testEmpty();
        testSet.clear();
    }
}
