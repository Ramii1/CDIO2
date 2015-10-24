package spil;

public class ResultController {

	//This is the GetSumResult for getting sum as a result.
	//It simply pluses the two values of the dice values (example: diceOne.value).
	public int getSumResult(Dice[] diceArray)
	{
		Dice diceOne = diceArray[0];
		Dice dicetwo = diceArray[1];
		int sum = diceOne.value + dicetwo.value; 
		return sum;
	}

}
