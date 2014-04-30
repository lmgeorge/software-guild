/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseballleague;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.matchers.JUnitMatchers.hasItems;

/**
 *
 * @author lmgeorge <lauren.george@live.com>
 */
public class LeagueTest {

	private final League l = new League();
	List<Player> mets = new ArrayList<>();
	List<Player> angels = new ArrayList<>();
	Map <String, Player> players = new HashMap<>();
	public LeagueTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {

		Player frieri = new Player();
		frieri.setJerseyNumber("49");
		frieri.setFirstName("Ernesto");
		frieri.setLastName("Frieri");
		frieri.setPosition("pitcher");
		frieri.setCareerBattingAvg(0.197);
		frieri.setCareerGames(240);
		frieri.setBirthday("7/19/1985");

		Player conger = new Player();
		conger.setJerseyNumber("16");
		conger.setFirstName("Hyun Choi");
		conger.setLastName("Conger");
		conger.setPosition("catcher");
		conger.setCareerBattingAvg(0.230);
		conger.setCareerGames(240);
		conger.setBirthday("7/19/1985");

		angels.add(conger);
		angels.add(frieri);
		
		Player colon = new Player();
		colon.setJerseyNumber("40");
		colon.setFirstName("Bartolo");
		colon.setLastName("Colon");
		colon.setPosition("pitcher");
		colon.setCareerBattingAvg(0.262);
		colon.setCareerGames(416);
		colon.setBirthday("5/24/1973");

		Player duda = new Player();
		duda.setJerseyNumber("21");
		duda.setFirstName("Lucas");
		duda.setLastName("Duda");
		duda.setPosition("infielder");
		duda.setCareerBattingAvg(0.283);
		duda.setCareerGames(374);
		duda.setBirthday("2/3/1986");

		mets.add(duda);
		mets.add(colon);
		
		players.put("Frieri", frieri);
		players.put("Colon", colon);
		players.put("Duda", duda);
		players.put("Conger", conger);
	}

	@After
	public void tearDown() {
		mets.clear();
		angels.clear();
	}

	public boolean compareObject(Player player1, Player player2) {
		return player1.getJerseyNumber().equals(player2.getJerseyNumber())
			&& player1.getFirstName().equals(player2.getFirstName())
			&& player1.getLastName().equals(player2.getLastName())
			&& player1.getPosition().equals(player2.getPosition())
			&& player1.getCareerBattingAvg() == player2.getCareerBattingAvg()
			&& player1.getCareerGames()== player2.getCareerGames()
			&& player1.getBirthday().equals(player2.getBirthday());
	}

	@Test
	public void testFileNameGen() {
		assertEquals("redsox.txt", l.fileNameGen("Red Sox"));
		assertEquals("mets.txt", l.fileNameGen("Mets"));
		assertEquals("redsox.txt", l.fileNameGen("Red Sox"));

	}

	@Test
	public void testLoadTeam() throws Exception {
		Player test= l.loadTeam("mets.txt")
			.stream()
			.filter(player -> player.getJerseyNumber().equals("40"))
			.collect(Collectors.toList()).get(0);
		
		assertTrue(compareObject(test, players.get("Colon")));
		
	}

	@Test
	public void testLoadLeague() {

		l.loadLeague();
	}

	@Test
	public void testAddPlayer() {

	}

	@Test
	public void testRemovePlayer() {
	}

	@Test
	public void testGetPlayer() {
	}

	@Test
	public void testGetTeam() {

	}

	@Test
	public void testAddTeam() {
	}

	@Test
	public void testRemoveTeam() {
	}

	@Test
	public void testSaveLeague() throws Exception {
	}

	@Test
	public void testSaveTeam() throws Exception {
	}


}
