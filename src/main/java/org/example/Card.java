package org.example;

public class Card {
    public String name;
    public int value;
    public String suit;
    public String symbol;

    public Card(int value, String suit){
        this.value = value;
        this.suit = suit;
        this.symbol = Integer.toString(value);
        if(this.value > 1 && this.value < 11) {
            this.name = String.format("%d of ", value) + String.format("%s", suit);
            this.symbol = "A";
        } else if (this.value == 1) {
            this.name = String.format("Ace of %s", suit);
            this.value = 14;
            this.symbol = "A";
        }
        else if (this.value == 11) {
            this.name = String.format("Jack of %s", suit);
            this.symbol = "J";
        }
        else if (this.value == 12) {
            this.name = String.format("Queen of %s", suit);
            this.symbol = "Q";
        }
        else if (this.value == 13) {
            this.name = String.format("King of %s", suit);
            this.symbol = "K";
        }
    }


}
