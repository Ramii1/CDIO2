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
		boolean gameIsNotWon = true;

				
		Dice diceOne = new Dice();
		Dice diceTwo = new Dice();
		DiceCup diceCup = new DiceCup(diceOne, diceTwo);
		Board board = new Board(diceCup);
			
		//A while loop for looping over the players and the players throw the dices.
		//It also contains the logic for winning and loosing of the players.
		while(gameIsNotWon)
		{
			String currentPlayerName = currentPlayer.getPlayerName();
			
			GUI.setBalance(playerOne.getPlayerName(), playerOne.getPlayerAccount().getBalance());
			GUI.setBalance(playerTwo.getPlayerName(), playerTwo.getPlayerAccount().getBalance());
			
			GUI.getUserButtonPressed(currentPlayerName + "'s turn.", "Shake Dice Cup");
			
				Dice[] diceArray = board.shakeDiceCup();
				int sum = diceCup.getSumResult(diceArray);
				int diceOneValue = diceArray[0].value;
				int diceTwoValue = diceArray[1].value;
				
				GUI.setDice(diceOneValue, diceTwoValue);
				
				switch(sum){
				case 2:
					currentPlayer.getPlayerAccount().addBalance(250);
					GUI.setBalance(currentPlayer.getPlayerName(), currentPlayer.getPlayerAccount().getBalance());
					GUI.showMessage(currentPlayer.getPlayerName()+", you find a tower with some hungry watchmen. You sell a bag of apples for 250$.");									
					break;
				case 3:
					currentPlayer.getPlayerAccount().subBalance(100);
					GUI.setBalance(currentPlayer.getPlayerName(), currentPlayer.getPlayerAccount().getBalance());
					GUI.showMessage(currentPlayer.getPlayerName()+" you fell into a crater and dropped 100$.");
					break;
				case 4:
					currentPlayer.getPlayerAccount().addBalance(100);
					GUI.setBalance(currentPlayer.getPlayerName(), currentPlayer.getPlayerAccount().getBalance());
					GUI.showMessage(currentPlayer.getPlayerName()+", you help out a young lady at the palace gate and recieves 100$.");
					break;
				case 5:
					currentPlayer.getPlayerAccount().subBalance(20);
					GUI.setBalance(currentPlayer.getPlayerName(), currentPlayer.getPlayerAccount().getBalance());
					GUI.showMessage(currentPlayer.getPlayerName()+", you're freezing in the cold desert and buy a blanket for 20$.");
					break;
				case 6:
					currentPlayer.getPlayerAccount().addBalance(180);
					GUI.setBalance(currentPlayer.getPlayerName(), currentPlayer.getPlayerAccount().getBalance());
					GUI.showMessage(currentPlayer.getPlayerName()+", you find labor in the Walled City and earn 180$");
					break;
				case 7:
					GUI.setBalance(currentPlayer.getPlayerName(), currentPlayer.getPlayerAccount().getBalance());
					GUI.showMessage(currentPlayer.getPlayerName()+", you find a place to spend the night at the monestary. (Nothing happens to your money)");
					break;
				case 8:
					currentPlayer.getPlayerAccount().subBalance(80);
					GUI.setBalance(currentPlayer.getPlayerName(), currentPlayer.getPlayerAccount().getBalance());
					GUI.showMessage(currentPlayer.getPlayerName()+", you find yourself in the black cave. Unfortunetly you're 80$ poorer when you find your way out.");
					break;
				case 9:
					currentPlayer.getPlayerAccount().addBalance(60);
					GUI.setBalance(currentPlayer.getPlayerName(), currentPlayer.getPlayerAccount().getBalance());
					GUI.showMessage(currentPlayer.getPlayerName()+", you find some huts in the mountain and earn 60$ by helping them with some labor.");
					break;
				case 10:
					currentPlayer.getPlayerAccount().subBalance(80);
					GUI.setBalance(currentPlayer.getPlayerName(), currentPlayer.getPlayerAccount().getBalance());
					GUI.showMessage(currentPlayer.getPlayerName()+", you've run into the werewall! You lose 80$ but gain another turn.");
					break;
				case 11:
					currentPlayer.getPlayerAccount().subBalance(50);
					GUI.setBalance(currentPlayer.getPlayerName(), currentPlayer.getPlayerAccount().getBalance());
					GUI.showMessage(currentPlayer.getPlayerName()+", you fell into the pit and lost 50$");
					break;
				case 12:
					currentPlayer.getPlayerAccount().addBalance(650);					
					GUI.setBalance(currentPlayer.getPlayerName(), currentPlayer.getPlayerAccount().getBalance());
					GUI.showMessage(currentPlayer.getPlayerName()+", you've found gold in the mountains. You sell it for 650$. You're rich!");
					break;
				}
				
				if(!(sum == 10))//This checks if you rolled a sum of 10. If you did, roll again. Otherwise it switches player.
				{
					changeCurrentPlayer();
				}					

			playerOneScore = playerOne.getPlayerAccount().getBalance();
			playerTwoScore = playerTwo.getPlayerAccount().getBalance();
			gameIsNotWon = playerOneScore < winnerScore && playerTwoScore < winnerScore;
						
			
			
			if(!gameIsNotWon)//If game is won the program passes through this check. 
			{
				if(playerOneScore >= winnerScore)
				{
					GUI.showMessage(playerOne.getPlayerName() + " has won with " + playerOneScore + " points!!! ");
				}
				else if(playerTwoScore >= winnerScore)
				{
					GUI.showMessage(playerTwo.getPlayerName() + " has won with " + playerTwoScore + " points!!! ");
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
