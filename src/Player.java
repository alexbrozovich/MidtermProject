
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
	
	public String skillSet(int num) {
		if(num == 1) {
			return "Beginner. This shouldn't be to hard...or will it???";
		}if(num == 2) {
			return "Average Joe. Average is a good word for you.";
		}if(num ==3) {
			return "Expert...we will see about that.";
		}
		return "";
		
	}
	//@Override
	public String toString() {		
		return name + " " + skill;
	}
	

}
