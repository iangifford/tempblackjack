package com.jackcannon.blackjack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Game blackJackGame;
    TextView[] playerCards;
    TextView[] dealerCards;
    
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
    }

    public void new_game(View view) {
        blackJackGame = new Game();
    }

    public void hit(View view) {
        blackJackGame.dealCard();
    }

    public void stop(View view) {
        blackJackGame.swapPlayer();
    }
}