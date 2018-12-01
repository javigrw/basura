package es.uva.inf.tds.pr2;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(BlackBoxTestFirst.class)
public class BlackBoxContest {
	

	@Test(expected = IllegalArgumentException.class)
	public void testInitNominationsLimitUnderZero() {
		Concurso<String> contest = new Concurso<>(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitNominationsLimitZero() {
		Concurso<String> contest = new Concurso<>(0);
	}
	
	public void testInitContest() {
		Concurso<String> contest = new Concurso<>(10);
		assertNotNull(contest);
		assertEquals(10, contest.nominationsLimit);
		assertFalse(contest.closedVotations);
		assertFalse(contest.closedNominations);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNominateNullElements() {
		Concurso<String> contest = new Concurso<>(10);
		String[] elements = null;
		contest.nominate(elements);
	}
	
	@Test
	public void testNominateElements() {
		Concurso<String> contest = new Concurso<>(10);
		String[] elements = {"top1","top2","top3","top4"};
		contest.nominate(elements);		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNominateNullElement() {
		Concurso<String> contest = new Concurso<>(10);
		String element = null;
		contest.nominate(element);
	}
	
	@Test
	public void testNominateElement() {
		Concurso<String> contest = new Concurso<>(10);
		String element = "top";
		contest.nominate(element);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNominateSameElement() {
		Concurso<String> contest = new Concurso<>(10);
		String element = "repetido";
		contest.nominate(element);
		contest.nominate(element);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNominateSameElements() {
		Concurso<String> contest = new Concurso<>(10);
		String[] elements = {"top1","top2","top3","top4"};
		contest.nominate(elements);
		contest.nominate(elements);
	}
	
	@Test
	public void testCloseNominations() {
		Concurso<String> contest = new Concurso<>(10);
		contest.closeNominations();
		assertTrue(contest.closedNominations);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testNominateElementAfterClosedNominations() {
		Concurso<String> contest = new Concurso<>(10);
		String element = "top";
		contest.nominate(element);
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void testNominateElementsAfterClosedNominations() {
		Concurso<String> contest = new Concurso<>(10);
		String[] element = {"top1","top2","top3","top4"};
		contest.nominate(element);
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void testCloseNominationsAlreadyClosed() {
		Concurso<String> contest = new Concurso<>(10);
		contest.closeNominations();
		contest.closeNominations();
	}
	
	
	
	
	
	
	
	
}
