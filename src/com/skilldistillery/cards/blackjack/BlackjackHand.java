package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.AbstractHand;
import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Rank;

public class BlackjackHand extends AbstractHand {

	@Override
	public int getHandValue() {
		int handValue = 0;
		for (Card card : cards) {
			handValue += card.getValue();
		}
		for (Card card : cards) {
			if (card.getRank().equals(Rank.ACE) && handValue > 21) {
				handValue = handValue - 10;
			}
		}

		return handValue;
	}

	public boolean isBlackJack() {
		boolean blackJack = false;
		if (getHandValue() == 21) {
			blackJack = true;
		}
		return blackJack;
	}

	public boolean isBust() {
		boolean bust = false;
		if (getHandValue() > 21) {
			bust = true;
		}
		return bust;
	}

	public boolean isHard() {
		boolean hard = false;
		for (Card card : cards) {
			if (card.getRank().equals(Rank.ACE) && getHandValue() < 12)
				;
			hard = true;
		}
		return hard;
	}

	public boolean isSoft() {
		boolean soft = false;
		for (Card card : cards) {
			if (card.getRank().equals(Rank.ACE) && getHandValue() >= 12)
				;
			soft = true;
		}
		return soft;
	}
	public void dealersToString() {
		
		System.out.println("Dealer's visible card is a " + cards.get(0).toString() );
	}
}
