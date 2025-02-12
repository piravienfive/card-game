package org.example;

import java.util.Scanner;

public class Snap extends CardGame {
    Scanner input = new Scanner(System.in);

    public void startGame() {
        System.out.println("Hi! Let's play Snap, type Enter to start by taking your turn...");
        super.getDeck();
        super.shuffleDeck();
        turn();
    }

    public void turn(){
        String userInput = input.nextLine().toUpperCase();

        if(userInput.equals("ENTER")){
            Card card1 = super.dealCard();
            System.out.println(card1.name);
            System.out.println("Type Enter to draw again?");
            String userInput2 = input.nextLine().toUpperCase();
            Card card2 = super.dealCard();
            turns(card1, card2, userInput2);
        }
        else if (userInput.equals("EXIT")) {
            System.out.println("Bye bye...");
        }
        else if (userInput.equals("SNAP")) {
            System.out.println("Not SNAP! You lose :( ");
        }
        else {
            System.out.println("Invalid input, please type Enter: to draw a card, Exit: to exit game, Snap: to call a match... ");
            turn();
        }}

    public void turns(Card prevCard1, Card prevCard2, String command) {
        if(!command.equals("ENTER") && !command.equals("EXIT") && !command.equals("SNAP")){
            System.out.println("Invalid input, please type Enter: to draw a card, Exit: to exit game, Snap: to call a match... ");
            String newUserInput = input.nextLine().toUpperCase();
            turns(prevCard1, prevCard2, newUserInput);
        }


        else{

            if(command.equals("ENTER")){
                System.out.println(prevCard1.name);
                System.out.println(prevCard2.name);
                System.out.println("Type Enter to draw again?");
                String userInput4 = input.nextLine().toUpperCase();
                if(userInput4.equals("SNAP") && prevCard1.symbol.equals(prevCard2.symbol)){
                    System.out.println("That's a match! Congratulations, you won...");
                }
                else if (userInput4.equals("ENTER")){
                    prevCard1 = prevCard2;
                    prevCard2 = super.dealCard();
                    turns(prevCard1, prevCard2, userInput4);
                }
                else{
                    turns(prevCard1, prevCard2, userInput4);
                }
            }
            else if (command.equals("EXIT")) {
                System.out.println("Bye bye...");
            }
            else if (command.equals("SNAP")) {
                if(prevCard1.symbol.equals(prevCard2.symbol)){
                    System.out.println("That's a match! Congratulations, you won...");
                }
                else {
                    System.out.println("Not SNAP! You lose :( ");
                }
            }}

    }}
