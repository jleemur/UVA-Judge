/*****
Jonathan Murray #3439348
Peer Problem - Name Changes

Expected output:
Smithey: 2
Cornye: 3
*****/

import java.util.*;
import java.io.*;

public class NameChanges
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//File file = new File("test.txt");
		Scanner sc = new Scanner(System.in);
		String name;

		while ( !(name = sc.next().toLowerCase()).equals("end") )
		{	
			String minName = ""; //name with smallest distance
			int minDistance = Integer.MAX_VALUE; //smallest distance
			for (int i=0; i<3; i++)
			{
				String newName = sc.next().toLowerCase(); //possible name change
				int distance; //current name distance
				//first case
				if (i == 0) 
				{
					distance = nameDistance(name,newName);
					minDistance = distance;
					minName = newName;
				}
				//keep smallest distance and the corresponding name
				else if (minDistance > (distance = nameDistance(name, newName)))
				{
					minDistance = distance;
					minName = newName;
				}
			}

			System.out.println(minName + ": " + minDistance); //output result
		}
	}

	//count the number of insertions:1/deletions:1/substitutions:2 to change names
	//arg1: original name, arg2: new name
	static int nameDistance(String name, String newName)
	{
		int[][] minEditDistance = new int[name.length()+1][newName.length()+1]; //create min edit distance table

		//fill name with base insertion case: 0 to name.length
		for (int r=0; r<=name.length(); r++)
			minEditDistance[r][0] = r;

		//fill newName with base insertion cases: 0 to newName.length
		for (int c=0; c<=newName.length(); c++)
			minEditDistance[0][c] = c;

		//iterate through name rows
		for (int r=1; r<=name.length(); r++) {
			//iterate through new name columns
			for (int c=1; c<=newName.length(); c++) {
				// if names have same letter, value = upper-left index + 0 (no cost)
				if ( String.valueOf(name.charAt(r-1)).equals(String.valueOf(newName.charAt(c-1))) )
					minEditDistance[r][c] = minEditDistance[r-1][c-1];
				// if names have different letter, value = smallest adjacent index + 1 (cost of 1)
				else
					minEditDistance[r][c] = (minEditDistance[r-1][c] < minEditDistance[r][c-1]) 
												? minEditDistance[r-1][c] + 1 : minEditDistance[r][c-1] + 1;
			}
		}

		//return value of final table index
		return minEditDistance[name.length()][newName.length()];
	}
}