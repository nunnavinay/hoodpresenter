package com.vinpoc.hoodpresenter.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CommonUtil {

	/**
	 * Utility to derive the combinations from the provided Integers list that sums
	 * up to the expected capacity.
	 * 
	 * @param arr
	 * @param sum
	 * @return
	 */
	public static List<List<Integer>> getPresentsCombinations(List<Integer> weights, int capacity) {
		List<List<Integer>> results = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();

		// Removing duplicate values from the weights
		Set<Integer> set = new HashSet<>(weights);
		weights.clear();
		weights.addAll(set);
		Collections.sort(weights);

		findNumbers(results, weights, capacity, 0, temp);
		return results;
	}

	private static void findNumbers(List<List<Integer>> results, List<Integer> arr, int capacity, int index,
			List<Integer> temp) {

		if (capacity == 0) {
			results.add(new ArrayList<>(temp));
			return;
		}

		for (int i = index; i < arr.size(); i++) {
			// checking that sum does not become negative
			if ((capacity - arr.get(i)) >= 0) {
				// adding element which can contribute to capacity
				temp.add(arr.get(i));
				findNumbers(results, arr, capacity - arr.get(i), i, temp);
				// removing element from list (backtracking)
				temp.remove(arr.get(i));
			}
		}
	}

	/**
	 * Get list with mimimum elements
	 * 
	 * @param results
	 * @return
	 */
	public static List<Integer> getMinimizedList(List<List<Integer>> results) {

		List<Integer> minimumElemList =  results.stream().min(Comparator.comparingInt(List::size)).orElse(new ArrayList<>());
		return minimumElemList;

	}

}
