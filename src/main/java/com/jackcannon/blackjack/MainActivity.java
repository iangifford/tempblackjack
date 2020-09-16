package com.jackcannon.blackjack;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Game blackJackGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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