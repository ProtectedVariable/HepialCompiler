package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;
import ch.hepia.IL.tcp.types.Type;

public class Idf extends Expression {

	private String name;
	private Type type;
	
	public Idf(String name) {
		this.name = name;
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}

	@Override
	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

}
