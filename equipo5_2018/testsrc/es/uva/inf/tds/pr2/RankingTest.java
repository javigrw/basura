package es.uva.inf.tds.pr2;

import static org.junit.Assert.*;

import org.junit.Test;

public class RankingTest {

	@Test
	public void testDefaultRanking() {
		String[] rankingElements = { "top1", "top2", "top3", "top4", "top5", "top6", "top7", "top8", "top9", "top10" };
		Ranking<String> ranking = new Ranking<>(rankingElements);

		assertNotNull(ranking.top);
		assertArrayEquals(rankingElements, ranking.top);

	}

	@Test
	public void testCustomRanking() {
		int size = 5;
		String[] rankingElements = { "top1", "top2", "top3", "top4", "top5" };
		Ranking<String> ranking = new Ranking<>(rankingElements, size);

		assertNotNull(ranking.top);
		assertArrayEquals(rankingElements, ranking.top);
	}

	@Test
	public void testGetElementByPosition() {
		int position = 4;
		String[] rankingElements = { "top1", "top2", "top3", "top4", "top5", "top6", "top7", "top8", "top9", "top10" };
		Ranking<String> ranking = new Ranking<>(rankingElements);

		String element = ranking.getElementByPosition(position);

		assertEquals(rankingElements[3], element);
	}

	@Test
	public void testGetPositionFromElementValue() {
		int expectedPosition = 4;
		String[] rankingElements = { "top1", "top2", "top3", "top4", "top5", "top6", "top7", "top8", "top9", "top10" };
		Ranking<String> ranking = new Ranking<>(rankingElements);

		int position = ranking.getPositionFromElementValue("top4");

		assertEquals(expectedPosition, position);
	}

	@Test
	public void testGetPositionFromElementReference() {
		int expectedPosition = 4;
		String expectedElement = "element";
		String[] rankingElements = { "top1", "top2", "top3", expectedElement, "element", "top6", "top7", "top8", "top9",
				"top10" };
		Ranking<String> ranking = new Ranking<>(rankingElements);

		int position = ranking.getPositionFromElementReference(expectedElement);
		String element = ranking.getElementByPosition(position);

		assertSame(expectedElement, element);
		assertEquals(expectedPosition, position);
	}

	@Test
	public void testExistsElementValue() {
		
		String[] rankingElements = { "top1", "top2", "top3", "top4", "top5", "top6", "top7", "top8", "top9", "top10" };
		Ranking<String> ranking = new Ranking<>(rankingElements);

		assertTrue(ranking.exists("top1"));
		assertFalse(ranking.exists("top54"));
	}

	@Test
	public void testExistsElementReference() {

		String expectedElement = "top1";
		String notExpectedElement = "top54";
		String[] rankingElements = { expectedElement, "top2", "top3", "top4", "top5", "top6", "top7", "top8", "top9", "top10" };
		Ranking<String> ranking = new Ranking<>(rankingElements);

		assertTrue(ranking.exists(expectedElement));
		assertFalse(ranking.exists(notExpectedElement));
	}

	@Test
	public void testCompareWith() {
		// TODO
		fail("Not yet implemented");
	}
}
