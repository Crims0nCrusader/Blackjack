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


            System.out.println("Player Hand");
            for(int i = 0; i < player.size(); i++) {
                System.out.println(player.get(i) + " ");
            }
            System.out.println("Dealer Hand");
            for(int i = 1; i < dealer.size(); i++) {
                System.out.println(dealer.get(i) + " ");
            }
            System.out.println("[?]");

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

    public void dealerVal() {
        for(int i = 0; i > dealer.size(); i++) {
            dealerVal += dealer.get(i).getValue();
        }
    }

    public void playerVal() {
        for(int i = 0; i > player.size(); i++) {
            playerVal += player.get(i).getValue();
        }
    }

    private void hitNStay() {
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
                else {
                    System.out.println("sdirujgberoijgrebajigenrujpihbn");
                    hitNStay();
                }

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
                else {
                    System.out.println("spdoiugnrjopgn zdrjkiolg 4arhiopugbarepihujb ");
                    hitNStay();
                }
                //reveal dealer hand & determine whether win or lose
            default:

                System.out.println("[?]");

                System.out.println("misinput");
                hitNStay();
        }
    }
}
