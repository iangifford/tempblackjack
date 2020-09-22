package com.jackcannon.blackjack;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Game blackJackGame;
    ImageView[] playerCards;
    ImageView[] dealerCards;

    TextView playerScore;
    TextView dealerScore;
    TextView winnerField;

    Button hitButton;
    Button stopButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerCards = new ImageView[8];
        playerCards[0] = (ImageView) findViewById(R.id.player_card_1);
        playerCards[1] = (ImageView) findViewById(R.id.player_card_2);
        playerCards[2] = (ImageView) findViewById(R.id.player_card_3);
        playerCards[3] = (ImageView) findViewById(R.id.player_card_4);
        playerCards[4] = (ImageView) findViewById(R.id.player_card_5);
        playerCards[5] = (ImageView) findViewById(R.id.player_card_6);
        playerCards[6] = (ImageView) findViewById(R.id.player_card_7);
        playerCards[7] = (ImageView) findViewById(R.id.player_card_8);

        dealerCards = new ImageView[8];
        dealerCards[0] = (ImageView) findViewById(R.id.dealer_card_1);
        dealerCards[1] = (ImageView) findViewById(R.id.dealer_card_2);
        dealerCards[2] = (ImageView) findViewById(R.id.dealer_card_3);
        dealerCards[3] = (ImageView) findViewById(R.id.dealer_card_4);
        dealerCards[4] = (ImageView) findViewById(R.id.dealer_card_5);
        dealerCards[5] = (ImageView) findViewById(R.id.dealer_card_6);
        dealerCards[6] = (ImageView) findViewById(R.id.dealer_card_7);
        dealerCards[7] = (ImageView) findViewById(R.id.dealer_card_8);

        playerScore = (TextView) findViewById(R.id.player_score_field);
        dealerScore = (TextView) findViewById(R.id.dealer_score_field);
        winnerField = (TextView) findViewById(R.id.winner_field);

        hitButton = (Button) findViewById(R.id.hit_button);
        stopButton = (Button) findViewById(R.id.stop_button);

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
        blackJackGame.hit("player");
        if(blackJackGame.hit_count == 3) {
            hitButton.setEnabled(false);
        }
        if(blackJackGame.isOver()){
            winnerField.setText(blackJackGame.winner);
        }
    }

    public void stop(View view) {
        blackJackGame.swapPlayer();
        if(blackJackGame.current_player.equals("dealer")) {
            hitButton.setEnabled(false);
            stopButton.setEnabled(false);
            blackJackGame.executeDealerTurn();
        }
        else {
            hitButton.setEnabled(true);
            stopButton.setEnabled(true);
        }
    }
}