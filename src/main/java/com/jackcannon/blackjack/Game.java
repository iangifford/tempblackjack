package com.jackcannon.blackjack;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Game {

    Deck deck;
    String current_player;
    ImageView[] playerCards;
    ImageView[] dealerCards;
    TextView playerScore;
    TextView dealerScore;
    int playerScore_int;
    int dealerScore_int;
    int hit_count;

    public Game(ImageView[] playerCards, ImageView[] dealerCards, TextView playerScore, TextView dealerScore) {
        this.current_player = "player";
        this.deck = new Deck();
        this.playerCards = playerCards;
        this.dealerCards = dealerCards;
        this.playerScore = playerScore;
        this.dealerScore = dealerScore;
        this.playerScore_int = 0;
        this.dealerScore_int = 0;
        this.hit_count = 0;
    }

    public void swapPlayer() {
        hit_count = 0;
        if(!current_player.equals("player")){
            current_player = "dealer";
        }
        else current_player = "player";
    }

    public String getPlayer() {
        return current_player;
    }

    public Card dealCard() {

        //TODO implement method to return the next card from the deck

    }

    public boolean isOver() {

        //TODO implement method to determine if the game is over or not

    }

    public String getWinner() {

        //TODO implement method to return the winner (called when the game is over)

    }

    public void hit(String player) {
        Card hit_card = dealCard();

        if (player.equals("player")) {
            for (int i = 0; i < 8; i++) {
                if (playerCards[i].getVisibility() == View.INVISIBLE) {

                    //TODO assign image corresponding to hit_card here

                    playerScore_int += hit_card.point_value;
                    playerScore.setText(playerScore_int);
                    playerCards[i].setVisibility(View.VISIBLE);
                    return;
                }
            }
        }

        if (player.equals("dealer")){
            for(int i=0; i < 8; i++) {
                if(dealerCards[i].getVisibility() == View.INVISIBLE) {

                    //TODO assign image corresponding to hit_card here

                    dealerScore_int += hit_card.point_value;
                    dealerScore.setText(dealerScore_int);
                    dealerCards[i].setVisibility(View.VISIBLE);
                    return;
                }
            }
        }

        hit_count++;
    }

    public void resetGame() {
        for(int i=0; i < 8; i++) {
            playerCards[i].setVisibility(View.INVISIBLE);
            dealerCards[i].setVisibility(View.INVISIBLE);
        }

        playerScore_int = 0;
        dealerScore_int = 0;
        playerScore.setText(playerScore_int);
        dealerScore.setText(dealerScore_int);
    }
}
