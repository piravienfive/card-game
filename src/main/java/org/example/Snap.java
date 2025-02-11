package org.example;

import java.util.Scanner;

public class Snap extends CardGame {
    static Scanner input = new Scanner(System.in);

    public void startSnap() {
        System.out.println("Hi! Let's play Snap, type Enter to start by taking your turn...");
        String userInput = input.nextLine().toUpperCase();

        if (userInput.equals("ENTER")) {
            getDeck();
            shuffleDeck();
            Card card1 = dealCard();
            System.out.println(card1.name);;
            System.out.println("Type Enter to draw again?");
            String userInput2 = input.nextLine().toUpperCase();
            if (userInput2.equals("ENTER")) {
                takeTurn(card1);
            }

        }
    }

    public void takeTurn(Card prevCard) {

        Card card2 = dealCard();
        System.out.println(card2.name);
        System.out.println(prevCard.symbol);
        System.out.println(card2.symbol);
            if (prevCard.symbol.equals(card2.symbol)) {
                System.out.println("That's a match! Congratulations, you won...");
            } else {
                System.out.println("Type Enter to draw again?");
                String userInput3 = input.nextLine().toUpperCase();
                if (userInput3.equals("ENTER")) {
                    prevCard = card2;
                    takeTurn(prevCard);
                }
            }
        }

    }
