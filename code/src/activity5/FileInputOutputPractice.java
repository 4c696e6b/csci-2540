package activity5;

import java.io.*;
import java.util.Scanner;

public class FileInputOutputPractice {

	public static void main(String[] args) {
		
		String filename1 = "activity5_input1.txt";
		String filename2 = "activity5_input2.txt";
		String filename3 = "activity5_output.txt";
		Scanner input1 = null;
		Scanner input2 = null;
		PrintWriter output = null;
		String line;
		
		try {
			input1 = new Scanner(new File(filename1));
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Error: file '" + filename1 + "' not found");
			System.exit(1);
		}
		
		try {
			input2 = new Scanner(new File(filename2));
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Error: file '" + filename2 + "' not found");
			System.exit(1);
		}
		
		try
        {
            output = new PrintWriter(filename3);
        }
        catch(IOException e)
        {
            System.out.println("Error: file '" + filename3 + "' unable to open");
            System.exit(1);
        }
		
		while (input1.hasNextLine()) {
			line = input1.nextLine();
			output.println(line);
		}
		
		while (input2.hasNextLine()) {
			line = input2.nextLine();
			output.println(line);
		}
		
		System.out.println("output created successfully");
		
		input1.close();
		input2.close();
		output.close();
	}
}
