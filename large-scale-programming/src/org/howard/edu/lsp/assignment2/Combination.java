package org.howard.edu.lsp.assignment2;
import java.util.*;

public class Combination {
	int sumTarget;
	Vector<Integer> possibles;
	
	public Combination(int sum, Vector<Integer> nums) {
		sumTarget = sum;
		possibles = nums;
		
	}
	
	public static void calculatePowerSubset(Vector<Integer> originalSet, String comboString, int i, int subsetLength, Vector<Vector<Integer>> powerSubset)
    {
		int originalSetLength = originalSet.size();
		
		// SubsetLength being greater than originalSetLength should be invalid
        if (subsetLength > originalSetLength) {
            return;
        }
 
        // When combination size is `subsetLength`
        if (subsetLength == 0) {
        	Vector<Integer> finalCombo = new Vector<Integer>();
        	
        	comboString = comboString.trim();
            String[] combos = comboString.split(" ");
            for (String term : combos)
            	finalCombo.add(Integer.parseInt(term));
            	
            powerSubset.add(finalCombo);
            return;
        }
 
        // start from the next index till the last index
        for (int j = i; j < originalSetLength; j++)
        {
            // Current element added to comboString and function recurs
            calculatePowerSubset(originalSet, comboString + " " + (originalSet.get(j)) , j + 1, subsetLength - 1, powerSubset);
 
        }
        
    }
	
	public static void calculatePowerSet() {
		// TODO: Loop calculatePowerSubset while subsetLength < originalSetLength and store full power set in Vector<Vector<Integer>>
		return;
	}
	public static void determineSum() {
		// TODO: Determine sum of each combination in the power set
		return;
	}
	public static void compareSum() {
		// TODO: Determine which members of the power set match the target sum
	}
	
	public static void main(String[] args) {
		
		Vector<Integer> testNums = new Vector<Integer>();
		for (int i = 1; i < 6; i++)
		{
			testNums.add(i);
		}
		
		Combination test = new Combination(5, testNums);
		
		Vector<Vector<Integer>> powerSubsetTest = new Vector<Vector<Integer>>();
		Combination.calculatePowerSubset(testNums, "", 0, 3, powerSubsetTest);
		
		System.out.println(powerSubsetTest);
	}
}
