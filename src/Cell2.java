/**
 * 
 */

/**
 * @author jordan
 *
 */
public enum Cell2 {
	Bomb,Flag,Played,NearBomb;

	@Override
	public String toString() {
		switch(this) {
		case Bomb:
			return "Bomb!, you loose";
		case Flag:
			return "(Flag symbol)";
		case Played:
			return "(Indent symbol)";
		case NearBomb:
			return "(Number)&&(Formula how close to bomb)";
		}
		return super.toString();
	}
	
	

}
