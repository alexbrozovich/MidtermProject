/**
 * 
 */

/**
 * @author jordan
 *
 */
public class Cell {
	
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
		
		if (display == false) {
			return "[]";
			
		} else {
		
		if (played == true) {
			return "■";
		}
		
		else if (bomb == true) {
			return "*";
		}
		
		else if (nearBomb > 0) {
			return String.valueOf(nearBomb);
		}
		
		else if (nearBomb == 2) {
			return "2";
		}
		
		else if (nearBomb == 3) {
			return "3";
		}
		
		else if (nearBomb == 4) {
			return "4";
		}
		
		else if (flag == true) {
			return "▶";
		}
		
		
		
	
	} return "X";
	}
	
	
	
	
		
	
}
