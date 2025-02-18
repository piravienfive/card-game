package org.example;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Snap extends CardGame {
    Scanner input = new Scanner(System.in);
    Player player1 = new Player();
    Player player2 = new Player();
    boolean isGameOver = false;
    boolean isTimerFinished = false;

    // You want the game to carry on until the isGameOver to be true

    public void startGame() {
        System.out.println("Type 1 or 2 to decide how many players will play...");
        int playerCount = Integer.valueOf(input.nextLine());
        if (playerCount == 1) {
            System.out.println("Starting 1 player game...");
            System.out.println("type Enter to start by taking your turn...");
            super.getDeck();
            super.shuffleDeck();
            turn(1);
        }
        else if (playerCount == 2) {
            System.out.println("Starting 2 player game...");
            player1.setName();
            player2.setName();
            System.out.println(String.format("Let's play! %s goes first, type Enter to start by taking your turn...", player1.name));
            super.getDeck();
            super.shuffleDeck();
            turn(playerCount);
        }
        else{
            System.out.println("That was not a valid input, please enter 1 for a 1 player game, or 2 for a 2 player game: ");
            startGame();
        }
    }

    public void turn(int playerCount) {
        String userInput = input.nextLine().toUpperCase();

        if (userInput.equals("ENTER") && playerCount == 1) {
            Card card1 = super.dealCard();
            System.out.println(card1.name);

            System.out.println(String.format("now %s Enter to draw again: ", player2.name));
            String userInput2 = input.nextLine().toUpperCase();
            turns(card1, card1, userInput2, playerCount, player2);
        } else if (userInput.equals("EXIT")) {
            System.out.println("Bye bye...");
            System.exit(0);
        } else if (userInput.equals("SNAP")) {
            System.out.println("Not SNAP! You lose :( ");
        } else {
            System.out.println(String.format("Invalid input by %s, please type Enter: to draw a card, Exit: to exit game, Snap: to call a match... ", player1.name));
            turn(playerCount);
        }


        if (userInput.equals("ENTER") && playerCount == 1) {
            Card card1 = super.dealCard();
            System.out.println(card1.name);

            System.out.println(String.format("now %s Enter to draw again: ", player2.name));
            String userInput2 = input.nextLine().toUpperCase();
            turns(card1, card1, userInput2, playerCount, player2);
        } else if (userInput.equals("EXIT")) {
            System.out.println("Bye bye...");
            System.exit(0);
        } else if (userInput.equals("SNAP")) {
            System.out.println("Not SNAP! You lose :( ");
        } else {
            System.out.println(String.format("Invalid input by %s, please type Enter: to draw a card, Exit: to exit game, Snap: to call a match... ", player1.name));
            turn(playerCount);
        }
    }

    public void turns(Card prevCard1, Card prevCard2, String command, int playerCount, Player currPlayer) {
        if (playerCount == 1) {
            if (!command.equals("ENTER") && !command.equals("EXIT") && !command.equals("SNAP")) {
                System.out.println("Invalid input, please type Enter: to draw a card, Exit: to exit game, Snap: to call a match... ");
                String newUserInput = input.nextLine().toUpperCase();
                turns(prevCard1, prevCard2, newUserInput, playerCount, currPlayer);
            } else {

                if (command.equals("ENTER")) {
                    prevCard1 = prevCard2;
                    prevCard2 = super.dealCard();
                    System.out.println(prevCard1.name);
                    System.out.println(prevCard2.name);
                    if (prevCard1.symbol.equals(prevCard2.symbol)) {
                        System.out.println("Starting timer");
                        setTimer();
                        String userWinInput = input.nextLine().toUpperCase();
                        if(!isTimerFinished){
                            if (userWinInput.equals("SNAP")) {
                                newTimer.cancel();
                                System.out.println("You win");
                            } else {
                                newTimer.cancel();
                                System.out.println("You lose");
                        }
                        }
                        else{
                            if (userWinInput.equals("AGAIN")) {
                                Snap newGame = new Snap();
                                newGame.startGame();
                            } else {
                                System.exit(0);
                            }
                        }
                        isGameOver = true;
                        if (isGameOver) {
                            System.out.println("Thank you for playing! to play again type 'again' to leave type 'leave' or anything else");
                            String userDecision = input.nextLine().toUpperCase();
                            if (userDecision.equals("AGAIN")) {
                                Snap newGame = new Snap();
                                newGame.startGame();
                            } else {
                                System.exit(0);
                            }
                        }
                    }
                    System.out.println("Type Enter to draw again?");
                    String userInput4 = input.nextLine().toUpperCase();
                    if (userInput4.equals("SNAP") && prevCard1.symbol.equals(prevCard2.symbol)) {
                        System.out.println("That's a match! Congratulations, you won...");
                    } else if (userInput4.equals("ENTER")) {
                        turns(prevCard1, prevCard2, userInput4, playerCount, currPlayer);
                    } else {
                        turns(prevCard1, prevCard2, userInput4, playerCount, currPlayer);
                    }
                } else if (command.equals("EXIT")) {
                    System.out.println("Bye bye...");
                    System.exit(0);
                } else if (command.equals("SNAP")) {
                    if (prevCard1.symbol.equals(prevCard2.symbol) && prevCard1 != prevCard2) {
                        System.out.println("That's a match! Congratulations, you won...");
                    } else {
                        System.out.println("Not SNAP! You lose :( ");
                    }
                }
            }

        } else if (playerCount == 2) {
            if (!command.equals("ENTER") && !command.equals("EXIT") && !command.equals("SNAP")) {
                System.out.println(String.format("Invalid input by %s, please type Enter: to draw a card, Exit: to exit game, Snap: to call a match... ", currPlayer.name));
                String newUserInput = input.nextLine().toUpperCase();
                turns(prevCard1, prevCard2, newUserInput, playerCount, currPlayer);
            } else {

                if (command.equals("ENTER")) {
                    if (currPlayer == player1) {
                        currPlayer = player2;
                    } else if (currPlayer == player2) {
                        currPlayer = player1;
                    }
                    prevCard1 = prevCard2;
                    prevCard2 = super.dealCard();
                    System.out.println(prevCard1.name);
                    System.out.println(prevCard2.name);
                    if (prevCard1.symbol.equals(prevCard2.symbol)) {
                        System.out.println("Starting timer");
                        setTimer();
                        String userWinInput = input.nextLine().toUpperCase();
                        if(!isTimerFinished){
                            if (userWinInput.equals("SNAP")) {
                                newTimer.cancel();
                                System.out.println(String.format("That's a match! Congratulations, Player %s won...", currPlayer.name));
                            } else {
                                newTimer.cancel();
                                System.out.println(String.format("Not SNAP! Player %s loses :( ", currPlayer.name));
                            }
                        }
                        else{
                            if (userWinInput.equals("AGAIN")) {
                                Snap newGame = new Snap();
                                newGame.startGame();
                            } else {
                                System.exit(0);
                            }
                        }
                        isGameOver = true;
                        if (isGameOver) {
                            System.out.println("Thank you for playing! to play again type 'again' to leave type 'leave' or anything else");
                            String userDecision = input.nextLine().toUpperCase();
                            if (userDecision.equals("AGAIN")) {
                                Snap newGame = new Snap();
                                newGame.startGame();
                            } else {
                                System.exit(0);
                            }
                        }
                    }
                    System.out.println(String.format("Player %s Type Enter to draw", currPlayer.name));
                    String userInput4 = input.nextLine().toUpperCase();
                    if (userInput4.equals("SNAP") && prevCard1.symbol.equals(prevCard2.symbol)) {
                        System.out.println(String.format("That's a match! Congratulations, Player %s won...", currPlayer.name));
                    } else if (userInput4.equals("ENTER")) {
                        turns(prevCard1, prevCard2, userInput4, playerCount, currPlayer);
                    } else {
                        turns(prevCard1, prevCard2, userInput4, playerCount, currPlayer);
                    }
                } else if (command.equals("EXIT")) {
                    System.out.println("Bye bye...");
                } else if (command.equals("SNAP")) {
                    if (prevCard1.symbol.equals(prevCard2.symbol) && prevCard1 != prevCard2) {
                        System.out.println(String.format("That's a match! Congratulations, Player %s won...", currPlayer.name));
                    } else {
                        System.out.println(String.format("Not SNAP! Player %s loses :( ", currPlayer.name));
                    }
                }
            }
        }
    }

    // CreateTimer
    public TimerTask stopGameOnSnap() {
        return new TimerTask() {
            public void run() {
                System.out.println("You took too long you lose");
                System.out.println("Thank you for playing! to play again type 'again' to leave type 'leave' or anything else");
                isTimerFinished = true;
                isGameOver = true;
            }
        };
    }
    Timer newTimer = new Timer();
    public void setTimer() {
        newTimer.schedule(stopGameOnSnap(), 4 * 1000L);

        }

    }