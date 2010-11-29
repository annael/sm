package net.ulno.sm.course.mancala.play;

import java.util.List;
import java.util.Stack;

import net.ulno.sm.course.mancala.graphics.MancalaGUI;
import net.ulno.sm.course.mancala.model.Cell;
import net.ulno.sm.course.mancala.model.Player;
import net.ulno.sm.course.mancala.model.Turn;
import net.ulno.sm.course.mancala.model.Stone;

public class Mancala {

	static Turn turn;
	public static Stack<Stone> stones = new Stack<Stone>();

	/**
	 * Main method to run, players and the field is created
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		generateStones();
		Player p1 = new Player(0, true, "1");
		Player p2 = new Player(0, false, "2");
		p1.generateCells();
		p2.generateCells();
		turn = new Turn(p1, p2);

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MancalaGUI().setVisible(true);
			}
		});

	}

	private static void generateStones() {
		for (int i = 0; i<48; i++){
			stones.push(new Stone(i));
		}		
	}

	public static Turn getTurn() {
		return turn;
	}

	public static void setTurn(Turn turn) {
		Mancala.turn = turn;
	}
	
	public static void Play (Cell activePit)
	{		
		boolean anotherTurn = false;
		if (activePit.getStoneNumber() != 0) {
			anotherTurn = Mancala.moveStones(activePit);
			MancalaGUI.changeStoneLabels();
		} else {
			anotherTurn = true;
		}

		Player player1;
		Player player2;

		if (Mancala.getTurn().getActivePlayer().getName().equals("1")) {
			player1 = Mancala.getTurn().getActivePlayer();
			player2 = Mancala.getTurn().getNonActivePlayer();
		} else {
			player1 = Mancala.getTurn().getNonActivePlayer();
			player2 = Mancala.getTurn().getActivePlayer();
		}

		boolean gameOver = Mancala.isGameOver(player1.getCells(), player2.getCells());

		if (gameOver) {
			MancalaGUI.disableU1Buttons();
			MancalaGUI.disableU2Buttons();
			MancalaGUI.getMessage().setText(
					MancalaGUI.getGameOverText(Mancala.getWinner(player1.getCells(),
							player2.getCells())));

			// write log
		}

		if (!anotherTurn) {
			Mancala.getTurn().changeTurn();
			MancalaGUI.disableButtons();
			MancalaGUI.getMessage().setText(
					"It's now player "
							+ Mancala.getTurn().getActivePlayer().getName()
							+ " turn!");
		}
	}
	/**
	 * Main method for interaction with the game (playing) Moves the stones
	 * according to the rules, checks if game is over or not
	 * 
	 * @param cell
	 *            cell to move stones from
	 * @return true if the turn should remain at the current player and false if
	 *         the turn should be changed
	 */
	public static boolean moveStones(Cell cell) {
		List<Cell> playerCell = cell.getOwner().getCells();
		List<Cell> enemyCells = getTurn().getNonActivePlayer().getCells();		
		Cell last = cell;
		Cell next = null;
		int c = cell.getStoneNumber() + 1;
		for (int i = 1; i < c; i++) {	
			next = getNextCell(last);
			next.addStone(cell.getStone());			
			System.out.println("owner " + next.getOwner().getName() + ", cell " + (next.getOrderNr()));
			last = next;
		}
		// check for capture
		if (!last.isMancala() && last.getStoneNumber() == 1 ) {
			int opposite = getOppositePitNumber(last.getOrderNr());
			if (last.getOwner() == cell.getOwner()) {
				System.out.println("captured op: " + opposite);
				while ( !enemyCells.get(opposite).getAllStones().empty() ){
					playerCell.get(0).addStone( enemyCells.get(opposite).getStone() );
				}
				playerCell.get(0).addStone(last.getStone());
			} 
		}
		System.out.println("end of play");		
		if (last.isMancala()) {
			// new turn 
			return true;
		}
		return false;
	}


	private static Cell getNextCell(Cell last) {
		int nr = last.getOrderNr();
		if (nr > 1) {
			return last.getOwner().getCellByOrder(nr - 1);
		}
		else if (nr == 1) {
			if (last.getOwner() == getTurn().getActivePlayer()) {
				return last.getOwner().getCellByOrder(0);
			}
			else {
				return getTurn().getActivePlayer().getCellByOrder(6);
			}
		}
		else {
			return getTurn().getNonActivePlayer().getCellByOrder(6);
		}		
	}

	/**
	 * Returns the order number of the opposite pit
	 * 
	 * @param order
	 *            order of the current pit
	 * @return number of the opposite pit
	 */
	private static int getOppositePitNumber(int order) {
		return 7 - order;
	}

	/**
	 * Checks if the game is over
	 * 
	 * @param player
	 *            pits of the active player
	 * @param enemy
	 *            pits of nonactive player
	 * @return true if game is over, false if not
	 */
	public static boolean isGameOver(List<Cell> player, List<Cell> enemy) {
		int result = 0;
		int result2 = 0;
		for (Cell c : player) {
			if (!c.isMancala()) {
				result += c.getStoneNumber();				
			}
		}

		for (Cell c : enemy) {
			if (!c.isMancala()) {
				result2 += c.getStoneNumber();
			}
		}
		return result == 0 || result2 == 0;
	}

	/**
	 * Returns number of the winner or zero if it's a draw
	 * 
	 * @param player1
	 *            pits of player 1
	 * @param player2
	 *            pits of player 2
	 * @return 0 for draw, 1 if winner is player 1, 2 if winner is player 2
	 */
	public static int getWinner(List<Cell> player1, List<Cell> player2) {
		int result1 = 0;
		int result2 = 0;
		for (Cell c : player1) {
			result1 += c.getStoneNumber();
		}

		for (Cell c : player2) {
			result2 += c.getStoneNumber();
		}

		if (result1 > result2) {
			return 1;
		} else if (result1 < result2) {
			return 2;

		} else {
			return 0;
		}

	}
}