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

}
