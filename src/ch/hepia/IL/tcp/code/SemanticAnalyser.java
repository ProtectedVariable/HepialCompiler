package ch.hepia.IL.tcp.code;

import ch.hepia.IL.tcp.tree.Addition;
import ch.hepia.IL.tcp.tree.And;
import ch.hepia.IL.tcp.tree.Assignment;
import ch.hepia.IL.tcp.tree.Binary;
import ch.hepia.IL.tcp.tree.BitNot;
import ch.hepia.IL.tcp.tree.Block;
import ch.hepia.IL.tcp.tree.Call;
import ch.hepia.IL.tcp.tree.Condition;
import ch.hepia.IL.tcp.tree.Different;
import ch.hepia.IL.tcp.tree.Division;
import ch.hepia.IL.tcp.tree.Equal;
import ch.hepia.IL.tcp.tree.For;
import ch.hepia.IL.tcp.tree.Idf;
import ch.hepia.IL.tcp.tree.InfEqual;
import ch.hepia.IL.tcp.tree.Inferior;
import ch.hepia.IL.tcp.tree.Not;
import ch.hepia.IL.tcp.tree.NumberValue;
import ch.hepia.IL.tcp.tree.Or;
import ch.hepia.IL.tcp.tree.Product;
import ch.hepia.IL.tcp.tree.QualifiedCall;
import ch.hepia.IL.tcp.tree.Read;
import ch.hepia.IL.tcp.tree.Substraction;
import ch.hepia.IL.tcp.tree.SupEqual;
import ch.hepia.IL.tcp.tree.Superior;
import ch.hepia.IL.tcp.tree.While;
import ch.hepia.IL.tcp.tree.Write;

public class SemanticAnalyser implements Visitor {

	private static SemanticAnalyser instance = null;
	
	private SemanticAnalyser() {}
	
	public static SemanticAnalyser getInstance() {
		if(instance == null) instance = new SemanticAnalyser();
		return instance;
	}
	
	public void verifyBinary(Binary b) {
		
	}
	
	@Override
	public Object visit(Addition a) {
		verifyBinary(a);
		
		return null;
	}

	@Override
	public Object visit(And a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Assignment a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(BitNot b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Block b) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Call c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Condition c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Different d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Division d) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Equal e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(For f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Idf i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(InfEqual i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Inferior i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Not n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(NumberValue n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Or o) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Product p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(QualifiedCall q) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Read r) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Substraction s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(SupEqual s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Superior s) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(While w) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Write w) {
		// TODO Auto-generated method stub
		return null;
	}

}
