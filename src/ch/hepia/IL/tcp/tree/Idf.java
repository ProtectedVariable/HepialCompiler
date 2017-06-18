package ch.hepia.IL.tcp.tree;

import java.util.List;

import ch.hepia.IL.tcp.code.Visitor;
import ch.hepia.IL.tcp.types.Type;

public class Idf extends Expression {

	private String name;
	private Type type;
	private List<Expression> access;
	
	private int local;
	
	public Idf(String name) {
		this.name = name;
		this.local = -1;
	}
	
	public Idf(String name, List<Expression> access) {
		this.name = name;
		this.local = -1;
		this.access = access;
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

	public int getLocal() {
		return local;
	}

	public void setLocal(int local) {
		this.local = local;
	}

}
