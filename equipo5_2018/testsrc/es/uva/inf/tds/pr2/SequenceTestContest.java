package es.uva.inf.tds.pr2;

import static org.junit.Assert.*;

import org.junit.Test;


import org.junit.experimental.categories.Category;

@Category(Sequence.class)
public class SequenceTestContest {

	@Test
	public void test() {
		Concurso<String> contest = new Concurso<String>(15,5,20);
		
		assertNotNull(contest);
		assertEquals(15,contest.nominationsLimit);
		assertEquals(5,contest.nominationsBottomLimit);
		assertEquals(20, contest.votesBottomLimit);
		assertFalse(contest.closedNominations);
		assertFalse(contest.closedVotations);
		
		String[] topos = new String[]{"raulillo","bimbas","ase el humilde","antooro","agapito","papito mi rey","jamon yorx","cachi"};
		
		contest.nominate(topos);
		
		contest.closeNominations();
		assertTrue(contest.closedNominations);
		
		for(int i = 1; i<101; i++) {
			contest.vote(i, "raulillo");
			
		}
		for(int i = 101; i<151; i++) {
			contest.vote(i, "ase el humilde");
			
		}
		for(int i = 151; i<171; i++) {
			contest.vote(i, "agapito");
			
		}
		
		contest.closeVotations();
		assertTrue(contest.closedVotations);
		
		
		Ranking<String> masTopos = contest.getRanking(3);
		
		assertNotNull(masTopos);
	}

}
