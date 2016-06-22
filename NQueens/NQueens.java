import java.util.Scanner;
import java.util.Arrays;

public class NQueens {
	static int solutions = 0;
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);

		System.out.print("How big is the board: ");
		int n = scan.nextInt();

		final long startTime = System.currentTimeMillis(); //start time
		findSolutions(n);

		System.out.print(solutions + " solutions - "); //print solution
		System.out.println(System.currentTimeMillis() - startTime + "ms"); //print time
	}

	static void findSolutions(int N)
	{
		String[][] board = new String[N][N];
		for (String[] col: board)
			Arrays.fill(col, "0");

		//printBoard(board);

		findSolutions(board, 0);

		// for (int n=0; n<Math.floor(N/2); n++)
		// {
		// 	findSolutions(board, 0);
		// }
		// solutions *= 2;

		//odd board length
		// if (N%2 == 1)
		// 	findSolutions(board, 0);
	}

	//broken
	static void findSolutions(String[][] board, int c)
	{
		for (int n=0; n<board.length; n++)
		{
			if ( (board[n][c] == "Q") )
				break;
			else if ( (board[n][c] != "X") )
			{
				String[][] prevBoard = board;
				printBoard(prevBoard);
				board = placeQueen(board, n, c);
				//printBoard(board);
				//printBoard(board);
				findSolutions(board, c+1);
				board = prevBoard;
				printBoard(board);
			}
			else if (c == board.length && board[n][c] == "0")
				solutions++;
		}
	}


	//arg: pass in current board with the placement of the queen (row, col)
	//returns: modified board with X's
	static String[][] placeQueen(String[][] board, int r, int c)
	{
		board[r][c] = "Q";
		//horizontal
		if (c+1 < board.length)
		{	
			for (int i=c+1; i<board.length; i++)
				board[r][i] = "X";
		}
		//diagonal (up-right)
		for (int i=-1; Math.abs(i)<board.length; i--)
		{
			if ( (r+i >= 0) && ((c-i) < board.length-1) )
				board[r+i][c-i] = "X";
		}
		//diagonal (down-right)
		for (int i=1; i<board.length; i++)
		{
			if ( (r+i < board.length) && (c+i < board.length) )
				board[r+i][c+i] = "X";
		}

		return board;
	}

	//TESTING
	static void printBoard(String[][] board)
	{
		for (int r=0; r<board.length; r++)
		{
			for (int c=0; c<board.length; c++)
				System.out.print(board[r][c] + " ");
			System.out.println();
		}
		System.out.println();
	}
}