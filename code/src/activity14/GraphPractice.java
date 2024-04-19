/**
 * @author Link Parrish
 * @author Tim Butts
 */
// 1789
package activity14;

import java.util.*;

public class GraphPractice {

	public static void main(String[] args) {
		
		LinkedList<LinkedList<Character>> graph = new LinkedList<LinkedList<Character>>();
		
		Scanner in = new Scanner(System.in);
		String line = null;
		String[] vertices = null;
		String[] edges = null;
		
		System.out.print("enter the vertices seperated by commas: ");
		
		line = in.nextLine();
		vertices = line.split(",");
		
		if (vertices[0].isEmpty()) {
			System.out.println("Error: no vertices entered");
			System.exit(1);
		}
		
		for (int i = 0; i < vertices.length; i++) {
			
			vertices[i].strip();
			LinkedList<Character> temp = new LinkedList<Character>();
			temp.add(vertices[i].charAt(0));
			graph.add(temp);
		}
		
		System.out.print("enter the edges seperated by commas: ");
		
		line = in.nextLine();
		edges = line.split(",");
		
		if (!edges[0].isEmpty()) {

			for (int i = 0; i < edges.length; i++) {
				edges[i].strip();
			
				for (int j = 0; j < graph.size(); j++) {
				
					if (edges[i].charAt(0) == graph.get(j).getFirst()) {
						if (!graph.get(j).contains(edges[i].charAt(1)))
							graph.get(j).add(edges[i].charAt(1));
					}
				}
			}
		}
		
		for (int i = 0; i < graph.size(); i++) {
			System.out.println(graph.get(i));
		}
		
		in.close();
	}
}
