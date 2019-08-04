package com.skilldistillery.cards.blackjack;

public class Player {
	BlackjackHand playerHand = new BlackjackHand();
	int wallet;

	public void stay() {
		System.out.println("You decide to stay, your hand is " + playerHand.toString());
	}

	public boolean placeBet(int betAmount) {
		boolean betPlaced = false;
			if (betAmount <= wallet && betAmount > 0) {
				wallet -= betAmount;
				System.out.println("You bet " + betAmount + ". You have " + wallet + " left in your wallet.");
				betPlaced = true;
			}
			else if(betAmount < 1){
				System.out.println("You have to bet something to play.");
			}
			else {
				System.out.println("You dont have enough for that bet.");
			}
			return betPlaced;
	}

	public void checkWallet() {
		System.out.println("You have " + wallet + " left in your wallet.");
	}
}
