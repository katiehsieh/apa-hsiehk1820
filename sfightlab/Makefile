JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Moveable.java \
	MovingThing.java \
	Ship.java \
	Alien.java \
	AlienHorde.java \
	Ammo.java \
	Bullets.java \
	OuterSpace.java \
	StarFighter.java \
	Shiptest.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class