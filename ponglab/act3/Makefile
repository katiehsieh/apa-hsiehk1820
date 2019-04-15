JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Block.java \
	Locatable.java \
	Ball.java \
	BallTestOne.java \
	BallTestTwo.java \
	Tester.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class