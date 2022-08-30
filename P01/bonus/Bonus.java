import java.util.Scanner; 


public class Bonus 
{
	public static void main(String[] args)
	{
	    Scanner in = new Scanner(System.in);
	    String n1;
		System.out.print("What is your name? ");
		n1 = in.nextLine();
		System.out.println("Hello, " + n1);
		
		StringBuilder sb = new StringBuilder(n1);
		System.out.println("Hello, " + sb.reverse());
		
	}
}
