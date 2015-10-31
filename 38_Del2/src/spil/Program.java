package spil;

import desktop_resources.GUI;

//The game begins with this Program class 
public class Program {

	public static void main(String[] args) {
		//TODO refactor
		new GameManager().StartGameEngine();
		
	

		GUI.close();//Closing the GUI => Graphical User Interface
		System.exit(0);//Terminates the currently running Java Virtual Machine - 0 means just to parse something into exit method.
	}

}
