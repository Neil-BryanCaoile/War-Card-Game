package com.caoile;

public class StandardCard extends Card{
    private final Value value;
    private final Suit suit;

    public StandardCard(Suit suit, Value value){
        this.suit = suit;
        this.value = value;
    }

    public String toString(){
        return suit + ":" + value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }
}
