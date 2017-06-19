package ch.hepia.IL.tcp.types;

/**Class BoolType
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 *
 * Class representing a boolean in hepial
 */

public class BoolType extends Type {

	private static BoolType instance;
	
	private BoolType() {}
	
	public static BoolType getInstance() {
		if(instance == null) instance = new BoolType();
		return instance;
	}
	
	@Override
	public boolean isValid(Type other) {
		return other instanceof BoolType;
	}
	
	public String toString() {
		return "BOOLEAN";
	}

}
