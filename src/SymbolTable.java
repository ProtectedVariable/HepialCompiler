import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
	private static SymbolTable instance = null;

	private Map<Entry, SymbolHEPIAL> table;
	private Stack<Integer> blocs;
	private int nextBloc = 0;

	private SymbolTable() {
		this.enterBlock();
		this.table = new HashMap<>();
	}

	public static SymbolTable getInstance() {
		if (instance == null) {
			instance = new SymbolTable();
		}
		return instance;
	}
	
	public void add(Entry e, SymbolHEPIAL s) {
		if(identify(e) == null) throw new RuntimeException("double declaration");
		this.table.put(e, s);
	}
	
	public SymbolHEPIAL identify(Entry e) {
		return table.get(e);
	}
	
	public void enterBlock() {
		this.blocs.push(nextBloc);
		nextBloc++;
	}
	
	public void exitBlock() {
		this.blocs.pop();
	}
	
	public int getBloc() {
		return blocs.peek();
	}
}
