import java.util.ArrayList;
import java.util.Scanner;

public class BlackJack {

    private int dealerVal = 0;
    private int playerVal = 0;
    private Deck deck;
    private ArrayList<Card> player;
    private ArrayList<Card> dealer;

    Scanner kb;

    public BlackJack() {
        deck = new Deck();
        player = new ArrayList<>();
        dealer = new ArrayList<>();
        kb = new Scanner(System.in);
    }

    public static void main(String[] args) {
        BlackJack game = new BlackJack();
        game.run();
    }

    private void run() {

        deck.shuffle();

        player.add(deck.getCard());
        dealer.add(deck.getCard());
        player.add(deck.getCard());
        dealer.add(deck.getCard());
        playerValue();
        dealerValue();


            System.out.println("Player Hand");
            for(int i = 0; i < player.size(); i++) {
                System.out.println(player.get(i) + " ");
            }
            System.out.println("Dealer Hand");
            for(int i = 1; i < dealer.size(); i++) {
                System.out.println(dealer.get(i) + " ");
            }
            System.out.println("[?]");
            playerValue();
            dealerValue();
            hitNStay();

        //while(response.equals("hit")) {...}
        //do{...}while(logic);
        /*
        for(int i = 0; i < player.size(); i++) {\
            //not a complete statement below
            //print what is below
            player.get(i)?
        }
         */
        // playerTurn()
        // dealerTurn()
        // calcHandValue()
    }

    public void dealerValue() {
        dealerVal = 0;
        for(int i = 0; i < dealer.size(); i++) {
            dealerVal += dealer.get(i).getValue();
        }
    }

    public void playerValue() {
        playerVal = 0;
        for(int b = 0; b < player.size(); b++) {
            playerVal += player.get(b).getValue();
        }
    }

    private void hitNStay() {
        playerValue();
        dealerValue();
        System.out.println();
        System.out.println("hit or stay?");

        switch(kb.nextLine()) {
            case "hit":


                if(dealerVal < 17) {
                    dealer.add(deck.getCard());
                }

                    player.add(deck.getCard());

                System.out.println("Player Hand");
                for(int i = 0; i < player.size(); i++) {
                    System.out.println(player.get(i) + " ");
                }
                System.out.println("Dealer Hand");
                for(int i = 1; i < dealer.size(); i++) {
                    System.out.println(dealer.get(i));
                }
                System.out.println("[?]");

                if(playerVal == 21) {
                    System.out.println("Free money");
                    break;
                }
                else if(playerVal > 21) {
                    System.out.println("You Lose!");
                    break;
                }
                else if(dealerVal > 21) {
                    System.out.println("You Win!");
                    break;
                }
                else if(dealerVal == 21) {
                    System.out.println("Free money for us");
                    break;
                }

                hitNStay();
                break;

            case "stay":

                System.out.println("Player Hand");
                for(int i = 0; i < player.size(); i++) {
                    System.out.println(player.get(i) + " ");
                }
                System.out.println("Dealer Hand");
                for(int i = 1; i < dealer.size(); i++) {
                    System.out.println(dealer.get(i));
                }
                System.out.println("[?]");

                if(dealerVal == playerVal) {
                    System.out.println("It is a push, Game over!");
                    break;
                }
                else if(playerVal > dealerVal) {
                    System.out.println("You Win!");
                    break;
                }
                else if(playerVal < dealerVal) {
                    System.out.println("You Lose!");
                    break;
                }

                break;
                //reveal dealer hand & determine whether win or lose
            default:

                System.out.println("[?]");

                System.out.println("misinput");
                hitNStay();
        }
    }
}
