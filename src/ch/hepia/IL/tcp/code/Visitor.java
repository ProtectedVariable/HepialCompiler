package ch.hepia.IL.tcp.code;

import ch.hepia.IL.tcp.tree.*;

public interface Visitor {

	Object visit(Addition a);
	Object visit(And a);
	Object visit(Assignment a);
	
	Object visit(BitNot b);
	Object visit(Block b);
	
	Object visit(Call c);
	Object visit(Condition c);
	
	Object visit(Different d);
	Object visit(Division d);
	
	//EffectiveParams ?
	Object visit(Equal e);
	
	Object visit(For f);
	
	Object visit(Idf i);
	Object visit(InfEqual i);
	Object visit(Inferior i);
	
	Object visit(Not n);
	Object visit(NumberValue n);
	
	Object visit(Or o);
	
	Object visit(Product p);

	Object visit(QualifiedCall q);
	
	Object visit(Read r);
	
	Object visit(Substraction s);
	Object visit(SupEqual s);
	Object visit(Superior s);
	
	Object visit(While w);
	Object visit(Write w);
}
