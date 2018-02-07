import java.util.Scanner;

//@author Ronald Kim
//@author Jordan Zwart
//@author Alex Brozovich
public class MidtermProjectMainApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to minefield\n");
		
		System.out.println("What is your name?: ");
		String name = scan.next();
		System.out.println("What is your skill?: ");
		String skill = scan.next();
		Player p1 = new Player(name,skill);
		
		System.out.println("Hey " + name + ". Welcome to minefield)");
		
		
		int size = Validator.getInt(scan, "First things first, please enter the size of board you would like to play");
		System.out.println("Your board is " + size + " x " + size + ".");
		
	

	}

}
