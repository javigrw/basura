package es.uva.inf.tds.pr2;

/**
 * Ranking of ordered elements of the same type. Default ranking is a top 10. El
 * ranking no podrá ser modificado una vez creado.
 * 
 * @author raumedi
 *
 * @param <Element>
 *            Elements of the ranking
 */
public class Ranking<Element> {

	protected final Element[] top;

	/**
	 * Creates a top 10 ranking from an array of elements. The order in the array
	 * will match the positions at the ranking. rankData[0] will be top 1
	 * rankData[9] will be top 10. If there are less elements than 10, the ranking
	 * will be filled with null elements
	 * 
	 * @param rankData
	 *            array with size of 10
	 */
	public Ranking(Element[] rankData) {
		// TODO not implemented yet FAKE IMPL
		top = null;
	}

	/**
	 * Creates a top ranking with variable size from an array of elements. The order
	 * in the array will match the position at the ranking. rankData[0] will be top
	 * 1 rankData[9] will be top 10. If there are less elements than topSize, the
	 * ranking will be filled with null elements
	 * 
	 * @param rankData
	 *            array of elements
	 * @param topSize
	 *            can be equal or bigger than rankData size
	 */
	public Ranking(Element[] rankData, int topSize) {
		// TODO not implemented yet
		top = null;
	}

	/**
	 * Returns the element at the ranking position desired or null if there is no
	 * element at that position.
	 * 
	 * @param position can not be greater than the ranking size
	 * @return element at the ranking position
	 */
	public Element getElementByPosition(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Returns the position of the element or null if there is no element with that
	 * values. If there are multiple elements with the same values, the returned one
	 * is the highest position at the top.
	 * 
	 * @param element
	 * @return position the position of the element at the ranking
	 */
	public int getPositionFromElementValue(Element element) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns the position of the element
	 * 
	 * @param element
	 * @return position the position of the element at the ranking
	 */
	public int getPositionFromElementReference(Element element) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * Returns true if an element with the same value exists at the ranking
	 * 
	 * @param element
	 * @return
	 */
	public boolean existsValue(Element element) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns true if the specific element exists at the ranking
	 * 
	 * @param element
	 * @return
	 */
	public boolean existsReference(Element element) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Returns an array that shows gained or lost positions regarding another
	 * ranking rankings. If an element leaves the ranking and is not replaced, the
	 * differences in positions is 0 E.g(target {A,B,C,D} This {C,A,B,D} Differences
	 * {2,-1,-1,0} )
	 * 
	 * @param targetRanking
	 * @return array that shows gained or lost positions between two rankings
	 */
	public int[] compareWith(Ranking<Element> targetRanking) {
		// TODO Auto-generated method stub
		return null;
	}
}
