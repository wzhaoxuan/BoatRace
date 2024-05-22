//Player's detail 
/*Name
 * Score
 * Increment score
 * **/

public class Player {
	
	//attribute
	private String name;  //Store player name 
	private int score;  //Store player score
	
	//constructor
	public Player(String name) { 
		this.name = name;  //initialize player with a name & set score to 0
		this.score = 0;
		
	}
	
	//setter getter
	public String getName() {
		return name;  
	}
	
	public int getScore() {
		return score;
	}
	
	
	//other methods
	public void incrementScore () {
		score++;    //Increase the score 
	}
	

}
