/**
 * @author Link  Parrish
 * @author Ari Laughlin
 */
package activity8;

public class LinkListTest {

	public static void main(String[] args) {
		
		Node n = new Node(10);
		
		for (int i = 9; i > 0; i--) {
			Node temp = new Node(i, n);
			n = temp;
		}
		
		System.out.println("the list:");
		Node temp = n;
		while (temp != null) {
			System.out.println(temp.item);
			temp = temp.next;
		}
		System.out.println();
		
		System.out.println("odds iterative:");
		oddElementsIterative(n);
		System.out.println();
		
		System.out.println("evens iterative:");
		evenElementsIterative(n);
		System.out.println();
		
		System.out.println("odds recursive:");
		oddElementsRecursive(n, 1);
		System.out.println();

		System.out.println("evens recursive:");
		evenElementsRecursive(n, 1);
		System.out.println();


	}
	
	public static void oddElementsIterative(Node n) {
		int i = 1;
		while (n.next != null) {
			if (i % 2 == 1)
				System.out.println(n.item);
			n = n.next;
			i++;
		}
	}
	
	public static void oddElementsRecursive(Node n, int i) {
		if (i % 2 == 1)
			System.out.println(n.item);
		if (n.next != null)
			oddElementsRecursive(n.next, i+1);
		
	}
	
	public static void evenElementsIterative(Node even)
	{
		int k = 1;
		while (even.next != null)
		{
			if (k % 2 == 0)
			{
				System.out.println(even.item);
			}
			even = even.next;
			k++;
		}
	}
	
	public static void evenElementsRecursive(Node even, int k)
	{
		if (k % 2 == 0)
		{
			System.out.println(even.item);
		}
		if (even.next != null)
		{
			evenElementsRecursive(even.next, k+1);
		}
		
	}

}
