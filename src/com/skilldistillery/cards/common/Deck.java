package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<>();

	public Deck() {
		for (int i = 0; i < Rank.values().length; i++) {
			for (int j = 0; j < Suit.values().length; j++) {
				deck.add(new Card(Rank.values()[i], Suit.values()[j]));
			}
		}
	}

	public Deck(ArrayList<Card> deck) {
		super();
		this.deck = deck;

	}

	public int checkDeckSize() {
		int size = deck.size();
		return size;
	}

	public Card dealCard(int numberOfCards) {
		Card card = null;
		card = deck.remove(0);
		return card;
	}

	public ArrayList<Card> dealCards(int numberOfCards) {
		ArrayList<Card> hand = new ArrayList<>();
		for (int i = 0; i < numberOfCards; i++) {
			hand.add(deck.remove(0));
		}
		return hand;
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}
}
