package DataStructure.CS.Algorithm;

/**
 * Let S denotes source Let P denotes pattern when the i in S and j in P
 * mismatch ,which index in P should compare with i in S st. P0P1...Pk-1 ==
 * Pj-kPj-k+1...Pj-1 -----------------[1]
 * 
 * next[j] = -1 when j == 0 max(k,st[1]) 0 others
 * 
 * @author mingchen
 * @date 2015年8月21日
 */
public class StringMatch {

	/**
	 * this is the traditional method for pattern match
	 * 
	 * @param source
	 *            source string
	 * @param pattern
	 *            pattern string to match on source
	 * @param start
	 *            the start point on source string
	 * @return int
	 * 
	 *         2015年8月21日
	 */
	public static int indexOf(String source, String pattern, int start) {
		int i = start, j = 0;
		// check whether the input parameter is legal
		if (source.length() < 1 || pattern.length() < 1 || start < 0) {
			return -1;
		}
		// matching
		while (i < source.length() && j < pattern.length()) {
			if (source.charAt(i) == pattern.charAt(j)) {
				++i;
				++j;
			} else {
				i = i - j + 1;
			}
		}
		// return the position of pattern , if not -1 instead
		return j == pattern.length() ? i - j : -1;
	}

	/**
	 * The implementation of KMP method for pattern match
	 * 
	 * @param source
	 *            source string
	 * @param pattern
	 *            pattern string to match on source string
	 * @param start
	 *            position to begin to match on source string
	 * @return int 2015年8月21日
	 */
	public static int KMPMatch(String source, String pattern, int start) {
		int[] next = getNext(pattern);
		int i = start, j = 0;
		while (i < source.length() && j < pattern.length()) {
			if (j == -1 || source.charAt(i) == pattern.charAt(j)) {
				++i;
				++j;
			} else {
				j = next[j];
			}
		}
		return j == pattern.length() ? i - j : -1;
	}

	/**
	 * Get the next array for running KMP
	 * 
	 * @param pattern
	 *            the pattern string
	 * @return int[] next array int
	 * 
	 *         2015年8月21日
	 */
	private static int[] getNext(String pattern) {
		if (pattern.length() < 1) {
			throw new IllegalArgumentException("The string can not be null");
		}
		int[] next = new int[pattern.length()];
		next[0] = -1;
		int i = 0, j = -1;
		while (i != pattern.length() - 1) {
			if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
				++i;
				++j;
				next[i] = j;
			} else {
				j = next[j];
			}
		}
		return next;
	}

	/**
	 * The low-efficiency implement of getNext
	 * 
	 * @param pattern
	 *            pattern string
	 * @return int[]
	 * 
	 *         2015年8月21日
	 */
	private static int[] getNextLow(String pattern) {
		if (pattern.length() < 1) {
			throw new IllegalArgumentException("The string can not be null");
		}
		int[] next = new int[pattern.length()];
		next[0] = -1;
		int i = 1, j = 0;
		while (i != pattern.length() - 1) {
			int step = 0;
			while (pattern.substring(0, step) == pattern.substring(i - step, i)) {
				step++;
			}
			next[i] = step;
		}
		return next;
	}
}
