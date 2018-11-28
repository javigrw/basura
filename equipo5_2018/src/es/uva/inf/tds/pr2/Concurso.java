package es.uva.inf.tds.pr2;

import java.util.Set;

/**
 * Concurso of elements of the same type. There is a bottom limit of votes and
 * nominations, so is a top limit of nominated elements. Bottom limit is 1/3 of
 * top limit.
 * 
 * @author raumedi
 *
 * @param <Element>
 */
public class Concurso<Element> {
	protected int nominationsLimit;
	protected int votesLimit;
	protected Set<Element> nominations;

	/**
	 * Creates a new Concurso with a top limit of nominated elements and a botton
	 * limit of elements needed to close a nomination phase and voting phase.
	 * 
	 * @param nominationsLimit
	 */
	public Concurso(int nominationsLimit) {
		// TODO not implemented yet
	}

	/**
	 * Adds a new nominated element to the Concurso. You cannot nominate new
	 * elements after the nominations limit has been reached.
	 * 
	 * @param element
	 *            that not exists in the Concurso already
	 */
	public void nominate(Element element) {
		// TODO Auto-generated method stub

	}

	/**
	 * Adds a set of nominated elements to the Concurso.
	 * 
	 * @param elements
	 *            that not exists in the Concurso already
	 */
	public void nominate(Element[] elements) {
		// TODO not implemented yet
	}

	/**
	 * Close the nominations phase, and votes phase starts.
	 */
	public void closeNominations() {
		// TODO Auto-generated method stub

	}
}
