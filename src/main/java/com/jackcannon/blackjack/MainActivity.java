package com.jackcannon.blackjack;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Main Activity Class
 * This class acts as the Controller for the BlackJack game
 * CS482 Software Engineering
 * Dr. Raunak
 * @author Jack Cannon
 * @author Ian Gifford
 */
public class MainActivity extends AppCompatActivity {

    Game blackJackGame;
    ImageView[] playerCards;
    ImageView[] dealerCards;

    TextView playerScore;
    TextView dealerScore;
    TextView winnerField;

    Button hitButton;
    Button stopButton;

    /**
     * On Create Method
     * Initializes the main View and instantiates other view objects for later use
     * @param savedInstanceState android system parameter
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Cards assigned to the player
        playerCards = new ImageView[8];
        playerCards[0] = (ImageView) findViewById(R.id.player_card_1);
        playerCards[1] = (ImageView) findViewById(R.id.player_card_2);
        playerCards[2] = (ImageView) findViewById(R.id.player_card_3);
        playerCards[3] = (ImageView) findViewById(R.id.player_card_4);
        playerCards[4] = (ImageView) findViewById(R.id.player_card_5);
        playerCards[5] = (ImageView) findViewById(R.id.player_card_6);
        playerCards[6] = (ImageView) findViewById(R.id.player_card_7);
        playerCards[7] = (ImageView) findViewById(R.id.player_card_8);

        //Cards assigned to the dealer
        dealerCards = new ImageView[8];
        dealerCards[0] = (ImageView) findViewById(R.id.dealer_card_1);
        dealerCards[1] = (ImageView) findViewById(R.id.dealer_card_2);
        dealerCards[2] = (ImageView) findViewById(R.id.dealer_card_3);
        dealerCards[3] = (ImageView) findViewById(R.id.dealer_card_4);
        dealerCards[4] = (ImageView) findViewById(R.id.dealer_card_5);
        dealerCards[5] = (ImageView) findViewById(R.id.dealer_card_6);
        dealerCards[6] = (ImageView) findViewById(R.id.dealer_card_7);
        dealerCards[7] = (ImageView) findViewById(R.id.dealer_card_8);

        //Scores
        playerScore = (TextView) findViewById(R.id.player_score_field);
        dealerScore = (TextView) findViewById(R.id.dealer_score_field);
        winnerField = (TextView) findViewById(R.id.winner_field);

        //Buttons
        hitButton = (Button) findViewById(R.id.hit_button);
        stopButton = (Button) findViewById(R.id.stop_button);

        //Game initialization
        blackJackGame = new Game(playerCards, dealerCards, playerScore, dealerScore, hitButton, stopButton);
        blackJackGame.resetGame();
    }

    /**
     * New Game Method
     * Initializes the View with a new game when the new game button is clicked
     * @param view the view from activity_main.xml
     */
    public void new_game(View view) {

        //BlackJack games begin with 2 cards dealt to each player
        blackJackGame.resetGame();
        blackJackGame.hit("player");
        blackJackGame.hit("dealer");
        blackJackGame.hit("player");
        blackJackGame.hit("dealer");
        blackJackGame.hit_count = 0;
    }

    /**
     * Hit Method
     * Allows the View to update by adding another card when the user selects the hit button
     * @param view the view from activity_main.xml
     */
    public void hit(View view) {

        //"player" will be the only user capable of selecting the Hit button
        blackJackGame.hit("player");

        //After 3 hits, prevent user from clicking Hit button
        if(blackJackGame.hit_count == 3) {
            hitButton.setEnabled(false);
        }

        //After every hit, check if the game has been won or tied
        if(blackJackGame.isOver()){
            winnerField.setText(blackJackGame.winner);
        }
    }

    /**
     * Stop Method
     * Allows the user to terminate their turn if they choose
     * @param view the view from activity_main.xml
     */
    public void stop(View view) {

        //Change to the Dealer and deactivate the Hit and Stop buttons
        blackJackGame.swapPlayer();
        if(blackJackGame.current_player.equals("dealer")) {
            hitButton.setEnabled(false);
            stopButton.setEnabled(false);
            blackJackGame.executeDealerTurn();
        }
    }
}