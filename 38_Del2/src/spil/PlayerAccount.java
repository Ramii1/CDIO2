package spil;

public class PlayerAccount {
	
	private int balance;
	
	public void addSaldo(int amount) {
		this.balance = this.balance + amount;
	}
	
	public void subSaldo(int amount) {
		if((this.balance - amount)<0)
			this.balance = 0;
		else
			this.balance = this.balance - amount;
	}
	
	public void setSaldo(int amount) {
		this.balance = amount;
	}
	
	public int getSaldo() {
		return this.balance;
	}

}
