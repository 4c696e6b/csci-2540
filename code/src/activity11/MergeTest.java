package activity11;
/**
 * @author Brady Bromaghim
 * @author Link Parrish
 */
import java.util.*;

public class MergeTest {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the number of ints for the list: ");
		int length = in.nextInt();
		
		System.out.print("Enter the ints seperated by spaces: ");
		
		for (int i = 0; i < length; i++) {
			list.add(in.nextInt());
		}
		
		System.out.println("Before Sorting:");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
		list = mergeSort(list);
		
		System.out.println("\nAfter Sorting: ");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		
		in.close();
	}
	
	 public static ArrayList<Integer> merge(ArrayList<Integer> ar1, ArrayList<Integer> ar2)
	    {
	        ArrayList<Integer> merged = new ArrayList<Integer>();
	        int j = 0;
	        for(int i = 0; i < ar1.size(); i++)
	        {
	            while(j < ar2.size() && ar2.get(j) < ar1.get(i))
	            {
	                merged.add(ar2.get(j));
	                j++;
	            }
	            merged.add(ar1.get(i));
	        }
	        if(j < ar2.size())
	        {
	            while(j < ar2.size())
	            {
	                merged.add(ar2.get(j));
	                j++;
	            }
	        }
	        
	        return merged;
	    }
	 
	public static ArrayList<Integer> mergeSort(ArrayList<Integer> l) {
		if (l.size() == 1)
			return l;
		
		if (l.size() == 2) {
			int n1 = l.get(0);
			int n2 = l.get(1);
			if (n1 > n2) {
				l.set(0, n2);
				l.set(1, n1);
			}
			return l;
		}
		
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		ArrayList<Integer> l3 = new ArrayList<Integer>();

		
		for (int i = 0; i < l.size(); i++) {
			if (i < l.size() / 2)
				l1.add(l.get(i));
			else
				l2.add(l.get(i));
		}
		
		l1 = mergeSort(l1);
		l2 = mergeSort(l2);
		l3 = merge(l1, l2);
		return l3;
	}
}
