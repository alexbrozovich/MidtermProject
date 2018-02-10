import java.util.Random;

public class Minefield {
	public int numberOfBombs;
	public Cell[][] grid;
	public int numberOfFlags;

	//if the player selects a cell without a mine in it, it changes to show how many mines are touching it
	//if it's a mine, the mine blows up and the game is over
	public void clickCell(int x, int y) {
		if (grid[x][y].isBomb() == true) {
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid.length; j++) {
					grid[i][j].setDisplay(true);
				}
			}
			System.out.println("You hit a mine, game over!");
		} else {
			grid[x][y].setDisplay(true);
		}
	}
	
	//adds a flag to a given cell
	public void addFlag(int x, int y) {
		grid[x][y].setDisplay(true);
		grid[x][y].setFlag(true);
	}
	
	//determines whether or not the player has won the game or not
	public boolean winner() {
		boolean isWinner = true;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j].isBomb() == true) {
					if (grid[i][j].isFlag() == true && (numberOfFlags == numberOfBombs)) {
						continue;
					} else {
						isWinner = false;
					}
				}
			}
		}
		if (isWinner == true) {
			System.out.println("Winner winner Chicken Dinner! You have flagged all of the mines");
			for (int i = 0; i < grid.length; i++) {
				for (int j = 0; j < grid.length; j++) {
					grid[i][j].setDisplay(true);
				}
			}
		}
		return isWinner;
	}
	
	//prints out the current layout of the minefield to the console
	public void printGrid() {
		int xDimension = grid.length;
		int yDimension = grid[0].length;
		String outGrid = "";
		for (int i = 0; i < xDimension; i++) {
			for (int j = 0; j < yDimension; j++) {
				outGrid += String.format("%-5s", grid[i][j]);
				try {
					if (Integer.valueOf(grid[i][j].toString()) > -1) {
						outGrid += "\u2002";
					}
				} catch (NumberFormatException e) {

				}
			}
			outGrid += "\n";
		}
		System.out.println(outGrid);
	}
	
	//creates the minefield that is used to play the game
	Minefield(int x, int y, int skill, int numOfCells){
		//set up up misc stuff
		Random rand = new Random();
		// 1. Make 2D array
		Cell[][] grid = new Cell[x][y];
		
		//choose number of bombs to place based on skill level and number of cells.
		int numberOfBombs = Player.numOfBombs(skill, numOfCells);
		this.numberOfFlags = Player.numOfFlags(skill, numOfCells);
		this.numberOfBombs = numberOfBombs;
		
		//create xarray and yarray objects (these are used to place the bombs later)
		int[] bombPlacementListX = new int[numberOfBombs];
		int[] bombPlacementListY = new int[numberOfBombs];
		
		// 2. Fill the minefield with blank cell objects
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				grid[i][j] = new Cell();
			}
		}
		// 3. Choose which cells have bombs in them

		// a. Choose number of bombs to place (moved outside of loop)

		// b. Choose random coordinates x,y
		// b. Add x to x array and y to y array
		// c. For loop to get each bomb coordinate and call

		for(int i = 0; i < numberOfBombs; i++) {
			bombPlacementListX[i] = (rand.nextInt(x));
			bombPlacementListY[i] = (rand.nextInt(y));
		}
		// c. For loop to get each bomb coordinate and call grid[xarray[i]][yarray[i]].setBomb(true);

		for(int i = 0; i < numberOfBombs; i++) {
			boolean noDupes = false;
			while (noDupes == false) {
				//if the cell at the given coordinates already has a bomb, pick a new set of coordinates
				if (grid[bombPlacementListX[i]][bombPlacementListY[i]].isBomb() == true) {
					bombPlacementListX[i] = rand.nextInt(x);
					bombPlacementListY[i] = rand.nextInt(x);
				}
				else {
					noDupes = true;
				}
			}
			grid[bombPlacementListX[i]][bombPlacementListY[i]].setBomb(true);
		}

		// the first two for loops go through each set of coordinates in the grid
		for (int xCoord = 0; xCoord < x; xCoord++) {
			for (int yCoord = 0; yCoord < y; yCoord++) {
				int bombCount = 0;
				// the second two for loops check each cell around the current cell to see if they're bombs
				for (int xRel = (xCoord - 1); xRel < (xCoord + 2); xRel++) {
					for (int yRel = (yCoord - 1); yRel < (yCoord + 2); yRel++) {
						// make sure it's a valid set of coordinates (can't have an index of less than 0 or bigger than the dimensions of the board
						if (xRel > -1 && xRel < x && yRel > -1 && yRel < y) {
							if (grid[xRel][yRel].isBomb() == true) {
								bombCount += 1;
							} else {
								continue;
							}
						} else {
							continue;
						}
					}
				}
				grid[xCoord][yCoord].setNearBomb(bombCount);
			}
		}
		this.grid = grid;
	}
}
