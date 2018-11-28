package es.uva.inf.tds.pr2;

import static org.junit.Assert.*;

import org.junit.Test;

public class ConcursoTest {

	@Test
	public void testConcurso() {
		int nominationsLimit = 10;
		Concurso<String> concurso = new Concurso<>(nominationsLimit);
		
		assertNotNull(concurso.nominationsLimit);
		assertNotNull(concurso.votesLimit);
		assertEquals(nominationsLimit, concurso.nominationsLimit);
		assertEquals((int)(nominationsLimit/3), concurso.votesLimit);
	}
	
	@Test
	public void testNominate() {
		String element = "nominatedElement";
		Concurso<String> concurso = new Concurso<>(3);
		
		concurso.nominate(element);
		
		assertTrue(concurso.nominations.contains(element));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDupedNominate() {
		String element = "nominatedElement";
		Concurso<String> concurso = new Concurso<>(3);
		concurso.nominate(element);
		concurso.nominate(element);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testFullNominationsNominate() {
		String element = "nominatedElement";
		String element2 = "anotherNomination";
		String element3 = "finalNomination";
		String element4 = "notAllowedNomination";
		Concurso<String> concurso = new Concurso<>(3);
		concurso.nominate(element);
		concurso.nominate(element2);
		concurso.nominate(element3);
		concurso.nominate(element4);
	}
	

}
