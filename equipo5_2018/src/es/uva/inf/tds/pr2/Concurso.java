package es.uva.inf.tds.pr2;

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

	/**
	 * Creates a new Concurso with a top limit of nominated elements and a botton
	 * limit of elements needed to close a nomination phase and voting phase.
	 * 
	 * @param nominationsLimit
	 */
	public Concurso(int nominationsLimit) {
		// TODO not implemented yet
	}
}
