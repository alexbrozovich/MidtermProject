
public class Player {
	
	private String name;
	private int skill;
	
	public Player() {
		
	}
	
	public Player(String name, int skill) {
		this.name = name;
		this.skill = skill;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSkill() {
		
		return skill;
	}

	public void setSkill(int skill) {
		this.skill = skill;
	}
	
	public String expertise(int num) {
		if(num == 1) {
			return "Beginner. This shouldn't be too hard...or will it???";
		}if(num == 2) {
			return "Average Joe. Average is a good word for you.";
		}if(num ==3) {
			return "Expert...we will see about that.";
		}
		return "";
			
	}
	public static int numOfBombs(int num, int numberOfCells) {
		int numOfBombs;
		
		if(num == 1) {
			numOfBombs = (int) (numberOfCells * .25);
			return numOfBombs; 
		}
		if(num == 2) {
			numOfBombs = (int) (numberOfCells * .35);
			return numOfBombs;
		}
		if(num == 3) {
			numOfBombs = (int) (numberOfCells * .45);
			return numOfBombs;
		}
		return 0;
	}

	public static int numOfFlags(int num, int numberOfCells) {
		int numOfFlags;
		
		if(num == 1) {
			numOfFlags = (int) (numberOfCells * .25);
			return numOfFlags; 
		}
		if(num == 2) {
			numOfFlags = (int) (numberOfCells * .35);
			return numOfFlags;
		}
		if(num == 3) {
			numOfFlags = (int) (numberOfCells * .45);
			return numOfFlags;
		}
		return 0;
	}
	



	//@Override
	public String toString() {		
		return name + " " + skill;
	}

	

}
