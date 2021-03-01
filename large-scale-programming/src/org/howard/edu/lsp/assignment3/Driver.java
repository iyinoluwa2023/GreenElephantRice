package org.howard.edu.lsp.assignment3;

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
        for (int i = 0; i < n; i++) testSet.add(i + 1);
        printTest("Length Method");
        System.out.println("Expected: " + n);
        System.out.println(testSet.toString() + "\n");
        System.out.println("testSet.length(): " + testSet.length());
    }
    public static void testLargest(IntegerSet testSet, int n) throws IntegerSetException {
        for (int i = 0; i < n; i++) testSet.add(i + 1);
        printTest("Largest Method");
        System.out.println("Expected: " + (n - 1));
        int max = testSet.largest();
        System.out.println(testSet.toString() + "\n");
        System.out.println("testSet.largest(): " + max);
    }
    public static void testSmallest(IntegerSet testSet, int n) throws IntegerSetException {
        for (int i = 0; i < n; i++) testSet.add(i + 1);
        printTest("Smallest Method");
        System.out.println("Expected: " + 1);
        int min = testSet.smallest();
        System.out.println(testSet.toString() + "\n");
        System.out.println("testSet.smallest(): " + min);
    }
    public static void main(String[] args) throws IntegerSetException {
        IntegerSet testSet = new IntegerSet();
        // IntegerSet.clear()
        testClear(testSet);
        // IntegerSet.length()
        testLength(testSet, 15);
        testSet.clear();
        // IntegerSet.largest()
        testLargest(testSet, 15);
        testSet.clear();
        // IntegerSet.smallest()
        testSmallest(testSet, 15);
        testSet.clear();
    }
}
