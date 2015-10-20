package preprocess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Builder {
	public Map<String, List<Integer>> sortedFormToWords;
	
	public Set<String> buildSortedDict(List<String> original_dict) {
		Set<String> sortedDict = new HashSet<>();
		// TODO
		for (int i = 0; i < original_dict.size(); i++) {
			String word = original_dict.get(i);
			String sortedForm = sortLetters(word.toCharArray());;		// 
			sortedDict.add(sortedForm);
			if (sortedFormToWords.keySet().contains(sortedForm)) {
				List<Integer> indices = sortedFormToWords.get(sortedForm);
				indices.add(i);
			} else {
				List<Integer> indices = new ArrayList<>();
				indices.add(i);
				sortedFormToWords.put(sortedForm, indices);
			}
		}
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
}
