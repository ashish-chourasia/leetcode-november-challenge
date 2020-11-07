package solutions;

public class Day06_FindTheSmallestDivisor {

	public static int smallestDivisor(int[] A, int threshold) {
		int left = 1, right = (int) 1e6;
		while (left < right) {
			int m = (left + right) / 2, sum = 0;
			for (int i : A)
				sum += (i + m - 1) / m;
			if (sum > threshold)
				left = m + 1;
			else
				right = m;
		}
		return left;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 5, 9 };
		int threshold = 6;
		System.out.println(smallestDivisor(nums, threshold));
	}

	/*
	 * Input: nums = [1,2,5,9], threshold = 6 
	 * Output: 5 
	 * Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
	 * If the divisor is 4 we can get a sum to 7 (1+1+2+3) and 
	 * if the divisor is 5 the sum will be 5 (1+1+1+2).
	 */

}
