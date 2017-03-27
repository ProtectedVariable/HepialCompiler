public class Variable extends SymbolHEPIAL {
	private Type type;

	public Variable (String name, Type type) {
		super(name);
		this.type = type;
	}
}
