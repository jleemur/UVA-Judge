//Marcus #10452
//Jonathan Murray 3439348

import java.io.*;
import java.util.*;

class Main
{
	public static void main(String[] args)
	{
		//File file = new File("test.txt");
		Scanner scan  = new Scanner(System.in);

		int num = scan.nextInt();
		for (int n=0; n<num; n++)
		{
			int rows = scan.nextInt();
			int cols = scan.nextInt();

			String[][] maze = new String[rows][cols];
			for (int i=0; i<rows; i++) {
				String line = scan.next();
				for (int j=0; j<cols; j++) {
					maze[i][j] = String.valueOf(line.charAt(j));
					//System.out.print(maze[i][j] + " ");
				}
				//System.out.println();
			}
			solveMaze(maze, rows, cols);
			System.out.println();
		}
	}

	//prints out maze solution (forth, left, right)
	static void solveMaze(String[][] maze, int rows, int cols)
	{
		String solution = "@IEHOVA#";
		int row = rows-1;
		int col = 0;

		//find #
		for (int i=0; i<cols; i++)
		{
			if (maze[row][i].equals(String.valueOf(solution.charAt(0)))) {
				col = i;
				break;
			}
		}	

		//follow maze with solution (might not like space after last command)
		for (int i=1; i<solution.length(); i++)
		{
			//formatting
			if (i != 1)
				System.out.print(" ");

			if (col != cols-1)
			{
				if (maze[row][col+1].equals(String.valueOf(solution.charAt(i)))) {
					col += 1;
					System.out.print("right");
					continue;
				}
			}
			if (col != 0)
			{
				if(maze[row][col-1].equals(String.valueOf(solution.charAt(i)))) {
					col -= 1;
					System.out.print("left");
					continue;
				}
			}
			if (row != 0)
			{
				if (maze[row-1][col].equals(String.valueOf(solution.charAt(i)))) {
					row -= 1;
					System.out.print("forth");
					continue;
				}
			}
			System.out.println("IMPOSSIBLE");
			break;
		}
	}
}