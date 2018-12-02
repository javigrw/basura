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
	
	private static String[] elements;
	private static String element;
	private static Concurso<String> contest;
	
	
	@Before
	public void initialize() {
		String[] initializer = { "top1", "top2", "top3", "top4" };
		elements = initializer;
		element = "top";
		contest = new Concurso<>(10,3,5);
	}

	

	@Test(expected = IllegalArgumentException.class)
	public void testInitNominationsLimitLessThanZero() {
		@SuppressWarnings("unused")
		Concurso<String> contest = new Concurso<>(-1,5,5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitNominationsLimitZero() {
		@SuppressWarnings("unused")
		Concurso<String> contest = new Concurso<>(0,5,5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitNominationsLimitOne() {
		@SuppressWarnings("unused")
		Concurso<String> contest = new Concurso<>(1,5,5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitVotesLimitLessThanZero() {
		@SuppressWarnings("unused")
		Concurso<String> contest = new Concurso<>(5,2,-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitVotesLimitZero() {
		@SuppressWarnings("unused")
		Concurso<String> contest = new Concurso<>(5,2,0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitVotesLimitOne() {
		@SuppressWarnings("unused")
		Concurso<String> contest = new Concurso<>(5,2,1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitNominationsBottomLimitLessThanZero() {
		@SuppressWarnings("unused")
		Concurso<String> contest = new Concurso<>(5,-1,5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitNominationsBottomLimitZero() {
		@SuppressWarnings("unused")
		Concurso<String> contest = new Concurso<>(5,0,5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitNominationsBottomLimitOne() {
		@SuppressWarnings("unused")
		Concurso<String> contest = new Concurso<>(5,1,5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInitNominationsLimitLessThanBottomLimit() {
		@SuppressWarnings("unused")
		Concurso<String> contest = new Concurso<>(3,4,5);
	}
	
	
	
	@Test
	public void testInitLimitEqualsBottom () {
		Concurso<String> contest = new Concurso<>(5,5,5);
		assertNotNull(contest);
		assertEquals(5, contest.nominationsLimit);
		assertFalse(contest.closedVotations);
		assertFalse(contest.closedNominations);
		assertEquals(5, contest.votesBottomLimit);
		assertEquals(5, contest.nominationsBottomLimit);
	}
	
	@Test
	public void testInitContest() {
		assertNotNull(contest);
		assertEquals(10, contest.nominationsLimit);
		assertFalse(contest.closedVotations);
		assertFalse(contest.closedNominations);
		assertEquals(5, contest.votesBottomLimit);
		assertEquals(5, contest.nominationsBottomLimit);
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
	
	@Test(expected = IllegalStateException.class)
	public void testCloseNominationsUnderMinimum() {
		assertEquals(1, contest.nominations.size());
		contest.nominate(element);
		contest.nominate("basura");
		contest.closeNominations();
		
	}
	
	@Test(expected = IllegalStateException.class)
	public void testCloseNominateElementAlreadyFull() {
		Concurso<String> contest = new Concurso<>(4,3,5);
		assertEquals(1, contest.nominations.size());
		contest.nominate(elements);
		contest.nominate("basura");
		
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
	
	@SuppressWarnings("null")
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
	
	@Test
	public void testCloseVotations() {
		contest.nominate(elements);
		contest.closeNominations();
		contest.vote(1, "top3");
		contest.vote(2, "top3");
		contest.vote(3, "top3");
		contest.vote(4, "top3");
		contest.vote(5, "top3");
		assertEquals((int)5, (int)contest.votes.get("top3"));
		contest.closeVotations();
		assertTrue(contest.closedVotations);
	}
	
	@Test(expected = IllegalStateException.class)
	public void testVoteSameId() {
		contest.nominate(elements);
		contest.closeNominations();
		contest.vote(1, "top3");
		contest.vote(1, "top3");
	}
	
	@Test(expected = IllegalStateException.class)
	public void testCloseVotationsWithoutMinimum() {
		contest.nominate(elements);
		contest.closeNominations();
		contest.vote(1, "top3");
		contest.vote(2, "top3");
		contest.vote(3, "top3");
		contest.vote(4, "top3");
		assertEquals((int)4, (int)contest.votes.get("top3"));
		contest.closeVotations();
	}
	
	
	@Test(expected = IllegalStateException.class)
	public void testCloseVotationsAlreadyClosed() {
		contest.nominate(elements);
		contest.closeNominations();
		contest.vote(1, "top3");
		contest.vote(2, "top3");
		contest.vote(3, "top3");
		contest.vote(4, "top3");
		contest.vote(5, "top3");
		contest.closeVotations();
		contest.closeVotations();
	}
	
	
	
	
	
}
