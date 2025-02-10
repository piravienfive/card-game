package org.example;

public class Card {
    public String name;
    public int value;
    public String suit;

    public Card(int value, String suit){
        this.value = value;
        this.suit = suit;
        if(this.value > 1 && this.value < 11) {
            this.name = String.format("%d of ", value) + String.format("%s", suit);
        } else if (this.value == 1) {
            this.name = String.format("Ace of %s", suit);
        }
        else if (this.value == 11) {
            this.name = String.format("Jack of %s", suit);
        }
        else if (this.value == 12) {
            this.name = String.format("Queen of %s", suit);
        }
        else if (this.value == 13) {
            this.name = String.format("King of %s", suit);
        }
    }


}
