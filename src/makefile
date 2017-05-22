all: Entry.class Function.class SymbolHEPIAL.class SymbolTable.class Type.class Variable.class run
FILE=../test/test.hepial

Test.class: HepialF.java hepial.cup Test.java 
	java -jar java-cup-11b.jar hepial.cup
	javac -classpath .:java-cup-11b.jar sym.java
	javac -classpath .:java-cup-11b.jar parser.java
	#SGML is my equivalent of Lexer
	javac -classpath .:java-cup-11b.jar HepialF.java
	javac -classpath .:java-cup-11b.jar Test.java

HepialF.java: hepial.flex
	jflex hepial.flex

run: Test.class
	java -classpath .:java-cup-11b.jar Test $(FILE)

%.class: %.java
	javac -classpath .:java-cup-11b.jar $^

clean:
	rm *.class sym.java parser.java HepialF.java\~ HepialF.java
