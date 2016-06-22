//Flip Sort #10327
//Jonathan Murray - 3439348


import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args)
	{
		//File file = new File("test.txt");
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext())
		{
			int length = sc.nextInt();
			int[] numArr = new int[length];

			//populate the array
			for (int i=0; i<length; i++)
			{
				numArr[i] = sc.nextInt();
			}

			findMinExchangeOperations(numArr);
		}
	}

	//count inversions through the whole array
	static void findMinExchangeOperations(int[] numArr)
	{
		int result = 0;
		for (int i=0; i<numArr.length; i++)
		{
			for (int j=i+1; j<numArr.length; j++)
			{	
				if (numArr[i] > numArr[j])
					result++;
			}
		}

		System.out.println("Minimum exchange operations : " + result);
	}
}