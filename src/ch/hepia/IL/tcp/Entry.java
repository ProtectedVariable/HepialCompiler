package ch.hepia.IL.tcp;

/**Class Entry
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 *
 * Class representing an entry in the symbol table
 */

public class Entry {

	protected String identifier;
	
	public Entry(String ident) {
		this.identifier = ident;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Entry) {
			return this.identifier.equals(((Entry)obj).identifier);
		}
		return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		return identifier.hashCode();
	}
}
