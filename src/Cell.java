
public class Cell {
	//creating our instances to what will be placed in our individual cells.
	//
	private boolean played;
	private boolean bomb; 
	private int nearBomb;
	private boolean flag;
	private boolean display;
	
	
	public boolean isPlayed() {
		return played;
	}
	public void setPlayed(boolean played) {
		this.played = played;
	}
	public boolean isBomb() {
		return bomb;
	}
	public void setBomb(boolean bomb) {
		this.bomb = bomb;
	}
	public int isNearBomb() {
		return nearBomb;
	}
	public void setNearBomb(int nearBomb) {
		this.nearBomb = nearBomb;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public boolean isDisplay() {
		return display;
	}
	public void setDisplay(boolean display) {
		this.display = display;
	}
	@Override
	public String toString() {
	//to string placed in order to print out our characters in our cells.	
		if (display == false) {
			return "▢";
			
		} else {
		
		if (played == true) {
			return "■";
		}
		
		else if (flag == true) {
			return "⚑";
		}
		
		else if (bomb == true) {
			return "💣" + " ";
		}
		

		//in order to work with numbers 0-3 we are using the -1 value to set our indexes 
		else if (nearBomb > -1) {
			return String.valueOf(nearBomb);
		}

		

		
		
		
	
	} return "X";
	}
	
	
	
	
		
	
}
