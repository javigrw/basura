package es.uva.inf.tds.pr2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(BlackBoxTestFirst.class)
public class BlackBoxRankingWithWrappers {

	private static Integer[] elements;
	private static Ranking<Integer> ranking;

	@Before
	public void initialize() {
		Integer[] initializer = { 1, 2, 3, 4 };
		elements = initializer;
		ranking = new Ranking<>(elements);
	}

	@Test
	public void testRankingElementUnder() {
		Integer[] expected = { 1, 2, 3, 4, null, null, null, null, null, null };

		assertArrayEquals(expected, ranking.top);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRankingDefaultOver() {
		Integer[] elements = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11 };
		@SuppressWarnings("unused")
		Ranking<Integer> ranking = new Ranking<>(elements);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRankingDefaultEmpty() {
		Integer[] elements = {};
		@SuppressWarnings("unused")
		Ranking<Integer> ranking = new Ranking<>(elements);
	}

	@Test(expected = NullPointerException.class)
	public void testRankingDefaultNull() {
		@SuppressWarnings("unused")
		Ranking<Integer> ranking = new Ranking<>(null);
	}

	@Test
	public void testRankingCustomUnder() {
		Ranking<Integer> ranking = new Ranking<>(elements, 5);
		Integer[] expected = { 1, 2, 3, 4, null };

		assertArrayEquals(expected, ranking.top);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRankingCustomOver() {
		@SuppressWarnings("unused")
		Ranking<Integer> ranking = new Ranking<>(elements, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRankingCustomEmpty() {
		Integer[] elements = {};
		@SuppressWarnings("unused")
		Ranking<Integer> ranking = new Ranking<>(elements, 3);
	}

	@Test(expected = NullPointerException.class)
	public void testRankingCustomNull() {
		@SuppressWarnings("unused")
		Ranking<Integer> ranking = new Ranking<>(null, 7);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testRankingCustomInvalidSize() {
		@SuppressWarnings("unused")
		Ranking<Integer> ranking = new Ranking<>(elements, 0);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetElementByPositionOver() {
		Ranking<Integer> ranking = new Ranking<>(elements, 4);
		ranking.getElementByPosition(5);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetElementByPositionUnder() {
		Ranking<Integer> ranking = new Ranking<>(elements, 4);
		ranking.getElementByPosition(-1);
	}

	@Test(expected = NullPointerException.class)
	public void testGetPositionFromNullElementValue() {

		ranking.getPositionFromElementValue(null);
	}

	@Test
	public void testGetPositionFromNonexistentElementValue() {

		int location = ranking.getPositionFromElementValue(5);

		assertEquals(0, location);
	}

	@Test(expected = NullPointerException.class)
	public void testGetPositionFromElementReference() {
		ranking.getPositionFromElementReference(null);
	}

	@Test
	public void testGetPositionFromElementSameValueDiffReference() {
		Integer sameValueReference = 1;
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
		Integer[] smallElementsList = { 1, 2, 3 };
		Ranking<Integer> smallRanking = new Ranking<>(smallElementsList, 3);

		ranking.compareWith(smallRanking);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCompareWithBiggerSize() {
		Integer[] bigElementsList = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11 };
		Ranking<Integer> bigRanking = new Ranking<>(bigElementsList, 11);

		ranking.compareWith(bigRanking);
	}

}
