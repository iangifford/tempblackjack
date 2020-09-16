package com.jackcannon.blackjack;

public class Deck {

    Card[] deck = new Card[52];

    public Deck() {
        deck[0] = new Card("Clubs", "2", 2);
        deck[1] = new Card("Clubs", "3", 3);
        deck[2] = new Card("Clubs", "4", 4);
        deck[3] = new Card("Clubs", "5", 5);
        deck[4] = new Card("Clubs", "6", 6);
        deck[5] = new Card("Clubs", "7", 7);
        deck[6] = new Card("Clubs", "8", 8);
        deck[7] = new Card("Clubs", "9", 9);
        deck[8] = new Card("Clubs", "10", 10);
        deck[9] = new Card("Clubs", "Jack", 10);
        deck[10] = new Card("Clubs", "King", 10);
        deck[11] = new Card("Clubs", "Queen", 10);
        deck[12] = new Card("Clubs", "Ace", 11);

        deck[13] = new Card("Hearts", "2", 2);
        deck[14] = new Card("Hearts", "3", 3);
        deck[15] = new Card("Hearts", "4", 4);
        deck[16] = new Card("Hearts", "5", 5);
        deck[17] = new Card("Hearts", "6", 6);
        deck[18] = new Card("Hearts", "7", 7);
        deck[19] = new Card("Hearts", "8", 8);
        deck[20] = new Card("Hearts", "9", 9);
        deck[21] = new Card("Hearts", "10", 10);
        deck[22] = new Card("Hearts", "Jack", 10);
        deck[23] = new Card("Hearts", "King", 10);
        deck[24] = new Card("Hearts", "Queen", 10);
        deck[25] = new Card("Hearts", "Ace", 11);

        deck[26] = new Card("Diamonds", "2", 2);
        deck[27] = new Card("Diamonds", "3", 3);
        deck[28] = new Card("Diamonds", "4", 4);
        deck[29] = new Card("Diamonds", "5", 5);
        deck[30] = new Card("Diamonds", "6", 6);
        deck[31] = new Card("Diamonds", "7", 7);
        deck[32] = new Card("Diamonds", "8", 8);
        deck[33] = new Card("Diamonds", "9", 9);
        deck[34] = new Card("Diamonds", "10", 10);
        deck[35] = new Card("Diamonds", "Jack", 10);
        deck[36] = new Card("Diamonds", "King", 10);
        deck[37] = new Card("Diamonds", "Queen", 10);
        deck[38] = new Card("Diamonds", "Ace", 11);

        deck[39] = new Card("Spades", "2", 2);
        deck[40] = new Card("Spades", "3", 3);
        deck[41] = new Card("Spades", "4", 4);
        deck[42] = new Card("Spades", "5", 5);
        deck[43] = new Card("Spades", "6", 6);
        deck[44] = new Card("Spades", "7", 7);
        deck[45] = new Card("Spades", "8", 8);
        deck[46] = new Card("Spades", "9", 9);
        deck[47] = new Card("Spades", "10", 10);
        deck[48] = new Card("Spades", "Jack", 10);
        deck[49] = new Card("Spades", "King", 10);
        deck[50] = new Card("Spades", "Queen", 10);
        deck[51] = new Card("Spades", "Ace", 11);

        //WRITE A SHUFFLE ALGORITHM FOR THE CARDS

    }

}
