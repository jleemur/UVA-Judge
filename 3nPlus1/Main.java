//The 3n+1 Problem ... Week 1
//Jonathan Murray - 3439348

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line; 

		while ( (line = reader.readLine()) != null )
		{
			String[] tokens = line.split("\\s+");

			if ( (tokens.length == 2) &&
					(Integer.parseInt(tokens[0]) <= 1000000) &&
					(Integer.parseInt(tokens[0]) >= 0) &&
					(Integer.parseInt(tokens[1]) <= 1000000) &&
					(Integer.parseInt(tokens[1]) >= 0) && 
					(Integer.parseInt(tokens[0]) <= Integer.parseInt(tokens[1])) )
			{	
				int maxCycleLength = findMaximumCycleLength(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
				System.out.println(tokens[0] + " " + tokens[1] + " " + maxCycleLength);
			}
		}
	}

	static int findMaximumCycleLength(int n1, int n2)
	{
		int maxCycleLength = 0;
		int currentCycleLength;

		while (n1 <= n2)
		{
			int currentNum = n1;
			currentCycleLength = 1;

			while (currentNum != 1)
			{
				if (currentNum%2 == 0)
					currentNum /= 2;
				else
					currentNum = currentNum*3 + 1;
				currentCycleLength++;
			}
			if (currentCycleLength > maxCycleLength)
				maxCycleLength = currentCycleLength;

			n1++;
		}

		return maxCycleLength;
	}
}