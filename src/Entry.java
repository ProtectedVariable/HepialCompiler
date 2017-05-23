
public class Entry {

	protected String identifier;
	
	protected Entry(String ident) {
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
