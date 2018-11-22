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

		assertTrue(ranking.existsValue("top1"));
		assertFalse(ranking.existsValue("top54"));
	}

	@Test
	public void testExistsElementReference() {

		String expectedElement = "top1";
		String notExpectedElement = "top54";
		String[] rankingElements = { expectedElement, "top2", "top3", "top4", "top5", "top6", "top7", "top8", "top9",
				"top10" };
		Ranking<String> ranking = new Ranking<>(rankingElements);

		assertTrue(ranking.existsReference(expectedElement));
		assertFalse(ranking.existsReference(notExpectedElement));
	}

	@Test
	public void testCompareWith() {

		String[] dataBefore = { "Alfonso", "Beatriz", "Carlos", "Diana", "Ernesto", "Fatima", "Guillermo", "Helena",
				"Ignacio", "Julia" };
		String[] dataAfter = { "Helena", "Alfonso", "Fatima", "Ernesto", "Carlos", "Diana", "Ignacio", "Guillermo",
				"Beatriz", "Julia" };
		int[] expectedResult = { 7, -1, 3, 1, -2, 2, 2, -1, -7, 0 };

		Ranking<String> rankingBefore = new Ranking<>(dataBefore);
		Ranking<String> rankingAfter = new Ranking<>(dataAfter);

		assertArrayEquals(expectedResult, rankingAfter.compareWith(rankingBefore));

	}
}
