package ch.hepia.IL.tcp.tree;

/**Class Instruction
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 * 
 * Parent to all possible instruction in the language
 */
public abstract class Instruction implements AbstractTree {

	protected int line;

	public Instruction(int line) {
		this.line = line;
	}

	public int getLine() {
		return line;
	}
	
}
