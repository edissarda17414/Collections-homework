package bigram;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Bigram {

	public static void main(String[] args) {
		
		//prvi deo zadatka
		
		String s = "abbcceeeeeeabcc";
		Map<String, Integer> map = new HashMap<>();
		
		for (int i = 0; i < s.length() - 1; i++) {
			String bigram = s.substring(i, i+2);
			
			if (map.containsKey(bigram)) {
				map.put(bigram, map.get(bigram) + 1);
			} else {
				map.put(bigram, 1);
			}
		}
		
		Iterator iter = map.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry<String, Integer> entry = (Entry<String, Integer>) iter.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
		
		// drugi deo zadatka
		
		String predvidi = "ja";
		
		for (int i = 0; i < 3; i++) {
			int najvecaFrekvencija = 0;
			String bigramSaNajvecomFrekvencijom = "";
			
			for (Map.Entry<String, Integer> e : map.entrySet()) {
				if (e.getKey().startsWith(predvidi.substring(predvidi.length()-1))) {
					if (najvecaFrekvencija < e.getValue()) {
						najvecaFrekvencija = e.getValue();
						bigramSaNajvecomFrekvencijom = e.getKey();
					}
				}
			}
			
			if (najvecaFrekvencija > 0) {
				char narednoSlovo = bigramSaNajvecomFrekvencijom.charAt(1);
				predvidi = predvidi + "" + narednoSlovo;
			}
			
		}
		
		System.out.println(predvidi);

	}

}
