package ch.hepia.IL.tcp.code;

public class ErrorHandler {

	private static String message = "";

	public static void addError(String m, int line) {
		message = message + "[ERROR]" + m + " file:" + line + "\n";
	}

	public static void addWarning(String m, int line) {
		message = message + "[WARNING]" + m + " file:" + line + "\n";
	}

	public static String getMessage() {
		return message;
	}
	
}
