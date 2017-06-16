package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;

public class Equal extends Relation {

	public Equal(Expression left, Expression right) {
		super(left, right);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object accept(Visitor v) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return left+" == "+right;
	}

}
