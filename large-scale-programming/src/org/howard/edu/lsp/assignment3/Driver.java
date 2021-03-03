package org.howard.edu.lsp.assignment3;

import java.util.Random;

class Driver {
  // re-used strings
  public static String BEFORE = "Before";
  public static String AFTER = "After";
  public static String SETA = "Set A";
  public static String SETB = "Set B";
  public static String SET = "Set";
  public static String UNION = "Union";
  public static String INTERSECTION = "Intersection";
  public static String DIFF = "Difference";

  // helper functions
  /**
   * Displays test name
   * "testString Method: Test n"
   *
   * @param testString the test name
   * @param n the number for the test
   */
  public static void test(String testString, int n) {
    System.out.println(
            "------------------------------------------------" + "\n"
                    + testString + " Method: Test " + n + "\n");
  }

  /**
   * Prints the integer set.
   * "tag : integerSet"
   *
   * @param tag the tag for the integer set
   * @param integerSet the integer set
   */
  public static void printIntegerSet(String tag, IntegerSet integerSet) {
    System.out.println(tag + ": " + integerSet.toString());
  }

  /**
   * Prints an integer.
   * "tag : integer"
   * @param tag the tag for the integer
   * @param integer the integer
   */
  public static void printInteger(String tag, int integer) {
    System.out.println(tag + ": " + integer);
  }

  /**
   * Prints the result for a boolean returning method
   * "IntegerSet.operation(): result"
   *
   * @param operation the IntegerSet method
   * @param result the boolean result
   */
  public static void printOperationResult(String operation, boolean result) {
    System.out.println("IntegerSet." + operation + "(): " + result);
  }

  /**
   * Prints the result for a integer returning method
   *
   * @param operation the IntegerSet method
   * @param result the integer result
   */
  public static void printOperationResult(String operation, int result) {
    System.out.println("IntegerSet." + operation + "(): " + result);
  }

  /**
   * Populates the IntegerSet with numbers from 0 to (n - 1)
   *
   * @param testSet the test IntegerSet
   * @param n the length of the IntegerSet
   */
  public static void populateSet(IntegerSet testSet, int n) {
    for (int i = 0; i < n; i++) {
      testSet.add(i);
    }
  }

  /**
   * Populates the IntegerSet with n random numbers between 0 and 99
   *
   * @param testSet the test IntegerSet
   * @param n the length of the IntegerSet
   */
  public static void populateSetRandom(IntegerSet testSet, int n) {
    Random rand = new Random();
    for (int i = 0; i < n; i++) {
      testSet.add(rand.nextInt(100));
    }
  }

  //testing functions
  /**
   * tests the IntegerSet.clear() method
   */
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

  /**
   * tests the IntegerSet.length() method
   */
  public static void lengthTest() {
    // tests method 5 times
    for (int i = 0; i < 5; i++) {
      IntegerSet testSet = new IntegerSet();
      Random rand = new Random();
      test("Length", i + 1);
      // creates randomly sized integer set not to exceed length of 10
      for (int j = rand.nextInt(10) - 1; j >= 0; j--) {
        testSet.add(j);
      }
      printIntegerSet(BEFORE, testSet);
      printOperationResult("length", testSet.length());
    }
  }

  /**
   * Helper function for the equalsTest() function
   *
   * @param testSetA the test IntegerSet A
   * @param testSetB the test IntegerSet B
   */
  public static void equalsSubTest(IntegerSet testSetA, IntegerSet testSetB) {
    // prints integer sets
    printIntegerSet(SETA, testSetA);
    printIntegerSet(SETB, testSetB);
    // performs operation on sets
    printOperationResult("equals", testSetA.equals(testSetB));
  }

