import java.util.Random;

public class Minefield {
	
	Minefield(int x, int y){
		//set up up misc stuff
		Random rand = new Random();
		// 1. Make 2D array
		Cell[][] grid = new Cell[x][y];
		
		//choose number of bombs to place
		//we can add this as an argument to the method later instead of hardcoding
		//or set it based on the size of the array
		int numberOfBombs = 4;
		
		
		//create xarray and yarray objects (these are used to place the bombs later)
		int[] bombPlacementListX = new int[numberOfBombs];
		int[] bombPlacementListY = new int[numberOfBombs];
		// 2. Fill with blank cell objects
		for (int i = 0; i < x; i++) {
			for (int j = 0; i < y; j++ ) {
				grid[i][j] = new Cell();
			}
		}
		// 3. Choose which cells have bombs in them
		
		// a. Choose number of bombs to place (moved outside of loop)
		
		// b. Choose random coordinates x,y
		// b. Add x to x array and y to y array
		for(int i = 0; i < numberOfBombs; i++) {
			bombPlacementListX[i] = (rand.nextInt(x) + 1);
			bombPlacementListY[i] = (rand.nextInt(y) + 1);
		}

		// c. For loop to get each bomb coordinate and call grid[xarray[i]][yarray[i]].setBomb(true);
		for(int i = 0; i < numberOfBombs; i++) {
			grid[bombPlacementListX[i]][bombPlacementListY[i]].setBomb(true);
		}
		
		// the first two for loops go through each set of coordinates in the grid
		for (int xCoord = 0; xCoord < x; xCoord++) {
			for (int yCoord = 0; yCoord < y; yCoord++) {
				int bombCount = 0;
				// the second two for loops check each cell around the current cell to see if they're bombs
				for (int xRel = (xCoord -1); xRel < (xCoord + 2); xRel++) {
					for (int yRel = (yCoord -1); yRel < (yCoord +2); yRel++) {
						//make sure it's a valid set of coordinates
						if (xRel > 0 && xRel < x && yRel > 0 && yRel < y) {
							if (grid[xRel][yRel].isBomb() == true) {
								bombCount += 1;
							}
							else {
								continue;
							}
						}
						else {
							continue;
						}
					}
				}
				if (grid[xCoord][yCoord].isBomb() == true) {
					bombCount = 0;
				}
				grid[xCoord][yCoord].setNearBomb(bombCount);
			}
		}
		
	}
}
