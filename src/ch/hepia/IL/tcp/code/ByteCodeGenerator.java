package ch.hepia.IL.tcp.code;

import java.util.HashMap;

import ch.hepia.IL.tcp.Entry;
import ch.hepia.IL.tcp.Function;
import ch.hepia.IL.tcp.SymbolTable;
import ch.hepia.IL.tcp.tree.AbstractTree;
import ch.hepia.IL.tcp.tree.Addition;
import ch.hepia.IL.tcp.tree.And;
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
import ch.hepia.IL.tcp.types.Type;

public class ByteCodeGenerator implements Visitor {

	private static ByteCodeGenerator instance;
	private StringBuilder target;
	private int nextLocal = 0;
	private HashMap<String, Integer> locals;

	public static final String classname = "hepial";

	private ByteCodeGenerator() {
		locals = new HashMap<>();
		target = new StringBuilder();
		target.append(".class public " + classname + "\n" + ".super java/lang/Object\n" + ".method public <init>()V\n" + "aload_0 \n" + "invokespecial java/lang/Object/<init>()V \n" + "return\n" + ".end method\n");
		appendln(".method public static read()I");
		appendln("    .limit locals 10 ");
		appendln("    .limit stack 10 ");
		appendln("    ldc 0 ");
		appendln("    istore 1  ; this will hold our final integer ");
		appendln("Label1: ");
		appendln("    getstatic java/lang/System/in Ljava/io/InputStream; ");
		appendln("    invokevirtual java/io/InputStream/read()I ");
		appendln("    istore 2 ");
		appendln("    iload 2 ");
		appendln("    ldc 10   ; the newline delimiter ");
		appendln("    isub ");
		appendln("    ifeq Label2 ");
		appendln("    iload 2 ");
		appendln("    ldc 32   ; the space delimiter ");
		appendln("    isub ");
		appendln("    ifeq Label2 ");
		appendln("    iload 2 ");
		appendln("    ldc 48   ; we have our digit in ASCII, have to subtract it from 48 ");
		appendln("    isub ");
		appendln("    ldc 10 ");
		appendln("    iload 1 ");
		appendln("    imul ");
		appendln("    iadd ");
		appendln("    istore 1 ");
		appendln("    goto Label1 ");
		appendln("Label2: ");
		appendln("    ;when we come here we have our integer computed in Local Variable 1 ");
		appendln("    iload 1 ");
		appendln("    ireturn ");
		appendln(".end method ");
	}

	public void Generate(AbstractTree t) {
		t.accept(this);
		System.out.println(target.toString());
	}

	public static ByteCodeGenerator getInstance() {
		if (instance == null)
			instance = new ByteCodeGenerator();
		return instance;
	}

	public void appendln(String ln) {
		target.append(ln).append("\n");
	}

	public void visitBinary(Binary b) {
		Object l = b.getLeft().accept(this);
		Object r = b.getRight().accept(this);
		if (l != null && l instanceof Integer) {
			appendln("iload " + (Integer) l);
		}
		if (r != null && r instanceof Integer) {
			appendln("iload " + (Integer) r);
		}
	}

	@Override
	public Object visit(Addition a) {
		visitBinary(a);
		appendln("iadd");
		return null;
	}

	@Override
	public Object visit(And a) {
		visitBinary(a);
		appendln("iand");
		return null;
	}

	@Override
	public Object visit(Assignment a) {
		Object local = a.getDest().accept(this);
		Object src = a.getSource().accept(this);
		if (src != null) {
			appendln("iload " + (Integer) src);
		}
		appendln("istore " + ((Integer) local).intValue());
		return null;
	}

	@Override
	public Object visit(Axiom a) {

		for (int i = 0; i < a.getFnames().size(); i++) {
			if (!a.getFnames().get(i).equals("main")) {
				Function f = (Function) SymbolTable.getInstance().identify(new Entry(a.getFnames().get(i)));
				String params = "";
				for (@SuppressWarnings("unused")
				Type t : f.getParams()) {
					params = params + "I"; // we only deal with integer since
										   // bool = int
				}
				appendln(".method public static " + a.getFnames().get(i) + "(" + params + ")I");
				appendln(".limit stack " + SymbolTable.getInstance().getSize());
				appendln(".limit locals " + SymbolTable.getInstance().getSize() * 2);
				a.getFunctions().get(i).accept(this);
				appendln(".end method");
			} else {
				appendln(".method public static main([Ljava/lang/String;)V");
				appendln(".limit stack " + (SymbolTable.getInstance().getSize() + 4));
				appendln(".limit locals " + SymbolTable.getInstance().getSize() * 4);
				a.getFunctions().get(i).accept(this);
				appendln("return");
				appendln(".end method");
			}
		}
		return null;
	}

	@Override
	public Object visit(BitNot b) {
		Object r = b.getRight().accept(this);
		if (r != null) {
			appendln("iload " + (Integer) r);
		}
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
		if (b.isValue()) {
			appendln("ldc 1");
		} else {
			appendln("ldc 0");
		}
		return null;
	}

