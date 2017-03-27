import java.util.HashSet;

public class SymbolTable {
	private static SymbolTable instance = null;
	private HashSet<SymbolHEPIAL> map;

	private SymbolTable () {
	}

	public static SymbolTable getInstance () {
		if (instance == null){
			instance = new SymbolTable();
		}
		return instance;
	}
}
