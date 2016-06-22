/*****
Factorial! You Must Be Kidding (#10323)
Author: Jonathan Murray #3439348
*****/

import java.util.*;
import java.io.*;

class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//File file = new File("test.txt");
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext())
		{
			int num = sc.nextInt(); //assume between 1-6 digits long
			findFactorial(num);
		}
	}

	//factorial > 6,227,020,800: print Overflow!
	//factorial < 10,000: print Underflow!
	//else: print factorial
	//even negative numbers = underflow, odd negative numbers = overflow
	static void findFactorial(int num)
	{	
		//num is negative
		if (num < 0)
		{
			if (num%2 == 0)
				System.out.println("Underflow!");
			else
				System.out.println("Overflow!");
		}
		//num if positive
		else
		{
			long result = 1L;
			for (int i=num; i>0; i--)
			{
				result *= i;
				if (result > 6227020800L)
				{	
					System.out.println("Overflow!");
					break;
				}
			}
			if (result < 10000L)
				System.out.println("Underflow!");
			else if (result <= 6227020800L)
				System.out.println(result);
		}
	}
}
