import java.io.FileReader;

class Test {
	public static void main(String[] args) {
		try {
			FileReader reader = new FileReader(args[0]);
			HepialF myLexer = new HepialF(reader);
			parser myParser = new parser(myLexer);
			try {
				System.out.println("===========PARSING THE FILE===========");
				myParser.parse();
			}catch (Exception e){
				//Here we catch the exception in case of a parsing error or an error with the grammar
				System.out.println("(Error)");
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Invalid file");
		}
	}
}
