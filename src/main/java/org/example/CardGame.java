package org.example;

import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Arrays;

public class CardGame {

    ArrayList<String> numbers = new ArrayList<String>(
            Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13")
    );

    ArrayList<Card> deckOfCards = new ArrayList<Card>();

    public ArrayList<Card> getDeck() {
        for (String number : numbers) {
            Card spadeCard = new Card(Integer.parseInt(number),"♠");
            deckOfCards.add(spadeCard);
            Card clubCard = new Card(Integer.parseInt(number),"♣");
            deckOfCards.add(clubCard);
            Card heartCard = new Card(Integer.parseInt(number),"♥");
            deckOfCards.add(heartCard);
            Card diamondCard = new Card(Integer.parseInt(number),"♦");
            deckOfCards.add(diamondCard);
        }
        return deckOfCards;
    }

    public ArrayList<String> to_String(){
        ArrayList<String> describedDeck = new ArrayList<String>();
        for (Card card : deckOfCards){
            describedDeck.add(card.name);
        }
        System.out.println(describedDeck);
        System.out.println(describedDeck.size());
    return describedDeck;
    }

    public Card dealCard() {
        return deckOfCards.getFirst();
    }

    public void sortDeckInNumberOrder() {
        ArrayList<Card> ascendingCards = new ArrayList<Card>();
        for (int i = 0; i < deckOfCards.size(); i++ ){
            for (int k = 0; k < deckOfCards.size(); k++){
                if(deckOfCards.get(i).value <= deckOfCards.get(k).value){
                    Card hold = deckOfCards.get(i);
                    deckOfCards.set(i, deckOfCards.get(k));
                    deckOfCards.set(k, hold);
                }
            }

        }
        System.out.println(deckOfCards);
        System.out.println(deckOfCards.size());;
    }
}
