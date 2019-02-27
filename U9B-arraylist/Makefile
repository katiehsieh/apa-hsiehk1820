JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	DownRunner.java \
	ListDown.java \
	ListOddToEven.java \
	ListSumFirst.java \
	OddToEvenRunner.java \
        SumFirstRunner.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
