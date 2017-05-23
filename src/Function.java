import java.util.List;

public class Function extends SymbolHEPIAL{
	private List<Type> params;

	public Function (List<Type> params, Type returnType, int line) {
		super(returnType, 0, line);
		this.params = params;
	}
}
