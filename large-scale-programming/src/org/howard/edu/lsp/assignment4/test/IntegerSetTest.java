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
    }

    @RepeatedTest(3)
    @DisplayName("IntegerSet.clear()")
    public void testClear() {
        populateSetRandom(intSet, 5);
        test("Clearing full IntegerSet - should be equal");

        // adds to intSet
        printIntegerSet(BEFORE, intSet);
        // clears intSet
        intSet.clear();
        // intSet should equal []
        printIntegerSet(AFTER, intSet);

        Assertions.assertEquals("[]", intSet.toString());
    }

    @RepeatedTest(3)
    @DisplayName("IntegerSet.length()")
    void testLength() {
        Random rand = new Random();
        int setLength = rand.nextInt(10);
        test("Length of IntegerSet - should be equal");

        // adds setLength terms to intSet
        populateSet(intSet, setLength);
        printIntegerSet(BEFORE, intSet);
        printOperationResult("length", intSet.length());

        // intSet.length() should equal setLength
        Assertions.assertEquals(intSet.length(), setLength);
    }


    @Test
    @DisplayName("IntegerSet.equals() - Populated IntegerSet equals Empty IntegerSet")
    void testEqualsPopulatedEmpty() {
        IntegerSet intSetB = new IntegerSet();
        test("Populated IntegerSet equals Empty IntegerSet - should be not equal");

        populateSetRandom(intSetB, 5);
        equalsSubTest(intSet, intSetB);

        Assertions.assertFalse(intSet.equals(intSetB));
    }

    @Test
    @DisplayName("IntegerSet.equals() - Empty IntegerSet equals Empty IntegerSet")
    void testEqualsEmptyEmpty() {
        IntegerSet intSetB = new IntegerSet();
        test("Empty IntegerSet equals Empty IntegerSet - should be equal");

        equalsSubTest(intSet, intSetB);

        Assertions.assertTrue(intSet.equals(intSetB));
    }

    @Test
    @DisplayName("IntegerSet.equals() - Populated IntegerSet equals Populated IntegerSet")
    void testEqualsPopulatedPopulatedTrue() {
        IntegerSet intSetB = new IntegerSet();
        test("Populated IntegerSet equals Populated IntegerSet - should be not equal");

        populateSetRandom(intSetB, 5);
        populateSet(intSet, 5);
        equalsSubTest(intSet, intSetB);

        Assertions.assertFalse(intSet.equals(intSetB));
    }

    @Test
    @DisplayName("IntegerSet.equals() - Populated IntegerSet equals Populated IntegerSet")
    void testEqualsPopulatedPopulatedFalse() {
        IntegerSet intSetB = new IntegerSet();
        test("Populated IntegerSet equals Populated IntegerSet - should be equal");

        populateSet(intSetB, 5);
        populateSet(intSet, 5);
        equalsSubTest(intSet, intSetB);

        Assertions.assertTrue(intSet.equals(intSetB));
    }


    @Test
    @DisplayName("IntegerSet.contains() test - IntegerSet contains control variable")
    void testContainsTrue() {
        int controlNumber = rand.nextInt(500);
        test("IntegerSet contains control variable - should be equal");

        populateSetRandom(intSet, 5);
        intSet.add(controlNumber);
        printIntegerSet(SET, intSet);
        System.out.println("Test Integer: " + controlNumber);
        printOperationResult("contains", intSet.contains(controlNumber));

        Assertions.assertTrue(intSet.contains(controlNumber));
    }

    @Test
    @DisplayName("IntegerSet.contains() test - IntegerSet doesn't contain control variable")
    void testContainsFalse() {
        int controlNumber = -1;
        test("IntegerSet doesn't contain control variable - should be not equal");

        populateSetRandom(intSet, 5);
        printIntegerSet(SET, intSet);
        System.out.println("Test Integer: " + controlNumber);
        printOperationResult("contains", intSet.contains(controlNumber));

        Assertions.assertFalse(intSet.contains(controlNumber));
    }

    @Test
    @DisplayName("IntegerSet.contains() test - IntegerSet doesn't contain control variable")
    void testContainsEmptyFalse() {
        int controlNumber = -1;
        test("IntegerSet doesn't contain control variable - should be not equal");

        printIntegerSet(SET, intSet);
        System.out.println("Test Integer: " + controlNumber);
        printOperationResult("contains", intSet.contains(controlNumber));

        Assertions.assertFalse(intSet.contains(controlNumber));
    }
