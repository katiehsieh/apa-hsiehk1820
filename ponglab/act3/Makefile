JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Block.java \
	Locatable.java \
	Ball.java \
	PaddleTestOne.java \
	PaddleTestTwo.java \
	Tester.java \
	Paddle.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class