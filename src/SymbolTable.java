import java.util.HashSet;

public class SymbolTable {
	private static SymbolTable instance = null;
	private HashSet<Symbol> map;

	private SymbolTable () {
	}

	public static SymbolTable getInstance () {
		if (instance == null){
			instance = new SymbolTable();
		}
		return instance;
	}
}
