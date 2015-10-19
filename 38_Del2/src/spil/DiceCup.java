package spil;

public class DiceCup {

	//Global variables of this class,
	//which also called fields.
	//This private fields can only be seen in this class.	
	private Dice diceOne;
	private Dice diceTwo;

	//DiceCup class constructor
	//which takes two class of Dice
	public DiceCup(Dice diceOne, Dice diceTwo) 
	{
		this.diceOne = diceOne;
		this.diceTwo = diceTwo;
	}

	//This Shake method is used for randomly choose
	//a random number between the numbers of the dice.
	//Shake method returns a Dice[] => which is a Dice array.
	public Dice[] Shake()
	{
		Dice[] diceArray = new Dice[2];//It creating a Dice fixed array with to index's
		diceOne.value =(int)(Math.random()* diceOne.maxValue + diceOne.minValue);
		diceTwo.value =(int)(Math.random()* diceTwo.maxValue + diceTwo.minValue);
		diceArray[0] = diceOne;//diceOne is a Dice and it is stored in index 0 of the array (diceArray[0])
		diceArray[1] = diceTwo;//diceTwo is a Dice and it is stored in index 1 of the array (diceArray[1])
		return diceArray;
	}
}
