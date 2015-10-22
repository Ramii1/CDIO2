package spil;

//The class Board is marked with final,
//because of we do not want to be a sub class
public final class Board {

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.
	private DiceCup diceCup;
	private ResultController resultController;
	

	//This is the constructor of this Board Class
	public Board(DiceCup diceCup, ResultController resultController)
	{
		this.diceCup = diceCup;
		this.resultController = resultController;
	}

	//This is the ShakeDiceCupe method, 
	//which calls DiceCup class and the Shake Method on that class
	public Dice[] ShakeDiceCup()
	{
		return diceCup.Shake();
	}

	//This is a method for calculating the sum of the dice values.
	//In the ResultController class in the method GetSumResult 
	//There simply pluses the two values of the dice values (example: diceOne.value).
	public int GetCalculatedSum(Dice[] diceArray)
	{
		return resultController.GetSumResult(diceArray);
	}
}
