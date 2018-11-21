package es.uva.inf.tds.pr2;

import static org.junit.Assert.*;

import org.junit.Test;

public class RankingTest {
	
	@Test
	public void testDefaultRanking() {
		int[] rankingElements = {1,2,3,4,5,6,7,8,9,10};
		Ranking<int> ranking= new Ranking<>(rankingElements);
		
		assertNotNull(ranking);
		assertArrayEquals(rankingElements, ranking.top);
		
	}
	
	@Test
	public void testCustomRanking() {
		//TODO
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetElementByPosition() {
		//TODO
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetPositionFromElementValue() {
		//TODO
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetPositionFromElementReference() {
		//TODO
		fail("Not yet implemented");
	}
	
	@Test
	public void testExistsElementValue() {
		//TODO
		fail("Not yet implemented");
	}
	
	@Test
	public void testExistsElementReference() {
		//TODO
		fail("Not yet implemented");
	}
	
	@Test
	public void testCompareWith() {
		//TODO
		fail("Not yet implemented");
	}
}
