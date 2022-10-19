import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Scheuler {
	public static void main(String args[]) throws IOException
	{
		List <String> L = new List<>();
		Scanner input = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char c;
		boolean exit = false;
	
		System.out.println("Welcome to the Scheduler app\n");
		System.out.println("You have no upcoming event\n");
		System.out.println("Select from the following options: ");
		System.out.println("A: " + "Add and event");
		System.out.println("R: " + "Remove an event");
		System.out.println("X: " + "Exit");
		
		System.out.printf("\nEnter your choice: ");
		c = input.next().charAt(0);
		
		
		if(c == 'A' || c == 'a')
		{
			System.out.printf("Please enter an event: ");
			String event = in.readLine();
			L.addFirst(event);
		}
		else if(c == 'R' || c == 'r')
		{
			System.out.printf("You have no events to remove");
			
		}
		else if(c == 'X' || c == 'x')
		{
			exit = true;
			System.out.println("Goodbye!");
		}
		else
		{
			System.out.println("Please select between A, R, X");
			c = input.next().charAt(0);
		}
		System.out.println();
		while(exit == false)
		{
			
		}
	}

}
