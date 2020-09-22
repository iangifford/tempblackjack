package com.jackcannon.blackjack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Game blackJackGame;
    TextView[] playerCards;
    TextView[] dealerCards;

    TextView playerScore;
    TextView dealerScore;

    int playerScore_int;
    int dealerScore_int;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerCards = new TextView[8];
        playerCards[0] = (TextView) findViewById(R.id.player_card_1);
        playerCards[1] = (TextView) findViewById(R.id.player_card_2);
        playerCards[2] = (TextView) findViewById(R.id.player_card_3);
        playerCards[3] = (TextView) findViewById(R.id.player_card_4);
        playerCards[4] = (TextView) findViewById(R.id.player_card_5);
        playerCards[5] = (TextView) findViewById(R.id.player_card_6);
        playerCards[6] = (TextView) findViewById(R.id.player_card_7);
        playerCards[7] = (TextView) findViewById(R.id.player_card_8);

        dealerCards = new TextView[8];
        dealerCards[0] = (TextView) findViewById(R.id.dealer_card_1);
        dealerCards[1] = (TextView) findViewById(R.id.dealer_card_2);
        dealerCards[2] = (TextView) findViewById(R.id.dealer_card_3);
        dealerCards[3] = (TextView) findViewById(R.id.dealer_card_4);
        dealerCards[4] = (TextView) findViewById(R.id.dealer_card_5);
        dealerCards[5] = (TextView) findViewById(R.id.dealer_card_6);
        dealerCards[6] = (TextView) findViewById(R.id.dealer_card_7);
        dealerCards[7] = (TextView) findViewById(R.id.dealer_card_8);

        playerScore = (TextView) findViewById(R.id.player_score_field);
        dealerScore = (TextView) findViewById(R.id.dealer_score_field);

        playerScore_int = 0;
        dealerScore_int = 0;

        playerScore.setText(playerScore_int);
        dealerScore.setText(dealerScore_int);


        for(int i=0; i < 8; i++) {
            playerCards[i].setVisibility(View.INVISIBLE);
            dealerCards[i].setVisibility(View.INVISIBLE);
        }
    }

    public void new_game(View view) {
        for(int i=0; i < 8; i++) {
            playerCards[i].setVisibility(View.INVISIBLE);
            dealerCards[i].setVisibility(View.INVISIBLE);
        }
        blackJackGame = new Game();
        playerScore_int = 0;
        dealerScore_int = 0;
        playerScore.setText(playerScore_int);
        dealerScore.setText(dealerScore_int);
    }

    public void hit(View view) {
        Card hit_card = blackJackGame.dealCard();

        if (blackJackGame.getPlayer().equals("player")) {
            for (int i = 0; i < 8; i++) {
                if (playerCards[i].getVisibility() == View.INVISIBLE) {

                    //assign image corresponding to hit_card here

                    playerScore_int += hit_card.point_value;
                    playerScore.setText(playerScore_int);
                    playerCards[i].setVisibility(View.VISIBLE);
                    return;
                }
            }
        }

        if (blackJackGame.getPlayer().equals("dealer")){
            for(int i=0; i < 8; i++) {
                if(dealerCards[i].getVisibility() == View.INVISIBLE) {

                    //assign image corresponding to hit_card here

                    dealerScore_int += hit_card.point_value;
                    dealerScore.setText(dealerScore_int);
                    dealerCards[i].setVisibility(View.VISIBLE);
                    return;
                }
            }
        }
    }

    public void stop(View view) {
        blackJackGame.swapPlayer();
    }
}