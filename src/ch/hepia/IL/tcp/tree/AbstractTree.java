package ch.hepia.IL.tcp.tree;

import ch.hepia.IL.tcp.code.Visitor;

public interface AbstractTree {
	
	Object accept(Visitor v);
	
}