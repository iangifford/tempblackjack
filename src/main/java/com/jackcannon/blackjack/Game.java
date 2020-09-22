package com.jackcannon.blackjack;

public class Game {

    Deck deck;
    String current_player;

    public Game(){
        this.current_player = "player";
        this.deck = new Deck();
    }

    public void swapPlayer() {
        if(!current_player.equals("player")){
            current_player = "dealer";
        }
        else current_player = "player";
    }

    public String getPlayer() {
        return current_player;
    }

    public Card dealCard() {

        //implement method to return the next card from the deck

        return next_card;
    }
}
