package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackJackTable {
	private Player player = new Player();
	private Dealer dealer = new Dealer();
	private Deck deck = new Deck();

	public BlackJackTable() {
		super();
	}

	public void hitPlayer() {
		Card card = getDeck().dealCard();
		getPlayer().playerHand.addCard(card);
		System.out.println("       ~~A " + card.toString() + "~~");
	}

	public void hitDealer() {
		Card card = getDeck().dealCard();
		getDealer().dealerHand.addCard(card);
		System.out.println("The dealer hits.");
		System.out.println("       ~~A " + card.toString() + "~~");
	}

	public void newHand() {
		getPlayer().playerHand.addCards(getDeck().dealCards(2));
		getDealer().dealerHand.addCards(getDeck().dealCards(2));
	}

	public void newDeck() {
		if (getDeck().checkDeckSize() < 15) {
			setDeck(new Deck());
			getDeck().shuffle();
		}
	}

	public boolean checkForWinner(int betAmount) {
		boolean isWinner = false;
		if (playerWin() == true) {
			System.out.println(getPlayer().playerHand.toString() + " beats " + getDealer().dealerHand.toString() + ".");
			System.out.println("You win, great job!");
			getPlayer().wallet += (betAmount * 2);
			isWinner = true;
		} else if (checkForBustDealer() == true) {
			System.out.println("Dealer Busts!");
			System.out.println("You win, great job!");
			getPlayer().wallet += (betAmount * 2);
			isWinner = true;
		} else if (dealerWin() == true) {
			System.out.println(getDealer().dealerHand.toString() + " beats " + getPlayer().playerHand.toString() + ".");
			System.out.println("Dealer wins! Better luck next time.");
			isWinner = true;
		} else if (checkForBustPlayer() == true) {
			System.out.println("You bust!");
			System.out.println("Dealer wins! Better luck next time.");
			isWinner = true;
		} else if (draw() == true) {
			System.out.println(getPlayer().playerHand.toString() + " draws " + getDealer().dealerHand.toString() + ".");
			System.out.println("The match is a draw.");
			getPlayer().wallet += betAmount;
			isWinner = true;
		}
		return isWinner;
	}

	public boolean draw() {
		boolean draw = false;
		if (getPlayer().playerHand.getHandValue() == getDealer().dealerHand.getHandValue()) {
			draw = true;
		}
		return draw;
	}

	public boolean playerWin() {
		boolean winner = false;
		if (getPlayer().playerHand.getHandValue() > getDealer().dealerHand.getHandValue()
				&& getPlayer().playerHand.getHandValue() < 22) {
			winner = true;
		}
		return winner;
	}

	public boolean dealerWin() {
		boolean winner = false;
		if (getPlayer().playerHand.getHandValue() < getDealer().dealerHand.getHandValue()
				&& getDealer().dealerHand.getHandValue() < 22) {
			winner = true;
		}
		return winner;
	}

	public void getHand() {
		System.out.println("Your hand is a " + getPlayer().playerHand.toString() + " .");
		getDealer().dealerHand.dealersToString();
	}

	public void getHandFlipped() {
		getPlayer().playerHand.getHandValue();
		getDealer().dealerHand.getHandValue();
	}

	public boolean checkForPlayerBlackjack() {
		boolean blackjackHasOccurred = false;
		if (getPlayer().playerHand.isBlackJack()) {
			System.out.println("You have Blackjack!");
			blackjackHasOccurred = true;
		}
		return blackjackHasOccurred;
	}

	public boolean checkForDealerBlackjack() {
		boolean blackjackHasOccurred = false;
		if (getDealer().dealerHand.isBlackJack()) {
			System.out.println("Dealer has Blackjack");
			blackjackHasOccurred = true;
			System.out.println("Dealer has a " + getDealer().dealerHand.toString() + ".");
		}
		return blackjackHasOccurred;
	}

	public boolean checkForBustPlayer() {
		boolean bustHasOccurred = false;
		if (getPlayer().playerHand.isBust()) {
			bustHasOccurred = true;
		}
		return bustHasOccurred;
	}

	public boolean checkForBustDealer() {
		boolean bustHasOccurred = false;
		if (getDealer().dealerHand.isBust()) {
			bustHasOccurred = true;
		}
		return bustHasOccurred;
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Dealer getDealer() {
		return dealer;
	}

	public void setDealer(Dealer dealer) {
		this.dealer = dealer;
	}
}
