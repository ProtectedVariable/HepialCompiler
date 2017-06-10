package ch.hepia.IL.tcp.types;

public class IntType extends Type {

	private static IntType instance;
	
	private IntType() {}
	
	public static IntType getInstance() {
		if(instance == null) instance = new IntType();
		return instance;
	}
	
	@Override
	public boolean isValid(Type other) {
		return other instanceof IntType;
	}
	
	@Override
	public String toString() {
		return "INTEGER";
	}
	
}
