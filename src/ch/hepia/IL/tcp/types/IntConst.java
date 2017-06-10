package ch.hepia.IL.tcp.types;
public class IntConst extends Const {

	//private final int VALUE;
	
	public IntConst(int bloc, int line) {
		super(IntType.getInstance(), bloc, line);
	}
/*
	public int getVALUE() {
		return VALUE;
	}
*/
	public String toString() {
		return "INTEGER";
	}
	
}
