package ch.hepia.IL.tcp.tree;

public class QualifiedCall extends Call {

	private Expression reciever;
	
	public QualifiedCall(int line, Expression reciever, Idf idf, EffectiveParameters parameters) {
		super(line, idf, parameters);
		this.reciever = reciever;
	}	
}
