package net.ulno.sm.course.mancala.play;

import net.ulno.sm.course.mancala.graphics.MancalaGUI;
import net.ulno.sm.course.mancala.model.Cell;
import net.ulno.sm.course.mancala.model.Player;
import net.ulno.sm.course.mancala.model.Turn;

public class Mancala {

	static Turn turn;

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

	public static void moveStones(Cell cell) {
		Player owner = cell.getOwner();
		int order = cell.getOrderNr();
		System.out.println(order);
		// different scenarious for two players??

		// just add to the given players pits
		if (cell.getOrderNr() >= cell.getStones()) {

		}
		// for (int i = 0; i < cell.getStones(); i++) {
		//
		// }
		cell.removeAll();
	}

}
