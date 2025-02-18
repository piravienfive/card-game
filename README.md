# My card-game Project Breakdown

- Use java classes and emthods to build a interactive game of snap that can be played in the terminal.
- The game should be playable by running the main class.


## CardGame class

- create a class that can create a deck of playing cards once the game is constructed.
- it will have a getDeck method that builds the deck.
- it has a toString method that can describes the speciifc card.
- Each card has a string suit, string, and an int value.
- a method called dealCard that deals a random card from the array list and then deletes it from there.
- a method to arrange cards by suit called sortDeckIntoSuits.
- a method to shuffle the deck into a random order, shuffleDeck.

## Snap Class

- in this class I start creating the methods that allow the user to play a game of Snap.
- Used multiple scanners to take user inputs.
- I used if statements to build up the logic depending on what the user inputs into the scanner.
- A lot of the functionality comes from using my methods recursively.
- Used a timer and timerTask to give the user a certain amount of time to input snap, if not they lose. The timer starts as soon as there is an oppurtunity for snap.
- Incase the the whole deck is dealt without a chance for snap, the game will automatically create a new deck and shuffle it so that the game can continue.

## Player Class

- made a simple player class to make the game 2 player. The player class only takes a username with a setName method.

## How to Run the Game

- Install Java JDK 8+ and an IDE like ItelliJ.
- Clone this repository using ssh or https.
- Run Main.java

## Future Improvements

- I hope I can make my code a little bit neater in the future.
- I know there are most likely to ways to refactor my code and make it a bit more succinct.
- I want to make the game carry on when the deck is empty by creating a new deck and shuffling that, then dealing from there.
- I would like the game to work in a way were even if therre is a chance for snap, if the  player isn't paying attention, he can still draw a card instead. I had half of this working but it was running into an error because on the 2nd snap oppurtunity, my timer couldn't work since it had already been cancelled. I would like to get past this error by possibly instantiating a new timer every time.
