package ooad;

public class DeckOfCards {

	enum Suits {
		HEARTS, DIAMONDS, SPADES, CLUBS
	}

	enum FaceValue {
		ACE, KING, TWO
	}

	private Card[] deck;

	public Card[] getDeck() {
		return deck;
	}

	public void setDeck(Card[] deck) {
		this.deck = deck;
	}

	public void DeckOfCards() {
		deck = new Card[52];
	}

	public static class BlackJack {
		private Shuffle shuffler = new Shuffler();
		private DeckOfCards deck;

		public void shuffle() {
			shuffler.shuffle(deck.getDeck());
		}

		public Shuffle getShuffler() {
			return shuffler;
		}

		public void setShuffler(Shuffle shuffler) {
			this.shuffler = shuffler;
		}

		public DeckOfCards getDeck() {
			return deck;
		}

		public void setDeck(DeckOfCards deck) {
			this.deck = deck;
		}

		public Card drawNextCard() {
			return deck.getDeck()[0];
		}

	}

	public static class Card {
		Suits suit;
		FaceValue faceValue;

		public void Card(Suits suit, FaceValue value) {
			this.suit = suit;
			this.faceValue = value;
		}
	}

	public static class Shuffler implements Shuffle {

		@Override
		public void shuffle(Card[] cards) {

		}

	}

	interface Shuffle {
		public void shuffle(Card[] cards);
	}

}
