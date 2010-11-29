package net.ulno.sm.course.mancala.model;

public class Cell {

	private Player owner;
	private int stones;
	private boolean mancala;
	private int orderNr; // 0-6, neighbour is n-1, 0 is mancala
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void removeStone() {
		this.stones--;
	}

	public void removeAll() {
		this.stones = 0;
	}

	public void addStone() {
		this.stones++;
	}

	public void addStone(int stones) {
		this.stones += stones;
	}

	public Cell(Player owner, int stones, boolean mancala, int order) {
		this.owner = owner;
		this.stones = stones;
		this.mancala = mancala;
		this.orderNr = order;
	}

	public int getOrderNr() {
		return orderNr;
	}

	public void setOrderNr(int orderNr) {
		this.orderNr = orderNr;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public int getStones() {
		return stones;
	}

	public void setStones(int stones) {
		this.stones = stones;
	}

	public boolean isMancala() {
		return mancala;
	}

	public void setMancala(boolean mancala) {
		this.mancala = mancala;
	}

}
