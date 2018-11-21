package es.uva.inf.tds.pr2;

import static org.junit.Assert.*;

import org.junit.Test;

public class RankingTest {
	
	@Test
	public void testDefaultRanking() {
		String[] rankingElements = {"top1","top2","top3","top4","top5","top6","top7","top8","top9","top10"};
		Ranking<String> ranking= new Ranking<>(rankingElements);
		
		assertNotNull(ranking.top);
		assertArrayEquals(rankingElements, ranking.top);
		
	}
	
	@Test
	public void testCustomRanking() {
		int size = 5;
		String[] rankingElements = {"top1", "top2", "top3", "top4", "top5"};
		Ranking<String> ranking = new Ranking<>(rankingElements,size);
		
		assertNotNull(ranking.top);
		assertArrayEquals(rankingElements,ranking.top);
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
