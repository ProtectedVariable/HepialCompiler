package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;

public class Idf extends Expression {

	private String name;
	
	public Idf(String name) {
		this.name = name;
	}

	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
