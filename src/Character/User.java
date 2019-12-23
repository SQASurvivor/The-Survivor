package Character;

import javafx.beans.property.SimpleIntegerProperty;

public class User {
	private SimpleIntegerProperty rank;
	private SimpleIntegerProperty score;
	
	/**
	 * Constructor
	 */
	public User(){
		rank = new SimpleIntegerProperty();
		score = new SimpleIntegerProperty();
	}
	
	/**
	 * Getter
	 * @return the rank
	 */
	public int getRank() {
		return rank.get();
	}
	
	/**
	 * Setter
	 * @param rank the rank of the score
	 */
	public void setRank(int rank) {
		this.rank.set(rank);;
	}
	
	/**
	 * Getter
	 * @return the score
	 */
	public int getScore() {
		return score.get();
	}
	
	/**
	 * Setter
	 * @param score the score
	 */
	public void setScore(int score) {
		this.score.set(score);
	}
}
