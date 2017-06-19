package ch.hepia.IL.tcp.tree;

/**Class QualifiedCall
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Unused class
 */
public class QualifiedCall extends Call {

	private Expression reciever;
	
	public QualifiedCall(int line, Expression reciever, Idf idf, EffectiveParameters parameters) {
		super(line, idf, parameters);
		this.reciever = reciever;
	}	
	
	public QualifiedCall(int line, Expression reciever, Idf idf) {
		super(line, idf);
		this.reciever = reciever;
	}
	
	@Override
	public String toString() {
		return "Qualified call to "+reciever;
	}
	
}
