package com.skilldistillery.cards.blackjack;

import java.util.Scanner;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp bJA = new BlackjackApp();
		bJA.run();
	}

	private void run() {
		Scanner scan = new Scanner(System.in);
		BlackJackTable theHouse = new BlackJackTable();
		theHouse.deck.shuffle();
		blackjackIntro();
		System.out.println("          Welcome to Blackjack!");
		gameplayLoop(theHouse, scan);
	}

	private void gameplayLoop(BlackJackTable theHouse, Scanner scan) {
		boolean stay = false;
		theHouse.newHand();
		theHouse.getHandValues();
		theHouse.checkForBlackjack();
		if (theHouse.dealer.dealerHand.getHandValue() == 21) {
			// house stays
			while (theHouse.player.playerHand.getHandValue() < 21 && stay == false) {
				stay = hitOrStay(theHouse, scan);
				theHouse.checkForBust();
				theHouse.getHandValues();
			}
			theHouse.checkForWinner();
		} else if (theHouse.player.playerHand.getHandValue() == 21) {
			// house hits until value >=17
			while (theHouse.dealer.dealerHand.getHandValue() <= 17) {
				theHouse.dealer.dealerHand.toString();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				theHouse.hitDealer();;
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				theHouse.checkForBust();
			}
			theHouse.checkForWinner();
		} else {
			while (theHouse.player.playerHand.getHandValue() < 21 && stay == false) {
				stay = hitOrStay(theHouse, scan);
				
				theHouse.checkForBust();
			}
			if(theHouse.player.playerHand.getHandValue() > theHouse.dealer.dealerHand.getHandValue())
			while (theHouse.dealer.dealerHand.getHandValue() < theHouse.dealer.dealerHand.getHandValue() ) {
				theHouse.dealer.dealerHand.toString();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				theHouse.hitDealer();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
				}
				theHouse.checkForBust();
			}
			theHouse.checkForWinner();
		}
	}

	private boolean hitOrStay(BlackJackTable theHouse, Scanner scan) {
		boolean stay = false;
		System.out.println("Your current hand is " + theHouse.player.playerHand.toString() + ". ");
		System.out.println("Would you like to hit or stay?\n1. Hit\n2. Stay");
		int choice;
		choice = scan.nextInt();
		switch (choice) {
		case 1:
			theHouse.hitPlayer();;
			System.out.println("Your current hand is " + theHouse.player.playerHand.toString());
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			break;
		case 2:
			stay = true;
		}
		return stay;
	}

	private static void blackjackIntro() {
		System.out.println("" + "\t██╗    ██████╗  ██╗    ██╗\n" + "\t██║    ╚════██╗███║    ██║\n"
				+ "\t██║     █████╔╝╚██║    ██║\n" + "\t╚═╝    ██╔═══╝  ██║    ╚═╝\n" + "\t██╗    ███████╗ ██║    ██╗\n"
				+ "\t╚═╝    ╚══════╝ ╚═╝    ╚═╝\n");

	}
}
