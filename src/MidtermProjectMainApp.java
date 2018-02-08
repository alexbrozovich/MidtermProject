import java.util.Scanner;

//@author Ronald Kim
//@author Jordan Zwart
//@author Alex Brozovich
public class MidtermProjectMainApp {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Welcome to minefield\n");
		
		String name = Validator.getString(scan, "What is your name?\n");
		
		int skill = Validator.getInt(scan, "What is your skill? Enter: (1)Beginner, (2)Average Joe, or (3)Expert:\n",1,3);
		
		Player p1 = new Player(name,skill);
		System.out.println("Hey " + p1.getName() + ". Welcome to the game!\n");
		
		System.out.println("You say your skill level is " + p1.expertise(skill));
		
		
		int size = Validator.getInt(scan, "First things first, please enter the size of board you would like to play: (Example if you enter 3, your board will be 3x3)\n",3,10);
		int numOfCells = size * size;
		System.out.println("Your board is " + size + " x " + size + ".\n");
		System.out.println("Lets play!\n");
		
		Minefield board = new Minefield(size,size,skill,numOfCells);
		board.printGrid();
		String keepGoing = "y";
		int userX = 0;
		int userY = 0;
		while (keepGoing.equalsIgnoreCase("y")) {
			System.out.println("Enter an x value");
			userX = (scan.nextInt() -1);
			System.out.println("Enter a y value");
			userY = (scan.nextInt() -1);
			board.clickCell(userX, userY);
			board.printGrid();
			
			
			if (board.grid[userX][userY].isBomb() == true) {
				
			System.out.println("Would you like to play again? (y/n) "); 
			keepGoing = scan.next();
			
			}
		}
//		board.printGrid();
//		board.clickCell(1, 1);
//		board.printGrid();
			System.out.println("Thanks for playing. Goodbye!");
//		
		
		
	

	}

}
