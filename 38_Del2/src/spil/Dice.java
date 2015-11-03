package spil;

public class Dice 
{
	//Global variables which also called fields
	//These are public in order to access them and use them.
	private int value; //Used to keep track of the dice value.
	private int maxValue;//The maximum the dice may be able to roll.
	private int minValue;//The minimum the dice may be able to roll.


	public Dice()
	{
		this.maxValue=6;
		this.minValue=1;
	}

	public Dice(int maxValue, int minValue) 
	{
		this.maxValue = maxValue;
		this.minValue = minValue;
	}

	public void roll() 
	{
		value =(int)(Math.random()* maxValue + minValue);
	}

	public int getValue() 
	{
		return value;
	}
}
