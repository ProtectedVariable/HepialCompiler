public class Variable extends SymbolHEPIAL {
	private Type type;

	public Variable (Type type, int bloc, int line) {
		super(bloc, line);
		this.type = type;
	}
}
