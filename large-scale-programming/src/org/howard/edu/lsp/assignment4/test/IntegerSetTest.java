package org.howard.edu.lsp.assignment4.test;

import org.howard.edu.lsp.assignment4.implementation.IntegerSet;
import org.howard.edu.lsp.assignment4.implementation.IntegerSetException;
import org.junit.jupiter.api.*;

import java.util.Random;

import static org.howard.edu.lsp.assignment4.test.Driver.*;

class IntegerSetTest {

    IntegerSet intSet = new IntegerSet();
    Random rand = new Random();

    @BeforeEach
    public void setUp() {
        intSet = new IntegerSet();
        rand = new Random();
    }

    @RepeatedTest(3)
    @DisplayName("IntegerSet.clear() - should  be equal")
    public void testClear() {
        // adds to intSet
        populateSetRandom(intSet, 5);
        test("Clearing full IntegerSet - should be equal");
        printIntegerSet(BEFORE, intSet);
        // clears intSet
        intSet.clear();
        // intSet should equal []
        printIntegerSet(AFTER, intSet);
        Assertions.assertEquals("[]", intSet.toString());
    }

    @RepeatedTest(3)
    @DisplayName("IntegerSet.length() - should be equal")
    void testLength() {
        Random rand = new Random();
        int setLength = rand.nextInt(10);
        // adds setLength terms to intSet
        populateSet(intSet, setLength);
        test("Length of IntegerSet - should be equal");
        printIntegerSet(BEFORE, intSet);
        printOperationResult("length", intSet.length());
        // intSet.length() should equal setLength
        Assertions.assertEquals(intSet.length(), setLength);
    }


    @Test
    @DisplayName("IntegerSet.equals() - should be not equal")
    void testEqualsPopulatedEmpty() {
        IntegerSet intSetB = new IntegerSet();
        test("Populated IntegerSet equals Empty IntegerSet - should be not equal");
        populateSetRandom(intSetB, 5);
        equalsSubTest(intSet, intSetB);
        Assertions.assertFalse(intSet.equals(intSetB));
    }

    @Test
    @DisplayName("IntegerSet.equals() - should be equal")
    void testEqualsEmptyEmpty() {
        IntegerSet intSetB = new IntegerSet();
        test("Empty IntegerSet equals Empty IntegerSet - should be equal");
        equalsSubTest(intSet, intSetB);
        Assertions.assertTrue(intSet.equals(intSetB));
    }

    @Test
    @DisplayName("IntegerSet.equals() - should be not equal")
    void testEqualsPopulatedPopulatedTrue() {
        IntegerSet intSetB = new IntegerSet();
        test("Populated IntegerSet equals Populated IntegerSet - should be not equal");
        populateSetRandom(intSetB, 5);
        populateSet(intSet, 5);
        equalsSubTest(intSet, intSetB);
        Assertions.assertFalse(intSet.equals(intSetB));
    }

    @Test
    @DisplayName("IntegerSet.equals() - should be equal")
    void testEqualsPopulatedPopulatedFalse() {
        IntegerSet intSetB = new IntegerSet();
        test("Populated IntegerSet equals Populated IntegerSet - should be equal");
        populateSet(intSetB, 5);
        populateSet(intSet, 5);
        equalsSubTest(intSet, intSetB);
        Assertions.assertTrue(intSet.equals(intSetB));
    }


    @Test
    @DisplayName("IntegerSet.contains() test - should pass")
    void testContainsTrue() {
        test("IntegerSet contains control variable - should be equal");
        populateSetRandom(intSet, 5);
        int controlNumber = rand.nextInt(500);
        intSet.add(controlNumber);
        printIntegerSet(SET, intSet);
        System.out.println("Test Integer: " + controlNumber);
        printOperationResult("contains", intSet.contains(controlNumber));
        Assertions.assertTrue(intSet.contains(controlNumber));
    }

    @Test
    @DisplayName("IntegerSet.contains() test - should pass")
    void testContainsFalse() {
        test("IntegerSet contains control variable - should be not equal");
        populateSetRandom(intSet, 5);
        int controlNumber = -1;
        printIntegerSet(SET, intSet);
        System.out.println("Test Integer: " + controlNumber);
        printOperationResult("contains", intSet.contains(controlNumber));
        Assertions.assertFalse(intSet.contains(controlNumber));
    }

