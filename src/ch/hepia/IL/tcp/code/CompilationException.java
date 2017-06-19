package ch.hepia.IL.tcp.code;

/**Class CompilationException
 * @author Ibanez Thomas & Lovino Maxime
 * @version 1.0
 *
 * Exception thrown in case of compilation error
 */

public class CompilationException extends Exception {
	private static final long serialVersionUID = -1493067017332011186L;
	
	public CompilationException(int line, String message) {
		super("Compilation Error "+message+" at line "+line);
	}
}
