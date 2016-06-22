import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	private static int[] road;
	public static void main(String[] args) throws IOException{
		final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String sCurrentLine = reader.readLine();
		 while (!sCurrentLine.isEmpty()) {
		 	sCurrentLine = sCurrentLine.replace("[", "").replace(",", "").replace("]", "");
		 	String[] nums = sCurrentLine.split("\\s+");
		 	road = new int[nums.length];
      		for(int i =0; i<nums.length;i++){
      			road[i] = Integer.parseInt(nums[i]);
      		}
      		boolean foundroute = findRoute(0);
      		if(foundroute)
      			System.out.println("true");
      		else
      			System.out.println("false");
			
			sCurrentLine = reader.readLine();
		}
	    
	}

	public static boolean findRoute(int position){
		boolean gotHome = false;
		//System.out.println(position);
		if(position >= road.length || gotHome)
			return true;
		for(int i = road[position]; i>0;i--){
			gotHome = findRoute(i + position);
			if(gotHome)
				return true;
		}
     	return false;
  	}

	
}