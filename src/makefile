all: run
	javac ch/hepia/IL/tcp/tree/*.java
	javac ch/hepia/IL/tcp/types/*.java
	javac ch/hepia/IL/tcp/code/*.java
FILE=../test/test.hepial

Test.class: HepialF.java hepial.cup Test.java
	java -jar java-cup-11b.jar hepial.cup
	javac -classpath .:java-cup-11b.jar sym.java
	javac -classpath .:java-cup-11b.jar parser.java
	javac -classpath .:java-cup-11b.jar HepialF.java
	javac -classpath .:java-cup-11b.jar Test.java

HepialF.java: hepial.flex
	jflex hepial.flex

run: Test.class
	java -classpath .:java-cup-11b.jar Test $(FILE)
	java -jar jasmin.jar hepial.j
	java hepial

%.class: %.java
	javac -classpath .:java-cup-11b.jar $^

clean:
	rm *.class sym.java parser.java HepialF.java
