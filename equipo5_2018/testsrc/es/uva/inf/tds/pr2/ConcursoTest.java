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

}
