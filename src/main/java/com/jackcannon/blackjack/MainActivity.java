package com.jackcannon.blackjack;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Game blackJackGame;
    TextView[] playerCards;
    TextView[] dealerCards;

    TextView playerScore;
    TextView dealerScore;

    Button hitButton;

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

        hitButton = (Button) findViewById(R.id.hit_button);

        blackJackGame = new Game(playerCards, dealerCards, playerScore, dealerScore);
        blackJackGame.resetGame();
    }

    public void new_game(View view) {
        blackJackGame.resetGame();
        blackJackGame.hit("player");
        blackJackGame.hit("dealer");
        blackJackGame.hit("player");
        blackJackGame.hit("dealer");
        blackJackGame.hit_count = 0;
    }

    public void hit(View view) {
        blackJackGame.hit(blackJackGame.getPlayer());
        if(blackJackGame.hit_count == 3) {
            hitButton.setEnabled(false);
        }
        if(blackJackGame.isOver()){
            AlertDialog.Builder builder = new AlertDialog.Builder(); //TODO add parameter
            if(blackJackGame.getWinner().equals("player")) {
                builder.setMessage(blackJackGame.getWinner() + " Won!").setTitle("WINNER!");
            }
            else builder.setMessage(blackJackGame.getWinner() + " Won!").setTitle("GAME OVER");
            AlertDialog dialog = builder.create();
            //enable the dialog later
        }
    }

    public void stop(View view) {
        blackJackGame.swapPlayer();
        hitButton.setEnabled(true);
    }
}