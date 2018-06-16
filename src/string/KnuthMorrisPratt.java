package string;

/**
 * Complexity O(n+m) where n is the length of the text to be searched and m is
 * the lengh of the pattern to be searched in text.
 * 
 * @author Ankit Pandoh
 *
 */
public class KnuthMorrisPratt {
	public static void main(String[] args) {
		String text = "abacadabrabracabracadabrabrabracad";
		String pattern = "abracadabra";
		KnuthMorrisPratt kmp = new KnuthMorrisPratt();
		System.out.println("Pattern Exist : " + kmp.search(text.toCharArray(), pattern.toCharArray()));
	}

	private boolean search(char[] text, char[] pattern) {
		int[] pmt = getPartialMatchTable(pattern);
		int i = 0;
		int j = 0;
		while (i < text.length && j < pattern.length) {
			if (text[i] == pattern[j]) {
				i++;
				j++;
			} else {
				if (j != 0) {
					j = pmt[j - 1];
				} else {
					i++;
				}
			}
		}
		if (j == pattern.length) {
			return true;
		}
		return false;
	}

	private int[] getPartialMatchTable(char[] pattern) {
		int[] pmt = new int[pattern.length];
		int i = 0;
		for (int j = 1; j < pattern.length;) {
			if (pattern[j] == pattern[i]) {
				pmt[j] = i + 1;
				i++;
				j++;
			} else {
				if (i != 0) {
					i = pmt[i - 1];
				} else {
					j++;
				}
			}
		}
		return pmt;
	}
}
