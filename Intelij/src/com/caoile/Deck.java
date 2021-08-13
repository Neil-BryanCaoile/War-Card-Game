package com.caoile;

/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */

import java.util.ArrayList;
import java.util.Random;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Megha Patel
 */
public class Deck {

    //The group of cards, stored in an ArrayList
    private int size;//the size of the grouping
    private ArrayList<StandardCard> cards;

    public Deck() {

        this.cards = new ArrayList<StandardCard>();
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<StandardCard> getCards() {
        return cards;
    }

    public void shuffle() {
        ArrayList<StandardCard> tmpDeck = new ArrayList<StandardCard>();
        Random random = new Random();//Create random

        int randomCardIndex = 0;
        int originalSize = this.cards.size();

        for(int i = 0 ; i < originalSize; i++){
            //Generate Random Index
            randomCardIndex = random.nextInt((this.cards.size() - 1) + 1);
            //add from the temp deck
            tmpDeck.add(this.cards.get(randomCardIndex));
            //Remove from original deck
            this.cards.remove(randomCardIndex);

        }

        this.cards = tmpDeck;
    }




    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

    public void createFullDeck(){
        //Generate Cards
        for (Suit cardSuit : Suit.values() ){
            for (Value cardValue: Value.values()) {
                //Add a new card to the mix
                this.cards.add(new StandardCard(cardSuit,cardValue));
            }
        }
    }

    public String toString(){
        StringBuilder cardListOutput = new StringBuilder();
        int i =0;
        for (StandardCard aCard : this.cards){
            cardListOutput.append("\n").append(i).append("-").append(aCard.toString());
            i++;
        }
        return cardListOutput.toString();
    }



}//end class
