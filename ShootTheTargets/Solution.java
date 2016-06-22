import java.util.ArrayList;

public class Solution {

	public static void main(String[] args)
	{
		int[] test1 = {2, 3, 4, 5};
		int[] test2 = {3, 1, 5, 8};
		int[] test3 = {4, 5, 6, 7, 6, 5, 4};

		System.out.println(maxCoins(test1));
		System.out.println(maxCoins(test2));
		System.out.println(maxCoins(test3));
	}

	static int maxCoins(int[] iNums) {
	    int[] nums = new int[iNums.length + 2];
	    int n = 1;
	    for (int x : iNums) if (x > 0) nums[n++] = x;
	    nums[0] = nums[n++] = 1;


	    int[][] memo = new int[n][n];
	    return burst(memo, nums, 0, n - 1);
	}

	static int burst(int[][] memo, int[] nums, int left, int right) {
	    if (left + 1 == right) return 0;
	    if (memo[left][right] > 0) return memo[left][right];
	    int ans = 0;
	    for (int i = left + 1; i < right; ++i)
	        ans = Math.max(ans, nums[left] * nums[i] * nums[right] 
	        + burst(memo, nums, left, i) + burst(memo, nums, i, right));
	    memo[left][right] = ans;
	    return ans;
	}
}