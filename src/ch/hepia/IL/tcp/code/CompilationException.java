package ch.hepia.IL.tcp.code;

public class CompilationException extends Exception {
	private static final long serialVersionUID = -1493067017332011186L;
	
	public CompilationException(int line, String message) {
		super("Compilation Error "+message+" at line "+line);
	}
}
