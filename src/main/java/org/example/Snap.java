package org.example;

import java.util.Scanner;

public class Snap extends CardGame {
    Scanner input = new Scanner(System.in);

    public void startGame() {
        System.out.println("Hi! Let's play Snap, type 1 or 2 to decide how many players will play...");
        Integer playerCount = Integer.valueOf(input.nextLine());
        if (playerCount == 1){
            System.out.println("Hi! Let's play Snap, type Enter to start by taking your turn...");
            super.getDeck();
            super.shuffleDeck();
            turn(1);
        }
        if (playerCount == 2){
            Player player1 = new Player();
            Player player2 = new Player();
            System.out.println("Let's play! player 1 goes first, type Enter to start by taking your turn...");
            super.getDeck();
            super.shuffleDeck();
            turn(playerCount);
        }
    }

    public void turn(Integer playerCount){
        String userInput = input.nextLine().toUpperCase();

        if(userInput.equals("ENTER")){
            Card card1 = super.dealCard();
            System.out.println(card1.name);

            System.out.println(String.format("Player %d, please type Enter to draw again?", playerCount));
            String userInput2 = input.nextLine().toUpperCase();
            turns(card1, card1, userInput2, playerCount, 2);
        }
        else if (userInput.equals("EXIT")) {
            System.out.println("Bye bye...");
        }
        else if (userInput.equals("SNAP")) {
            System.out.println("Not SNAP! You lose :( ");
        }
        else {
            System.out.println("Invalid input, please type Enter: to draw a card, Exit: to exit game, Snap: to call a match... ");
            turn(playerCount);
        }}

    public void turns(Card prevCard1, Card prevCard2, String command, Integer playerCount, Integer d) {
        if(playerCount == 1){
            if(!command.equals("ENTER") && !command.equals("EXIT") && !command.equals("SNAP")){
                System.out.println("Invalid input, please type Enter: to draw a card, Exit: to exit game, Snap: to call a match... ");
                String newUserInput = input.nextLine().toUpperCase();
                turns(prevCard1, prevCard2, newUserInput, playerCount, d);
            }


            else{

                if(command.equals("ENTER")){
                    prevCard1 = prevCard2;
                    prevCard2 = super.dealCard();
                    System.out.println(prevCard1.name);
                    System.out.println(prevCard2.name);
                    System.out.println("Type Enter to draw again?");
                    String userInput4 = input.nextLine().toUpperCase();
                    if(userInput4.equals("SNAP") && prevCard1.symbol.equals(prevCard2.symbol)){
                        System.out.println("That's a match! Congratulations, you won...");
                    }
                    else if (userInput4.equals("ENTER")){
                        turns(prevCard1, prevCard2, userInput4, playerCount, d);
                    }
                    else{
                        turns(prevCard1, prevCard2, userInput4, playerCount, d);
                    }
                }
                else if (command.equals("EXIT")) {
                    System.out.println("Bye bye...");
                }
                else if (command.equals("SNAP")) {
                    if(prevCard1.symbol.equals(prevCard2.symbol) && prevCard1 != prevCard2 ){
                        System.out.println("That's a match! Congratulations, you won...");
                    }
                    else {
                        System.out.println("Not SNAP! You lose :( ");
                    }
                }
            }

        }
        else if (playerCount == 2){
            if(!command.equals("ENTER") && !command.equals("EXIT") && !command.equals("SNAP")){
                System.out.println(String.format("Player %d : Invalid input, please type Enter: to draw a card, Exit: to exit game, Snap: to call a match... ", d));
                String newUserInput = input.nextLine().toUpperCase();
                turns(prevCard1, prevCard2, newUserInput, playerCount, d);
            }


            else{

                if(command.equals("ENTER")){
                    if (d == 1){
                        d = 2;
                    }
                    else if (d == 2){
                        d = 1;
                    }
                    prevCard1 = prevCard2;
                    prevCard2 = super.dealCard();
                    System.out.println(prevCard1.name);
                    System.out.println(prevCard2.name);
                    System.out.println(String.format("Player %d Type Enter to draw", d));
                    String userInput4 = input.nextLine().toUpperCase();
                    if(userInput4.equals("SNAP") && prevCard1.symbol.equals(prevCard2.symbol)){
                        System.out.println(String.format("That's a match! Congratulations, Player %d won...", d));
                    }
                    else if (userInput4.equals("ENTER")){
                        turns(prevCard1, prevCard2, userInput4, playerCount, d);
                    }
                    else{
                        turns(prevCard1, prevCard2, userInput4, playerCount, d);
                    }
                }
                else if (command.equals("EXIT")) {
                    System.out.println("Bye bye...");
                }
                else if (command.equals("SNAP")) {
                    if(prevCard1.symbol.equals(prevCard2.symbol) && prevCard1 != prevCard2){
                        System.out.println(String.format("That's a match! Congratulations, Player %d won...", d));
                    }
                    else {
                        System.out.println(String.format("Not SNAP! Player %d loses :( ", d));
                    }
                }
            }
        }
    }
}
