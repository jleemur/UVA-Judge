import java.util.*;

public class Potholes{
	
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);


		while(sc.hasNextInt()){
			String temp = sc.nextLine();
			String[] tempValues = temp.split(" ");
			int[] values = new int[tempValues.length];
			for(int i =0; i< tempValues.length; i++){
				values[i] = Integer.parseInt(tempValues[i]);
			}

			boolean answer = canJump(values);
			if(answer == true)
				System.out.println("true");
			else{
				System.out.println("false");
			}
		}
	}
 
 	 public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length-1; i++) {
            maxReach = Math.max(maxReach, nums[i] + i);
            if (maxReach <= i) return false;
            if (maxReach >= nums.length-1) return true;
        }
        return true;
    }
}