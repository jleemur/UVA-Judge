/***
Let me Count The Ways #10219
Jonathan Murray - 3439348 
***/

import java.util.*;
import java.io.*;
// import java.math.BigInteger;

class Main {

	public static void main(String[] args) throws IOException
	{
		// File file = new File("test.txt");
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext())
		{
			int n = sc.nextInt();
			int r = sc.nextInt();

			System.out.println(countCombinations(n, r));
		}
	}


	static int countCombinations(int n, int r)
	{
	    double num = 0, den = 0;
	    int digits = 0;

	    if ((n - r) < r) 
	    	r = n - r;
	    
	    for (int i=1; i<=r; i++)
	    {
	        num += Math.log10(n - r + i );
	        den += Math.log10(i);
	    }
	    
	    //formula for counting digits: floor[log10(number)] + 1
	    digits = (int)(Math.floor(num-den+1e-9)+1);

	    return digits;
	}
}