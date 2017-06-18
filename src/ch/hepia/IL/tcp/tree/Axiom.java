package ch.hepia.IL.tcp.tree;

import java.util.ArrayList;
import java.util.List;

import ch.hepia.IL.tcp.code.Visitor;

public class Axiom implements AbstractTree {

	private List<String> fnames;
	private List<Block> functions;
	
	public Axiom() {
		this.functions = new ArrayList<>();
		this.fnames = new ArrayList<>();
	}
	
	public void add(String name, Block b) {
		this.functions.add(b);
		this.fnames.add(name);
	}
	
	@Override
	public Object accept(Visitor v) {
		return v.visit(this);
	}

	public List<String> getFnames() {
		return fnames;
	}

	public List<Block> getFunctions() {
		return functions;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Block b : this.functions) {
			sb.append(b.toString()).append("\n");
		}
		return sb.toString();
	}
}
