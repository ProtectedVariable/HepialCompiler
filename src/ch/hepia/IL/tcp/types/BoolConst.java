package ch.hepia.IL.tcp.types;

public class BoolConst extends Const {

//	private final boolean VALUE;
	
	public BoolConst(int bloc, int line) {
		super(BoolType.getInstance(), bloc, line);
//		this.VALUE = value;
	}
/*
	public boolean getVALUE() {
		return VALUE;
	}
*/
	public String toString() {
		return "BOOLEAN";
	}
}
