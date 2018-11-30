package es.uva.inf.tds.pr2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BlackBoxRanking {

	private static String[] elements;
	private static Ranking<String> ranking;

	@Before
	public void initialize() {
		String[] initializer = { "top1", "top2", "top3", "top4" };
		elements = initializer;
		ranking = new Ranking<>(elements);
	}

	@Test
	public void testRankingElementUnder() {
		String[] expected = { "top1", "top2", "top3", "top4", null, null, null, null, null, null };

		assertArrayEquals(expected, ranking.top);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRankingDefaultOver() {
		String[] elements = { "top1", "top2", "top3", "top4", "top5", "top6", "top7", "top8", "top9", "top10",
				"top11" };
		@SuppressWarnings("unused")
		Ranking<String> ranking = new Ranking<>(elements);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRankingDefaultEmpty() {
		String[] elements = {};
		@SuppressWarnings("unused")
		Ranking<String> ranking = new Ranking<>(elements);
	}

	@Test(expected = NullPointerException.class)
	public void testRankingDefaultNull() {
		@SuppressWarnings("unused")
		Ranking<String> ranking = new Ranking<>(null);
	}

	@Test
	public void testRankingCustomUnder() {
		Ranking<String> ranking = new Ranking<>(elements, 5);
		String[] expected = { "top1", "top2", "top3", "top4", null };

		assertArrayEquals(expected, ranking.top);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRankingCustomOver() {
		@SuppressWarnings("unused")
		Ranking<String> ranking = new Ranking<>(elements, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRankingCustomEmpty() {
		String[] elements = {};
		@SuppressWarnings("unused")
		Ranking<String> ranking = new Ranking<>(elements, 3);
	}

	@Test(expected = NullPointerException.class)
	public void testRankingCustomNull() {
		@SuppressWarnings("unused")
		Ranking<String> ranking = new Ranking<>(null, 7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRankingCustomInvalidSize() {
		@SuppressWarnings("unused")
		Ranking<String> ranking = new Ranking<>(elements, 0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetElementByPositionOver() {
		Ranking<String> ranking = new Ranking<>(elements, 4);
		ranking.getElementByPosition(5);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetElementByPositionUnder() {
		Ranking<String> ranking = new Ranking<>(elements, 4);
		ranking.getElementByPosition(-1);
	}

	@Test(expected = NullPointerException.class)
	public void testGetPositionFromNullElementValue() {

		ranking.getPositionFromElementValue(null);
	}

	@Test
	public void testGetPositionFromNonexistentElementValue() {

		int location = ranking.getPositionFromElementValue("top5");

		assertEquals(0, location);
	}

	@Test(expected = NullPointerException.class)
	public void testGetPositionFromElementReference() {
		ranking.getPositionFromElementReference(null);
	}

	@Test
	public void testGetPositionFromElementSameValueDiffReference() {
		String sameValueReference = "top1";
		int location = ranking.getPositionFromElementReference(sameValueReference);
		assertEquals(0, location);
	}

	@Test(expected = NullPointerException.class)
	public void testExistsNullValue() {
		ranking.existsValue(null);
	}

	@Test(expected = NullPointerException.class)
	public void testExistsNullReference() {
		ranking.existsReference(null);
	}

	@Test(expected = NullPointerException.class)
	public void testCompareWithNull() {
		ranking.compareWith(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompareWithSmallerSize() {
		String[] smallElementsList = { "top1", "top2", "top3" };
		Ranking<String> smallRanking = new Ranking<>(smallElementsList, 3);

		ranking.compareWith(smallRanking);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompareWithBiggerSize() {
		String[] bigElementsList = { "top1", "top2", "top3", "top4", "top5", "top6", "top7", "top8", "top9", "top10",
				"top11" };
		Ranking<String> bigRanking = new Ranking<>(bigElementsList, 11);

		ranking.compareWith(bigRanking);
	}

}
