package ch.hepia.IL.tcp.code;

public class ErrorHandler {

	private static String message = "";
	private static boolean ok = true;

	public static void addError(String m, int line) {
		ok = false;
		message = message + "[ERROR]" + m + " file:" + line + "\n";
	}

	public static void addWarning(String m, int line) {
		message = message + "[WARNING]" + m + " file:" + line + "\n";
	}

	public static String getMessage() {
		return message;
	}
	
	public static boolean canGenerate() {
		return ok;
	}
}
