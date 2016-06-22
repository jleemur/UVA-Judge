//Word-Search Wonder #422
//Jonathan Murray - 3439348

import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException
	{
		//File file = new File("test.txt");
		Scanner sc = new Scanner(System.in);
		int matrixSize = sc.nextInt();
		String[][] matrix = new String[matrixSize][matrixSize];

		for (int r=0; r<matrixSize; r++)
		{
			String element = sc.next();
			for (int c=0; c<element.length(); c++)
			{
				matrix[r][c] = String.valueOf(element.charAt(c));
			}
		}

		String word;
		while ( !(word = sc.next()).equals("0") )
		{
			System.out.println(findWordInMatrix(matrix, word));
		}
	}

	// If first character in word matches the current character of matrix, check all 
	// acceptable directions for the word. If you find it, print coordinates.
	static String findWordInMatrix(String[][] matrix, String word)
	{
		String result = "";
		int wordLength = word.length();

		for (int r=0; r<matrix.length; r++)
		{
			for (int c=0; c<matrix.length; c++)
			{
				if ( String.valueOf(word.charAt(0)).equals(matrix[r][c]))
				{
					//one character
					if (wordLength == 1)
					{
						return ((r+1) + "," + (c+1) + " " + (r+1) + "," + (c+1));
					}
					//check right
					if ((matrix.length - c) >= wordLength)
					{
						for (int i=1; i<wordLength; i++)
						{
							int tempC = c+i;
							if (String.valueOf(word.charAt(i)).equals(matrix[r][tempC]))
							{
								if (wordLength == (tempC+1 - c))
									return ((r+1) + "," + (c+1) + " " + (r+1) + "," + (tempC+1));
							}
							else
								break;
						}
					}
					//check left
					if ((c+1) >= wordLength)
					{
						for (int i=1; i<wordLength; i++)
						{
							int tempC = c-i;
							if (String.valueOf(word.charAt(i)).equals(matrix[r][tempC]))
							{
								if (wordLength == (c+1 - tempC))
									return ((r+1) + "," + (c+1) + " " + (r+1) + "," + (tempC+1));
							}
							else
								break;
						}
					}
					//check down
					if ((matrix.length - r) >= wordLength)
					{
						for (int i=1; i<wordLength; i++)
						{
							int tempR = r+i;
							if (String.valueOf(word.charAt(i)).equals(matrix[tempR][c]))
							{
								if (wordLength == (tempR+1 - r))
									return ((r+1) + "," + (c+1) + " " + (tempR+1) + "," + (c+1));
							}
							else
								break;
						}
					}
					//check up-right diagonal
					if ( ((r+1) >= wordLength) && ((matrix.length) - c >= wordLength) )
					{
						for (int i=1; i<wordLength; i++)
						{
							int tempC = c+i;
							int tempR = r-i;
							if (String.valueOf(word.charAt(i)).equals(matrix[tempR][tempC]))
							{
								if ( (wordLength == (tempC+1 - c)) && (wordLength == r+1 - tempR) )
									return ((r+1) + "," + (c+1) + " " + (tempR+1) + "," + (tempC+1));
							}
							else
								break;
						}
					}
					//check up-left diagonal
					if ( ((r+1) >= wordLength) && ((c+1) >= wordLength) )
					{
						for (int i=1; i<wordLength; i++)
						{
							int tempC = c-i;
							int tempR = r-i;
							if (String.valueOf(word.charAt(i)).equals(matrix[tempR][tempC]))
							{
								if ( (wordLength == (c+1 - tempC)) && (wordLength == r+1 - tempR) )
									return ((r+1) + "," + (c+1) + " " + (tempR+1) + "," + (tempC+1));
							}
							else
								break;
						}
					}
					//check down-right diagonal
					if ( ((matrix.length - r) >= wordLength) && ((matrix.length) - c >= wordLength) )
					{
						for (int i=1; i<wordLength; i++)
						{
							int tempC = c+i;
							int tempR = r+i;
							if (String.valueOf(word.charAt(i)).equals(matrix[tempR][tempC]))
							{
								if ( (wordLength == (tempC+1 - c)) && (wordLength == (tempR+1 - r)) )
									return ((r+1) + "," + (c+1) + " " + (tempR+1) + "," + (tempC+1));
							}
							else
								break;
						}
					}
					//check down-left diagonal
					if ( ((matrix.length - r) >= wordLength) && ((c+1) >= wordLength) )
					{
						for (int i=1; i<wordLength; i++)
						{
							int tempC = c-i;
							int tempR = r+i;
							if (String.valueOf(word.charAt(i)).equals(matrix[tempR][tempC]))
							{
								if ( (wordLength == (c+1 - tempC)) && (wordLength == (tempR+1 - r)) )
									return ((r+1) + "," + (c+1) + " " + (tempR+1) + "," + (tempC+1));
							}
							else
								break;
						}
					}
				}
			}
		}

		return "Not found";
	}
}