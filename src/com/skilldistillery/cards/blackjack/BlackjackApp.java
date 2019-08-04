package com.skilldistillery.cards.blackjack;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BlackjackApp {

	public static void main(String[] args) {
		BlackjackApp bJA = new BlackjackApp();
		bJA.run();
	}

	private void run() {
		Scanner scan = new Scanner(System.in);
		boolean playAgain = true;
		boolean gameOver = false;
		BlackJackTable theHouse = new BlackJackTable();
		theHouse.player.wallet = 500;
		theHouse.deck.shuffle();
		theHouse.player.lookAroundDialogue();
		blackjackIntro();
		System.out.println("          Welcome to Blackjack!\n\n");
		System.out.println(theHouse.player.lookAroundDialogue.get(0));
		while (playAgain) {
			gameplayLoop(theHouse, scan);
			gameOver = gameOver(theHouse);
			if (gameOver == false) {
				playAgain = playAgain(scan);
				theHouse.newDeck(theHouse.deck);
				theHouse.dealer.dealerHand.clear();
				theHouse.player.playerHand.clear();
			} else if (gameOver == true) {
				playAgain = false;
			}
		}
		scan.close();
	}

	private void gameplayLoop(BlackJackTable theHouse, Scanner scan) {
		theHouse.player.checkWallet();
		boolean betPlaced = false;
		int betAmount = 5;
		while (betPlaced == false) {
			System.out.println("Place your bet: ");
			boolean valid = false;
			do {
				try {
					betAmount = scan.nextInt();
					betPlaced = theHouse.player.placeBet(betAmount);
					valid = true;
				} catch (InputMismatchException e) {
					System.out.println("Nope try again.");
					scan.next();
				}
			} while (!valid);
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

	private boolean gameOver(BlackJackTable theHouse) {
		boolean gameOver = false;
		if (theHouse.player.wallet <= 0) {
			gameOver = true;
			System.out.println(
					"You're screwed man! You're really screwed!! You blew it! Addison is out her stupid Dialysis money and you better get out of town quick before she finds out! You really did it this time! Your mom was right all along, you're a total loser and you bought a one way ticket to an alley dumpster! You're gonna be rat food in the back of P.F.Changs if you don't get outta town quick! Forget going home and getting your stuff you've got to make tracks now.. wait.. a large man in black is walking towards you.. it looks like he's on the phone but who's he tal...");
			System.out.println("Game Over LOSER!");
		}
		return gameOver;
	}

	private boolean playAgain(Scanner scan) {
		boolean playAgain = true;
		System.out.println("\n\nPlay again? \n1. Yes\n2. No");
		int choice = 0;
		boolean valid = false;
		do {
			try {
				choice = scan.nextInt();
				if (choice == 1 || choice == 2) {
					valid = true;
				} else {
					System.out.println("Nope try again.");
				}

			} catch (InputMismatchException e) {
				System.out.println("Nope try again.");
				scan.next();
			}
		} while (!valid);
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

		System.out.println(
				"Would you like to hit or stay?\n1. Hit\n2. Stay\n3. Get Hand Value\n4. Look at dealers hand\n5. Contemplate");
		int choice = 0;
		boolean valid = false;
		do {
			try {
				choice = scan.nextInt();
				if (choice >= 1 && choice <= 5) {
					valid = true;
				} else {
					System.out.println("Nope try again.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Nope try again.");
				scan.next();
			}
		} while (!valid);
		switch (choice) {
		case 1:
			theHouse.hitPlayer();
			break;
		case 2:
			System.out.println("You stay.");
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
		case 5:
			theHouse.player.lookAround();
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
