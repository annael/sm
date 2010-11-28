package net.ulno.sm.course.mancala.play;

import java.util.List;

import net.ulno.sm.course.mancala.graphics.MancalaGUI;
import net.ulno.sm.course.mancala.model.Cell;
import net.ulno.sm.course.mancala.model.Player;
import net.ulno.sm.course.mancala.model.Turn;

public class Mancala {

	static Turn turn;

	/**
	 * Main method to run, players and the field is created
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
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

	public static Turn getTurn() {
		return turn;
	}

	public static void setTurn(Turn turn) {
		Mancala.turn = turn;
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
		Cell last = null;

		for (int i = 1; i < cell.getStones() + 1; i++) {

			if (cell.getOrderNr() - i >= 0) {
				playerCell.get(cell.getOrderNr() - i).addStone();
				last = playerCell.get(cell.getOrderNr() - i);
			} else {
				System.out.println(cell.getStones() - i + 1);

				for (int j = 6; j > (6 - cell.getStones() + i - 1); j--) {
					if (j > 0) {
						enemyCells.get(j).addStone();
						last = enemyCells.get(j);
					}
				}
				break;
			}
		}
		// TODO check if capture
		if (!last.isMancala() && last.getStones() == 1) {
			int opposite = getOppositePitNumber(last.getOrderNr());
			System.out.println("op:" + opposite);
			if (last.getOwner() == cell.getOwner()) {
				playerCell.get(0)
						.addStone(enemyCells.get(opposite).getStones());
				enemyCells.get(opposite).removeAll();
			} else {
				playerCell.get(0)
						.addStone(playerCell.get(opposite).getStones());
				playerCell.get(opposite).removeAll();
			}
		}

		cell.removeAll();

		if (last.isMancala()) {
			// new turn somehow
			return true;
		}

		return false;
	}

	/**
	 * Returns the order number of the opposite pit
	 * 
	 * @param order
	 *            order of the current pit
	 * @return number of the opposite pit
	 */
	private static int getOppositePitNumber(int order) {
		switch (order) {
		case 1:
			return 6;
		case 2:
			return 5;
		case 3:
			return 4;
		case 4:
			return 3;
		case 5:
			return 2;
		case 6:
			return 1;
		}

		return 0;
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
				result += c.getStones();
			}
		}

		for (Cell c : enemy) {
			if (!c.isMancala()) {
				result2 += c.getStones();
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
			result1 += c.getStones();
		}

		for (Cell c : player2) {
			result2 += c.getStones();
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
