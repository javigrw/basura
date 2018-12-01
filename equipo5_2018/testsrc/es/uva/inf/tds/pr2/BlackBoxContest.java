package es.uva.inf.tds.pr2;


import static org.junit.Assert.assertArrayEquals;
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
	public void testInitNominationsLimitLessThanZero() {
		Concurso<String> contest = new Concurso<>(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitNominationsLimitZero() {
		Concurso<String> contest = new Concurso<>(0);
	}
	
	@Test
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
		assertEquals(4, contest.nominations.size());
		for(String s : elements) {
			assertTrue(contest.nominations.contains(s));
		}
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
		assertEquals(1, contest.nominations.size());
		contest.nominate(element);
		assertTrue(contest.nominations.contains(element));
		
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
	
	@Test(expected = IllegalStateException.class)
	public void testCloseNominationsWithoutElements() {
		Concurso<String> contest = new Concurso<>(10);
		contest.closeNominations();
	}
	
	@Test
	public void testCloseNominations() {
		Concurso<String> contest = new Concurso<>(10);
		contest.closeNominations();
		String[] elements = {"top1","top2","top3","top4"};
		contest.nominate(elements);
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
	
	@Test(expected = IllegalArgumentException.class)
	public void testVoteLessThanZeroIdentifier() {
		Concurso<String> contest = new Concurso<>(10);
		String[] elements = {"top1","top2","top3","top4"};
		contest.nominate(elements);	
		contest.closeNominations();
		contest.vote(-1, "top1");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVoteWithoutElementsNominated() {
		Concurso<String> contest = new Concurso<>(10);
		contest.vote(1, "top");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVoteNullIdentifier() {
		Concurso<String> contest = new Concurso<>(10);
		String[] elements = {"top1","top2","top3","top4"};
		contest.nominate(elements);
		contest.closeNominations();
		contest.vote((Integer) null, "top4");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVoteNullElement() {
		Concurso<String> contest = new Concurso<>(10);
		String[] elements = {"top1","top2","top3","top4"};
		contest.nominate(elements);	
		contest.closeNominations();
		contest.vote(2, null);
	}
	
	public void testVote() {
		Concurso<String> contest = new Concurso<>(10);
		String[] elements = {"top1","top2","top3","top4"};
		contest.nominate(elements);
		contest.closeNominations();
		contest.vote(1, "top3");
		assertEquals((int)1, (int)contest.votes.get("top3"));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testVoteWithNominationsOpen() {
		Concurso<String> contest = new Concurso<>(10);
		String[] elements = {"top1","top2","top3","top4"};
		contest.nominate(elements);	
		contest.vote(1, "top3");
		assertEquals((int)1, (int)contest.votes.get("top3"));
	}
	
	
	
	
	
	
}
