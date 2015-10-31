package spil;

public class Dice 
{
	//Global variables which also called fields
	//These are public in order to access them and use them.
	private int value;
	private int maxValue = 6;//Final keyword is used here, because we don't want to change this value.
	private int minValue = 1;//Final keyword is used here, because we don't want to change this value.
	
	public Dice(){
		this.maxValue=6;
		this.minValue=1;
	}
	
	public Dice(int maxValue, int minValue) {
		super();
		this.maxValue = maxValue;
		this.minValue = minValue;
	}

	public void roll() {
		value =(int)(Math.random()* maxValue + minValue);
	}

	public int getValue() {
		return value;
	}
	
	
	
}
