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
- Used multiple scanners to take user input.
- I used a lot of if statements to build up the logic depending on what the user inputs into the scanner.
- A lot of the functionality comes from using my methods recursively.
- Used a timer and timerTask to give the user a certain amount of time to input snap, if not they lose. The timer starts as soon as there is an oppurtunity for snap.

## Player Class

- made a simple player class to make the game 2 player. The player class only takes a username with a setName method.
