package net.ulno.sm.course.mancala.model;

import java.util.ArrayList;
import java.util.List;

public class Player {

	private int points;
	private String name;
	private List<Cell> cells;

	public List<Cell> getCells() {
		return cells;
	}

	public void setCells(List<Cell> cells) {
		this.cells = cells;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private boolean turn;

	public Player(int points, boolean turn, String name) {
		this.points = points;
		this.turn = turn;
		this.name = name;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public List<Cell> generateCells() {
		List<Cell> cells = new ArrayList<Cell>();
		Cell p1Mancala = new Cell(this, 0, true, 0);
		Cell p1c1 = new Cell(this, 4, false, 1);
		Cell p1c2 = new Cell(this, 4, false, 2);
		Cell p1c3 = new Cell(this, 4, false, 3);
		Cell p1c4 = new Cell(this, 4, false, 4);
		Cell p1c5 = new Cell(this, 4, false, 5);
		Cell p1c6 = new Cell(this, 4, false, 6);
		cells.add(p1Mancala);
		cells.add(p1c1);
		cells.add(p1c2);
		cells.add(p1c3);
		cells.add(p1c4);
		cells.add(p1c5);
		cells.add(p1c6);
		for (Cell c : cells) {
			c.setName("u" + getName() + "h" + c.getOrderNr());
		}

		this.setCells(cells);
		return cells;
	}

	public Cell getCellByName(String name) {
		for (Cell c : getCells()) {
			if (c.getName().equals(name)) {
				return c;
			}
		}
		return null;
	}

	public Cell getCellByOrder(int order) {
		for (Cell c : getCells()) {
			if (c.getOrderNr() == order) {
				return c;
			}
		}
		return null;
	}
}
