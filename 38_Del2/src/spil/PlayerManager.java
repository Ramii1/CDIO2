package spil;

public class PlayerManager 
{	
	private Player playerOne;
	private Player playerTwo;
	
	//This is the constructor of class PlayerManager, which takes two different players.
	//In this case playerOne and playerTwo
	public PlayerManager(Player playerOne, Player playerTwo)
	{
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
	}
	
	//In this SelectPlayerRandomly method
	//we use this one as a flip coin.
	public String SelectPlayerRandomly()
	{
		Dice diceOneForPlayerOne = new Dice();
		Dice diceTwoForPlayerTwo = new Dice();
		DiceCup diceCup = new DiceCup(diceOneForPlayerOne, diceTwoForPlayerTwo);
		Dice[] diceArray = diceCup.Shake();
		diceOneForPlayerOne = diceArray[0];
		diceTwoForPlayerTwo = diceArray[1];
		
		if(diceOneForPlayerOne.value > diceTwoForPlayerTwo.value)
		{
			String playerOneChoosen = playerOne.getPlayerName();
			return playerOneChoosen;
		}
		else
		{
			String playerTwoChoosen = playerTwo.getPlayerName();
			return playerTwoChoosen;
		}
	}
}
