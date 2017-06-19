package ch.hepia.IL.tcp.code;

import ch.hepia.IL.tcp.Entry;
import ch.hepia.IL.tcp.Function;
import ch.hepia.IL.tcp.SymbolHEPIAL;
import ch.hepia.IL.tcp.SymbolTable;
import ch.hepia.IL.tcp.tree.AbstractTree;
import ch.hepia.IL.tcp.tree.Addition;
import ch.hepia.IL.tcp.tree.And;
import ch.hepia.IL.tcp.tree.ArrayAccess;
import ch.hepia.IL.tcp.tree.Assignment;
import ch.hepia.IL.tcp.tree.Axiom;
import ch.hepia.IL.tcp.tree.Binary;
import ch.hepia.IL.tcp.tree.BitNot;
import ch.hepia.IL.tcp.tree.Block;
import ch.hepia.IL.tcp.tree.BoolValue;
import ch.hepia.IL.tcp.tree.Call;
import ch.hepia.IL.tcp.tree.Condition;
import ch.hepia.IL.tcp.tree.Different;
import ch.hepia.IL.tcp.tree.Division;
import ch.hepia.IL.tcp.tree.Equal;
import ch.hepia.IL.tcp.tree.Expression;
import ch.hepia.IL.tcp.tree.For;
import ch.hepia.IL.tcp.tree.FunctionReturn;
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
import ch.hepia.IL.tcp.tree.Return;
import ch.hepia.IL.tcp.tree.Substraction;
import ch.hepia.IL.tcp.tree.SupEqual;
import ch.hepia.IL.tcp.tree.Superior;
import ch.hepia.IL.tcp.tree.While;
import ch.hepia.IL.tcp.tree.Write;
import ch.hepia.IL.tcp.types.BoolType;
import ch.hepia.IL.tcp.types.Const;
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
		if (b.getLeft().getType() == null) {
			ErrorHandler.addError("Unknown type of operand " + b.getLeft(), 0);
			return;
		}
		b.getRight().accept(this);
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
		verifyBooleanBinary(a);
		Object valL = a.getLeft().accept(this);
		if (valL != null) {
			boolean l = ((Boolean) valL).booleanValue();
			if (!l)
				return false;
		}
		Object valR = a.getRight().accept(this);
		if (valR != null) {
			boolean r = ((Boolean) valR).booleanValue();
			if (!r)
				return false;
		}
		if (valL == null || valR == null)
			return null;
		return new Boolean(((Boolean) valL).booleanValue() && ((Boolean) valR).booleanValue());
	}

	@Override
	public Object visit(ArrayAccess a) {
		a.getArray().accept(this);
		return null;
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
	public Object visit(Axiom a) {
		for (Block b : a.getFunctions()) {
			b.accept(this);
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
		for (Expression e : c.getParameters().getParams()) {
			e.accept(this);
		}
		SymbolHEPIAL sh = SymbolTable.getInstance().identify(new Entry(c.getIdf().getName()));
		if (sh == null || !(sh instanceof Function)) {
			ErrorHandler.addError(c.getIdf().getName() + " is not a function", c.getLine());
		} else {
			Function f = (Function) sh;
			if (f.getParams().size() == c.getParameters().getParams().size()) {
				for (int i = 0; i < f.getParams().size(); i++) {
					if (!f.getParams().get(i).isValid(c.getParameters().getParams().get(i).getType())) {
						ErrorHandler.addError("Parameter number " + i + " type mismatch, expected " + f.getParams().get(i) + "  but got " + c.getParameters().getParams().get(i).getType(), c.getLine());
					}
				}
			} else if (f.getParams().size() < c.getParameters().getParams().size()) {
				ErrorHandler.addError("Too many parameters when calling function " + c.getIdf(), c.getLine());
			} else if (f.getParams().size() > c.getParameters().getParams().size()) {
				ErrorHandler.addError("Too few parameters when calling function " + c.getIdf(), c.getLine());
			}
		}
		return null;
	}

	@Override
	public Object visit(Condition c) {
		c.getCondition().accept(this);
		if (!c.getCondition().getType().isValid(BoolType.getInstance())) {
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
		Object valL = d.getLeft().accept(this);
		Object valR = d.getRight().accept(this);
		if (valL != null && valR != null) {
			if (valL instanceof Boolean) {
				d.setLeft(new BoolValue((Boolean) valL));
				d.setRight(new BoolValue((Boolean) valR));
			} else if (valL instanceof Integer) {
				d.setLeft(new NumberValue((Integer) valL));
				d.setRight(new NumberValue((Integer) valR));
			}
		}
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
		Object valL = e.getLeft().accept(this);
		Object valR = e.getRight().accept(this);
		if (valL != null && valR != null) {
			if (valL instanceof Boolean) {
				e.setLeft(new BoolValue((Boolean) valL));
				e.setRight(new BoolValue((Boolean) valR));
			} else if (valL instanceof Integer) {
				e.setLeft(new NumberValue((Integer) valL));
				e.setRight(new NumberValue((Integer) valR));
			}
		}
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
	public Object visit(FunctionReturn f) {
		return null;
	}

	@Override
	public Object visit(Idf i) {
		SymbolHEPIAL sh = SymbolTable.getInstance().identify(new Entry(i.getName()));
		if (sh instanceof Const) {
			return ((Const) sh).getValue().accept(this);
		}
		return null;
	}

	@Override
	public Object visit(InfEqual i) {
		verifyIntegerBinary(i);
		Object valL = i.getLeft().accept(this);
		Object valR = i.getRight().accept(this);
		if (valL != null && valR != null) {
			i.setLeft(new NumberValue((Integer) valL));
			i.setRight(new NumberValue((Integer) valR));
		}
		return null;
	}

	@Override
	public Object visit(Inferior i) {
		verifyIntegerBinary(i);
		Object valL = i.getLeft().accept(this);
		Object valR = i.getRight().accept(this);
		if (valL != null && valR != null) {
			i.setLeft(new NumberValue((Integer) valL));
			i.setRight(new NumberValue((Integer) valR));
		}
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
		verifyBooleanBinary(o);
		Object valL = o.getLeft().accept(this);
		if (valL != null) {
			boolean l = ((Boolean) valL).booleanValue();
			if (l)
				return true;
		}
		Object valR = o.getRight().accept(this);
		if (valR != null) {
			boolean r = ((Boolean) valR).booleanValue();
			if (r)
				return true;
		}
		if (valL == null || valR == null)
			return null;
		return new Boolean(((Boolean) valL).booleanValue() || ((Boolean) valR).booleanValue());
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
		// USELESS
		return null;
	}

	@Override
	public Object visit(Read r) {
		if (SymbolTable.getInstance().identify(new Entry(r.getDest().getName())) == null) {
			ErrorHandler.addError("Identifier " + r.getDest().getName() + " doesn't exisits", r.getLine());
		}
		return null;
	}

	@Override
	public Object visit(Return r) {
		r.getValue().accept(this);
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
		Object valL = s.getLeft().accept(this);
		Object valR = s.getRight().accept(this);
		if (valL != null && valR != null) {
			s.setLeft(new NumberValue((Integer) valL));
			s.setRight(new NumberValue((Integer) valR));
		}
		return null;
	}

	@Override
	public Object visit(Superior s) {
		verifyIntegerBinary(s);
		Object valL = s.getLeft().accept(this);
		Object valR = s.getRight().accept(this);
		if (valL != null && valR != null) {
			s.setLeft(new NumberValue((Integer) valL));
			s.setRight(new NumberValue((Integer) valR));
		}
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
		if (w.getContent() != null) {
			w.getContent().accept(this);
		}
		return null;
	}
}
