package preprocess;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
	
	public static List<String>  readDict(String fname) throws IOException {
		System.out.println("Loading dictionary...");
		List<String> original_dict = new ArrayList<String>();
		BufferedReader br = new BufferedReader(new FileReader(fname));
		String line;
		while ((line = br.readLine()) != null) {
			original_dict.add(line);
		}
		br.close();
		System.out.println("dictionary loaded");
		return original_dict;
	}
}
