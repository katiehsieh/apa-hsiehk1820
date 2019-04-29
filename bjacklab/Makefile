JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	Card.java \
	Playerable.java \
	AbstractPlayer.java \
	Player.java \
	Deck.java \
	Dealer.java \
	DeckTestOne.java \
	BlackJackCard.java \
	DealerTestOne.java \
	PlayerTestOne.java \
	BlackJack.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class