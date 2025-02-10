package org.example;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Arrays;

public class CardGame {

    ArrayList<String> numbers = new ArrayList<String>(
            Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13")
    );

    ArrayList<Card> deck = new ArrayList<Card>();

    public ArrayList<Card> getDeck() {
        for (String number : numbers) {
            Card spadeCard = new Card(Integer.parseInt(number),"♠");
            deck.add(spadeCard);
            Card clubCard = new Card(Integer.parseInt(number),"♣");
            deck.add(clubCard);
            Card heartCard = new Card(Integer.parseInt(number),"♥");
            deck.add(heartCard);
            Card diamondCard = new Card(Integer.parseInt(number),"♦");
            deck.add(diamondCard);
        }
        return deck;
    }
    public ArrayList<String> describedDeck = new ArrayList<String>();
    public ArrayList<String> to_String(){

        for (Card card : deck){
            describedDeck.add(card.name);
        }
        System.out.println(describedDeck);
    return describedDeck;
    }
}
