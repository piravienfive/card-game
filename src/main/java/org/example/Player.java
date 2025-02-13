package org.example;

import java.util.Scanner;

public class Player {
    Scanner input = new Scanner(System.in);

    public String name;

    public Player(){
        this.name = name;
    }

    public void setName()
    {
        System.out.println("Type a Player's name please: ");
        String userInput = input.nextLine();
        this.name = userInput.substring(0,1).toUpperCase() + userInput.substring(1);
    }

    public String getName(){
        return name;
    }
}
