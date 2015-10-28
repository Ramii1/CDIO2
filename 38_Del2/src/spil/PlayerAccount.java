package spil;

public class PlayerAccount {
	
	private int balance;
	
	public void addBalance(int amount) {
		this.balance = this.balance + amount;
	}
	
	public void subBalance(int amount) {
		if((this.balance - amount)<0)
			this.balance = 0;
		else
			this.balance = this.balance - amount;
	}
	
	public void setBalance(int amount) {
		this.balance = amount;
	}
	
	public int getBalance() {
		return this.balance;
	}

}
