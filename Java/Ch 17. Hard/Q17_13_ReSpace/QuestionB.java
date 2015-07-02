package Q17_13_ReSpace;

import java.util.HashSet;

import CtCILibrary.AssortedMethods;
public class QuestionB {
	
	public static String bestSplit(HashSet<String> dictionary, String sentence) {
		ParseResult[] memo = new ParseResult[sentence.length()];
		ParseResult r = split(dictionary, sentence, 0, memo);
		return r == null ? null : r.parsed;
	}
	
	public static ParseResult split(HashSet<String> dictionary, String sentence, int start, ParseResult[] memo) {
		if (start >= sentence.length()) {
			return new ParseResult(0, "");
		} if (memo[start] != null) {
			return memo[start];
		}

		int bestInvalid = Integer.MAX_VALUE;
		String bestParsing = null;

		String partial = "";
		int index = start;
		while (index < sentence.length()) {
			char c = sentence.charAt(index);
			partial += c;
			int invalid = dictionary.contains(partial) ? 0 : 
				partial.length();
			if (invalid < bestInvalid) { // Short circuit
				/* Recurse, putting a space after this character. If this
				 * is better than the current best option, replace the best
				 * option. */
				ParseResult result = split(dictionary, sentence, index + 1, memo);
				if (invalid + result.invalid < bestInvalid) { 
					bestInvalid = invalid + result.invalid;
					bestParsing = partial + " " + result.parsed;
					if (bestInvalid == 0) break; // Short circuit
				}
			}
			
			index++;
		}
		memo[start] = new ParseResult(bestInvalid, bestParsing);
		return memo[start];
	}	
	
	public static String clean(String str) {
		char[] punctuation = {',', '"', '!', '.', '\'', '?', ','};
		for (char c : punctuation) {
			str = str.replace(c, ' ');
		}
		return str.replace(" ", "").toLowerCase();
	}
	
	public static void main(String[] args) {
		HashSet<String> dictionary = AssortedMethods.getWordListAsHashSet();
		String sentence = "As one of the topk companies in the world, Google will surely attract the attention of computer gurus. This does not, however, mean the company is for everyone.";
		sentence = clean(sentence);
		System.out.println(sentence);
		//Result v = parse(0, 0, new HashMap<Integer, Result>());
		//System.out.println(v.parsed);
		System.out.println(bestSplit(dictionary, sentence));
	}

}
