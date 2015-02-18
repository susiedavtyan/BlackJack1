public class Card {

	     public interface cards{ final int SPADES = 0;       
	                             final int  HEARTS = 1;
	                             final int DIAMONDS = 2;
	                             final int CLUBS = 3;
	    }
	                            
	    public interface types{ final static int ACE = 1;          // Codes for the non-numeric cards.
	    						final static int JACK = 11;        //   Cards 2 through 10 have their 
	    						final static int QUEEN = 12;       //   numerical values for their codes.
	    						final static int KING = 13;
	    }

		private static final int SPADES = 0;

		private static final int HEARTS = 1;

		private static final int DIAMONDS = 2;

		private static final int CLUBS = 3;
	                            
	    private final int suit;   
	                            
	                              
	    private final int value;  
	                             
	    public Card(int theValue, int theSuit) {
	            // Construct a card with the specified value and suit.
	            // Value must be between 1 and 13.  Suit must be between
	            // 0 and 3.  If the parameters are outside these ranges,
	            // the constructed card object will be invalid.
	        value = theValue;
	        suit = theSuit;
	    }
	        
	    public int getSuit() {
	        return suit;
	    }
	    
	    public int getValue() {
	        return value;
	    }
	    
	    public String getSuitAsString () {
	        switch ( suit ) {
	           case SPADES:   return "Spades";
	           case HEARTS:   return "Hearts";
	           case DIAMONDS: return "Diamonds";
	           case CLUBS:    return "Clubs";
	           default:       return "??";
	        }
	    }
	    
	    public String getValueAsString () {
	        switch ( value ) {
	           case 1:   return "Ace";
	           case 2:   return "2";
	           case 3:   return "3";
	           case 4:   return "4";
	           case 5:   return "5";
	           case 6:   return "6";
	           case 7:   return "7";
	           case 8:   return "8";
	           case 9:   return "9";
	           case 10:  return "10";
	           case 11:  return "Jack";
	           case 12:  return "Queen";
	           case 13:  return "King";
	           default:  return "??";
	        }
	    }
	    
	    public String toString() {
	        return getValueAsString() + " of " + getSuitAsString();
	    }
	    
	} 	
