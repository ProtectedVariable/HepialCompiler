package ch.hepia.IL.tcp;

/**Class Variable
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 *
 * Class representing a variable symbol
 */

import ch.hepia.IL.tcp.types.Type;

public class Variable extends SymbolHEPIAL {

	public Variable (Type type, int bloc, int line) {
		super(type, bloc, line);
	}
}
