import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class SymbolTable {
	private static SymbolTable instance = null;

	private Map<Entry, List<SymbolHEPIAL>> table;
	private Stack<Integer> blocs;
	private int nextBloc = 0;

	private SymbolTable() {
		this.blocs = new Stack<>();
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
		if (identify(e) == null) {
			this.table.put(e, new ArrayList<>());
		}
		for (SymbolHEPIAL sh : identify(e)) {
			System.out.println(sh.bloc+" "+s.bloc);
			if(sh.bloc <= s.bloc)
				throw new RuntimeException("Double declaration of symbol "+e.identifier);
		}
		
		this.table.get(e).add(s);
	}

	public List<SymbolHEPIAL> identify(Entry e) {
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

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Symbol Table:\n");
		for (Map.Entry<Entry, List<SymbolHEPIAL>> entry : table.entrySet()) {
			String key = entry.getKey().identifier;
			for (SymbolHEPIAL sh : entry.getValue()) {
				String value = sh.type.toString();
				if(sh instanceof Variable)
					sb.append("Variable "+key+" of type "+value+" (Block "+sh.bloc+")").append("\n");
				else if (sh instanceof Function)
					sb.append("Function "+key+" returns "+sh.type+" params ("+((Function)sh).getParams().toString()+")").append("\n");
				else if(sh instanceof Const)
					sb.append("Constant "+key+" of type "+sh.type).append("\n");
			}
		}
		return sb.toString();
	}
}
