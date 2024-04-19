/**
 * @author Tim Butts
 * @author Link Parrish
 */
package activity10;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class QueuePractice {

	public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        Integer num = kbd.nextInt();	
        Node head, n;
        
        head = listGenerator(num);
        n = head;
        
        System.out.println("\nPrinting the Linked List:");
        while (n.next != null ) {
            System.out.print(n.item + "\t");
            n = n.next;
        }
        System.out.println("\n\nPrinting the Queue:");
        queueTest(head);
        kbd.close();
    }
	
	public static Node listGenerator(int size) {
		
		Random rand = new Random();
		Node head = new Node(rand.nextInt(50));
		Node temp = null;
		Node n = head;
		
		for (int i = 0; i < size; i++) {
			
			temp = new Node(rand.nextInt(50));
			n.next = temp;
			n = n.next;
		}
		
		return head;
	}
	
	 public static void queueTest(Node head) {
	        
	        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
	       
	        
	        while (head.next != null) {
	            head.item *= 2;
	            queue.add(head.item);
	            if (head.next != null)
	                head = head.next;
	        }
	        
	        Iterator<Integer> iter = queue.iterator();
	        while (iter.hasNext()) {
	            System.out.print(iter.next()+"\t");
	        }
	    }
}
