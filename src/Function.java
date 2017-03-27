import java.util.List;

public class Function extends SymbolHEPIAL{
	private List<Type> params;
	private Type returnType;

	public Function (String name, List<Type> params, Type returnType) {
		super(name);
		this.params = params;
		this.returnType = returnType;
	}
}
