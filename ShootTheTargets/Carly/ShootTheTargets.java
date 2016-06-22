/**
	@author - Carly Smith 3414419
	Peer Problem: Shoot The Targets
*/
import java.util.*;
public class ShootTheTargets {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// continue scanning for input while there are more test cases
		while(sc.hasNextLine()) {
			// create the list of targets to be read in
			ArrayList<Integer> targets = new ArrayList<Integer>();
			// read in the next list of targets
			String line = sc.nextLine();
			// remove the square brackets from the input String
			line = line.substring(1, line.length()-1);

			// create a scanner for that line to scan for ints, ignoring the commas and space afterwards
			Scanner lineSc = new Scanner(line);
			lineSc.useDelimiter(", ");

			// add the ints to the array list
			while(lineSc.hasNext()) {
				targets.add(Integer.parseInt(lineSc.next()));
			}

			// keep track of points
			int total = 0;
			// length num for for loop
			int origLength = targets.size();
			for(int i = 0; i < origLength; i++) {
				// find the smallest index (or smallest on the inside of the list if the list is greater than 2 elems)
				int smallestIndex = findSmallestIndex(targets);

				// if there is only one item in the target list, add it to the total (this is the last one)
				if(targets.size() == 1) {
					total += targets.get(0);
				} 
				// if the index is not one of the end elems, multiply by the targets on either side of it
				else if(smallestIndex > 0 && smallestIndex < targets.size()-1) {
					total += targets.get(smallestIndex) * targets.get(smallestIndex-1) * targets.get(smallestIndex+1);
				} 
				// if the index is zero only multiply by item on the right
				else if(smallestIndex == 0) {
					total += targets.get(smallestIndex) * targets.get(smallestIndex+1);
				} 
				// if index is targest list length, only multiply by the item on the left
				else {
					total += targets.get(smallestIndex) * targets.get(smallestIndex-1);
				}

				// remove the target we used
				targets.remove(smallestIndex);
			}

			// print max score
			System.out.println(total);
		}
	}

	// function to find the best target to shoot
	// while there are numbers inside the boundary targets (first and last),
	// find the smallest one within the boundaries
	// otherwise, use the smallest of the boundaries
	public static int findSmallestIndex(ArrayList<Integer> arr) {
		int smallestIndex = 1;
		// if size is 1 or 2
		// or the first elem is a 0,
		// use the first boundary (first elem)
		if(arr.size() <= 2 || arr.get(0) == 0) {
			smallestIndex = 0;
		}

		// find smallest within boundary elems
		for(int i = smallestIndex+1; i < arr.size()-1; i++) {
			if(arr.get(i) < arr.get(smallestIndex)) {
				smallestIndex = i;
			}
		}

		// if size is 1 or 2
		// or the last elem is a 0,
		// include the last boundary (last elem) in the search 
		if(arr.size() <= 2 || arr.get(arr.size()-1) == 0) {
			if(arr.get(arr.size()-1) <= arr.get(smallestIndex)) {
				smallestIndex = arr.size()-1;
			}
		}

		// return best index
		return smallestIndex;
	}
}