package ch.hepia.IL.tcp.types;

public class BoolType extends Type {

	private static BoolType instance;
	
	private BoolType() {}
	
	public static BoolType getInstance() {
		if(instance == null) instance = new BoolType();
		return instance;
	}
	
	@Override
	public boolean isValid(Type other) {
		return other instanceof BoolType;
	}
	
	public String toString() {
		return "BOOLEAN";
	}

}
