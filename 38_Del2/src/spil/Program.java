package spil;

import desktop_resources.GUI;
import desktop_fields.Field;
import desktop_fields.Empty;

//The game begins with this Program class 
public class Program {

	public static void main(String[] args) {
		
		//Creating fields for emptying them on the GUI.
		Field[] fields = new Field[40];
		for(int i=0; i < fields.length ; i++)
		{
			Field emptyField = new Empty.Builder().build();
			fields[i] = emptyField;
		}
		
		GUI.create(fields);
		GUI.showMessage("Welcome to the Money Making Dice Game\nMade by Ramyar, Mikkel, Silas, Martin and Frank - Team 38 at DTU 2015 Autumn");	
				 
		String playerOneNameTypedInByTheUser = GUI.getUserString("Please type in the name of player One");

		//Creating a new player object
		Player playerOne = new Player();
		playerOne.setPlayerName(playerOneNameTypedInByTheUser);
		GUI.addPlayer(playerOne.getPlayerName(), 0);		
		
		String playerTwoNameTypedInByTheUser = GUI.getUserString("Please type in the name of player Two");
		Player playerTwo = new Player();
		playerTwo.setPlayerName(playerTwoNameTypedInByTheUser);
		GUI.addPlayer(playerTwo.getPlayerName(), 0 );

		GUI.getUserButtonPressed("Flip a coin to decide who starts", "Flip Coin");
		PlayerManager playerManager = new PlayerManager(playerOne, playerTwo);
		String playerNameChoosen = playerManager.SelectPlayerRandomly();
		
		GUI.showMessage(playerNameChoosen + " starts! "  + "\nLet the game between " + playerOne.getPlayerName() + " and " + playerTwo.getPlayerName() + " begin.");		
		GameManager gameManager = new GameManager(playerOne, playerTwo);
		gameManager.setCurrentPlayer(playerNameChoosen);

		gameManager.StartGameEngine();//Here is the brain of this game program.  

		GUI.close();//Closing the GUI => Graphical User Interface
		System.exit(0);//Terminates the currently running Java Virtual Machine - 0 means just to parse something into exit method.
	}

}
