package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;

/**Class Read
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Represents a reading into a variable instruction
 */
public class Read extends Instruction {

	private Idf dest;
	
	public Read(int line, Idf dest) {
		super(line);
		this.dest = dest;
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

	public Idf getDest() {
		return dest;
	}
	
	@Override
	public String toString() {
		return "Read "+dest.getName();
	}

}
