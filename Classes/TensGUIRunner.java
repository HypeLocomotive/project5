package tensGame;

class TensGUIRunner {

	/**
	 * Plays the GUI version of Elevens.
	 */
	public static void main(String[] args) {
		Board board = new TensBoard();
		CardGameGUI gui = new CardGameGUI(board);
		gui.displayGame();
	}
}
