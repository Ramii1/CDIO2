package spil;

public class Player 
{

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private String playerName;
	private PlayerAccount playerAccount;

	public Player() 
	{
		playerAccount = new PlayerAccount(1000);
	}

	//Setter method for setting player name.
	public void setPlayerName(String playerName)
	{
		this.playerName = playerName;
	}

	//It simply returns the player name
	public String getPlayerName()
	{
		return playerName;
	}

	public PlayerAccount getPlayerAccount()
	{
		return playerAccount;
	}
}
