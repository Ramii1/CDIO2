package spil;

public class Player {

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private String playerName;
	private int playerGameScore;

	//Setter method for setting player name.
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	//Setter method for setting adding score values from the two dices thrown
	public void setPlayerGameScoreValue(int playerGameScoreValue)
	{
		this.playerGameScore = this.playerGameScore + playerGameScoreValue;
	}
	
	//resets the player game score value
	//this is used for getting two dice with 1 value on each.
	public void resetPlayerGameScoreValue()
	{
		this.playerGameScore = 0;
	}

	//It simply returns the player name
	public String getPlayerName()
	{
		return playerName;
	}

	//returns game player score
	public int getPlayerGameScore()
	{
		return playerGameScore;
	}
}
