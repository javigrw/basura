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
	
	private static String[] elements;
	private static String element;
	private static Concurso<String> contest;
	
	
	@Before
	public void initialize() {
		String[] initializer = { "top1", "top2", "top3", "top4" };
		elements = initializer;
		element = "top";
		contest = new Concurso<>(10);
	}

	

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
		assertNotNull(contest);
		assertEquals(10, contest.nominationsLimit);
		assertFalse(contest.closedVotations);
		assertFalse(contest.closedNominations);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNominateNullElements() {
		String[] elements = null;
		contest.nominate(elements);
	}
	
	@Test
	public void testNominateElements() {
		contest.nominate(elements);
		assertEquals(4, contest.nominations.size());
		for(String s : elements) {
			assertTrue(contest.nominations.contains(s));
		}
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNominateNullElement() {
		String element = null;
		contest.nominate(element);
	}
	
	@Test
	public void testNominateElement() {
		assertEquals(1, contest.nominations.size());
		contest.nominate(element);
		assertTrue(contest.nominations.contains(element));
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNominateSameElement() {
		contest.nominate(element);
		contest.nominate(element);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNominateSameElements() {
		contest.nominate(elements);
		contest.nominate(elements);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testCloseNominationsWithoutElements() {
		contest.closeNominations();
	}
	
	@Test
	public void testCloseNominations() {
		contest.nominate(elements);
		contest.closeNominations();
		assertTrue(contest.closedNominations);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testNominateElementAfterClosedNominations() {
		contest.nominate(element);
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void testNominateElementsAfterClosedNominations() {
		contest.nominate(elements);
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void testCloseNominationsAlreadyClosed() {
		contest.closeNominations();
		contest.closeNominations();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVoteLessThanZeroIdentifier() {
		contest.nominate(elements);	
		contest.closeNominations();
		contest.vote(-1, "top1");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVoteWithoutElementsNominated() {
		contest.vote(1, "top");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVoteNullIdentifier() {
		contest.nominate(elements);
		contest.closeNominations();
		contest.vote((Integer) null, "top4");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testVoteNullElement() {
		contest.nominate(elements);	
		contest.closeNominations();
		contest.vote(2, null);
	}
	
	@Test
	public void testVote() {
		contest.nominate(elements);
		contest.closeNominations();
		contest.vote(1, "top3");
		assertEquals((int)1, (int)contest.votes.get("top3"));
	}
	
	@Test(expected = IllegalStateException.class)
	public void testVoteWithNominationsOpen() {
		contest.nominate(elements);	
		contest.vote(1, "top3");
		assertEquals((int)1, (int)contest.votes.get("top3"));
	}
	
	
	
	
	
	
}
