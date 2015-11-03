package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import spil.Player;

public class TestGame {

	// Testscript der tester om playerAccount kan gå i minus.
	
	
	Player p;
			
	@Before
	public void setUp() throws Exception {
		p = new Player();
		p.getPlayerAccount().setBalance(0);		assertEquals(0, p.getPlayerAccount().getBalance());
	
	}
		
	
	@Test
	public void test1() {
		p.getPlayerAccount().setBalance(-1000);
	
	}
	
	
	@Test
	public void test2() {
		p.getPlayerAccount().subBalance(500);
	}
	
	
	
	@After
	public void tearDown() throws Exception {
		assertEquals(0, p.getPlayerAccount().getBalance());
	}

	

}
