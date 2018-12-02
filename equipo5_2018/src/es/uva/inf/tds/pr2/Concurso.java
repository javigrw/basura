package es.uva.inf.tds.pr2;

import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

/**
 * Concurso of elements of the same type. Nominations have a fixed top limit
 * 
 * @author raumedi
 * @author javguti
 *
 * @param <Element>
 */
public class Concurso<Element> {
	
	protected boolean closedNominations;
	protected boolean closedVotations;
	protected int nominationsLimit;
	protected int nominationsBottomLimit;
	protected int votesBottomLimit;
	protected Set<Element> nominations;
	protected Hashtable<Element, Integer> votes;

	/**
	 * Creates a new Concurso with an upper limit of nominated elements and a botton
	 * limit of elements needed to close a nomination phase and voting phase.
	 * 
	 * @param nominationsLimit
	 * @throws IllegalArgumentException if {@code nominationsLimit < nominationsBottomLimit}
	 * @throws IllegalArgumentException if {@code votesBottomLimit <= 1}
	 * @throws IllegalArgumentException if {@code nominationsBottomLimit <= 1}
	 */
	public Concurso(int nominationsLimit, int nominationsBottomLimit, int votesBottomLimit) {
		// TODO not implemented yet FAKE IMPLEMENTATION
		votes = new Hashtable<>();
		nominations = new HashSet<>();
	}

	/**
	 * Adds a new nominated element to the Concurso. You cannot nominate new
	 * elements after the nominations limit heen reached.
	 * 
	 * @param element
	 *            that not exists in the Concurso already
	 * @throws IllegalArgumentException if element is already nominated or element is null
	 * @throws IllegalStateException if nominations are closed
	 */
	public void nominate(Element element) {
		// TODO Auto-generated method stub

	}

	/**
	 * Adds a set of nominated elements to the Concurso.
	 * 
	 * @param elements
	 *            that not exists in the Concurso already
	 * @throws IllegalArgumentException if any element of elements is already nominated or is null
	 * @throws IllegalStateException if nominations are closed
	 */
	public void nominate(Element[] elements) {
		// TODO not implemented yet
	}

	/**
	 * Close the nominations phase, and votes phase starts.
	 * 
	 * @throws IllegalStateException if minimum of nominated elements is not reached
	 * @throws IllegalStateException if nomination are already closed
	 * 
	 */
	public void closeNominations() {
		// TODO Auto-generated method stub

	}

	/**
	 * Votes an element as a user.
	 * 
	 * @param identifier
	 *            a user that didn't vote yet
	 * @param element
	 *            a nominated element of this Concurso
	 * @throws IllegalArgumentException if identifier is less than zero or null
	 * @throws IllegalArgumentException if element is null
	 * @throws IllegalStateException if nominations are open
	 * @throws IllegalStateException if votations are closed
	 * @throws IllegalStateException if identifier has already voted
	 */
	public void vote(int identifier, Element element) {
		// TODO Auto-generated method stub

	}

	/**
	 * Close the votations phase.Nominations phase has to be ended first. Can not
	 * return from this state.
	 * 
	 * @throws IllegalStateException if minimum number of votes is not reached
	 * @throws IllegalStateException if votations are already closed
	 */
	public void closeVotations() {
		// TODO Auto-generated method stub

	}

	/**
	 * Return a ranking of nominated elements, all the elements appears in the
	 * ranking. First position will be for the element with more votes. Nominations
	 * phase has to be ended first.
	 * 
	 * @return ranking with all the elements of this Concurso.
	 * @throws IllegalStateException if votations or nominations are open.
	 */
	public Ranking<Element> getRanking() {
		// TODO Auto-generated method stub FAKE IMPLEMENTATION
		String [] fakeElements = {"","","","","","","","","",""};
		return new Ranking(fakeElements);
	}

	/**
	 * Return a ranking of nominated elements, the ranking contains as much elements
	 * as its size. First position will be for the element with more votes.
	 * Nominations phase has to be ended first.
	 * 
	 * @param rankingSize size of the ranking
	 * @return ranking with elements of this Concurso.
	 * @throws IllegalStateException if votations or nominations are open.
	 */
	public Ranking<Element> getRanking(int rankingSize) {
		// TODO Auto-generated method stub FAKE IMPLEMENTATION
		String [] fakeElements = {"","","","","","","","","",""};
		return new Ranking(fakeElements);
	}
}
