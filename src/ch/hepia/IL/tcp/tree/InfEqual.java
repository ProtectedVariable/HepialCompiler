package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;

public class InfEqual extends Relation {

	public InfEqual(Expression left, Expression right) {
		super(left, right);
	}

	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return left +" <= "+right;
	}

}
