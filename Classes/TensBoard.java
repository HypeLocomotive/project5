package tensGame;

import java.util.List;
import java.util.ArrayList;

/**
 * The TensBoard class represents the board in a game of Elevens.
 */
public class TensBoard extends Board {

	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 13;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS = { "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen",
			"king" };

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS = { "spades", "hearts", "diamonds", "clubs" };

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0 };

	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public TensBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}

	/**
	 * Determines if the selected cards form a valid group for removal. In Elevens,
	 * the legal groups are (1) a pair of non-face cards whose values add to 11, and
	 * (2) a group of three cards consisting of a jack, a queen, and a king in some
	 * order.
	 */
	@Override
	public boolean isLegal(List<Integer> selectedCards) {
		/* *** TO BE MODIFIED IN ACTIVITY 11 *** */
		if (selectedCards.size() == 2) {
			return containsPairSum10(selectedCards);
		} else if (selectedCards.size() == 4) {
			return containsJQK(selectedCards);
		} else {
			return false;
		}
	}

	/**
	 * Determine if there are any legal plays left on the board. In tHENS, there is
	 * a legal play if the board contains (1) a pair of non-face cards whose values
	 * add to 10, or (2) a group of four cards consisting of a jack, a queen, and a
	 * king and a 10
	 */
	@Override
	public boolean anotherPlayIsPossible() {
		/* *** TO BE MODIFIED IN ACTIVITY 11 *** */
		List<Integer> cIndexes = cardIndexes();
		return containsPairSum10(cIndexes) || containsJQK(cIndexes);
	}

	/**
	 * Look for an 11-pair in the selected cards.
	 */
	private boolean containsPairSum10(List<Integer> selectedCards) {
		/* *** TO BE CHANGED INTO findPairSum11 IN ACTIVITY 11 *** */
		for (int sk1 = 0; sk1 < selectedCards.size(); sk1++) {
			int k1 = selectedCards.get(sk1).intValue();
			for (int sk2 = sk1 + 1; sk2 < selectedCards.size(); sk2++) {
				int k2 = selectedCards.get(sk2).intValue();
				if (cardAt(k1).pointValue() + cardAt(k2).pointValue() == 10) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Look for a JQK in the selected cards.
	 */
	private boolean containsJQK(List<Integer> selectedCards) {
		/* *** TO BE CHANGED INTO findJQK IN ACTIVITY 11 *** */
		boolean foundTen = false;
		boolean foundJack = false;
		boolean foundQueen = false;
		boolean foundKing = false;
		for (Integer kObj : selectedCards) {
			int k = kObj.intValue();
			if (cardAt(k).rank().equals("10")) {
				foundTen = true;
			} else if (cardAt(k).rank().equals("jack")) {
				foundJack = true;
			} else if (cardAt(k).rank().equals("queen")) {
				foundQueen = true;
			} else if (cardAt(k).rank().equals("king")) {
				foundKing = true;
			}
		}
		return foundTen && foundJack && foundQueen && foundKing;
	}

	/**
	 * Looks for a legal play on the board. If one is found, it plays it.
	 */
	public boolean playIfPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 11 *** */
		return false; // REPLACE !
	}

	/**
	 * Looks for a pair of non-face cards whose values sum to 11. If found, replace
	 * them with the next two cards in the deck. The simulation of this game uses
	 * this method.
	 */
	private boolean playPairSum10IfPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 11 *** */
		return false; // REPLACE !
	}

	/**
	 * Looks for a group of three face cards JQK. If found, replace them with the
	 * next three cards in the deck. The simulation of this game uses this method.
	 */
	private boolean playJQKIfPossible() {
		/* *** TO BE IMPLEMENTED IN ACTIVITY 11 *** */
		return false; // REPLACE !
	}
}
