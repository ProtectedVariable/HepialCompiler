package ch.hepia.IL.tcp.tree;

import java.util.ArrayList;
import java.util.List;

import ch.hepia.IL.tcp.code.Visitor;
import ch.hepia.IL.tcp.types.ArrayType;
import ch.hepia.IL.tcp.types.Type;

public class ArrayAccess extends Expression {

	private Idf array;
	private List<Expression> access;
	
	
	public ArrayAccess(Idf array, List<Expression> access) {
		this.array = array;
		this.access = new ArrayList<>();
		this.access.addAll(access);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

	@Override
	public Type getType() {
		return ((ArrayType)array.getType()).getType();
	}
	
	@Override
	public String toString() {
		return array.getName()+access.toString();
	}

	public Idf getArray() {
		return array;
	}

	public List<Expression> getAccess() {
		return access;
	}

}
