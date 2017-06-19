package ch.hepia.IL.tcp.types;

/**Class IntType
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 *
 * Class representing an int in hepial
 */

public class IntType extends Type {

	private static IntType instance;
	
	private IntType() {}
	
	public static IntType getInstance() {
		if(instance == null) instance = new IntType();
		return instance;
	}
	
	@Override
	public boolean isValid(Type other) {
		return other instanceof IntType;
	}
	
	@Override
	public String toString() {
		return "INTEGER";
	}
	
}
