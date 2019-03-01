JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	NumberShifter.java \
	NumberShifterRunner.java \
	NumberSorter.java \
	NumberSorterRunner.java \
	WordSortTwo.java \
        WordSortTwoRunner.java \

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
