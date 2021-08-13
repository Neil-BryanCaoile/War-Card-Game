package com.caoile;


import java.util.ArrayList;

public class WarPlayer extends Player{

    private final ArrayList<StandardCard> cardsWon;
    private StandardCard drawnCard;

    public WarPlayer(String name) {
        super(name);
        cardsWon = new ArrayList<StandardCard>();
    }

    public ArrayList<StandardCard> getPlayingHand() {
        return cardsWon;
    }


    public String toString(){
        StringBuilder cardListOutput = new StringBuilder();
        int i =0;
        for (StandardCard aCard : this.cardsWon){
            cardListOutput.append("\n").append(i).append("-").append(aCard.toString());
            i++;
        }
        return cardListOutput.toString();
    }

    public void draw(Deck deck){
        drawnCard = deck.getCards().get(0);
        deck.getCards().remove(0);
    }

    public StandardCard getDrawnCard() {
        return drawnCard;
    }

    public ArrayList<StandardCard> getCardsWon() {
        return cardsWon;
    }

    @Override
    public void play() {

    }
}
