public class Variable extends Symbol {
	private Type type;

	public Variable (String name, Type type) {
		super(name);
		this.type = type;
	}
}
