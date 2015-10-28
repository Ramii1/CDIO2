package test;

import java.util.Scanner;

import spil.Board;
import spil.Dice;
import spil.DiceCup;

public class TestGame 
{
	public static void main(String[] args) 
	{		
		int countMaxRun = 0;//Antal gange kast af terningerne
		int countDoubleRunAll = 0;//antal af kast, hvor terninger er ens. 
		
		int countDoubleOne = 0;//Antal af ens ener
		int countDoubleTwo = 0;//Antal af ens toer
		int countDoubleThree = 0;//Antal af ens trer
		int countDoubleFour = 0;//Antal af ens fire
		int countDoubleFive = 0;//Antal af ens femer
		int countDoubleSix = 0;//Antal af ens sekser
		
		int sumTotalValue = 0;//V�rdien af summen
		int sumTotalDoubles = 0;

		int a=0, b=0, c=0, d=0, e=0, f=0, g=0, h=0, i=0, j=0, k=0;
		
		Scanner scanner = new Scanner(System.in);//Opretter en scanner
		System.out.println("Indstast antal gange terningerne skal kastes.");//Info til brugeren eller testeren.
		countMaxRun = scanner.nextInt();//Indtast af antal kast af testeren.
		
		//for loop start
		for(int index = 0; index < countMaxRun; index++)
		{
			Dice diceOne = new Dice();
			Dice diceTwo = new Dice();
			DiceCup diceCup = new DiceCup(diceOne, diceTwo);
			Board board = new Board(diceCup);
			Dice[] diceArray = board.shakeDiceCup();
			int diceOneValue = diceArray[0].value;
			int diceTwoValue = diceArray[1].value;
			sumTotalValue += board.getCalculatedSum(diceArray);;
			
			int x = board.getCalculatedSum(diceArray);;
			
			switch(x) {//switch case for 2 to 12
				case 2: a++; break;
				case 3: b++; break;
				case 4: c++; break;
				case 5: d++; break;
				case 6: e++; break;
				case 7: f++; break;
				case 8: g++; break;
				case 9: h++; break;
				case 10: i++; break;
				case 11: j++; break;
				case 12: k++; break;
			}
			
			if(diceOneValue == diceTwoValue)
			{
				switch(diceOneValue)//switch case for two a like
				{
					case 1: 
						countDoubleOne++;
						countDoubleRunAll++;
						sumTotalDoubles +=  diceOneValue + diceTwoValue;
						break;
					case 2: 
						countDoubleTwo++; 
						countDoubleRunAll++;
						sumTotalDoubles +=  diceOneValue + diceTwoValue;
						break;
					case 3: 
						countDoubleThree++; 
						countDoubleRunAll++;
						sumTotalDoubles +=  diceOneValue + diceTwoValue;
						break;
					case 4: 
						countDoubleFour++; 
						countDoubleRunAll++;
						sumTotalDoubles +=  diceOneValue + diceTwoValue;
						break;
					case 5: 
						countDoubleFive++;
						countDoubleRunAll++;
						sumTotalDoubles +=  diceOneValue + diceTwoValue;
						break;
					case 6: 
						countDoubleSix++; 
						countDoubleRunAll++;
						sumTotalDoubles +=  diceOneValue + diceTwoValue;
						break;
				}
			}
		}
		//End for loop
		
		System.out.println("");
		System.out.println("2: " + a);
		System.out.println("3: " + b);
		System.out.println("4: " + c);
		System.out.println("5: " + d);
		System.out.println("6: " + e);
		System.out.println("7: " + f);
		System.out.println("8: " + g);
		System.out.println("9: " + h);
		System.out.println("10: " + i);
		System.out.println("11: " + j);
		System.out.println("12: " + k);
		
		System.out.println("");
		
		System.out.println("");
		
		System.out.println("Antal af dobbelt en'er: " + countDoubleOne);
		System.out.println("Antal af dobbelt to'er: " + countDoubleTwo);
		System.out.println("Antal af dobbelt tre'er: " + countDoubleThree);
		System.out.println("Antal af dobbelt fire'er: " + countDoubleFour);
		System.out.println("Antal af dobbelt fem'er: " + countDoubleFive);
		System.out.println("Antal af dobbelt seks'er: " + countDoubleSix);
		System.out.println("Antal af dobbelt sl�et i alt: " + countDoubleRunAll);
		
		System.out.println("");
		
		System.out.println("Sum af dobbelt v�rdier totalt: " + sumTotalDoubles);
		System.out.println("Sum totalt: " + sumTotalValue);	
		System.out.println("Antal kast: " + countMaxRun);
		
		scanner.close();
	}
}