    @Test
    @DisplayName("IntegerSet.contains() test - should pass")
    void testContainsEmptyFalse() {
        test("IntegerSet contains control variable - should be not equal");
        int controlNumber = -1;
        printIntegerSet(SET, intSet);
        System.out.println("Test Integer: " + controlNumber);
        printOperationResult("contains", intSet.contains(controlNumber));
        Assertions.assertFalse(intSet.contains(controlNumber));
    }
//
    @RepeatedTest(3)
    @DisplayName("IntegerSet.largest() test - should pass")
    void testLargestTrue() throws IntegerSetException {
        test("IntegerSet identifies largest integer - should be equal");
        populateSetRandom(intSet, 5);
        int controlNumber = rand.nextInt(200 - 101 + 1) + 101;
        intSet.add(controlNumber);
        printIntegerSet(SET, intSet);
        printOperationResult("largest", intSet.largest());
        Assertions.assertEquals(intSet.largest(), controlNumber);
    }

    @RepeatedTest(3)
    @DisplayName("IntegerSet.largest() test - should pass")
    void testLargestFalse() throws IntegerSetException {
        test("IntegerSet identifies largest integer - should be not equal");
        populateSetRandom(intSet, 5);
        int controlNumber = -(rand.nextInt(200 - 101 + 1) + 101);
        intSet.add(controlNumber);
        printIntegerSet(SET, intSet);
        printInteger("Test Integer", controlNumber);
        printOperationResult("largest", intSet.largest());
        Assertions.assertNotEquals(intSet.largest(), controlNumber);
    }

    @RepeatedTest(3)
    @DisplayName("IntegerSet.smallest() test - should pass")
    void testSmallestTrue() throws IntegerSetException {
        test("IntegerSet identifies smallest integer - should be equal");
        populateSetRandom(intSet, 5);
        int controlNumber = -(rand.nextInt(200 - 101 + 1) + 101);
        intSet.add(controlNumber);
        printIntegerSet(SET, intSet);
        printOperationResult("smallest", intSet.smallest());
        Assertions.assertEquals(intSet.smallest(), controlNumber);
    }

    @RepeatedTest(3)
    @DisplayName("IntegerSet.smallest() test - should pass")
    void testSmallestFalse() throws IntegerSetException {
        test("IntegerSet identifies smallest integer - should be not equal");
        populateSetRandom(intSet, 4);
        int controlNumber = rand.nextInt(200 - 101 + 1) + 101;
        intSet.add(controlNumber);
        printIntegerSet(SET, intSet);
        printInteger("Test Integer", controlNumber);
        printOperationResult("smallest", intSet.smallest());
        Assertions.assertNotEquals(intSet.smallest(), controlNumber);
    }

    @Test
    @DisplayName("IntegerSet.add() test - should pass")
    void testAddEmptySet() {
        int controlNumber = rand.nextInt(100);
        test("IntegerSet adds integer to empty set - should add to set");
        printIntegerSet(BEFORE, intSet);
        intSet.add(controlNumber);
        printInteger("Test Integer", controlNumber);
        printIntegerSet(AFTER, intSet);
        Assertions.assertEquals("[" + String.valueOf(controlNumber) + "]", intSet.toString());
    }

    @Test
    @DisplayName("IntegerSet.add() test - should pass")
    void testAddPopulatedSet() {
        int controlNumber = rand.nextInt(200 - 101 + 1) + 101;
        test("IntegerSet adds integer to populated set - should add to set");
        populateSet(intSet, 5);
        printIntegerSet(BEFORE, intSet);
        intSet.add(controlNumber);
        printInteger("Test Integer", controlNumber);
        printIntegerSet(AFTER, intSet);
        Assertions.assertEquals("[0, 1, 2, 3, 4, " + String.valueOf(controlNumber) + "]", intSet.toString());
    }

