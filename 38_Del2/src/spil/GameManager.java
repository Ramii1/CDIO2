package spil;

import desktop_resources.GUI;

public class GameManager {

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private final int winnerScore = 3000;
	private Player playerOne;
	private Player playerTwo;
	private Player currentPlayer;

	//GameManager constructor
	public GameManager(Player playerOne, Player playerTwo)
	{
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		currentPlayer = this.playerOne;
	}

	//StartGameEngine method is a void method, which means 
	//it does not return any value.
	//StartGameEngine is the brain of this game-program
	public void StartGameEngine()
	{
		int playerOneScore = playerOne.getPlayerGameScore();
		int playerTwoScore = playerTwo.getPlayerGameScore();
		String playerOneName = playerOne.getPlayerName();
		String playerTwoName = playerTwo.getPlayerName();
		boolean gameIsNotWon = true;
		boolean playerOneDoubleDice = false;
		boolean playerTwoDoubleDice = false;
		
		Dice diceOne = new Dice();
		Dice diceTwo = new Dice();
		DiceCup diceCup = new DiceCup(diceOne, diceTwo);
		Board board = new Board(diceCup);

		//A while loop for looping over the players and the players throw the dices.
		//It also contains the logic for winning and loosing of the players.
		while(gameIsNotWon)
		{
			String currentPlayerName = currentPlayer.getPlayerName();
			
			GUI.getUserButtonPressed(currentPlayerName + " Click on Shake Dice Cup.", "Shake Dice Cup");
			
				Dice[] diceArray = board.shakeDiceCup();
				int sum = diceCup.getSumResult(diceArray);
				int diceOneValue = diceArray[0].value;
				int diceTwoValue = diceArray[1].value;
				
				GUI.setDice(diceOneValue, diceTwoValue);
				
				switch(sum){
				case 2:
					GUI.showMessage("Du finder et tårn med nogle sultne vagter, som du sælger en pose æbler til for 250kr!");
					
					break;
				case 3:
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
					
				case 11:
				case 12:
				}
				
				if(currentPlayer.getPlayerGameScore() < winnerScore)
				{				
					currentPlayer.setPlayerGameScoreValue(sum);
				}
				
				GUI.setBalance(currentPlayer.getPlayerName(), currentPlayer.getPlayerGameScore());
				
				if(!(sum == 10))//This check is for getting an extra throw if you got two of the same value from the two dices. 
				{
					changeCurrentPlayer();
				}					

			playerOneScore = playerOne.getPlayerGameScore();
			playerTwoScore = playerTwo.getPlayerGameScore();
			gameIsNotWon = playerOneScore < winnerScore && playerTwoScore < winnerScore;
						
			
			if(diceOneValue == diceTwoValue && (playerOne.getPlayerGameScore() >= winnerScore || playerTwo.getPlayerGameScore() >= winnerScore))
			{
				if(playerOne.getPlayerGameScore() >= winnerScore && currentPlayer.getPlayerName() == playerOne.getPlayerName())
				{
					playerOneDoubleDice = true;
					gameIsNotWon = false;
				}
				else
				if(playerTwo.getPlayerGameScore() >= winnerScore && currentPlayer.getPlayerName() == playerTwo.getPlayerName())
				{
					playerTwoDoubleDice = true;
					gameIsNotWon = false;
				}
			}
			
			if(!gameIsNotWon)//If game is won the program passes through this check. 
			{
				if(playerOneScore >= winnerScore && playerOneDoubleDice)
				{
					GUI.showMessage(playerOneName + " has won with " + playerOneScore + " points!!! ");
				}
				else
				if(playerTwoScore >= winnerScore && playerTwoDoubleDice)
				{
					GUI.showMessage(playerTwoName + " has won with " + playerTwoScore + " points!!! ");
				}
				else
				{
					gameIsNotWon = true;
				}
			}			
		}		
	}

	//Simply returns winner score
	public int getWinnerScore()
	{
		return winnerScore;
	}

	//Setting the current player.
	//This is used in the Program class after choosing which player starts with the game.
	public void setCurrentPlayer(String playerName)
	{
		if(playerOne.getPlayerName() == playerName)
		{
			currentPlayer = playerOne;
		}
		else
		{
			currentPlayer = playerTwo;
		}
	}
	
	//This method is used in the while loop in this GameManager class
	//in order to change the current player to the next player.
	private void changeCurrentPlayer()
	{
		if(currentPlayer == playerOne)
		{
			currentPlayer = playerTwo;
		}
		else
		{
			currentPlayer = playerOne;
		}
	}
}
