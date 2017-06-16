package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;

public class Inferior extends Relation {

	public Inferior(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

	@Override
	public String toString() {
		return left+" < "+right;
	}
	
}
