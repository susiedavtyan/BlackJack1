import java.util.Scanner;
public class mainClass {

       public static void main(String[] args) {
       
          int money;          
          int bet;            
          boolean userWins;   
          
 
          System.out.println("Welcome to the game of blackjack.");
          
          money = 100;  
          
          @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);

          while (true) {
              System.out.println("You have " + money + " dollars.");
              do {
            	  System.out.println("How many dollars do you want to bet?  (Enter 0 to end.)");
                 bet = scan.nextInt();
                 if (bet < 0 || bet > money)
                     System.out.println("Your answer must be between 0 and " + money + '.');
              } while (bet < 0 || bet > money);
              if (bet == 0)
                 break;
              userWins = playBlackjack();
              if (userWins)
                 money = money + bet;
              else
                 money = money - bet;
              money = scan.nextInt();
              if (money == 0) {
            	  System.out.println("Looks like you've are out of money!");
                 break;
              }
          }
          
          System.out.println();
          System.out.println("You leave with $" + money + '.');
       
       } 
       
       
       @SuppressWarnings("resource")
	static boolean playBlackjack() {
    
          Deck deck;                 
          blackJack dealerHand;   
          blackJack userHand;     
          
          deck = new Deck();
          dealerHand = new blackJack();
          userHand = new blackJack();
              
          deck.shuffle();
          dealerHand.addCard( deck.dealCard() );
          dealerHand.addCard( deck.dealCard() );
          userHand.addCard( deck.dealCard() );
          userHand.addCard( deck.dealCard() );
          
          
  
          if (dealerHand.getValue() == 21) {
        	  System.out.println("Dealer has the " + dealerHand.getCard(0)
                                       + " and the " + dealerHand.getCard(1) + ".");
        	  System.out.println("User has the " + userHand.getCard(0)
                                         + " and the " + userHand.getCard(1) + ".");
        	  System.out.println();
        	  System.out.println("Dealer has Blackjack.  Dealer wins.");
               return false;
          }
          
          if (userHand.getValue() == 21) {
        	  System.out.println("Dealer has the " + dealerHand.getCard(0)
                                       + " and the " + dealerHand.getCard(1) + ".");
        	  System.out.println("User has the " + userHand.getCard(0)
                                         + " and the " + userHand.getCard(1) + ".");
        	
        	  System.out.println("You have Blackjack.  You win.");
               return true;
          }
          

          while (true) {
                  
              Scanner scan = new Scanner(System.in);
               System.out.println("Your cards are:");
               for ( int i = 0; i < userHand.getCardCount(); i++ )
            	   System.out.println("    " + userHand.getCard(i));
               System.out.println("Your total is " + userHand.getValue());
               System.out.println("Dealer is showing the " + dealerHand.getCard(0));
               System.out.println("Hit (H) or Stand (S)? ");
               char H;
               char S;
               do {
                  if (scan.nextInt() != 'H' && scan.nextInt() != 'S')
                	  System.out.println("H or S:  ");
               } while (scan.nextInt() != 'H' && scan.nextInt() != 'S');
    
               if ( scan.nextInt() == 'S' ) {
                   break;
               }
               else {  
                   Card newCard = deck.dealCard();
                   userHand.addCard(newCard);
                   System.out.println("User hits.");
                   System.out.println("Your card is the " + newCard);
                   System.out.println("Your total is now " + userHand.getValue());
                   if (userHand.getValue() > 21) {
                	   System.out.println("You busted by going over 21.  You lose.");
                	   System.out.println("Dealer's other card was the " + dealerHand.getCard(1));
                       return false;  
                   }
               }
               
          } 
          /* If we get to this point, the user has Stood with 21 or less.  Now, it's
             the dealer's chance to draw.  Dealer draws cards until the dealer's
             total is > 16.  If dealer goes over 21, the dealer loses.
          */
    
          System.out.println("User stands.");
          System.out.println("Dealer's cards are");
          System.out.println("    " + dealerHand.getCard(0));
          System.out.println("    " + dealerHand.getCard(1));
          while (dealerHand.getValue() <= 16) {
             Card newCard = deck.dealCard();
             System.out.println("Dealer hits and gets the " + newCard);
             dealerHand.addCard(newCard);
             if (dealerHand.getValue() > 21) {
            	 System.out.println("Dealer l by going over 21.  You win.");
                return true;
             }
          }
          System.out.println("Dealer's total is " + dealerHand.getValue());
          
                  
          if (dealerHand.getValue() == userHand.getValue()) {
        	  System.out.println("Dealer wins on a tie.  You lose.");
             return false;
          }
          else if (dealerHand.getValue() > userHand.getValue()) {
        	  System.out.println("Dealer wins, " + dealerHand.getValue() 
                              + " points to " + userHand.getValue() + ".");
             return false;
          }
          else {
        	  System.out.println("You win, " + userHand.getValue() 
                              + " points to " + dealerHand.getValue() + ".");
             return true;
          }
    
       }  

    } 
