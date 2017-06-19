package ch.hepia.IL.tcp.tree;

/**Class Relation
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Parent to all relation (comparison) between two elements
 */
public abstract class Relation extends Binary {

	public Relation(Expression left, Expression right) {
		super(left, right);
	}

}
