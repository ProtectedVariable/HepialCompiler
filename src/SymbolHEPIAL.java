public abstract class SymbolHEPIAL {
	
	protected int line;
	protected Type type;
	protected int bloc;
	
	protected SymbolHEPIAL(Type t, int bloc, int line) {
		this.line = line;
		this.type = t;
		this.bloc = bloc;
	}
}
