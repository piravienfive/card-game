package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class CardGame {

    ArrayList<String> numbers = new ArrayList<String>(
            Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13")
    );

    public void createDeck() {
        ArrayList<Card> deck = new ArrayList<Card>();
        for (String number : numbers) {
            Card spadeCard = new Card(Integer.parseInt(number),"Spades");
            deck.add(spadeCard);
            Card clubCard = new Card(Integer.parseInt(number),"Clubs");
            deck.add(clubCard);
            Card heartCard = new Card(Integer.parseInt(number),"Hearts");
            deck.add(heartCard);
            Card diamondCard = new Card(Integer.parseInt(number),"Diamonds");
            deck.add(diamondCard);
            System.out.println(deck);
            System.out.println(deck.size());
        }
        ;


    }
}
