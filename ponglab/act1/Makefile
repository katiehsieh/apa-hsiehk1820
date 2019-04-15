JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Block.java \
	Locatable.java \
	BlockTestOne.java \
	BlockTestTwo.java \
	Tester.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class