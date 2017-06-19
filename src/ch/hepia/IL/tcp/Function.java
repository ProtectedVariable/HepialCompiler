package ch.hepia.IL.tcp;

/**Class Function
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 *
 * Class representing a function in hepial
 */

import java.util.ArrayList;
import java.util.List;

import ch.hepia.IL.tcp.types.Type;

public class Function extends SymbolHEPIAL{
	
	private final List<Type> params;
	private final List<String> pnames;

	public Function (Type returnType, int line) {
		super(returnType, 0, line);
		this.params = new ArrayList<>();
		this.pnames = new ArrayList<>();
	}

	public List<Type> getParams() {
		return params;
	}

	public List<String> getPnames() {
		return pnames;
	}
}
