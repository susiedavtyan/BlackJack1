import java.util.Vector;

public class Hand implements Showable{

   public Vector<Card> hand;   
   
   public Hand() {
      hand = new Vector<Card>();
   }
   
   public void clear() {
      hand.removeAllElements();
   }
   
   public void addCard(Card c) {
      if (c != null)
         hand.addElement(c);
   }
   
   public void removeCard(Card c) {
      hand.removeElement(c);
   }
   
   public void removeCard(int position) {
         // If the specified position is a valid position in the hand,
         // then the card in that position is removed.
      if (position >= 0 && position < hand.size())
         hand.removeElementAt(position);
   }
   
   public int getCardCount() {
         // Return the number of cards in the hand.
      return hand.size();
   }
   
   public Card getCard(int position) {
          // Get the card from the hand in given position, where positions
          // are numbered starting from 0.  If the specified position is
          // not the position number of a card in the hand, then null
          // is returned.
      if (position >= 0 && position < hand.size())
         return (Card)hand.elementAt(position);
      else
         return null;
   }
   
   public void sortBySuit() {
         // Sorts the cards in the hand so that cards of the same suit are
         // grouped together, and within a suit the cards are sorted by value.
         // Note that aces are considered to have the lowest value, 1.
      Vector<Card> newHand = new Vector<Card>();
      while (hand.size() > 0) {
         int pos = 0;  // Position of minimal card.
         Card c = (Card)hand.elementAt(0);  // Minimal card.
         for (int i = 1; i < hand.size(); i++) {
            Card c1 = (Card)hand.elementAt(i);
            if ( c1.getSuit() < c.getSuit() ||
                    (c1.getSuit() == c.getSuit() && c1.getValue() < c.getValue()) ) {
                pos = i;
                c = c1;
            }
         }
         hand.removeElementAt(pos);
         newHand.addElement(c);
      }
      hand = newHand;
   }
   
   public void sortByValue() {
         // Sorts the cards in the hand so that cards of the same value are
         // grouped together.  Cards with the same value are sorted by suit.
         // Note that aces are considered to have the lowest value, 1.
      Vector<Card> newHand = new Vector<Card>();
      while (hand.size() > 0) {
         int pos = 0;  
         Card c = (Card)hand.elementAt(0);  
         for (int i = 1; i < hand.size(); i++) {
            Card c1 = (Card)hand.elementAt(i);
            if ( c1.getValue() < c.getValue() ||
                    (c1.getValue() == c.getValue() && c1.getSuit() < c.getSuit()) ) {
                pos = i;
                c = c1;
            }
         }
         hand.removeElementAt(pos);
         newHand.addElement(c);
      }
      hand = newHand;

   }
   

}
