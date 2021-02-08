package org.howard.edu.lsp.assignment2.test;

import java.util.Random;
import java.util.Vector;
import org.howard.edu.lsp.assignment2.combination.Combination;

public class Main {
	
	/**
	 * Test case.
	 *
	 * @param testSetLength the test set length
	 * @param testSum the test target sum
	 */
	public static void testCase(int testSetLength, int testSum) {
		Vector<Integer> testSet = new Vector<Integer>();
		for (int i = 1; i < testSetLength + 1; i++) {
			testSet.add(i);
		}
		
		// prints test case results to console
		System.out.println("----------------------------------------------");
		System.out.println("Original Set: " + testSet);
		Combination test = new Combination(testSum, testSet);
		System.out.println("\nTotal Combinations:");
		for (Vector<Integer> combo : test.powerSet) {
			System.out.println(combo);
		}
		System.out.println("\nSolution Combinations for sum of " + testSum + ":");
		for (Vector<Integer> combo : test.solutionSet) {
			System.out.println(combo);
		}
		System.out.println("\n");
		
	}
	public static void main(final String[] args) {
		// random test cases
		Random rand = new Random();
		testCase(rand.nextInt(8), rand.nextInt(20));
		testCase(rand.nextInt(8), rand.nextInt(20));
		testCase(rand.nextInt(8), rand.nextInt(20));
		// controlled test cases
		testCase(8, 20);
		testCase(5, 15);
		testCase(3, 4);
	}
}
