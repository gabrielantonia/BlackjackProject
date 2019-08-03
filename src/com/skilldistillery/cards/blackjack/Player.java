package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class Player {
	BlackjackHand playerHand = new BlackjackHand();
	
	public void stay() {
		System.out.println("You decide to stay, your hand is " + playerHand.toString());
	}
}
