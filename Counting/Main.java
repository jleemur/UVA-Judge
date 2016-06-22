/*****
Counting (#10198)
Author: Jonathan Murray #3439348
*****/

import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//File file = new File("test.txt");
		Scanner sc = new Scanner(System.in);

		while(sc.hasNext())
		{
			int num = sc.nextInt();	//between 1-1000, inclusive
			System.out.println(gustavoCounting(num));
		}
	}

	//count different ways to make numbers by using 1, 2, 3, 4(=1)
	//e.g. 2 = (1+1), (1+4), (4+1), (4+4), (2)
	static BigInteger gustavoCounting(int num)
	{
		BigInteger[] count = new BigInteger[num+3]; //+3 for ArrayOutOfBoundException
		count[0] = BigInteger.valueOf(1);	//0
		count[1] = BigInteger.valueOf(2);	//1
		count[2] = BigInteger.valueOf(5);	//2
		count[3] = BigInteger.valueOf(13);	//3

		//every increment has the same equation. 2*(index-1) + index-2 + index-3
		for (int i=4; i<=num; i++)
		{	
			count[i] = count[i-1].multiply(BigInteger.valueOf(2));
			count[i] = count[i].add(count[i-2]);
			count[i] = count[i].add(count[i-3]);
		}

		return count[num];
	}
}



