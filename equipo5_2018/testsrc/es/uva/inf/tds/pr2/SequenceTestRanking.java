package es.uva.inf.tds.pr2;

import static org.junit.Assert.*;

import org.junit.Test;


import org.junit.experimental.categories.Category;

@Category(Sequence.class)
public class SequenceTestRanking {

	@Test
	public void test() {
		
		String[] topos = new String[]{"raulillo","bimbas","ase el humilde","antooro","agapito","papito mi rey","yorx","cachi"};
		
		Ranking<String> rank = new Ranking<>(topos, 3);
		
		assertNotNull(rank);
		
		for(String topo : topos) {
			assertTrue(rank.existsValue(topo));
		}
		
		String[] otrosTopos = new String[]{"antooro","agapito","papito mi rey","yorx","raulillo","bimbas","ase el humilde","cachi"};
		Ranking<String> rank2 = new Ranking<>(otrosTopos, 3);
		
		
		assertEquals(1,rank.getPositionFromElementValue("raulillo"));
		
		int[] diff = rank.compareWith(rank2);
		assertNotNull(diff);
		
		int[] realDiff = new int[] {4,4,4,-3,-3,-3,-3,0};
		
		for(int i = 0; i < realDiff.length; i++) {
			
			assertEquals(realDiff[i], diff[i]);
			
		}
		
		
	}

}
