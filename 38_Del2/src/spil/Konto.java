package spil;

public class Konto {
	
	private Player Player;
	private int Saldo;
	
	public Konto(Player Player, int Saldo) {
		this.Player = Player;
		this.Saldo = Saldo;
	}
	
	public void addSaldo(int beløb) {
		this.Saldo = this.Saldo + beløb;
	}
	
	public void subSaldo(int beløb) {
		if((this.Saldo - beløb)<0)
			this.Saldo = 0;
		else
			this.Saldo = this.Saldo - beløb;
	}
	
	public void setSaldo(int Beløb) {
		this.Saldo = Beløb;
	}
	
	public int getSaldo() {
		return this.Saldo;
	}
}
