package com.skilldistillery.cards.blackjack;

import java.util.ArrayList;


public class Player {
	BlackjackHand playerHand = new BlackjackHand();
	int wallet;
	ArrayList<String> lookAroundDialogue = new ArrayList<>(); 
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
	public void lookAround() {
		if(!lookAroundDialogue.isEmpty()) {
			System.out.println(lookAroundDialogue.remove(0)+ "\n");
		}else {
			System.out.println("No more thinking, it's time to get your head in the game.\n");
		}
			
	}
	public void lookAroundDialogue() {
		lookAroundDialogue.add("Well here you are again...familiar territory. Addisons' freshly liberated benjamins are burning a whole in your wallet and it's time to make some magic happen. You order your usual beverage of choice, a Pink Rasberry Cosmo. The uncomfortable greasy pleather seat beneath you squaks at you as you lean in to place a bet. \n ");
	
	lookAroundDialogue.add("The suffocating smell of talcum powder and piss floods your nostrils. The smell of the barely here surrounds you. The smell of clinging on, waiting to for one last hurrah before kicking the proverbial bucket. ");
	lookAroundDialogue.add("Your fingers are beginning to sweat profusely, does the dealer notice? Does he care? How many hopeless shmucks does he sit not three feet from on a daily basis. How does he not go neck himself after witnessing the putrid excuse for humanity that shuffle through this casino like Capitalist zombies.");
	lookAroundDialogue.add("Has Addison realized you took her rent money? You're only borrowing it afterall. Your gonna put it all back and then some! You've had a bad month, you just need a small stepping stool to get back on your feet. Tonight will change everything.");
	lookAroundDialogue.add("Enough looking around, its game time.");
	lookAroundDialogue.add("This son of a #$*@# dealer! There's no way he can have so much luck! This #$%$#@%!^ game is rigged! Pull yourself together! You're gonna win it all back and then some! Hang in there!");
	lookAroundDialogue.add("Mom always said you reminded her of your father so much that it sickened her to look at you. She said you'd end up dead in a dumpster like him too after she found out about your \" gambling addiction \" , as if that's a real thing. You can quit anytime you want, you just need to finish on top though.. can't let the house win.. ");
	lookAroundDialogue.add("The redheaded waitress you christened Ruby comes by asking if you'd like a drink. You order. Were has she been all night! She's your good little good luck charm! And one of these nights you're gonna make it big and she'll see your a winner! She'll be yours for sure then! It's all gonna happen for you! Its like Rhonda Byrne says, just visualize your desires and the Universe will bring them to you.");
	lookAroundDialogue.add("God, maybe Addison wasn't the right one to borrow this money from.. Her family ties to the cartel scare the shit out of you. If you lose all this money it could literally be the end of the line... That wont happen though! You've got your lucky polk-a-dot socks and a no nonsense  $80 suit on that screams success! ");
	lookAroundDialogue.add("You're really starting to worry now but you can't let it effect your game, gotta stay focused, you can do this!");
	lookAroundDialogue.add("Where is Ruby with that damn Pink Rasberry Cosmo?! If you're going down you sure as shit won't be sober!");
	lookAroundDialogue.add("God that smug look on the dealers face! You'd like to smack that grin right off that stuble laden jaw.");
	lookAroundDialogue.add("Sounds like someone hit it big on the penny slots.. of course everyone's getting lucky but you..figures.");
	lookAroundDialogue.add("Stay focused! You are pretty sure that dealer has a few aces up his sleave. If you can catch him cheating at least you can get out of here with Addisons' dialysis money.");
	lookAroundDialogue.add("Oh man, Oh man, skipping town is starting to sound like the only option. That or meeting up with Shalamar and turning a few tricks. Yeah that's all in your past but desperate times..");
	lookAroundDialogue.add("You better find Shalamar's number just in case.. even if you can't find it, he's never far from 5th and Cojack, you can ask a little birdy for directions if need be.");
	}
}
