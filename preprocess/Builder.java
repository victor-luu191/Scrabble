package preprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Builder {
	public Map<String, List<Integer>> sortedFormToWordIndex;
	
	public Builder() {
		sortedFormToWordIndex = new HashMap<>();
	}
	
	public Set<String> buildSortedDict(List<String> original_dict) {
		
		System.out.println("Building the dict of sorted forms...");
		Set<String> sortedDict = new HashSet<>();
		for (int i = 0; i < original_dict.size(); i++) {
			String word = original_dict.get(i);
			String sortedForm = sortLetters(word.toCharArray());;		// 
			sortedDict.add(sortedForm);
			if (sortedFormToWordIndex.keySet().contains(sortedForm)) {
				List<Integer> indices = sortedFormToWordIndex.get(sortedForm);
				indices.add(i);
			} else {
				List<Integer> indices = new ArrayList<>();
				indices.add(i);
				sortedFormToWordIndex.put(sortedForm, indices);
			}
		}
		System.out.println("Done. The number of sorted forms is " + sortedDict.size());
		return sortedDict;
	}
//	sort a group of letters (either from player or from a word in dict) in alphabet order
	private String sortLetters(char[] letters) {
		Arrays.sort(letters);
		String sorted_form = "";
		for (int i = 0; i < letters.length; i++) {
			sorted_form += letters[i];
		}
		return sorted_form;
	}
	
	public Set<String> wordsCreatedBy(char[] letters, List<String> original_dict)  {
		
		String sorted_form = sortLetters(letters);
		try {
			return toWords(sorted_form, original_dict);
		} catch (CannotFormWordException e) {
			System.err.println(e.getMessage());
			return new HashSet<>();
		}
		
	}

	private Set<String> toWords(String sorted_form, List<String> original_dict)
			throws CannotFormWordException {
		
		List<Integer> indices = sortedFormToWordIndex.get(sorted_form);
		if (indices != null) {
			Set<String> created_words = new HashSet<>();
			for (Integer idx : indices) {
				created_words.add(original_dict.get(idx));
			}
			return created_words;
		} else {
			String msg = "no English word can be formed by the letters " + 
							Arrays.toString(sorted_form.toCharArray()) ;
			
			throw new CannotFormWordException(msg);
		}
	}
	/**
	 * Find all sorted subgroups of {@code letters} and check which one forms valid word(s)
	 * Suppose |letters| = n, then
	 * such a subgroup corresponds to a sequence of n binary digits, 
	 * with 1s at letters in the subgroup and 0s at letters outside the subgroup
	 * Hence the sequence can be mapped a number in base 2 whose values fall within range [1, 2^n - 1]
	 * Example: 
	 * positions	{1, 2, 3}
	 * for letters 	{T, O, P}, subgroups will map like this: 
	 * {T} <-> 100, {O} <-> 010, {P} <-> 001, {TO} <-> 110
	 * Note that all sequence must have full length n, otherwise we get wrong results 
	 * (e.g. 1 will map to T instead of P)   
	 * 
	 * @param letters
	 * @param original_dict
	 * @return
	 */
	public Set<String> allPossibleWords(char[] letters, List<String> original_dict) {
		Set<String> possible_words = new HashSet<>();
		int n = letters.length;
		double max = Math.pow(2, n) - 1;
		for (int number = 1; number <= max; number++) {
			String bin_rep = toBinary(number, n);
			char[] digits = bin_rep.toCharArray();
			// positions of 1's tell us which letters are selected
			String selected = "";
			for (int i = 0; i < digits.length; i++) {
				if (digits[i] == '1') {
					selected += letters[i];
				}
			}
			// exclude trivial subgroups with only 1,2 letters
			if (selected.length() > 2) {
				char[] selected_letters = selected.toCharArray();
				String sorted_form = sortLetters( selected_letters );
				try {
					Set<String> words = toWords(sorted_form, original_dict);
					possible_words.addAll(words);
				} catch (CannotFormWordException e) {
					System.err.println(e.getMessage());
//					e.printStackTrace();
				}
			}
		}
		
		return possible_words;
	}

	private String toBinary(int number, int full_length) {
		// Careful: built-in toBinaryString() does NOT auto add leading 0's to reach full_length
		// Thus, we have to do that manually
		String bin_rep = Integer.toBinaryString(number);
		if (bin_rep.length() < full_length) {
			int numZeros = full_length - bin_rep.length();
			for (int i = 0; i < numZeros; i++) {
				bin_rep = "0" + bin_rep;
			}
		}
		
		return bin_rep;
	}
}
