package solutions;

import java.util.Arrays;

public class Day08_TwoSumLessThanK {

	// O(n^2) approach
	public static int twoSumLessThanK(int[] A, int K) {
		int max = -1;
		for (int i = 0; i < A.length; i++) {
			for (int j = i + 1; j < A.length; j++) {
				int sum = A[i] + A[j];
				if (sum > max && K > sum) {
					max = sum;
				}
			}
		}
		return max;
	}

	// O(n log n) approach
	 public static int twoSumLessThanKOptimized(int[] A, int k) {
	        Arrays.sort(A);
	        
	        int lo = 0;
	        int hi = A.length-1;
	        
	        int max = -1;
	        int sum = 0;
	        
	        while (lo < hi) {
	            sum = A[lo] + A[hi];
	            if (sum > max) {
	                if (k > sum) {
	                    max = sum;
	                }
	                // Sum is greater than k, move hi to left to decrease sum
	                else {
	                    hi--;
	                }
	            }
	            // Sum is smaller than max, move lo to right to increase sum
	            else {
	                lo++;
	            }
	        }
	        return max;
	    }
	public static void main(String[] args) {
		int[] A = {34,23,1,24,75,33,54,8};
		int K = 60;
		System.out.println(twoSumLessThanK(A, K));
	}

}
