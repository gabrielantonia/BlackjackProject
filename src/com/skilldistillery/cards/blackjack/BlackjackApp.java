package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp bJA = new BlackjackApp();
		bJA.run();
	}

	private void run() {
		Scanner scan = new Scanner(System.in);
		boolean playAgain = true;
		BlackJackTable theHouse = new BlackJackTable();
		theHouse.player.wallet = 500;
		theHouse.deck.shuffle();
		blackjackIntro();
		System.out.println("          Welcome to Blackjack!\n\n");
		while (playAgain) {
			gameplayLoop(theHouse, scan);
			playAgain = playAgain(scan);
			theHouse.newDeck(theHouse.deck);
			theHouse.dealer.dealerHand.clear();
			theHouse.player.playerHand.clear();
		}
	}

	private void gameplayLoop(BlackJackTable theHouse, Scanner scan) {
		theHouse.player.checkWallet();
		boolean betPlaced = false;
		int betAmount = 0;
		while(betPlaced == false) {
		System.out.println("Place your bet: ");
		betAmount = scan.nextInt();
		betPlaced = theHouse.player.placeBet(betAmount);
		}
		theHouse.newHand();
		theHouse.dealer.dealerHand.dealersToString();
		boolean stay = false;
		while (theHouse.checkForBustDealer() == false && theHouse.checkForBustPlayer() == false && stay == false) {
			if (theHouse.checkForDealerBlackjack() == true) {
				// house stays
				stay = hitOrStay(theHouse, scan, stay);
			} else if (theHouse.checkForPlayerBlackjack() == true) {
				stay = true;
				while (theHouse.checkForBustDealer() == false && theHouse.checkForBustPlayer() == false
						&& theHouse.dealer.dealerHand.getHandValue() <= 17) {
					theHouse.hitDealer();
				}
			} else {
				while (theHouse.checkForBustDealer() == false && theHouse.checkForBustPlayer() == false
						&& stay == false) {
					stay = hitOrStay(theHouse, scan, stay);

				}
				while (theHouse.checkForBustDealer() == false && theHouse.checkForBustPlayer() == false
						&& theHouse.dealer.dealerHand.getHandValue() <= 17) {
					theHouse.hitDealer();
				}
			}
		}
		theHouse.checkForWinner(betAmount);
	}

	private boolean playAgain(Scanner scan) {
		boolean playAgain = true;
		System.out.println("\n\nPlay again? \n1. Yes\n2. No");
		int choice = scan.nextInt();
		switch (choice) {
		case 1:
			playAgain = true;
			break;
		case 2:
			playAgain = false;
			break;
		}
		return playAgain;
	}

	private boolean hitOrStay(BlackJackTable theHouse, Scanner scan, boolean stay) {

		System.out.println("Your current hand is " + theHouse.player.playerHand.toString() + ". ");

		System.out
				.println("Would you like to hit or stay?\n1. Hit\n2. Stay\n3. Get Hand Value\n4. Look at dealers hand");
		int choice;
		choice = scan.nextInt();
		switch (choice) {
		case 1:
			theHouse.hitPlayer();
			break;
		case 2:
			System.out.println("You stay");
			stay = true;
			break;
		case 3:
			System.out.println("Your hand value is " + theHouse.player.playerHand.getHandValue());
			break;
		case 4:
			if (theHouse.checkForDealerBlackjack() == true) {

			} else {
				theHouse.dealer.dealerHand.dealersToString();
			}
			break;
		}
		return stay;
	}

	private void blackjackIntro() {
		System.out.println("" + "\t██╗    ██████╗  ██╗    ██╗\n" + "\t██║    ╚════██╗███║    ██║\n"
				+ "\t██║     █████╔╝╚██║    ██║\n" + "\t╚═╝    ██╔═══╝  ██║    ╚═╝\n" + "\t██╗    ███████╗ ██║    ██╗\n"
				+ "\t╚═╝    ╚══════╝ ╚═╝    ╚═╝\n");

	}
}
