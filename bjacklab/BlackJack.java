//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack
{
  private Dealer dealer;
  private Player player;

  public BlackJack()
  {
    dealer = new Dealer();
    player = new Player();
  }

  public void playGame()
  {
    Scanner keyboard = new Scanner(System.in);
    char choice = 0;
    
    do {
      dealer.shuffle();
      dealer.resetHand();
      player.resetHand();
      
      for (int i = 0; i < 2; i++) {
        player.addCardToHand(dealer.deal());
      }
      
      for (int i = 0; i < 2; i++) {
        dealer.addCardToHand(dealer.deal());
      }
      
      //PLAYER
      out.println("\n--- PLAYER ---");
      out.println("\nCurrent " + player);
      char hit = 'Y';
      while (player.hit() && (hit == 'Y' || hit == 'y')) {
        
        out.print("Do you want to hit? [Y/N] :: ");
        hit = keyboard.next().charAt(0);
        
        if (hit == 'Y' || hit == 'y') {
          player.addCardToHand(dealer.deal());
          out.println("\nCurrent " + player);
        }
      }
      
      //DELAER
      out.println("\n--- DEALER ---");
      out.println("\nDealer " + dealer);
      while (dealer.hit() && player.hit()) {
         dealer.addCardToHand(dealer.deal());
         out.println("Dealer " + dealer);
      }
      
      out.println("\n--- RESULTS ---");
      
      out.println("\nPLAYER");
      out.println("Hand Value :: " + player.getHandValue());
      out.println("Hand Size :: " + player.getHandSize());
      out.println("Cards in Hand :: " + player);
      
      out.println("\nDEALER");
      out.println("Hand Value :: " + dealer.getHandValue());
      out.println("Hand Size :: " + dealer.getHandSize());
      out.println("Cards in Hand :: " + dealer);
      
      if (player.getHandValue() > 21) {
        out.println("\nDealer wins - Player busted!\n");
        dealer.addWinCount();
      }
      else if (dealer.getHandValue() > 21) {
        out.println("\nPlayer wins - Dealer busted!\n");
        player.addWinCount();
      }
      else if (player.getHandValue() > dealer.getHandValue()) {
        out.println("\nPlayer has bigger hand value!\n");
        player.addWinCount();
      }
      else if (dealer.getHandValue() > player.getHandValue()) {
        out.println("\nDealer has bigger hand value!\n");
        dealer.addWinCount();
      }
      else {
        out.println("\nTie!\n");
      }
      
      out.println("Dealer has won " + dealer.getWinCount() + " times.");
      out.println("Player has won " + player.getWinCount() + " times.");
      
      out.print("\nDo you want to play again? [Y/N] :: ");
      choice = keyboard.next().charAt(0);
      
    } while (choice == 'Y' || choice == 'y');
    
  }
        
  public static void main(String[] args)
  {
    BlackJack game = new BlackJack();
    game.playGame();
  }
}