/*****
Jonathan Murray #3439348
Peer Problem - CircularMemory

Expected output: 4364
*****/

import java.util.*;
import java.io.*;

public class CircularMemory
{
	static int arm = 0; //current angle of arm
	static int result = 0; //current result
	static int memoryIndex = 0;	//current memory index in cells array
	static int memoryValue = 0; //current memory value in cells array

	public static void main(String[] args)
	{
		//File file = new File("test.txt");
		Scanner sc = new Scanner(System.in);

		int numCells = sc.nextInt(); //0 < numCells < 36, assume cells is factor of 360
		int[] cells = new int[numCells]; //holds the values of cells

		//generate values for cells[]
		for (int i=0; i<numCells; i++)
		{
			cells[i] = sc.nextInt();
		}
		memoryValue = cells[0]; //initialize memory value

		int numInstructions = sc.nextInt(); // 0 < numInstructions < 100
		for (int i=0; i<numInstructions; i++)
		{
			String instruction = sc.next().toLowerCase();
			if (instruction.equals("rotate"))
			{
				int rotation = sc.nextInt(); //find rotation value
				rotate(rotation); //rotate arm accordingly
				updateMemoryIndex(numCells); //update memoryIndex
				memoryValue = cells[memoryIndex]; //update memoryValue
			}
			else if (instruction.equals("add"))
				result += memoryValue;
			else if (instruction.equals("subtract"))
				result -= memoryValue;
			else if (instruction.equals("multiply"))
				result *= memoryValue;
			else if (instruction.equals("store"))
			{
				cells[memoryIndex] = result;
				memoryValue = result;
			}
		}

		System.out.println(result); //output result
	}

	//rotate arm, and update memory index/value if necessary
	static void rotate(int rotation)
	{
		arm += rotation%360;

		//arm resets if it goes past 360
		if (arm > 359)
			arm += arm%360;

		//arm resets if it goes past 0
		if (arm < 0)
			arm += arm%360;
	}

	//update memoryIndex to reflect arm angle
	static void updateMemoryIndex(int numCells)
	{
		int size = 360/numCells;
		memoryIndex = (int)Math.floor(arm/size);
	}
}