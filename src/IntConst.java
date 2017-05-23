
public class IntConst extends Const {

	private final int VALUE;
	
	protected IntConst(Type t, int bloc, int line, int value) {
		super(t, bloc, line);
		this.VALUE = value;
	}

	public int getVALUE() {
		return VALUE;
	}

}
