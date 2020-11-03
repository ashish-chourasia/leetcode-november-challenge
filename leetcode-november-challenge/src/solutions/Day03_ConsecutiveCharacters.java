package solutions;

public class Day03_ConsecutiveCharacters {
	public static int maxPower(String s) {
		int n = s.length();
		if (n <= 1) {
			return n;
		}
		int overAllMax = 1;
		int maxSoFar = 1;
		for (int i = 1; i < n; i++) {
			if (s.charAt(i) != s.charAt(i - 1)) {
				maxSoFar = 1;
			} else {
				maxSoFar++;
			}
			overAllMax = Math.max(overAllMax, maxSoFar);
		}
		return overAllMax;
	}

	public static void main(String[] args) {
		String s = "abbcccddddeeeeedcba";
		System.out.println(maxPower(s));
	}

}
