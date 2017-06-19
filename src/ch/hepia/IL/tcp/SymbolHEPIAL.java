package ch.hepia.IL.tcp;

/**Class SymbolHEPIAL
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 *
 * Parent class representing a symbol in hepial
 */

import ch.hepia.IL.tcp.types.Type;

public abstract class SymbolHEPIAL {
	
	protected int line;
	protected Type type;
	protected int bloc;
	
	protected SymbolHEPIAL(Type t, int bloc, int line) {
		this.line = line;
		this.type = t;
		this.bloc = bloc;
	}

	public int getLine() {
		return line;
	}

	public Type getType() {
		return type;
	}

	public int getBloc() {
		return bloc;
	}
}
