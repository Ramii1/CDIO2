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
					GUI.showMessage(currentPlayer.getPlayerName()+" you find a tower with some hungry watchmen. You sell a bag of apples for 250$.");
					
					break;
				case 3:
					GUI.showMessage(currentPlayer.getPlayerName()+" you fell into a crater and dropped 100$.");
					
					break;
				case 4:
					GUI.showMessage(currentPlayer.getPlayerName()+" you help out a young lady at the palace gate and recieves 100$.");
					
					break;
				case 5:
					GUI.showMessage(currentPlayer.getPlayerName()+" you're freezing in the cold desert and buy a blanket for 20$.");
					
					break;
				case 6:
					GUI.showMessage(currentPlayer.getPlayerName()+" you find labor in the Walled City and earn 180$");
					
					break;
				case 7:
					GUI.showMessage(currentPlayer.getPlayerName()+" you find a place to spend the night at the monestary.");
					
					break;
				case 8:
					GUI.showMessage(currentPlayer.getPlayerName()+" you find yourself in the black cave. Unfortunetly you're 80$ poorer when you find your way out.");
					
					break;
				case 9:
					GUI.showMessage(currentPlayer.getPlayerName()+" you find some huts in the mountain and earn 60$ by helping them with some labor.");
					
					break;
				case 10:
					GUI.showMessage(currentPlayer.getPlayerName()+" you've run into the werewall! You lose 80$ but gain another turn.");
					
					break;
				case 11:
					GUI.showMessage(currentPlayer.getPlayerName()+" you fell into the pit and lost 50$");
					
					break;
				case 12:
					GUI.showMessage(currentPlayer.getPlayerName()+" you've found gold in the mountains. You sell it for 650$. You're rich!");
					
					break;
				}
				
				
				GUI.setBalance(currentPlayer.getPlayerName(), currentPlayer.getPlayerGameScore());
				
				if(!(sum == 10))//This checks if you rolled a sum of 10. If you did, roll again. Otherwise it switches player.
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
