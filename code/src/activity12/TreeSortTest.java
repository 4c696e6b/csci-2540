/**
 * @author Link Parrish
 * @author Hayden Roan
 */

package activity12;

import java.util.*;
import java.io.*;

public class TreeSortTest {
	public static void main(String[] args) {
		
		Scanner in = null;
		String filename = "activity12_input.txt";
		String line = null;
		String[] lineArgs = null;
		ArrayList<City> unsorted = new ArrayList<City>();
		ArrayList<City> sorted = new ArrayList<City>(); 
		
		try {
			in = new Scanner(new File(filename));
		}
		
		catch (FileNotFoundException e) {
			System.out.println(e);
			System.exit(1);
		}
		
		while (in.hasNextLine()) {
			line = in.nextLine();
			lineArgs = line.split(",");
			City city = new City(lineArgs[0], lineArgs[1]);
			unsorted.add(city);
		}
		
		sorted = treeSort(unsorted);
	
		for(int i = 0; i < sorted.size(); i++) {
			System.out.println(sorted.get(i));
		}
	}
	
	public static ArrayList<City> treeSort(ArrayList<City> in) {
		
		BinarySearchTree<City, String> brt = new BinarySearchTree<City, String>(in.get(0));
		
		for(int i = 1; i < in.size(); i++) {
			brt.insert(in.get(i));
		}
		
		TreeIterator<City> treeIter = new TreeIterator<City>(brt);
		treeIter.setInorder();
		
		ArrayList<City> out = new ArrayList<City>();
		
		while (treeIter.hasNext()) {
			out.add(treeIter.next());
		}
		
		return out;
		
	}
}