	@Override
	public Object visit(Call c) {
		Function f = (Function) SymbolTable.getInstance().identify(new Entry(c.getIdf().getName()));
		String params = "";
		for (@SuppressWarnings("unused")
		Type t : f.getParams()) {
			params = params + "I";
		}
		for (Expression e : c.getParameters().getParams()) {
			Object p = e.accept(this);
			if(p != null) {
				appendln("iload "+(Integer)p);
			}
		}
		appendln("invokestatic " + classname + "." + c.getIdf().getName() + "(" + params + ")I");
		return null;
	}

	@Override
	public Object visit(Condition c) {
		Object cnd = c.getCondition().accept(this);

		appendln(((String) cnd) + " if" + c.hashCode() + "_then");
		appendln("goto if" + c.hashCode() + "_else");

		appendln("if" + c.hashCode() + "_then:");
		for (Instruction i : c.getThen()) {
			i.accept(this);
		}
		appendln("goto endif" + c.hashCode());
		appendln("if" + c.hashCode() + "_else:");
		for (Instruction i : c.get_else()) {
			i.accept(this);
		}
		appendln("endif" + c.hashCode() + ":");
		return null;
	}

	@Override
	public Object visit(Different d) {
		visitBinary(d);
		appendln("isub");
		return "ifne";
	}

	@Override
	public Object visit(Division d) {
		visitBinary(d);
		appendln("idiv");
		return null;
	}

	@Override
	public Object visit(Equal e) {
		visitBinary(e);
		appendln("isub");
		return "ifeq";
	}

	@Override
	public Object visit(For f) {
		Integer local = (Integer) f.getIdf().accept(this);
		f.getInfLimit().accept(this);
		appendln("istore " + local.intValue());
		appendln("for" + f.hashCode() + ":");
		appendln("iload " + local.intValue());
		f.getSupLimit().accept(this);

		appendln("isub");
		appendln("ifgt endfor" + f.hashCode());

		for (Instruction i : f.getInstructions()) {
			i.accept(this);
		}
		appendln("ldc 1");
		appendln("iload " + local.intValue());
		appendln("iadd");
		appendln("istore " + local.intValue());
		appendln("goto for" + f.hashCode());

		appendln("endfor" + f.hashCode() + ":");
		return null;
	}

	@Override
	public Object visit(FunctionReturn f) {
		return f;
	}

	@Override
	public Object visit(Idf i) {
		if (!locals.containsKey(i.getName())) {
			i.setLocal(nextLocal);
			locals.put(i.getName(), nextLocal);
			nextLocal++;
		} else if (i.getLocal() == -1) {
			i.setLocal(locals.get(i.getName()));
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
		visitBinary(i);
		appendln("isub");
		return "iflt";
	}

	@Override
	public Object visit(Not n) {
		Object r = n.getRight().accept(this);
		if (r != null) {
			appendln("iload " + (Integer) r);
		}
		appendln("ldc 1");
		appendln("ixor");
		return null;
	}

	@Override
	public Object visit(NumberValue n) {
		appendln("ldc " + n.getValue());
		return null;
	}

	@Override
	public Object visit(Or o) {
		visitBinary(o);
		appendln("ior");
		return null;
	}

	@Override
	public Object visit(Product p) {
		visitBinary(p);
		appendln("imul");
		return null;
	}

	@Override
	public Object visit(QualifiedCall q) {
		// USELESS
		return null;
	}

	@Override
	public Object visit(Read r) {
		Object local = r.getDest().accept(this);
		appendln("invokestatic " + classname + ".read()I");
		appendln("istore "+(Integer)local);
		return null;
	}

	@Override
	public Object visit(Return r) {
		Object ret = r.getValue().accept(this);
		if (ret != null)
			appendln("iload " + (Integer) ret);
		appendln("ireturn");
		return null;
	}

	@Override
	public Object visit(Substraction s) {
		visitBinary(s);
		appendln("isub");
		return null;
	}

	@Override
	public Object visit(SupEqual s) {
		visitBinary(s);
		appendln("isub");
		return "ifge";
	}

	@Override
	public Object visit(Superior s) {
		visitBinary(s);
		appendln("isub");
		return "ifgt";
	}

	@Override
	public Object visit(While w) {
		appendln("while " + w.hashCode() + ":");
		String cnd = (String) w.getCondition().accept(this);
		appendln(cnd + " endwhile" + w.hashCode());
		for (Instruction i : w.getInstructions()) {
			i.accept(this);
		}
		appendln("goto while" + w.hashCode());
		appendln("endwhile" + w.hashCode() + ":");
		return null;
	}

	@Override
	public Object visit(Write w) {
		if (w.getContent() != null) {
			Object r = w.getContent().accept(this);
			if(r instanceof Integer) {
				appendln("iload "+(Integer)r);
			}
			appendln("getstatic java/lang/System/out Ljava/io/PrintStream;");
			appendln("swap");
			appendln("invokevirtual java/io/PrintStream/print(I)V");
		} else {
			appendln("ldc " + w.getConstant());
			appendln("getstatic java/lang/System/out Ljava/io/PrintStream;");
			appendln("swap");
			appendln("invokevirtual java/io/PrintStream/print(Ljava/lang/String;)V");
		}
		return null;
	}
}
