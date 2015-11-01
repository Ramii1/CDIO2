package spil;

import desktop_fields.Empty;
import desktop_fields.Field;
import desktop_resources.GUI;

public class GameManager {

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private final int winnerScore = 3000;
	private Player playerOne;
	private Player playerTwo;
	private DiceCup diceCup;
	private boolean cointoss;
	private int sum;

	//GameManager constructor
	public GameManager()
	{
		this.diceCup = new DiceCup();
	}

	//StartGameEngine method is a void method, which means 
	//it does not return any value.
	//StartGameEngine is the brain of this game-program
	public void StartGameEngine()
	{
		initGUI();
		initPlayers();
		boolean gameIsNotWon = true;
		
		
		while (gameIsNotWon){
			if (cointoss){
				gameIsNotWon = playerTurn(playerTwo);
				gameIsNotWon = playerTurn(playerOne);
				
			} else {
				gameIsNotWon = playerTurn(playerOne);
				gameIsNotWon = playerTurn(playerTwo);
			}
		}
		showWinnerScreen();
		//Show winner screen?? Rematch??
				
		
	}

	

	private void showWinnerScreen() {
		if(playerOne.getPlayerAccount().getBalance() >= winnerScore)
			GUI.showMessage(playerOne.getPlayerName()+" won!");
		else if(playerTwo.getPlayerAccount().getBalance() >= winnerScore)
			GUI.showMessage(playerTwo.getPlayerName()+" won!");
		
	}

	private void initPlayers() {
		String playerOneNameTypedInByTheUser = GUI.getUserString("Please type in the name of player One");

		//Creating a new player object
		playerOne = new Player();
		playerOne.setPlayerName(playerOneNameTypedInByTheUser);
		GUI.addPlayer(playerOne.getPlayerName(), 1000);		
		
		String playerTwoNameTypedInByTheUser = GUI.getUserString("Please type in the name of player Two");
		playerTwo = new Player();
		playerTwo.setPlayerName(playerTwoNameTypedInByTheUser);
		GUI.addPlayer(playerTwo.getPlayerName(), 1000);

		GUI.getUserButtonPressed("Flip a coin to decide who starts!", "Flip Coin");
		
		Dice dice = new Dice(1,2);
		dice.roll();
		if (dice.getValue()==2) cointoss=true;
		else cointoss=false;
		
		if(cointoss==true)
		GUI.showMessage(playerTwo.getPlayerName() + " starts! "  + "\nLet the game between " + playerOne.getPlayerName() + " and " + playerTwo.getPlayerName() + " begin.");		
		
	}

	private boolean playerTurn(Player player) {
		
		
		
		GUI.getUserButtonPressed(player.getPlayerName() + "'s turn.", "Shake Dice Cup");
		diceCup.shake();
//		GUI.setDice();
		sum = diceCup.getSumResult();
		
		switch(sum){
		case 2:
			player.getPlayerAccount().addBalance(250);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.showMessage(player.getPlayerName()+", you find a tower with some hungry watchmen. You sell a bag of apples for 250$.");									
			break;
		case 3:
			player.getPlayerAccount().subBalance(100);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.showMessage(player.getPlayerName()+" you fell into a crater and dropped 100$.");
			break;
		case 4:
			player.getPlayerAccount().addBalance(100);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.showMessage(player.getPlayerName()+", you help out a young lady at the palace gate and recieves 100$.");
			break;
		case 5:
			player.getPlayerAccount().subBalance(20);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.showMessage(player.getPlayerName()+", you're freezing in the cold desert and buy a blanket for 20$.");
			break;
		case 6:
			player.getPlayerAccount().addBalance(180);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.showMessage(player.getPlayerName()+", you find labor in the Walled City and earn 180$");
			break;
		case 7:
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.showMessage(player.getPlayerName()+", you find a place to spend the night at the monestary. (Nothing happens to your money)");
			break;
		case 8:
			player.getPlayerAccount().subBalance(70);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.showMessage(player.getPlayerName()+", you find yourself in the black cave. Unfortunetly you're 70$ poorer when you find your way out.");
			break;
		case 9:
			player.getPlayerAccount().addBalance(60);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.showMessage(player.getPlayerName()+", you find some huts in the mountain and earn 60$ by helping them with some labor.");
			break;
		case 10:
			player.getPlayerAccount().subBalance(80);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.showMessage(player.getPlayerName()+", you've run into the werewall! You lose 80$ but gain another turn.");
			break;
		case 11:
			player.getPlayerAccount().subBalance(50);
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.showMessage(player.getPlayerName()+", you fell into the pit and lost 50$");
			break;
		case 12:
			player.getPlayerAccount().addBalance(650);					
			GUI.setBalance(player.getPlayerName(), player.getPlayerAccount().getBalance());
			GUI.showMessage(player.getPlayerName()+", you've found gold in the mountains. You sell it for 650$. You're rich!");
			break;
		}
		
		if (player.getPlayerAccount().getBalance()>=3000){
			return false;
		}
		return true;
		
	}

	private void initGUI() {
		//Creating fields for emptying them on the GUI.
				Field[] fields = new Field[40];
				for(int i=0; i < fields.length ; i++)
				{
					Field emptyField = new Empty.Builder().build();
					fields[i] = emptyField;
				}
				
				GUI.create(fields);
				GUI.showMessage("Welcome to the Money Making Dice Game\nMade by Ramyar, Mikkel, Silas, Martin and Frank - Team 38 at DTU 2015 Autumn");	
						 		
	}

	//Simply returns winner score
	public int getWinnerScore()
	{
		return winnerScore;
	}


}