    @Test
    @DisplayName("IntegerSet.add() test - should pass")
    void testAddDuplicatePopulatedSet() {
        int controlNumber = 0;
        test("IntegerSet adds duplicate to populated set - should not add to set");
        populateSet(intSet, 5);
        printIntegerSet(BEFORE, intSet);
        intSet.add(controlNumber);
        printInteger("Test Integer", controlNumber);
        printIntegerSet(AFTER, intSet);
        Assertions.assertEquals("[0, 1, 2, 3, 4]", intSet.toString());
    }

    @Test
    @DisplayName("IntegerSet.remove() test - should be equal")
    void testRemovePopulatedSet() {
        test("IntegerSet adds removes from populated set - should remove from set");
        populateSet(intSet, 5);
        printIntegerSet(BEFORE, intSet);
        intSet.remove(0);
        printInteger("Test Integer", 0);
        printIntegerSet(AFTER, intSet);
        Assertions.assertEquals("[1, 2, 3, 4]", intSet.toString());
    }

    @Test
    @DisplayName("IntegerSet.remove() test - should be equal")
    void testRemoveEmptySet() {
        test("IntegerSet removes from empty set - should not remove from set");
        printIntegerSet(BEFORE, intSet);
        intSet.remove(0);
        printInteger("Test Integer", 0);
        printIntegerSet(AFTER, intSet);
        Assertions.assertEquals("[]", intSet.toString());
    }

    @Test
    @DisplayName("IntegerSet.remove() test - should be equal")
    void testRemovePopulatedSetNotPresent() {
        test("IntegerSet removes item from populated set where not present - should not remove from set");
        populateSet(intSet, 5);
        printIntegerSet(BEFORE, intSet);
        intSet.remove(5);
        printInteger("Test Integer", 5);
        printIntegerSet(AFTER, intSet);
        Assertions.assertEquals("[0, 1, 2, 3, 4]", intSet.toString());
    }

    @Test
    @DisplayName("IntegerSet.remove() test - should be equal")
    void testRemoveSingleIntegerSet() {
        test("IntegerSet removes from single integer set - should remove from set");
        intSet.add(0);
        printIntegerSet(BEFORE, intSet);
        intSet.remove(0);
        printInteger("Test Integer", 0);
        printIntegerSet(AFTER, intSet);
        Assertions.assertEquals("[]", intSet.toString());
    }

