//Name -
//Date -
//Class -
//Lab  - 

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
  public static final int NUMFACES = 13;
  public static final int NUMSUITS = 4;
  public static final int NUMCARDS = 52;

  public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

  private int topCardIndex;
  private ArrayList<Card> stackOfCards;

  public Deck ()
  {
    //initialize data - stackOfCards - topCardIndex
    topCardIndex = NUMCARDS - 1;
    stackOfCards = new ArrayList<Card>();
    
    for (String suit : SUITS) {
      for (int i = 0; i < NUMFACES; i++) {
        stackOfCards.add(new BlackJackCard(i+1, suit));
      }
    }
    
    //loop through suits
    //loop through faces
    //add in a new card
                
  }

  //modifiers
  public void shuffle ()
  {
    //shuffle the deck
    //reset variables as needed
    Collections.shuffle(stackOfCards);
    topCardIndex = NUMCARDS - 1;
  }

  //accessors
  public int size ()
  {
    return NUMCARDS;
  }

  public int numCardsLeft()
  {
    return topCardIndex + 1;
  }

  public Card nextCard()
  {
    return stackOfCards.get(topCardIndex--);
  }

  public String toString()
  {
    return stackOfCards + "   topCardIndex = " + topCardIndex;
  } 
}