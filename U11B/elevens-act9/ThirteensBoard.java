import java.util.List;
import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Thirteens.
 */
public class ThirteensBoard extends Board {

    /**
     * The size (number of cards) on the board.
     */
    private static final int BOARD_SIZE = 10;

    /**
     * The ranks of the cards for this game to be sent to the deck.
     */
    private static final String[] RANKS =
        {"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    /**
     * The suits of the cards for this game to be sent to the deck.
     */
    private static final String[] SUITS =
        {"spades", "hearts", "diamonds", "clubs"};

    /**
     * The values of the cards for this game to be sent to the deck.
     */
    private static final int[] POINT_VALUES =
        {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0};

    /**
     * Flag used to control debugging print statements.
     */
    private static final boolean I_AM_DEBUGGING = false;


    /**
     * Creates a new <code>ElevensBoard</code> instance.
     */
     public ThirteensBoard() {
        super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
     }

    /**
     * Determines if the selected cards form a valid group for removal.
     * In Elevens, the legal groups are (1) a pair of non-face cards
     * whose values add to 11, and (2) a group of three cards consisting of
     * a jack, a queen, and a king in some order.
     * @param selectedCards the list of the indices of the selected cards.
     * @return true if the selected cards form a valid group for removal;
     *         false otherwise.
     */
    @Override
    public boolean isLegal(List<Integer> selectedCards) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 9 *** */
      if (selectedCards.size() == 2) {
        return containsPairSum13(selectedCards);
      }
      else if (selectedCards.size() == 1) {
        return containsK(selectedCards);
      }
      return false;
    }

    /**
     * Determine if there are any legal plays left on the board.
     * In Elevens, there is a legal play if the board contains
     * (1) a pair of non-face cards whose values add to 11, or (2) a group
     * of three cards consisting of a jack, a queen, and a king in some order.
     * @return true if there is a legal play left on the board;
     *         false otherwise.
     */
    @Override
    public boolean anotherPlayIsPossible() {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 10 *** */
      List<Integer> selected = super.cardIndexes();
      List<Integer> selectedCards = new ArrayList<Integer>();
      selectedCards.add(0);
      selectedCards.add(0);
      
      for (int a = 0; a < selected.size() - 1; a++) {
        selectedCards.set(0, selected.get(a));
        
        for (int b = a + 1; b < selected.size(); b++) {
          selectedCards.set(1, selected.get(b));
          
          if (containsPairSum13(selectedCards)) {
              return true;
          }
        }
      }
      
      if (containsK(selected)) {
        return true;
      }
      
      return false;
    }

    /**
     * Check for an 13-pair in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find an 13-pair.
     * @return true if the board entries in selectedCards
     *              contain an 13-pair; false otherwise.
     */
    private boolean containsPairSum13(List<Integer> selectedCards) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 10 *** */
      int a = selectedCards.get(0);
      int b = selectedCards.get(1);
      return cardAt(a).pointValue() + cardAt(b).pointValue() == 13;
    }

    /**
     * Check for a K in the selected cards.
     * @param selectedCards selects a subset of this board.  It is list
     *                      of indexes into this board that are searched
     *                      to find a K group.
     * @return true if the board entries in selectedCards
     *              include king; false otherwise.
     */
    private boolean containsK(List<Integer> selectedCards) {
        /* *** TO BE IMPLEMENTED IN ACTIVITY 10 *** */
      for (int item : selectedCards) {
        if (cardAt(item).rank().equals("king")) {
          return true;
        }
      }
      return false;
    }
}
