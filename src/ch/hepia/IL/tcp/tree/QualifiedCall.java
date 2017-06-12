package ch.hepia.IL.tcp.tree;

public class QualifiedCall extends Call {

	private Expression reciever;
	
	public QualifiedCall(Expression reciever, Idf idf, EffectiveParameters parameters) {
		super(idf, parameters);
		this.reciever = reciever;
	}	
}
