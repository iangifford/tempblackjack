package com.jackcannon.blackjack;

public class Card {

    String suit;
    String face_value;
    int point_value;

    public Card(String suit, String face_value, int point_value) {
        this.suit = suit;
        this.face_value = face_value;
        this.point_value = point_value;
    }
}
