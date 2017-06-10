import java.util.ArrayList;
import java.util.List;

public class Function extends SymbolHEPIAL{
	
	private final List<Type> params;

	public Function (Type returnType, int line) {
		super(returnType, 0, line);
		this.params = new ArrayList<>();
	}

	public List<Type> getParams() {
		return params;
	}
}
