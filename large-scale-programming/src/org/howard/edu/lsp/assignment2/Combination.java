package org.howard.edu.lsp.assignment2;

import java.util.Vector;

/**
 * The Class Combination.
 */
public class Combination {
	/** The sum target. */
	private int sumTarget;
	/** The power set. */
	private Vector<Vector<Integer>> powerSet  =
			new Vector<Vector<Integer>>();
	/** The solution set. */
	private Vector<Vector<Integer>> solutionSet =
			new Vector<Vector<Integer>>();
	/**
	 * Instantiates a new combination.
	 *
	 * @param sum the sum
	 * @param nums the nums
	 */
	public Combination(final int sum, final Vector<Integer> nums) {
		sumTarget = sum;
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
		// SubsetLength being greater than originalSetLength
		// should be invalid
        if (subsetLength > originalSetLength) {
            return;
        }
        // When combination size is `subsetLength`
        if (subsetLength == 0) {
        	Vector<Integer> finalCombo = new Vector<Integer>();
        	comboString = comboString.trim();
            String[] combos = comboString.split(" ");
            for (String term : combos) {
            	finalCombo.add(Integer.parseInt(term));
            }
            powerSubset.add(finalCombo);
            return;
        }
        // start from the next index till the last index
        for (int j = i; j < originalSetLength; j++) {
            // Current element added to comboString and function recurs
            calculatePowerSubset(originalSet,
            		comboString + " " + (originalSet.get(j)),
            		j + 1, subsetLength - 1,
            		powerSubset);
        }
    }
	/**
	 * Calculates full power set.
	 *
	 * @param originalSet the original set
	 */
	public void calculatePowerSet(final Vector<Integer> originalSet) {
		String comboString = "";
		int i = 0;
		int subsetLength = originalSet.size();
		for (int j = 1; j < (subsetLength + 1); j++) {
			Vector<Vector<Integer>> powerSubset =
					new Vector<Vector<Integer>>();
			Combination.calculatePowerSubset(originalSet,
					comboString,
					i,
					j,
					powerSubset);
			this.powerSet.addAll(powerSubset);
		}
	}
	/**
	 * Determines which subsets of the power set meet the original
	 * target sum and saves solution set in instance variable.
	 */
	public void calculateSolutionSet() {
		for (Vector<Integer> set : this.powerSet) {
			int setSum = 0;
			for (int num : set) {
				setSum += num;
			}
			if (setSum == this.sumTarget) {
				this.solutionSet.add(set);
			} else {
				continue;
			}
		}
	}
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(final String[] args) {
		Vector<Integer> testNums = new Vector<Integer>();
		for (int i = 1; i < 7; i++) {
			testNums.add(i);
		}
		final int TEST_SUM = 10;
		Combination test = new Combination(TEST_SUM, testNums);
		System.out.println("Power Set:");
		for (Vector<Integer> combo : test.powerSet) {
			System.out.println(combo);
		}
		System.out.println("\nSolution Set:");
		for (Vector<Integer> combo : test.solutionSet) {
			System.out.println(combo);
		}
	}
}
