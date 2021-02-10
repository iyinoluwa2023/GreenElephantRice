package org.howard.edu.lsp.assignment2.combination;

import java.util.Vector;

/**
 * The Combination Class.
 */
public class Combination {
	private Vector<Integer> combination;
	/** The sum target. */
	private int sumTarget;
	/** The power set. */
	public Vector<Vector<Integer>> powerSet  =
			new Vector<Vector<Integer>>();
	/** The solution set. */
	public Vector<Vector<Integer>> solutionSet =
			new Vector<Vector<Integer>>();
	/**
	 * Instantiates a new combination.
	 *
	 * @param sum the target sum for the Combination instance
	 * @param nums the original set of numbers for the Combination instance
	 */
	public Combination(
			final int sum, 
			final Vector<Integer> nums) {
		
		sumTarget = sum;
		combination = nums;
		this.calculatePowerSet(nums);
		this.calculateSolutionSet();
	}
	/**
	 * Calculates subset of n length of power set for
	 * the original set.
	 * @param originalSet the original set of numbers for the
	 * class instance
	 * @param comboString empty string where the values of a
	 * given subset are built
	 * @param i recursion call index
	 * @param subsetLength target length of power subset
	 * @param powerSubset final power subset after all operations
	 */
	public static void calculatePowerSubset(
			final Vector<Integer> originalSet,
			String comboString,
			final int i,
			final int subsetLength,
			final Vector<Vector<Integer>> powerSubset) {
		int originalSetLength = originalSet.size();
		// subsetLength being greater than originalSetLength invalid
        if (subsetLength > originalSetLength) {
            return;
        }
        // When combination size is equal to subsetLength
        if (subsetLength == 0) {
        	Vector<Integer> finalCombo = new Vector<Integer>();
        	// converts combination string to Vector of integers
        	comboString = comboString.trim();
            String[] combos = comboString.split(" ");
            for (String term : combos) {
            	finalCombo.add(Integer.parseInt(term));
            }
            // adds final combination to the total power subset
            powerSubset.add(finalCombo);
        }
        // moves on to the next index until the last index is reached
        for (int j = i; j < originalSetLength; j++) {
            // current element added to comboString and function recurs
            calculatePowerSubset(originalSet,
            		comboString + " " + (j),
            		j + 1, 
            		subsetLength - 1,
            		powerSubset);
        }
    }
	/**
	 * Calculates full power set by looping calculatePowerSubset functionality.
	 *
	 * @param originalSet the original set
	 */
	public void calculatePowerSet(final Vector<Integer> originalSet) {
		String comboString = "";
		int i = 0;
		int subsetLength = originalSet.size();
		// loops calculate powerSubset for all possible subset lengths for
		// for a given originalSet length
		for (int j = 1; j < (subsetLength + 1); j++) {
			Vector<Vector<Integer>> powerSubset =
					new Vector<Vector<Integer>>();
			Combination.calculatePowerSubset(originalSet,
					comboString,
					i,
					j,
					powerSubset);
			// adds calculated subset  to Combination instance powerSet
			this.powerSet.addAll(powerSubset);
		}
	}
	/**
	 * Determines which subsets of the power set meet the original
	 * target sum and saves solution set in instance variable.
	 */
	public void calculateSolutionSet() {
		for (Vector<Integer> set : this.powerSet) {
			int sum = 0;
			for (int num : set) {
				sum += this.combination.get(num);
			}
			if (sum == this.sumTarget) {
				this.solutionSet.add(set);
			}
		}
		return;
	}
}
