package com.skilldistillery.cards.common;

public class Card {
	
	private Rank rank;
	private Suit suit;
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(rank).append(" of ").append(suit);
		return builder.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}


	public Card() {
		// TODO Auto-generated constructor stub
	}
	
	public int getValue() {
		return rank.getValue();
	}


	public Card(Rank rank, Suit suit) {
		super();
		this.rank = rank;
		this.suit = suit;
	}


	public Rank getRank() {
		return rank;
	}


	public void setRank(Rank rank) {
		this.rank = rank;
	}


	public Suit getSuit() {
		return suit;
	}


	public void setSuit(Suit suit) {
		this.suit = suit;
	}

}
