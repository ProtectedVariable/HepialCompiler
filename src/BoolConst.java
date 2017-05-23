
public class BoolConst extends Const {

	private final boolean VALUE;
	
	protected BoolConst(Type t, int bloc, int line, boolean value) {
		super(t, bloc, line);
		this.VALUE = value;
	}

	public boolean getVALUE() {
		return VALUE;
	}

}
