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
			
			userX = Validator.getInt(scan, "Enter an x value" , 1, size );
			userX = userX - 1;
			userY = Validator.getInt(scan, "Enter an y value" , 1, size );
			userY = userY - 1;
						
			System.out.println("Do you want to select cell or place flag?: (1)Cell or (2)Flag");
			int plays = scan.nextInt();
			if(plays == 1) {
				board.clickCell(userX, userY);
				board.printGrid();
			}
			//board.clickCell(userX, userY);
			
			
			if (board.grid[userX][userY].isBomb() == true) {
				
			System.out.println("Would you like to play again? (y/n) "); 
			keepGoing = scan.next();
			board = new Minefield(size, size, skill, numOfCells);
			}
		}
//		board.printGrid();
//		board.clickCell(1, 1);
//		board.printGrid();
			System.out.println("Thanks for playing. Goodbye!");
//		
		
		
	

	}

}
