package com.skilldistillery.cards.common;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractHand {

	protected List<Card> cards;
	
	public AbstractHand() {
		cards = new ArrayList<>();
	}
	public void addCard(Card card) {
		cards.remove(card);
	}
	public void addCards(ArrayList<Card> _cards) {
		cards.addAll(_cards);
	}
	
	public void clear() {
		cards.clear();
	}
	public abstract int getHandValue();
	
	public String toString() {
			StringBuilder sb = new StringBuilder();
			for (Card card : cards) {
				sb.append(card.getRank() + " of " + card.getSuit());
				sb.append(" and a ");
			}
//			sb.delete(start, end)
//			sb.deleteCharAt(sb.lastIndexOf(" and a "));
			sb.toString();
			return sb.toString();
		}
		
	
	public void getCardValue(int indexValue) {
		cards.get(indexValue).toString();
	}
}