//
    @RepeatedTest(3)
    @DisplayName("IntegerSet.largest() test - IntegerSet identifies control int as largest integer")
    void testLargestTrue() throws IntegerSetException {
        int controlNumber = rand.nextInt(200 - 101 + 1) + 101;
        test("IntegerSet identifies largest integer - should be equal");

        populateSetRandom(intSet, 5);
        intSet.add(controlNumber);
        printIntegerSet(SET, intSet);
        printOperationResult("largest", intSet.largest());

        Assertions.assertEquals(intSet.largest(), controlNumber);
    }

    @RepeatedTest(3)
    @DisplayName("IntegerSet.largest() test - IntegerSet doesn't identify control int as largest integer")
    void testLargestFalse() throws IntegerSetException {
        int controlNumber = -(rand.nextInt(200 - 101 + 1) + 101);
        test("IntegerSet identifies largest integer - should be not equal");

        populateSetRandom(intSet, 5);
        intSet.add(controlNumber);
        printIntegerSet(SET, intSet);
        printInteger("Test Integer", controlNumber);
        printOperationResult("largest", intSet.largest());

        Assertions.assertNotEquals(intSet.largest(), controlNumber);
    }

    @RepeatedTest(3)
    @DisplayName("IntegerSet.smallest() test - IntegerSet identifies control int as smallest integer")
    void testSmallestTrue() throws IntegerSetException {
        int controlNumber = -(rand.nextInt(200 - 101 + 1) + 101);
        test("IntegerSet identifies smallest integer - should be equal");

        populateSetRandom(intSet, 5);
        intSet.add(controlNumber);
        printIntegerSet(SET, intSet);
        printOperationResult("smallest", intSet.smallest());

        Assertions.assertEquals(intSet.smallest(), controlNumber);
    }

    @RepeatedTest(3)
    @DisplayName("IntegerSet.smallest() test - IntegerSet doesn't identify control int as smallest integer")
    void testSmallestFalse() throws IntegerSetException {
        int controlNumber = rand.nextInt(200 - 101 + 1) + 101;
        test("IntegerSet identifies smallest integer - should be not equal");

        populateSetRandom(intSet, 4);
        intSet.add(controlNumber);
        printIntegerSet(SET, intSet);
        printInteger("Test Integer", controlNumber);
        printOperationResult("smallest", intSet.smallest());

        Assertions.assertNotEquals(intSet.smallest(), controlNumber);
    }

    @Test
    @DisplayName("IntegerSet.add() test - IntegerSet adds integer to empty set")
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
    @DisplayName("IntegerSet.add() test - IntegerSet adds integer to populated set")
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
    @DisplayName("IntegerSet.add() test - IntegerSet adds duplicate to populated set")
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
    @DisplayName("IntegerSet.remove() test - IntegerSet adds removes from populated set")
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
    @DisplayName("IntegerSet.remove() test - IntegerSet removes from empty set")
    void testRemoveEmptySet() {
        test("IntegerSet removes from empty set - should not remove from set");

        printIntegerSet(BEFORE, intSet);
        intSet.remove(0);
        printInteger("Test Integer", 0);
        printIntegerSet(AFTER, intSet);

        Assertions.assertEquals("[]", intSet.toString());
    }

    @Test
    @DisplayName("IntegerSet.remove() test - IntegerSet removes item from populated set where not present")
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
    @DisplayName("IntegerSet.remove() test - IntegerSet removes from single integer set")
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
    @DisplayName("IntegerSet.union() test - Union of two one integer length sets with non-intersecting ints")
    void unionSingleIntegerSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Union of two one integer length sets with non-intersecting ints");

        intSet.add(1);
        intSetB.add(-1);
        unionSubTest(intSet, intSetB);

        Assertions.assertEquals(intSet.toString(), "[1, -1]");
    }

    @Test
    @DisplayName("IntegerSet.union() - Union of two populated sets with intersecting ints")
    void unionPopulatedSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Union of two populated sets with intersecting ints");

        for (int i = 4; i < 10; i++) intSetB.add(i);
        for (int i = 0; i < 5; i++) intSet.add(i);
        unionSubTest(intSet, intSetB);

        Assertions.assertEquals(intSet.toString(), "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]");
    }

    @Test
    @DisplayName("IntegerSet.union() test - Union of one populated set and one unpopulated set")
    void unionPopulatedUnpopulatedIntegerSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Union of one populated set and one unpopulated set");

        populateSet(intSet, 5);
        unionSubTest(intSet, intSetB);

        Assertions.assertEquals(intSet.toString(), "[0, 1, 2, 3, 4]");
    }

    @Test
    @DisplayName("IntegerSet.union() test - Union of two empty sets")
        void unionEmptyIntegerSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Union of two empty sets");
        unionSubTest(intSet, intSetB);

        Assertions.assertEquals(intSet.toString(), "[]");
    }

    @Test
    @DisplayName("IntegerSet.intersection() test - Intersection of two one integer length sets with non-intersecting ints")
    void testIntersectionSingleIntegerSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Intersection of two one integer length sets with non-intersecting ints");

        intSet.add(1);
        intSetB.add(-1);
        intersectionSubTest(intSet, intSetB);

        Assertions.assertEquals(intSet.toString(), "[]");
    }

    @Test
    @DisplayName("IntegerSet.intersection() test - Intersection of two populated sets with intersecting ints")
    void testIntersectionRandomSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Intersection of two populated sets with intersecting ints");

        for (int i = 12; i < 37; i++) intSetB.add(i);
        for (int i = 0; i < 25; i++) intSet.add(i);
        intersectionSubTest(intSet, intSetB);

        Assertions.assertEquals(intSet.toString(), "[12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24]");
    }

    @Test
    @DisplayName("IntegerSet.intersection() test - Intersection of two populated sets with intersecting ints")
    void testIntersectionCommonInts() {
        IntegerSet intSetB = new IntegerSet();
        test("Intersection of two populated sets with intersecting ints");

        populateSet(intSet, 5);
        for (int i = 2; i < 7; i++) intSetB.add(i);
        intersectionSubTest(intSet, intSetB);

        Assertions.assertEquals(intSet.toString(), "[2, 3, 4]");
    }

    @Test
    @DisplayName("IntegerSet.intersection() test - Intersection of populated set with empty set")
    void testIntersectionPopulatedUnpopulated() {
        IntegerSet intSetB = new IntegerSet();
        test("Intersection of populated set with empty set");

        populateSet(intSet, 5);
        intersectionSubTest(intSet, intSetB);

        Assertions.assertEquals(intSet.toString(), "[]");
    }

    @Test
    @DisplayName("IntegerSet.intersection() test - Intersection of two empty sets")
    void testIntersectionEmptyIntegerSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Intersection of two empty sets");
        intersectionSubTest(intSet, intSetB);

        Assertions.assertEquals(intSet.toString(), "[]");
    }

    @Test
    @DisplayName("IntegerSet.difference() test - Difference of two one integer length sets with intersecting ints")
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
    @DisplayName("IntegerSet.difference() test - Difference of two populated sets with intersecting ints")
    void testDiffRandomSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Difference of two populated sets with intersecting ints");

        for (int i = 12; i < 37; i++) intSetB.add(i);
        for (int i = 0; i < 25; i++) intSet.add(i);
        diffSubTest(intSet, intSetB);

        Assertions.assertEquals(intSet.toString(), "[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]");
    }

    @Test
    @DisplayName("IntegerSet.difference() test - Difference of two one integer length sets with intersecting ints")
    void testDiffCommonInts() {
        IntegerSet intSetB = new IntegerSet();
        test("Difference of two one integer length sets with intersecting ints");

        populateSet(intSet, 5);
        for (int i = 2; i < 7; i++) intSetB.add(i);
        diffSubTest(intSet, intSetB);

        Assertions.assertEquals(intSet.toString(), "[0, 1]");
    }

    @Test
    @DisplayName("IntegerSet.difference() test - Difference of one populated set with one empty set")
    void testDiffPopulatedUnpopulated() {
        IntegerSet intSetB = new IntegerSet();
        test("Difference of one populated set with one empty set");
        populateSet(intSet, 5);
        diffSubTest(intSet, intSetB);

        Assertions.assertEquals(intSet.toString(), "[0, 1, 2, 3, 4]");
    }

    @Test
    @DisplayName("IntegerSet.difference() test - Difference of two empty sets")
    void testDiffEmptyIntegerSets() {
        IntegerSet intSetB = new IntegerSet();
        test("Difference of two empty sets");
        diffSubTest(intSet, intSetB);

        Assertions.assertEquals(intSet.toString(), "[]");
    }

    @Test
    @DisplayName("IntegerSet.isEmpty() test - Checks if empty set is empty")
    void testEmptyEmptySet() {
        test("Checks if empty set is empty");
        printIntegerSet(SET, intSet);
        printOperationResult("isEmpty", intSet.isEmpty());

        Assertions.assertEquals(intSet.toString(), "[]");
    }

    @Test
    @DisplayName("IntegerSet.isEmpty() test - Checks if populated set is empty")
    void testEmptyPopulatedSet() {
        test("Checks if populated set is empty");
        // populates set
        populateSet(intSet, 5);
        printIntegerSet(SET, intSet);
        printOperationResult("isEmpty", intSet.isEmpty());

        Assertions.assertEquals(intSet.toString(), "[0, 1, 2, 3, 4]");
    }

    @Test
    @DisplayName("IntegerSet.toString() test - Checks if populated set turns to String")
    void testToString() {
        test("Checks if populated set turns to String");
        // populates set
        populateSet(intSet, 5);
        System.out.println("Expected: [0, 1, 2, 3, 4]");
        printIntegerSet("Result Set: ", intSet);

        Assertions.assertEquals(intSet.toString(), "[0, 1, 2, 3, 4]");
    }
}