package spil;

public class PlayerAccount 
{

	private int balance;

	public PlayerAccount(int balance) 
	{
		if(balance < 0)
			this.balance = 0;
		else
			this.balance = balance;
	}

	public void addBalance(int amount) 
	{
		this.balance = this.balance + amount;
	}

	public void subBalance(int amount) 
	{
		if((this.balance - amount)<0)
			this.balance = 0;
		else
			this.balance = this.balance - amount;
	}

	public void setBalance(int amount) 
	{
		if(amount < 0)
			this.balance = 0;
		else
			this.balance = amount;
	}

	public int getBalance() 
	{
		return this.balance;
	}

}
