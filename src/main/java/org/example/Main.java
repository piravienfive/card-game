package org.example;
//Stage 1
//        Using classes, ArrayLists and methods, create a deck of Cards.
//You should use the following classes:
//CardGame
//● Contains an ArrayList<Card> for the deckOfCards that contains all 52 cards. This is created and populated when the game is constructed.
//        ● Has a name which is also defined in the constructor.
//        ● Has a getDeck method that lists out the cards in the deck.
//Card
//● Has a String suit. Use the unicode characters of heart, club, diamond and spade.
//        ● Has a String symbol (2,3,4,5,6,7,8,9,10,J,Q,K,A)
//● Has an int value (2,3,4,5,6,7,8,9,10,11,12,13,14)
//● Has a toString method that describes the class
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CardGame game = new CardGame();
        game.createDeck();
        }
    }