/*****
Jonathan Murray #3439348
Peer Problem - Coin Change

Expected output:
3
-1
*****/

import java.util.*;
import java.io.*;

public class CoinChange
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//File file = new File("test.txt");
		Scanner sc = new Scanner(System.in);

		while (sc.hasNext())
		{
			int amount = Integer.parseInt(sc.nextLine()); //read in amount
			String[] rawCoins = sc.nextLine().split("\\s+"); //read in coins

			//convert coins to integer array
			int[] coins = new int[rawCoins.length];
			for (int i=0; i<coins.length; i++)
				coins[i] = Integer.parseInt(rawCoins[i]);

			System.out.println(findMinCoins(amount, coins));
		}

	}

	//arg1: amount, arg2: array of different possible coins
	//return fewest amount of coins, or -1 if not possible
	static int findMinCoins(int amount, int[] coins)
	{
		int[] minCoins = new int[amount+1];
		Arrays.fill(minCoins, Integer.MAX_VALUE); //fill array with max value
		minCoins[0] = 0; //base case

		//fill out minCoins table for all values from 1 to amount
		for (int i=1; i<=amount; i++) {
			//go through all coins smaller than i
			for (int j=0; j<coins.length; j++) {
				if (coins[j] <= i)
				{
					int temp = minCoins[i-coins[j]];
					if (temp != Integer.MAX_VALUE && temp+1 < minCoins[i])
						minCoins[i] = temp+1;
				}
			}
		}

		//return amount of coins, or -1 if no combination of coins exists
		return (minCoins[amount] == Integer.MAX_VALUE) ? -1 : minCoins[amount];
	}
} 