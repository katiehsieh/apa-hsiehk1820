//Name - 
//Date - 
//Class - 
//Lab  - 

public class BlackJackCard extends Card
{
  //constructors
  BlackJackCard() {
    super();
  }
  
  BlackJackCard(int f, String s) {
    super(f, s);
  }

  public int getValue()
  {
    //enables you to build the value for the game into the card
    //this makes writing the whole program a little easier
    if (getFace() == 1) {
      //Ace
      return 11;
    }
    if (getFace() > 10) {
      //JQK
      return 10;
    }
    else {
      return getFace();
    }
  }
        
}