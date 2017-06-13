package ch.hepia.IL.tcp.tree;

public class Write extends Instruction {
	
	private Expression content;
	private String constant;

	public Write(int line, Expression content) {
		super(line);
		this.setContent(content);
	}
	
	public Write(int line, String str) {
		super(line);
		this.constant = str;
	}

	@Override
	public AbstractTree accept(AbstractTree o) {
		// TODO Auto-generated method stub
		return null;
	}

	public Expression getContent() {
		return content;
	}

	public void setContent(Expression content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "Write "+(content==null?constant:content.toString());
	}
	
}
