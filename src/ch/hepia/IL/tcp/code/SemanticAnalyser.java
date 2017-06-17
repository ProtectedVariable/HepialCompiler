package ch.hepia.IL.tcp.code;

import ch.hepia.IL.tcp.tree.AbstractTree;
import ch.hepia.IL.tcp.tree.Addition;
import ch.hepia.IL.tcp.tree.And;
import ch.hepia.IL.tcp.tree.Assignment;
import ch.hepia.IL.tcp.tree.Binary;
import ch.hepia.IL.tcp.tree.BitNot;
import ch.hepia.IL.tcp.tree.Block;
import ch.hepia.IL.tcp.tree.BoolValue;
import ch.hepia.IL.tcp.tree.Call;
import ch.hepia.IL.tcp.tree.Condition;
import ch.hepia.IL.tcp.tree.Different;
import ch.hepia.IL.tcp.tree.Division;
import ch.hepia.IL.tcp.tree.Equal;
import ch.hepia.IL.tcp.tree.For;
import ch.hepia.IL.tcp.tree.Idf;
import ch.hepia.IL.tcp.tree.InfEqual;
import ch.hepia.IL.tcp.tree.Inferior;
import ch.hepia.IL.tcp.tree.Instruction;
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
import ch.hepia.IL.tcp.types.BoolType;
import ch.hepia.IL.tcp.types.IntType;

public class SemanticAnalyser implements Visitor {

	private static SemanticAnalyser instance = null;

	private SemanticAnalyser() {
	}

	public static SemanticAnalyser getInstance() {
		if (instance == null)
			instance = new SemanticAnalyser();
		return instance;
	}

	public void analyze(AbstractTree t) {
		t.accept(this);
		System.out.println(ErrorHandler.getMessage());
		System.out.println("Semantical analysis done...");
	}

	public void verifyIntegerBinary(Binary b) {
		b.getLeft().accept(this);
		if (b.getLeft().getType() == null) {
			ErrorHandler.addError("Unknown type of operand " + b.getLeft(), 0);
			return;
		}
		if (!b.getLeft().getType().isValid(IntType.getInstance())) {
			ErrorHandler.addError("Bad operand : expected integer (" + b.getLeft() + ")", 0);
		}

		b.getRight().accept(this);
		if (b.getRight().getType() == null) {
			ErrorHandler.addError("Unknown type of operand " + b.getRight(), 0);
			return;
		}
		if (!b.getRight().getType().isValid(IntType.getInstance())) {
			ErrorHandler.addError("Bad operand : expected integer (" + b.getRight() + ")", 0);
		}
	}

	public void verifyBooleanBinary(Binary b) {
		b.getLeft().accept(this);
		if (b.getLeft().getType() == null) {
			ErrorHandler.addError("Unknown type of operand " + b.getLeft(), 0);
			return;
		}
		if (!b.getLeft().getType().isValid(BoolType.getInstance())) {
			ErrorHandler.addError("Bad operand : expected boolean (" + b.getLeft() + ")", 0);
		}

		b.getRight().accept(this);
		if (b.getRight().getType() == null) {
			ErrorHandler.addError("Unknown type of operand " + b.getRight(), 0);
			return;
		}
		if (!b.getRight().getType().isValid(BoolType.getInstance())) {
			ErrorHandler.addError("Bad operand : expected boolean (" + b.getRight() + ")", 0);
		}
	}

	public void verifyAnyBinary(Binary b) {
		b.getLeft().accept(this);
		b.getRight().accept(this);
		if (b.getLeft().getType() == null) {
			ErrorHandler.addError("Unknown type of operand " + b.getLeft(), 0);
			return;
		}
		if (b.getRight().getType() == null) {
			ErrorHandler.addError("Unknown type of operand " + b.getRight(), 0);
			return;
		}
		if (!b.getLeft().getType().isValid(b.getRight().getType())) {
			ErrorHandler.addError("Operand type mismatch: " + b.getLeft() + " is of type " + b.getLeft().getType() + " but " + b.getRight() + " is of type " + b.getRight().getType(), 0);
		}
	}

	@Override
	public Object visit(Addition a) {
		verifyIntegerBinary(a);
		Object valL = a.getLeft().accept(this);
		if (valL == null)
			return null;
		Object valR = a.getRight().accept(this);
		if (valR == null)
			return null;
		int l = ((Integer) valL).intValue();
		int r = ((Integer) valR).intValue();
		return new Integer(l + r);
	}

	@Override
	public Object visit(And a) {
		verifyIntegerBinary(a);
		Object valL = a.getLeft().accept(this);
		if (valL != null) {
			int l = ((Integer) valL).intValue();
			if (l == 0)
				return 0;
		}
		Object valR = a.getRight().accept(this);
		if (valR != null) {
			int r = ((Integer) valR).intValue();
			if (r == 0)
				return 0;
		}
		if (valL == null || valR == null)
			return null;
		return new Integer(((Integer) valL).intValue() & ((Integer) valR).intValue());
	}

