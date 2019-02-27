JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	GraphicsRunner.java \
	Robot.java \
	SmileyFace.java \
	Shape.java \
	ShapePanel.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class