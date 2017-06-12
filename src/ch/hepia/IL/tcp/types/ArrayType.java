package ch.hepia.IL.tcp.types;

public class ArrayType extends Type {

	private int[] infLimits, supLimits;
	private Type type;
	
	public ArrayType(Type type, int[] infLimits, int[] supLimits) {
		this.infLimits = infLimits;
		this.supLimits = supLimits;
		this.type = type;
	}
	
	@Override
	public boolean isValid(Type other) {
		return false;
	}

}
