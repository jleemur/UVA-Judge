public class Solution
{
	public static void main(String[] args)
	{
		int[] test1 = {0, 5, 1};
		int[] test2 = {1, 1, 3, 1, 0, 2};
		int[] test3 = {1, 1, 1, 0};

		System.out.println(canJump(test1));
		System.out.println(canJump(test2));
		System.out.println(canJump(test3));
	}


	static boolean canJump(int[] A) {
	    if(A.length <= 1)
	        return true;
	 
	    int max = A[0]; //max stands for the largest index that can be reached.
	 
	    for(int i=0; i<A.length; i++){
	        //if not enough to go to next
	        if(max <= i && A[i] == 0) 
	            return false;
	 
	        //update max    
	        if(i + A[i] > max){
	            max = i + A[i];
	        }
	 
	        //max is enough to reach the end
	        if(max >= A.length-1) 
	            return true;
	    }
 
    	return false;    
	}
}