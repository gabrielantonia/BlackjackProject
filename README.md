## Blackjack Project
Week 4 Project for Skill Distillery Full Stack Java bootcamp... Quite confidently the coolest program anyone has ever made.
## Overview
This program is a fairly simple OO designed Blackjack simulation. It starts the player off with $500 and allows the player to bet any amount less than their amount remaining. Players then draw and if they have blackjack the dealer will attempt to tie. if Dealer has blackjack the player attempts to tie, otherwise the player sees the face up card of the dealer and is given a menu of options including hit or stay. After player stays, the dealer will flip their face down card and hit if their score is less than 17 and lower than the players. After house stays or busts the winner is announced. If player wins their bet is doubled and returned to their wallet. 

Additional story and dialogue is available to the player just to make the game a little more interesting and give it some character. An array of dialogue was written for the player class and can be called from the hitOrStay menu by selecting "Contemplate". 

Once the player runs out of money the game is over. The player can leave with their winnings at any time after a hand is finished. 

The dealer is provided with unlimited decks. When a deck card count drops below 15, before the next round a new shuffled deck will be provided to the dealer. 

Aces value is dependent upon hand value. If the player has an Ace in their hand and score is greater than 21, Ace value will dynamically change from 11 to 1. Otherwise it will be scored as 11. 

## Technologies Used
* Development - Java
* IDE - Eclipse
* Text Editor - Atom
* Distributed Version Control - Git/ Github
* Peer Communication - Slack

## Unique Challenges
* Object Oriented Programming
* Abstraction, Polymorphism, Inheritance, Encapsulation
* Array Lists 
* Enum
* Try-Catch blocks
* Determining which methods and objects are located in which class in order to allow smooth interaction between player and dealer class

## Lessons Learned
* ULM was critical in planning a program of this scale. 
* Object Oriented programming provides a natural program design methodology that keeps packages well organized and easy to review and troubleshoot.
* Furthering reinforcement of fundamental principles while vastly increasing utilization and working knowledge of OO.
* Finish project minimums before attempting to code in more advanced features.

## Areas of Improvement
* Add option for more than one player/npc's
* Add pretty ASCII art for cards and chips
* Add chip object to bet with instead of cash 
* Dealer dialogue