    @Test
    @DisplayName("IntegerSet.union() test - should pass")
    void unionSingleIntegerSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Union of two one integer length sets with non-intersecting ints");
        intSet.add(1);
        intSetB.add(-1);
        unionSubTest(intSet, intSetB);
        Assertions.assertEquals(intSet.toString(), "[1, -1]");
    }

    @Test
    @DisplayName("IntegerSet.union() test - should pass")
    void unionPopulatedSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Union of two populated sets with intersecting ints");
        for (int i = 4; i < 10; i++) intSetB.add(i);
        for (int i = 0; i < 5; i++) intSet.add(i);
        unionSubTest(intSet, intSetB);
        Assertions.assertEquals(intSet.toString(), "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
    }

    @Test
    @DisplayName("IntegerSet.union() test - should pass")
    void unionPopulatedUnpopulatedIntegerSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Union of one populated set and one unpopulated set");
        populateSet(intSet, 5);
        unionSubTest(intSet, intSetB);
        Assertions.assertEquals(intSet.toString(), "[0, 1, 2, 3, 4]");
    }

    @Test
    @DisplayName("IntegerSet.union() test - should pass")
        void unionEmptyIntegerSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Union of two empty sets");
        unionSubTest(intSet, intSetB);
        Assertions.assertEquals(intSet.toString(), "[]");
    }

    @Test
    @DisplayName("IntegerSet.intersection() test - should pass")
    void testIntersectionSingleIntegerSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Intersection of two one integer length sets with non-intersecting ints");
        intSet.add(1);
        intSetB.add(-1);
        intersectionSubTest(intSet, intSetB);
        Assertions.assertEquals(intSet.toString(), "[]");
    }

    @Test
    @DisplayName("IntegerSet.intersection() test - should pass")
    void testIntersectionRandomSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Intersection of two populated sets with intersecting ints");
        for (int i = 12; i < 37; i++) intSetB.add(i);
        for (int i = 0; i < 25; i++) intSet.add(i);
        intersectionSubTest(intSet, intSetB);
        Assertions.assertEquals(intSet.toString(), "[12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]");
    }

    @Test
    @DisplayName("IntegerSet.intersection() test - should pass")
    void testIntersectionCommonInts() {
        IntegerSet intSetB = new IntegerSet();
        test("Intersection of two populated sets with intersecting ints");
        populateSet(intSet, 5);
        for (int i = 2; i < 7; i++) intSetB.add(i);
        intersectionSubTest(intSet, intSetB);
        Assertions.assertEquals(intSet.toString(), "[2, 3, 4]");
    }

    @Test
    @DisplayName("IntegerSet.intersection() test - should pass")
    void testIntersectionPopulatedUnpopulated() {
        IntegerSet intSetB = new IntegerSet();
        test("Intersection of populated set with empty set");
        populateSet(intSet, 5);
        intersectionSubTest(intSet, intSetB);
        Assertions.assertEquals(intSet.toString(), "[]");
    }

    @Test
    @DisplayName("IntegerSet.intersection() test - should pass")
    void testIntersectionEmptyIntegerSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Intersection of two empty sets");
        intersectionSubTest(intSet, intSetB);
        Assertions.assertEquals(intSet.toString(), "[]");
    }

    @Test
    @DisplayName("IntegerSet.difference() test - should pass")
    void testDiffSingleIntegerSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Difference of two one integer length sets with intersecting ints");
        intSet.add(1);
        intSet.add(-1);
        intSetB.add(-1);
        diffSubTest(intSet, intSetB);
        Assertions.assertEquals(intSet.toString(), "[1]");
    }

    @Test
    @DisplayName("IntegerSet.difference() test - should pass")
    void testDiffRandomSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Difference of two populated sets with intersecting ints");
        for (int i = 12; i < 37; i++) intSetB.add(i);
        for (int i = 0; i < 25; i++) intSet.add(i);
        diffSubTest(intSet, intSetB);
        Assertions.assertEquals(intSet.toString(), "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]");
    }

    @Test
    @DisplayName("IntegerSet.difference() test - should pass")
    void testDiffCommonInts() {
        IntegerSet intSetB = new IntegerSet();
        test("Difference of two one integer length sets with intersecting ints");
        populateSet(intSet, 5);
        for (int i = 2; i < 7; i++) intSetB.add(i);
        diffSubTest(intSet, intSetB);
        Assertions.assertEquals(intSet.toString(), "[0, 1]");
    }

    @Test
    @DisplayName("IntegerSet.difference() test - should pass")
    void testDiffPopulatedUnpopulated() {
        IntegerSet intSetB = new IntegerSet();
        test("Difference of one populated set with one empty set");
        populateSet(intSet, 5);
        diffSubTest(intSet, intSetB);
        Assertions.assertEquals(intSet.toString(), "[0, 1, 2, 3, 4]");
    }

    @Test
    @DisplayName("IntegerSet.difference() test - should pass")
    void testDiffEmptyIntegerSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Difference of two empty sets");
        diffSubTest(intSet, intSetB);
        Assertions.assertEquals(intSet.toString(), "[]");
    }

    @Test
    @DisplayName("IntegerSet.isEmpty() test - should pass")
    void testEmptyEmptySet() {
        test("Checks if empty set is empty");
        printIntegerSet(SET, intSet);
        printOperationResult("isEmpty", intSet.isEmpty());
        Assertions.assertEquals(intSet.toString(), "[]");
    }

    @Test
    @DisplayName("IntegerSet.isEmpty() test - should pass")
    void testEmptyPopulatedSet() {
        test("Checks if populated set is empty");
        populateSet(intSet, 5);
        printIntegerSet(SET, intSet);
        printOperationResult("isEmpty", intSet.isEmpty());
        Assertions.assertEquals(intSet.toString(), "[0, 1, 2, 3, 4]");
    }

    @Test
    @DisplayName("IntegerSet.toString() test - should pass")
    void testToString() {
        IntegerSet testSet = new IntegerSet();
        test("Checks if populated set turns to String");
        // populates set
        populateSet(testSet, 5);
        System.out.println("Expected: [0, 1, 2, 3, 4]");
        printIntegerSet("Result Set: ", testSet);
        Assertions.assertEquals(intSet.toString(), "[]");
    }
}