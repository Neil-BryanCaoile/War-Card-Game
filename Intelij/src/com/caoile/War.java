package com.caoile;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class War extends Game {
    public War() {
        super("War Card Game");
    }
    Scanner scanner = new Scanner(System.in);

    @Override
    public void play() {


        System.out.println("\n******************************************************");
        System.out.println("           Welcome to " + super.getName());
        System.out.println("******************************************************\n");

        boolean isTwoPlayer = false;

        while (true){
            System.out.print("Is there two players? (y/n): ");
            char input = scanner.next().toLowerCase().charAt(0);
            scanner.nextLine();

            if (input == 'y'){
                isTwoPlayer = true;
                break;
            }else if (input == 'n'){
                break;
            }else {
                System.out.println("Invalid input please try again.");
            }
        }


        //Players
        WarPlayer player1;
        WarPlayer player2;

        //Create playingDeck;
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();


        //Player name
        String player1Name ="";
        String player2Name ="Computer";

        //Get player 1 name
        System.out.println("\n******************************************************");
        System.out.print("Enter player 1 name: ");
        player1Name = scanner.nextLine();

        //Get player 2 name
        if (isTwoPlayer) {
            System.out.print("Enter player 2 name: ");
            player2Name = scanner.nextLine();
        }
        System.out.println("******************************************************\n");

        //Create players
        player1 = new WarPlayer(player1Name);
        player2 = new WarPlayer(player2Name);

        ArrayList <StandardCard> cardsCurrentlyDrawn = new ArrayList<StandardCard>();
        int round = 1;
        while (playingDeck.getCards().size() != 0){


            System.out.println("\n-------------------------------------------------------");
            System.out.println("\n                     Round " + round + "! \n");
            System.out.println("\n-------------------------------------------------------");

            System.out.println("\n******************************************************");
            System.out.println( "       Press [enter] to draw a card for " + player1.getName());
            System.out.println("******************************************************");
            scanner.nextLine();
            player1.draw(playingDeck);
            System.out.println( player1.getName() + "'s card is: " + player1.getDrawnCard());
            cardsCurrentlyDrawn.add(player1.getDrawnCard());

            System.out.println("\n******************************************************");
            System.out.println( "        Press [enter] to draw a card for " + player2.getName());
            System.out.println("*******************************************************");
            scanner.nextLine();
            player2.draw(playingDeck);
            System.out.println( player2.getName() + "'s card is: " + player2.getDrawnCard());
            cardsCurrentlyDrawn.add(player2.getDrawnCard());

            System.out.println("\n******************************************************");
            System.out.println( "             Press [enter] to compare");
            System.out.println("******************************************************\n");
            scanner.nextLine();



            WarPlayer roundWinner = getRoundWinner(player1, player2);
            declareRoundWinner(roundWinner, cardsCurrentlyDrawn);
            showCardsWon(player1,player2);

            ++round;

        }



        declareWinner(player1, player2);

    }
    public WarPlayer getRoundWinner(WarPlayer p1, WarPlayer p2){
        WarPlayer playerRoundWinner = p2;
        System.out.println("-------------------------------------------------------");
        if(cardValueToInt(p1.getDrawnCard()) > cardValueToInt(p2.getDrawnCard())){
            playerRoundWinner = p1;
            System.out.println("              " + p1.getDrawnCard() + " > " + p2.getDrawnCard());
        }else{
            System.out.println("              " + p2.getDrawnCard() + " > " + p1.getDrawnCard());
        }
        System.out.println("-------------------------------------------------------");
        return playerRoundWinner;
    }
    
    public int cardValueToInt(StandardCard card){
        int value = 0;
        switch (card.getValue()){
            case TWO:
                value =  2;
                break;
            case THREE:
                value =  3;
                break;
            case FOUR:
                value =  4;
                break;
            case FIVE:
                value =  5;
                break;
            case SIX:
                value =  6;
                break;
            case SEVEN:
                value =  7;
                break;
            case EIGHT:
                value =  8;
                break;
            case NINE:
                value =  9;
                break;
            case TEN:
                value =  10;
                break;
            case JACK:
                value =  11;
                break;
            case KING:
                value =  12;
                break;
            case QUEEN:
                value =  13;
                break;
            case ACE:
                value =  14;
                break;
        }
        return value;
    }

    public void declareRoundWinner(WarPlayer roundWinner, ArrayList<StandardCard> cardsCurrentlyDrawn){
        System.out.println("\n******************************************************");
        System.out.println( "              " + roundWinner.getName() + "  won for this round! ");
        System.out.println( "          press [enter] to continue.");
        System.out.println("******************************************************\n");
        roundWinner.getCardsWon().addAll(cardsCurrentlyDrawn);
        cardsCurrentlyDrawn.clear();
        scanner.nextLine();
    }
    public void showCardsWon(WarPlayer p1, WarPlayer p2){
        System.out.println("******************************************************");
        System.out.println("               ~ Player cards won ~");
        System.out.println("             n" + p1.getName() + " [" + p1.getCardsWon().size() + "] | " + p2.getName() + " [" + p2.getCardsWon().size() + "] " );
        if(p1.getCardsWon().size() > p2.getCardsWon().size()){
            System.out.println("              ~ " + p1.getName() + " is winning!" + "~ ");
        }else{
            System.out.println("               ~ " + p2.getName() + " is winning!" + "~ ");
        }
        System.out.println( "          press [enter] to go to next round");
        System.out.println("******************************************************\n");
        scanner.nextLine();
    }

    public void declareWinner(WarPlayer p1, WarPlayer p2) {
        System.out.println("******************************************************\n");
        System.out.println("________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ \n" +
                "________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ \n" +
                "___¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ \n" +
                "_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ \n" +
                "¶¶¶¶______¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_______¶¶¶¶ \n" +
                "¶¶¶_______¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶________¶¶¶ \n" +
                "¶¶¶____¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶____¶¶¶¶ \n" +
                "_¶¶¶___¶¶¶_¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_¶¶¶____¶¶¶ \n" +
                "___¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶_¶¶¶¶¶ \n" +
                "______¶¶¶¶¶¶__¶¶¶¶¶¶¶¶¶¶¶¶¶¶___¶¶¶¶¶¶ \n" +
                "_______________¶¶¶¶¶¶¶¶¶¶¶¶ \n" +
                "_________________¶¶¶¶¶¶¶¶ \n" +
                "___________________¶¶¶¶ \n" +
                "___________________¶¶¶¶ \n" +
                "_______________¶¶¶¶¶¶¶¶¶¶¶¶ \n" +
                "____________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ \n" +
                "____________¶¶¶____________¶¶¶ \n" +
                "____________¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶ \n");
        if(p1.getCardsWon().size() > p2.getCardsWon().size()){
            System.out.println("            " + p1.getName() + " won!");
        }else if(p1.getCardsWon().size() < p2.getCardsWon().size()){
            System.out.println(p2.getName() + " won!");
        }else{
            System.out.println("DRAW!");
        }
        System.out.println("\n******************************************************");

    }
}
