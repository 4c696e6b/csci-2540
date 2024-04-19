/*
 * Link Parrish
 */

package assg1_parrishl21;

import java.util.Scanner;

public class CountFamilies {

	public static void main(String[] args) {

		int numOfFamilies;
        int max = 0, count = 0;
            
        Scanner keyboard = new Scanner(System.in);
            
        System.out.print("How Many Families: ");
        numOfFamilies = keyboard.nextInt();
            
        int incomes[] = new int[numOfFamilies];
            
        // gets the incomes
        for (int i = 0; i < numOfFamilies; i++) {
            System.out.print("Enter an Income: ");
            incomes[i] = keyboard.nextInt();
            
            // calculates the highest income while getting the incomes
            if (max < incomes[i]) max = incomes[i];
        }
            
        System.out.println("\nMax Income: " + max + "\n");
        System.out.println("The number of families making less than 10% of the max are:");
        
        // displays incomes less than 10% and counts them
        for (int i = 0; i < numOfFamilies; i++) {
            if (incomes[i] < max / 10) {
                System.out.println(incomes[i]);
                count++;
            }
        }
        
        System.out.println("For a total of " + count + " families");
        keyboard.close();
    }
}