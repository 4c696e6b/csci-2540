package activity6_parrishl21;

import java.util.Scanner;

public class RecursionPractice {
    
    public static void main(String[] args) {
        
        Scanner keyboard = new Scanner(System.in);
        String str;
        char c;
        
        System.out.print("Enter a string: ");
        str = keyboard.nextLine();

        System.out.print("Enter a character: ");
        c = keyboard.nextLine().charAt(0);
        
        System.out.println("\nSearch first: " + searchFirst(str, c));
        System.out.println("Search last: " + searchLast(str, c));
        
        keyboard.close();
    }

    
    public static int searchFirst(String str, char c) {
        
        if (str.length() == 0)
            return -1;
        
        if (str.charAt(0) == c)
            return 0;
        
        int x = searchFirst(str.substring(1), c);
        
        if (x == -1)
            return x;
        
        else
            return x + 1;
        
        
    }
    
public static int searchLast(String str, char c) {
        
        if (str.length() == 0)
            return -1;
        
        if (str.charAt(str.length() - 1) == c)
            return str.length() - 1;
        
        return searchLast(str.substring(0, str.length() - 1), c);
    }
}