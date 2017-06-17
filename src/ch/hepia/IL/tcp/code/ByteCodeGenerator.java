package ch.hepia.IL.tcp.code;

import ch.hepia.IL.tcp.SymbolTable;
import ch.hepia.IL.tcp.tree.AbstractTree;
import ch.hepia.IL.tcp.tree.Addition;
import ch.hepia.IL.tcp.tree.And;
import ch.hepia.IL.tcp.tree.Assignment;
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

public class ByteCodeGenerator implements Visitor {

	private static ByteCodeGenerator instance;
    private StringBuilder target;
    private int nextLocal = 0;
    
    private ByteCodeGenerator() {
    	target = new StringBuilder();
    	target.append(".class public simple\n"
    			+ ".super java/lang/Object\n"
    			+ ".method public <init>()V\n"
    			+ "aload_0 \n"
    			+ "invokespecial java/lang/Object/<init>()V \n"
    			+ "return\n"
    			+ ".end method\n"
    			+ ".method public static main([Ljava/lang/String;)V\n"
    			+ ".limit stack "+SymbolTable.getInstance().getSize()+"\n"
    			+ ".limit locals "+SymbolTable.getInstance().getSize()*2+"\n");
	}
    
    public void Generate(AbstractTree t) {
    	t.accept(this);
    	System.out.println(target.toString());
    }
    
	public static ByteCodeGenerator getInstance() {
		if(instance == null) instance = new ByteCodeGenerator();
		return instance;
	}
	
	public void appendln(String ln) {
		target.append(ln).append("\n");
	}
	
	@Override
	public Object visit(Addition a) {
		a.getLeft().accept(this);
		a.getRight().accept(this);
		appendln("iadd");
		return null;
	}

	@Override
	public Object visit(And a) {
		a.getLeft().accept(this);
		a.getRight().accept(this);
		appendln("iand");
		return null;
	}

	@Override
	public Object visit(Assignment a) {
		Object local = a.getDest().accept(this);
		a.getSource().accept(this);
		appendln("istore "+((Integer)local).intValue());
		return null;
	}

	@Override
	public Object visit(BitNot b) {
		b.getRight().accept(this);
		appendln("ineg");
		appendln("ldc 1");
		appendln("isub");
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
		if(b.isValue()) {
			appendln("ldc 1");
		} else {
			appendln("ldc 0");
		}
		return null;
	}

	@Override
	public Object visit(Call c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object visit(Condition c) {
		Object cnd = c.getCondition().accept(this);
		
		appendln(((String)cnd)+" if"+c.hashCode()+"_then");
		appendln("goto if"+c.hashCode()+"_else");
		
		appendln("if"+c.hashCode()+"_then:");
		for (Instruction i : c.getThen()) {
			i.accept(this);
		}
		appendln("goto endif"+c.hashCode());
		appendln("if"+c.hashCode()+"_else:");
		for (Instruction i : c.get_else()) {
			i.accept(this);
		}
		appendln("endif"+c.hashCode()+":");
		return null;
	}

	@Override
	public Object visit(Different d) {
		d.getLeft().accept(this);
		d.getRight().accept(this);
		appendln("isub");
		return "ifne";
	}

	@Override
	public Object visit(Division d) {
		d.getLeft().accept(this);
		d.getRight().accept(this);
		appendln("idiv");
		return null;
	}

	@Override
	public Object visit(Equal e) {
		e.getLeft().accept(this);
		e.getRight().accept(this);
		appendln("isub");
		return "ifeq";
	}

	@Override
	public Object visit(For f) {
		//TODO 
		f.getIdf().accept(this);
		return null;
	}

	@Override
	public Object visit(Idf i) {
		if(i.getLocal() == -1) {
			i.setLocal(nextLocal);
			nextLocal++;
		} else {
			appendln("iload "+i.getLocal());
		}
		return new Integer(i.getLocal());
	}

	@Override
	public Object visit(InfEqual i) {
		i.getLeft().accept(this);
		i.getRight().accept(this);
		appendln("isub");
		return "ifle";
	}

	@Override
	public Object visit(Inferior i) {
		i.getLeft().accept(this);
		i.getRight().accept(this);
		appendln("isub");
		return "iflt";
	}

	@Override
	public Object visit(Not n) {
		n.getRight().accept(this);
		appendln("ldc 1");
		appendln("ixor");
		return null;
	}

	@Override
	public Object visit(NumberValue n) {
		appendln("ldc "+n.getValue());
		return null;
	}

	@Override
	public Object visit(Or o) {
		o.getLeft().accept(this);
		o.getRight().accept(this);
		appendln("ior");
		return null;
	}

	@Override
	public Object visit(Product p) {
		p.getLeft().accept(this);
		p.getRight().accept(this);
		appendln("imul");
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
		s.getLeft().accept(this);
		s.getRight().accept(this);
		appendln("isub");
		return null;
	}

	@Override
	public Object visit(SupEqual s) {
		s.getLeft().accept(this);
		s.getRight().accept(this);
		appendln("isub");
		return "ifge";
	}

	@Override
	public Object visit(Superior s) {
		s.getLeft().accept(this);
		s.getRight().accept(this);
		appendln("isub");
		return "ifgt";
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
