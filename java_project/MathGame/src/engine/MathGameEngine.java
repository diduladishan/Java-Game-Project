package engine;
import java.util.Random;
public class MathGameEngine {
	String thePlayer = null;
	public static int level = -1;
	public static int score = 0;
	public static String answer = "";
	public static String username = "";
	
	// URLS for Images and their answer
	String[][] levels = {
							{"https://indraoo7.github.io/mathgameproject/Level1_.jpeg",
							"https://indraoo7.github.io/mathgameproject/Level1__.jpeg", "10", "20"},
							
							{"https://indraoo7.github.io/mathgameproject/Level2_.jpeg",
							"https://indraoo7.github.io/mathgameproject/Level2__.jpeg", "10", "20"},
							
							{"https://indraoo7.github.io/mathgameproject/Level3_.jpeg",
							"https://indraoo7.github.io/mathgameproject/Level3__.jpeg", "10", "20"},
							
							{"https://indraoo7.github.io/mathgameproject/Level4_.jpeg",
							"https://indraoo7.github.io/mathgameproject/Level4__.jpeg", "10", "20"}
						}; 
	
	// Current Player
	public MathGameEngine(String player)
	{
		MathGameEngine.username = player;
	}
	
	//Get current level
	public int getLevel() 
	{
		MathGameEngine.level += 1;
		return MathGameEngine.level;
	}
	
	//Get image for the current level
	public String getImage(int level) 
	{	
		int index = new Random().nextInt(levels[0].length-2);
		String choosenImage = levels[level][index];
		MathGameEngine.answer = levels[level][index+2];
		return choosenImage;
	}
	
	//Update Score
	public void updateScore(int points) 
	{
		MathGameEngine.score += points;
	}

	//Check Answer
	public boolean checkSolution(String ans) {
		if(ans.equals(MathGameEngine.answer)) {
			return true;
		}
		else {
			return false;
		}
	}

	// Check if game over
	public boolean gameOver() 
	{
		if (MathGameEngine.level == 3) 
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	//Get score
	public int getScore() {
		return MathGameEngine.score;
	}
	
	public String getUserName() {
		return MathGameEngine.username;
	}
	
	
}
