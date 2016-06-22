import java.util.*;

public class ShootTargets{

	public static int score =0;
	
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()){
			String temp = sc.nextLine();
			String[] tempValues = temp.split("\\s*");
			int[] nums = new int[tempValues.length];
			for(int i =0; i< tempValues.length; i++){
				nums[i] = Integer.parseInt(tempValues[i]);
				i++;

			}
			score = maxPoints(nums);
			System.out.println(score);
			score =0;
		}	
	}

	static int maxPoints(int[] nums) {
    // Extend list with head and tail (both are 1), index starts at 1
    int array[] = new int[nums.length + 2];
    array[0] = 1;
    array[array.length-1] = 1;
    for (int i = 0; i < nums.length; i++) {
        array[i+1] = nums[i];
    }

    // Initialize DP arrays, 1 index based
    int dp[][] = new int[array.length][array.length]; //dp[i][j] stands for max coins at i step, burst j
    for (int i =0; i < array.length; i++) {
        for (int j = 0; j < array.length; j++) {
            dp[i][j] = 0;
        }
    }

    for (int i=1; i< array.length-1; i++) {
        for (int j=i; j >=1; j--) {
            // k as last
            for (int k=j; k <= i; k++) {
                dp[j][i] = Math.max(array[j-1]*array[k]*array[i+1] + dp[j][k-1] + dp[k+1][i], dp[j][i]);
            }
        }
    }

    return dp[1][array.length-2];
	}
		
}