package es.uva.inf.tds.pr2;

public class ConcursoTestDeSecuencia {

	public void test1 () {
		
		Concurso<String> contest = new Concurso<String>(15,5,20);
		
		String[] topos = new String[]{"raulillo","bimbas","ase el humilde","antooro","agapito","papito mi rey","yorx","cachi"};
		
		contest.nominate(topos);
		
		contest.closeNominations();
		
		for(int i = 1; i<101; i++) {
			contest.vote(i, "raulillo");
			
		}
		for(int i = 101; i<151; i++) {
			contest.vote(i, "ase el humilde");
			
		}
		for(int i = 151; i<171; i++) {
			contest.vote(i, "agapito");
			
		}
		
		
		
		Ranking<String> masTopos = contest.getRanking(3);
		
		System.out.println("Felicidades, el más topo es : " + masTopos.getElementByPosition(1));
		
		
	}
	
}