  /**
   * tests the IntegerSet.equals() method
   */
  public static void equalsTest() {
    IntegerSet testSetA;
    IntegerSet testSetB;
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

  /**
   * tests the IntegerSet.contains() method
   */
  public static void containsTest() {
    IntegerSet testSet = new IntegerSet();
    Random rand = new Random();
    // populated set contains random integer (true)
    test("Contains", 1);
    // populates set with numbers
    populateSetRandom(testSet, 25);
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
    populateSetRandom(testSet, 25);
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

  /**
   * tests the IntegerSet.largest() method
   */
  public static void largestTest() throws IntegerSetException {
	IntegerSet testSet = new IntegerSet();
    // tests method 3 times
    for (int i = 0; i < 3; i++) {
      test("Largest", i + 1);
      // populates random set
      populateSetRandom(testSet, 7);
      // sorts set to clarify largest number
      testSet.sort();
      printIntegerSet(SET, testSet);
      printOperationResult("largest", testSet.largest());
      testSet.clear();
    }
    test("Largest", 4);
	printIntegerSet(SET, testSet);
	printOperationResult("largest", testSet.largest());
  }

  /**
   * tests the IntegerSet.smallest() method
   */
  public static void smallestTest() throws IntegerSetException {
	IntegerSet testSet = new IntegerSet();
	for (int i = 0; i < 3; i++) {
      test("Smallest", i + 1);
      // populates random set
      populateSetRandom(testSet, 7);
      // sorts set to clarify largest number
      testSet.sort();
      printIntegerSet(SET, testSet);
      printOperationResult("smallest", testSet.smallest());
      testSet.clear();
    }
	test("Smallest", 4);
	printIntegerSet(SET, testSet);
	printOperationResult("smallest", testSet.smallest());
  }

  /**
   * tests the IntegerSet.add() method
   */
  public static void addTest() {
    IntegerSet testSet = new IntegerSet();
    Random rand = new Random();
    int randomInt = rand.nextInt(100);

    // adds to empty list
    test("Add", 1);
    printIntegerSet(BEFORE, testSet);

    // adds random integer
    testSet.add(randomInt);
    printInteger("Test Integer", randomInt);
    printIntegerSet(AFTER, testSet);

    // adds to populated list
    test("Add", 2);
    populateSetRandom(testSet, 7);
    printIntegerSet(BEFORE, testSet);
    // adds random integer
    randomInt = -1;
    testSet.add(randomInt);
    printInteger("Test Integer", randomInt);
    printIntegerSet(AFTER, testSet);

    // attempts to add duplicate to list
    testSet.clear();
    test("Add", 2);
    populateSet(testSet, 7);
    printIntegerSet(BEFORE, testSet);
    // adds duplicate integer
    randomInt = 1;
    testSet.add(randomInt);
    printInteger("Test Integer", randomInt);
    printIntegerSet(AFTER, testSet);
  }

  /**
   * tests the IntegerSet.remove() method
   */
  public static void removeTest() {
    IntegerSet testSet = new IntegerSet();

    // remove from populated set
    test("Remove", 1);
    // populates set
    populateSet(testSet, 7);
    printIntegerSet(BEFORE, testSet);
    // removes 6 from set
    testSet.remove(6);
    printInteger("Test Integer", 6);
    printIntegerSet(AFTER, testSet);

    // remove from empty set
    test("Remove", 2);
    testSet.clear();
    printIntegerSet(BEFORE, testSet);
    // removes 6 from set
    testSet.remove(6);
    printInteger("Test Integer", 6);
    printIntegerSet(AFTER, testSet);


    // remove from set where not present
    test("Remove", 3);
    // populates set
    populateSet(testSet, 7);
    printIntegerSet(BEFORE, testSet);
    // removes 6 from set
    testSet.remove(7);
    printInteger("Test Integer", 7);
    printIntegerSet(AFTER, testSet);

    // remove from one integer set
    test("Remove", 4);
    testSet.clear();
    // populates set
    populateSet(testSet, 1);
    printIntegerSet(BEFORE, testSet);
    // removes 6 from set
    testSet.remove(0);
    printInteger("Test Integer", 0);
    printIntegerSet(AFTER, testSet);
  }

  /**
   * Helper function for the unionTest() function
   *
   * @param testSetA the test IntegerSet A
   * @param testSetB the test IntegerSet B
   */
  public static void unionSubTest(IntegerSet testSetA, IntegerSet testSetB) {
    // prints integer sets
    printIntegerSet(SETA, testSetA);
    printIntegerSet(SETB, testSetB);
    // union of sets
    testSetA.union(testSetB);
    // prints union result
    printIntegerSet(UNION, testSetA);
  }

  /**
   * tests the IntegerSet.union() method
   */
  public static void unionTest() {
    IntegerSet testSetA = new IntegerSet();
    IntegerSet testSetB = new IntegerSet();

    // union of two one integer sets
    test(UNION, 1);
    testSetA.add(1);
    testSetB.add(-1);
    unionSubTest(testSetA, testSetB);

    // union of two random sets of size n
    testSetA.clear();
    testSetB.clear();
    test(UNION, 2);
    populateSetRandom(testSetA, 7);
    populateSetRandom(testSetB, 7);
    unionSubTest(testSetA, testSetB);

    // union of two sets with common integers
    testSetA.clear();
    testSetB.clear();
    test(UNION, 3);
    populateSet(testSetA, 7);
    for (int i = 3; i < 10; i++) testSetB.add(i);
    unionSubTest(testSetA, testSetB);

    // union of populated set with unpopulated set
    testSetA.clear();
    testSetB.clear();
    test(UNION, 4);
    populateSet(testSetA, 7);
    unionSubTest(testSetA, testSetB);

    //union of two empty sets
    testSetA.clear();
    testSetB.clear();
    test(UNION, 5);
    unionSubTest(testSetA, testSetB);
  }

  /**
   * Helper function for the intersectionTest() function
   *
   * @param testSetA the test IntegerSet A
   * @param testSetB the test IntegerSet B
   */
  public static void intersectionSubTest(IntegerSet testSetA, IntegerSet testSetB) {
    // sorts sets for clarity
    testSetA.sort();
    testSetB.sort();
    // prints integer sets
    printIntegerSet(SETA, testSetA);
    printIntegerSet(SETB, testSetB);
    // intersection of sets
    testSetA.intersect(testSetB);
    // prints intersection set
    printIntegerSet(INTERSECTION, testSetA);
  }

  /**
   * tests the IntegerSet.intersect() method
   */
  public static void intersectionTest() {
    IntegerSet testSetA = new IntegerSet();
    IntegerSet testSetB = new IntegerSet();

    // intersection of two one integer sets
    test(INTERSECTION, 1);
    testSetA.add(1);
    testSetB.add(-1);
    intersectionSubTest(testSetA, testSetB);

    // intersection of two random sets of size n
    testSetA.clear();
    testSetB.clear();
    test(INTERSECTION, 2);
    populateSetRandom(testSetA, 25);
    populateSetRandom(testSetB, 25);
    intersectionSubTest(testSetA, testSetB);

    // intersection of two sets with common integers
    testSetA.clear();
    testSetB.clear();
    test(INTERSECTION, 3);
    populateSet(testSetA, 7);
    for (int i = 3; i < 10; i++) testSetB.add(i);
    intersectionSubTest(testSetA, testSetB);

    // intersection of populated set with unpopulated set
    testSetA.clear();
    testSetB.clear();
    test(INTERSECTION, 4);
    populateSet(testSetA, 7);
    intersectionSubTest(testSetA, testSetB);

    // intersection of two empty sets
    testSetA.clear();
    testSetB.clear();
    test(INTERSECTION, 5);
    intersectionSubTest(testSetA, testSetB);
  }

  /**
   * Helper function for the diffTest() function
   *
   * @param testSetA the test IntegerSet A
   * @param testSetB the test IntegerSet B
   */
  public static void diffSubTest(IntegerSet testSetA, IntegerSet testSetB) {
    // sorts sets for clarity
    testSetA.sort();
    testSetB.sort();
    // prints integer sets
    printIntegerSet(SETA, testSetA);
    printIntegerSet(SETB, testSetB);
    // difference of sets
    testSetA.diff(testSetB);
    printIntegerSet(DIFF, testSetA);
  }

  /**
   * tests the IntegerSet.diff() method
   */
  public static void diffTest() {
    IntegerSet testSetA = new IntegerSet();
    IntegerSet testSetB = new IntegerSet();

    // difference of one integer
    test(DIFF, 1);
    testSetA.add(1);
    testSetA.add(-1);
    testSetB.add(-1);
    diffSubTest(testSetA, testSetB);

    // intersection of two random sets of size n
    testSetA.clear();
    testSetB.clear();
    test(DIFF, 2);
    populateSetRandom(testSetA, 25);
    populateSetRandom(testSetB, 25);
    diffSubTest(testSetA, testSetB);

    // intersection of two sets with common integers
    testSetA.clear();
    testSetB.clear();
    test(DIFF, 3);
    populateSet(testSetA, 7);
    for (int i = 3; i < 10; i++) testSetB.add(i);
    diffSubTest(testSetA, testSetB);

    // intersection of populated set with unpopulated set
    testSetA.clear();
    testSetB.clear();
    test(DIFF, 4);
    populateSet(testSetB, 7);
    diffSubTest(testSetA, testSetB);

    // intersection of populated set with unpopulated set
    testSetA.clear();
    testSetB.clear();
    test(DIFF, 5);
    populateSet(testSetA, 7);
    diffSubTest(testSetA, testSetB);

    // intersection of two empty sets
    testSetA.clear();
    testSetB.clear();
    test(DIFF, 6);
    diffSubTest(testSetA, testSetB);

    // intersection of two one integer sets
    testSetA.clear();
    testSetB.clear();
    test(DIFF, 7);
    testSetA.add(1);
    testSetB.add(1);
    diffSubTest(testSetA, testSetB);
  }

  /**
   * tests the IntegerSet.isEmpty() method
   */
  public static void isEmptyTest() {
    IntegerSet testSet = new IntegerSet();

    // empty set
    test("Is Empty", 1);
    printIntegerSet(SET, testSet);
    printOperationResult("isEmpty", testSet.isEmpty());

    // non empty set
    test("Is Empty", 2);
    populateSet(testSet, 7);
    printIntegerSet(SET, testSet);
    printOperationResult("isEmpty", testSet.isEmpty());
  }

  /**
   * tests the IntegerSet.toString() method
   */
  public static void toStringTest() {
    IntegerSet testSet = new IntegerSet();
    test("To String", 1);
    // populates set
    populateSet(testSet, 7);
    System.out.println("Expected: [0, 1, 2, 3, 4 ,5 ,6]");
    printIntegerSet("Result Set: ", testSet);
  }
  
  
  /**
   * The main method.
   *
   * @param args the arguments
   * @throws IntegerSetException the integer set exception
   */
  public static void main(String[] args) throws IntegerSetException {
	// runs all tests
    clearTest();
    lengthTest();
    equalsTest();
    containsTest();
    largestTest();
    smallestTest();
    addTest();
    removeTest();
    unionTest();
    intersectionTest();
    diffTest();
    isEmptyTest();
    toStringTest();
  }
}