	@Override
	public Object visit(Assignment a) {
		Object s = a.getSource().accept(this);
		a.getDest().accept(this);
		if (!a.getSource().getType().isValid(a.getDest().getType())) {
			ErrorHandler.addError("Type mismatch: trying to put " + a.getSource().getType() + " in " + a.getDest().getType(), a.getLine());
		} else {
			if (s != null) {
				if (a.getDest().getType().isValid(IntType.getInstance())) {
					a.setSource(new NumberValue((Integer) s));
				} else {
					a.setSource(new BoolValue((Boolean) s));
				}
			}
		}
		return null;
	}

	@Override
	public Object visit(BitNot b) {
		if (b.getRight().getType().isValid(IntType.getInstance())) {
			Object valR = b.getRight().accept(this);
			if (valR == null)
				return null;
			int r = ((Integer) valR).intValue();
			return new Integer(~r);
		}
		ErrorHandler.addError("Bad operand : expected integer (" + b.getRight() + ")", 0);
		return null;
	}

	@Override
	public Object visit(Block b) {
		for (Instruction i : b.getInstructions()) {
			i.accept(this);
		}
		return null;
	}

	@Override
	public Object visit(BoolValue b) {
		return new Boolean(b.isValue());
	}

	@Override
	public Object visit(Call c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Condition c) {
		c.getCondition().accept(this);
		if(!c.getCondition().getType().isValid(BoolType.getInstance())) {
			ErrorHandler.addError("Condition must be boolean type", c.getLine());
		}
		for (Instruction i : c.getThen()) {
			i.accept(this);
		}
		for (Instruction i : c.get_else()) {
			i.accept(this);
		}
		return null;
	}

	@Override
	public Object visit(Different d) {
		verifyAnyBinary(d);
		return null;
	}

	@Override
	public Object visit(Division d) {
		verifyIntegerBinary(d);
		Object valL = d.getLeft().accept(this);
		if (valL == null)
			return null;
		Object valR = d.getRight().accept(this);
		if (valR == null)
			return null;
		int l = ((Integer) valL).intValue();
		int r = ((Integer) valR).intValue();
		return new Integer(l / r);
	}

	@Override
	public Object visit(Equal e) {
		verifyAnyBinary(e);
		return null;
	}

	@Override
	public Object visit(For f) {
		if (!f.getIdf().getType().isValid(IntType.getInstance())) {
			ErrorHandler.addError("For variable must be an integer", f.getLine());
		}
		Object i = f.getInfLimit().accept(this);
		Object s = f.getSupLimit().accept(this);

		if (i != null) {
			f.setInfLimit(new NumberValue(((Integer) i).intValue()));
		}

		if (s != null) {
			f.setSupLimit(new NumberValue(((Integer) s).intValue()));
		}

		for (Instruction in : f.getInstructions()) {
			in.accept(this);
		}

		return null;
	}

	@Override
	public Object visit(Idf i) {
		return null;
	}

	@Override
	public Object visit(InfEqual i) {
		verifyAnyBinary(i);
		return null;
	}

	@Override
	public Object visit(Inferior i) {
		verifyAnyBinary(i);
		return null;
	}

	@Override
	public Object visit(Not n) {
		Object valR = n.getRight().accept(this);
		if (valR == null)
			return null;
		boolean r = ((Boolean) valR).booleanValue();
		return new Boolean(!r);
	}

	@Override
	public Object visit(NumberValue n) {
		return new Integer(n.getValue());
	}

	@Override
	public Object visit(Or o) {
		verifyIntegerBinary(o);
		Object valL = o.getLeft().accept(this);
		if (valL == null)
			return null;
		Object valR = o.getRight().accept(this);
		if (valR == null)
			return null;
		int l = ((Integer) valL).intValue();
		int r = ((Integer) valR).intValue();
		return new Integer(l | r);
	}

	@Override
	public Object visit(Product p) {
		verifyIntegerBinary(p);
		Object valL = p.getLeft().accept(this);
		if (valL == null)
			return null;
		Object valR = p.getRight().accept(this);
		if (valR == null)
			return null;
		int l = ((Integer) valL).intValue();
		int r = ((Integer) valR).intValue();
		return new Integer(l * r);
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
		verifyIntegerBinary(s);
		Object valL = s.getLeft().accept(this);
		if (valL == null)
			return null;
		Object valR = s.getRight().accept(this);
		if (valR == null)
			return null;
		int l = ((Integer) valL).intValue();
		int r = ((Integer) valR).intValue();
		return new Integer(l - r);
	}

	@Override
	public Object visit(SupEqual s) {
		verifyAnyBinary(s);
		return null;
	}

	@Override
	public Object visit(Superior s) {
		verifyAnyBinary(s);
		return null;
	}

	@Override
	public Object visit(While w) {
		w.getCondition().accept(this);
		for (Instruction i : w.getInstructions()) {
			i.accept(this);
		}
		return null;
	}

	@Override
	public Object visit(Write w) {
		// TODO Auto-generated method stub
		return null;
	}

}
