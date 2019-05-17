//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack
{
  private ArrayList<Playerable> players;

  public BlackJack(int numPlayers)
  {
    players = new ArrayList<Playerable>();
    players.add(new Dealer());
    for (int i = 0; i < numPlayers; i++) {
      players.add(new Player());
    }
  }

  public void playGame()
  {
    Dealer dealer = (Dealer)players.get(0);
    Scanner keyboard = new Scanner(System.in);
    char choice = 0;
    
    do {
      dealer.shuffle();
      
      for (Playerable player : players) {
        player.resetHand();
      }
      
      for (int i = 1; i < players.size(); i++) {
        for (int j = 0; j < 2; j++) {
          players.get(i).addCardToHand(dealer.deal());
        }
      }
      
      for (int i = 0; i < 2; i++) {
        dealer.addCardToHand(dealer.deal());
      }
      
      //PLAYERS
      for (int i = 1; i < players.size(); i ++) {
        Player player = (Player)players.get(i);
        out.println("\n--- PLAYER " + i + " ---");
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
        
        if (player.getHandValue() > 21) {
          out.println("Player " + i + " busted!");
        }
      }
      
      //DEALER
      out.println("\n--- DEALER ---");
      out.println("\nDealer " + dealer);
      
      while (dealer.hit()) {
         dealer.addCardToHand(dealer.deal());
         out.println("Dealer " + dealer);
      }
      
      if (dealer.getHandValue() > 21) {
        out.println("Dealer busted!");
      }
      
      //RESULTS
      out.println("\n--- RESULTS ---");
      
      for (int i = 1; i < players.size(); i++) {
        Player player = (Player)players.get(i);
        out.println("\nPLAYER " + i);
        out.println("Hand Value :: " + player.getHandValue());
        out.println("Hand Size :: " + player.getHandSize());
        out.println("Cards in Hand :: " + player);
      }
      
      out.println("\nDEALER");
      out.println("Hand Value :: " + dealer.getHandValue());
      out.println("Hand Size :: " + dealer.getHandSize());
      out.println("Cards in Hand :: " + dealer);
      
      //WINNNERS
      out.println("\nWINNERS");
      
      int highest = 0;
      for (int i = 0; i < players.size(); i++) {
        int val = players.get(i).getHandValue();
        if (val <= 21 && val > highest) {
          highest = val;
        }
      }
      
      if (highest == 0) {
        out.println("No winner - all players busted!");
      }
      else {
        for (int i = 1; i < players.size(); i++) {
          if (players.get(i).getHandValue() == highest) {
            out.println("Player " + i + " wins!");
            Player winner = (Player)players.get(i);
            winner.addWinCount();
          }
        }
        
        if (dealer.getHandValue() == highest) {
          out.println("Dealer wins!");
          dealer.addWinCount();
        }
      }
      
      out.println("\nDealer has won " + dealer.getWinCount() + " times.");
      for (int i = 1; i < players.size(); i++) {
        out.println("Player " + i + " has won " + players.get(i).getWinCount() + " times.");
      }
      
      out.print("\nDo you want to play again? [Y/N] :: ");
      choice = keyboard.next().charAt(0);
      
    } while (choice == 'Y' || choice == 'y');
    
  }
        
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    int numPlayers;
    do {
      out.print("How many players? :: ");
      numPlayers = keyboard.nextInt();
    } while (numPlayers < 1);
    
    BlackJack game = new BlackJack(numPlayers);
    game.playGame();
  }
}