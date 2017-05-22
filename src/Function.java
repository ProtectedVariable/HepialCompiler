import java.util.List;

public class Function extends SymbolHEPIAL{
	private List<Type> params;
	private Type returnType;

	public Function (List<Type> params, Type returnType, int bloc, int line) {
		super(bloc, line);
		this.params = params;
		this.returnType = returnType;
	}
}
