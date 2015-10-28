package spil;

//The class Board is marked with final,
//because of we do not want to be a sub class
public final class Board {

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private DiceCup diceCup;	

	//This is the constructor of this Board Class
	public Board(DiceCup diceCup)
	{
		this.diceCup = diceCup;
	}

	//This is the ShakeDiceCupe method, 
	//which calls DiceCup class and the Shake Method on that class
	public Dice[] shakeDiceCup()
	{
		return diceCup.Shake();
	}

}
