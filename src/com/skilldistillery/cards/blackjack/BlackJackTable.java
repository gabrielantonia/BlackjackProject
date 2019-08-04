package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.Card;
import com.skilldistillery.cards.common.Deck;

public class BlackJackTable {
	Player player = new Player();
	Dealer dealer = new Dealer();
	Deck deck = new Deck();

	public BlackJackTable() {
		super();
	}

	public void hitPlayer() {
		Card card = deck.dealCard();
		player.playerHand.addCard(card);
		System.out.println("       ~~A " + card.toString() + "~~");
	}

	public void hitDealer() {
		Card card = deck.dealCard();
		dealer.dealerHand.addCard(card);
		System.out.println("The dealer hits.");
		System.out.println("       ~~A " + card.toString() + "~~");
	}

	public void newHand() {
		player.playerHand.addCards(deck.dealCards(2));
		dealer.dealerHand.addCards(deck.dealCards(2));
	}

	public void newDeck() {
		if (deck.checkDeckSize() < 15) {
			deck = new Deck();
			deck.shuffle();
		}
	}

	public boolean checkForWinner(int betAmount) {
		boolean isWinner = false;
		if (playerWin() == true) {
			System.out.println(player.playerHand.toString() + " beats " + dealer.dealerHand.toString() + ".");
			System.out.println("You win, great job!");
			player.wallet += (betAmount * 2);
			isWinner = true;
		} else if (checkForBustDealer() == true) {
			System.out.println("Dealer Busts!");
			System.out.println("You win, great job!");
			player.wallet += (betAmount * 2);
			isWinner = true;
		} else if (dealerWin() == true) {
			System.out.println(dealer.dealerHand.toString() + " beats " + player.playerHand.toString() + ".");
			System.out.println("Dealer wins! Better luck next time.");
			isWinner = true;
		} else if (checkForBustPlayer() == true) {
			System.out.println("You bust!");
			System.out.println("Dealer wins! Better luck next time.");
			isWinner = true;
		} else if (draw() == true) {
			System.out.println(player.playerHand.toString() + " draws " + dealer.dealerHand.toString() + ".");
			System.out.println("The match is a draw.");
			player.wallet += betAmount;
			isWinner = true;
		}
		return isWinner;
	}

	public boolean draw() {
		boolean draw = false;
		if (player.playerHand.getHandValue() == dealer.dealerHand.getHandValue()) {
			draw = true;
		}
		return draw;
	}

	public boolean playerWin() {
		boolean winner = false;
		if (player.playerHand.getHandValue() > dealer.dealerHand.getHandValue()
				&& player.playerHand.getHandValue() < 22) {
			winner = true;
		}
		return winner;
	}

	public boolean dealerWin() {
		boolean winner = false;
		if (player.playerHand.getHandValue() < dealer.dealerHand.getHandValue()
				&& dealer.dealerHand.getHandValue() < 22) {
			winner = true;
		}
		return winner;
	}

	public void getHand() {
		System.out.println("Your hand is a " + player.playerHand.toString() + " .");
		dealer.dealerHand.dealersToString();
	}

	public void getHandFlipped() {
		player.playerHand.getHandValue();
		dealer.dealerHand.getHandValue();
	}

	public boolean checkForPlayerBlackjack() {
		boolean blackjackHasOccurred = false;
		if (player.playerHand.isBlackJack()) {
			System.out.println("You have Blackjack!");
			blackjackHasOccurred = true;
		}
		return blackjackHasOccurred;
	}

	public boolean checkForDealerBlackjack() {
		boolean blackjackHasOccurred = false;
		if (dealer.dealerHand.isBlackJack()) {
			System.out.println("Dealer has Blackjack");
			blackjackHasOccurred = true;
			System.out.println("Dealer has a " + dealer.dealerHand.toString() + ".");
		}
		return blackjackHasOccurred;
	}

	public boolean checkForBustPlayer() {
		boolean bustHasOccurred = false;
		if (player.playerHand.isBust()) {
			bustHasOccurred = true;
		}
		return bustHasOccurred;
	}

	public boolean checkForBustDealer() {
		boolean bustHasOccurred = false;
		if (dealer.dealerHand.isBust()) {
			bustHasOccurred = true;
		}
		return bustHasOccurred;
	}
}
