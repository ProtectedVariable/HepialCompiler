import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
	private static SymbolTable instance = null;

	private Stack<Map<Entry, SymbolHEPIAL>> block;

	private SymbolTable() {
		this.block = new Stack<>();
		this.block.push(new HashMap<>());
	}

	public static SymbolTable getInstance() {
		if (instance == null) {
			instance = new SymbolTable();
		}
		return instance;
	}
	
	public void add(Entry e, SymbolHEPIAL s) {
		if(identify(e) == null) throw new RuntimeException("double declaration");
		this.block.peek().put(e, s);
	}
	
	public SymbolHEPIAL identify(Entry e) {
		for (Map<Entry, SymbolHEPIAL> map : block) {
			if(map.get(e) != null) map.get(e);
		}
		return null;
	}
	
	public void enterBlock() {
		this.block.push(new HashMap<>());
	}
	
	public void exitBlock() {
		this.block.pop();
	}
}
