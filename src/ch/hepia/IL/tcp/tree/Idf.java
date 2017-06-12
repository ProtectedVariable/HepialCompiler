package ch.hepia.IL.tcp.tree;

public class Idf extends Expression {

	private String name;
	
	public Idf(String name) {
		this.name = name;
	}

	@Override
	public AbstractTree accept(AbstractTree o) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}

}
